package com.renomad;

import minum.Constants;
import minum.logging.Logger;
import minum.web.FullSystem;
import minum.web.StartLine;

import minum.web.Response;
import minum.web.WebFramework;

public class Main {

    public static void main(String[] args) throws Exception {
        // Initialize the constants, these are used throughout the system
        var constants = new Constants();

        // Build the logger.  We separate the construction of the logger
        // as a separate task to avoid circular dependencies.  The logger
        // uses a lot of the same objects as FullSystem.
        var logger = Logger.make(constants);

        // Start the system
        FullSystem fs = FullSystem.initialize(logger, constants);

        // Register some endpoints
        fs.getWebFramework().registerPath(
                StartLine.Verb.GET,
                "",
                request -> Response.htmlOk("<p>Hi there world!</p>"));

        fs.block();
    }
}
