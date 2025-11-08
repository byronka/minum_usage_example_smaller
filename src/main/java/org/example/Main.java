package org.example;

import com.renomad.minum.utils.StringUtils;
import com.renomad.minum.web.FullSystem;
import com.renomad.minum.web.Response;

import static com.renomad.minum.web.RequestLine.Method.GET;

public class Main {

    public static void main(String[] args) {
        // Start the application
        FullSystem fs = FullSystem.initialize();

        // Register the endpoints
        registerEndpoints(fs);

        fs.block();
    }

    /**
     * This method handles registering the endpoints that this
     * application will serve.  By splitting it out to its own
     * method, the testing becomes much easier.  See AppTest.java
     */
    public static void registerEndpoints(FullSystem fs) {
        fs.getWebFramework().registerPath(GET, "", request -> Response.redirectTo("/index.html"));

        fs.getWebFramework().registerPath(GET, "hello", request -> {
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
