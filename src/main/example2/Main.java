package example2;

import minum.FullSystem;
import minum.web.StartLine;

import minum.web.Response;
import minum.web.WebFramework;

public class Main {

    public static void main(String[] args) {
        try (WebFramework wf = FullSystem.initialize()) {
            // register a handler
            wf.registerPath(
                    StartLine.Verb.GET,
                    "",
                    request -> Response.htmlOk("<p>Hi there world!</p>"));
        }
    }
}
