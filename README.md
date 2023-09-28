Minum example - small
====================

This is a small project meant to demonstrate use of the [Minum framework](https://github.com/byronka/minum).
Check out the [code](src/main/java/org/example/Main.java). 

Here it is:

```java
public class Main {

   public static void main(String[] args) {
      // Start the system
      FullSystem fs = FullSystem.initialize();

      // Register some endpoints
      fs.getWebFramework().registerPath(
              RequestLine.Method.GET,
              "",
              request -> Response.htmlOk("<p>Hi there world!</p>"));

      fs.block();
   }
}
```

Quick start:
------------

To build and run:  

```shell
./mvnw compile exec:java
```

then visit http://localhost:8080

See the [Minum quick start](https://github.com/byronka/minum/blob/master/docs/quick_start.md) for a comprehensive (but still speedy) step-by-step.
