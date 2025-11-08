package org.example;

import com.renomad.minum.logging.TestLogger;
import com.renomad.minum.state.Constants;
import com.renomad.minum.state.Context;
import com.renomad.minum.web.FullSystem;
import com.renomad.minum.web.FunctionalTesting;
import com.renomad.minum.web.StatusLine;
import org.junit.*;

import static com.renomad.minum.testing.TestFramework.*;
import static com.renomad.minum.web.StatusLine.StatusCode.CODE_200_OK;


public class AppTest
{

    private Context context;
    private TestLogger logger;
    private FullSystem fullSystem;
    private Constants constants;
    private FunctionalTesting ft;

    /**
     * Initialize a full system startup for each test
     */
    @Before
    public void init() {
        this.context = buildTestingContext("AppTest");
        this.constants = this.context.getConstants();
        this.logger = (TestLogger) context.getLogger();

        this.fullSystem = new FullSystem(context);
        this.fullSystem.start();

        Main.registerEndpoints(this.fullSystem.getWebFramework());

        this.ft = new FunctionalTesting(context, this.constants.hostName, this.constants.serverPort);
    }

    /**
     * Cleanly shut down the system after each test
     */
    @After
    public void cleanup() {
        this.fullSystem.shutdown();
        this.context.getLogger().stop();
        this.context.getExecutorService().shutdownNow();
    }

    /**
     * Test getting a static resource, like "moon.png" which comes bundled with
     * this project in src/main/webapp/static/moon.webp
     * <br>
     * Adjust the location of your static values by modifying the setting
     * in minum.config, which defaults to src/main/webapp/static.
     * <br>
     * When using Minum, it is expected that the local development configuration
     * may be different than for other environments like testing or prod.
     */
    @Test
    public void testGettingStaticResource()
    {
        // execute an HTTP GET request for moon.webp
        FunctionalTesting.TestResponse testResponse = ft.get("moon.webp");

        assertEquals(testResponse.statusLine().status(), CODE_200_OK);
        assertEquals(testResponse.body().asBytes().length, 4190);
    }

    /**
     * If we send a GET request to the "hello" endpoint without a query
     * string, it is expected to respond with "Hi there world" in HTML.
     */
    @Test
    public void testHelloEndpoint_Default() {
        // execute an HTTP GET request for the "hello" endpoint
        FunctionalTesting.TestResponse testResponse = ft.get("hello");

        assertEquals(testResponse.statusLine().status(), CODE_200_OK);
        assertEquals(testResponse.body().asString(), "<p>Hi there world!</p>");
    }

    /**
     * Similar to {@link #testHelloEndpoint_Default()} but he we
     * specify the name in the query string
     */
    @Test
    public void testHelloEndpoint_SpecificNameValue() {
        // execute an HTTP GET request for the "hello" endpoint
        FunctionalTesting.TestResponse testResponse = ft.get("hello?name=alice");

        assertEquals(testResponse.statusLine().status(), CODE_200_OK);
        assertEquals(testResponse.body().asString(), "<p>Hi there alice!</p>");
    }

    /**
     * If the user tries sending a value for name that could end up
     * getting run as JavaScript, convert it to a safe value that cannot.
     */
    @Test
    public void testHelloEndpoint_EdgeCase_XSSName() {
        // execute an HTTP GET request for the "hello" endpoint
        FunctionalTesting.TestResponse testResponse = ft.get("hello?name=<script>alert('danger_XSS')</script>");

        assertEquals(testResponse.statusLine().status(), CODE_200_OK);
        assertEquals(testResponse.body().asString(), "<p>Hi there %3Cscript%3Ealert%28%27danger_XSS%27%29%3C%2Fscript%3E!</p>");
    }

    /**
     * Confirm we get what is expected for the index.html page, the
     * page presented to the user when they hit http://localhost:8080/index.html
     */
    @Test
    public void testIndexHappyPath() {
        // execute an HTTP GET request for the "index" endpoint
        FunctionalTesting.TestResponse testResponse = ft.get("index.html");

        assertEquals(testResponse.statusLine().status(), CODE_200_OK);
        assertEquals(testResponse.body().asString().length(), 239);

    }

    /**
     * If the user requests http://localhost:8080/, the system will
     * redirect their browser to index.html
     */
    @Test
    public void testIndexRedirect() {
        FunctionalTesting.TestResponse testResponseEmpty = ft.get("");

        assertEquals(testResponseEmpty.statusLine().status(), StatusLine.StatusCode.CODE_303_SEE_OTHER);
        assertEquals(testResponseEmpty.headers().valueByKey("location").getFirst(), "/index.html");
    }


}
