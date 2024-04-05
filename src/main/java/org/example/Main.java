package org.example;

import com.renomad.minum.web.FullSystem;
import com.renomad.minum.web.Response;

import static com.renomad.minum.web.RequestLine.Method.GET;

public class Main {

    public static void main(String[] args) {
        FullSystem fs = FullSystem.initialize();
        fs.getWebFramework().registerPath(GET, "", request -> Response.htmlOk("<p>Hi there world!</p>"));
        fs.block();
    }
}
