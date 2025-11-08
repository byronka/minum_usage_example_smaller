package org.example;

import com.renomad.minum.utils.StringUtils;
import com.renomad.minum.web.FullSystem;
import com.renomad.minum.web.Response;
import com.renomad.minum.web.WebFramework;

import static com.renomad.minum.web.RequestLine.Method.GET;

public class Main {

    public static void main(String[] args) {
        // Start the application
        FullSystem fs = FullSystem.initialize();

        // Register the endpoints
        registerEndpoints(fs.getWebFramework());

        fs.block();
    }

    /**
     * This method handles registering the endpoints that this
     * application will serve.  By splitting it out to its own
     * method, the testing becomes much easier.  See AppTest.java
     */
    public static void registerEndpoints(WebFramework webFramework) {
        webFramework.registerPath(GET, "", request -> Response.redirectTo("/index.html"));

        webFramework.registerPath(GET, "hello", request -> {
            String name = request.getRequestLine().queryString().get("name");
            if (name == null || name.isBlank()) {
                return Response.htmlOk("<p>Hi there world!</p>");
            } else {
                // encoding prevents XSS attacks
                String urlEncodedName = StringUtils.encode(name);
                return Response.htmlOk("<p>Hi there "+urlEncodedName+"!</p>");
            }

        });
    }
}
