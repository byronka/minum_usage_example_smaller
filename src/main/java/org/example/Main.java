package org.example;

import minum.Constants;
import minum.Context;
import minum.logging.Logger;
import minum.web.FullSystem;
import minum.web.StartLine;

import minum.web.Response;
import minum.web.WebFramework;

public class Main {

    public static void main(String[] args) {
        // Start the system
        FullSystem fs = FullSystem.initialize();

        // Register some endpoints
        fs.getWebFramework().registerPath(
                StartLine.Verb.GET,
                "",
                request -> Response.htmlOk("<p>Hi there world!</p>"));

        fs.block();
    }
}
