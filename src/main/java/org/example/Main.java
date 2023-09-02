package org.example;

import com.renomad.minum.Constants;
import com.renomad.minum.Context;
import com.renomad.minum.logging.Logger;
import com.renomad.minum.web.FullSystem;
import com.renomad.minum.web.StartLine;

import com.renomad.minum.web.Response;
import com.renomad.minum.web.WebFramework;

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
