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
              StartLine.Verb.GET,
              "",
              request -> Response.htmlOk("<p>Hi there world!</p>"));

      fs.block();
   }
}
```

Quick start:
------------

(Note that Minum is not yet published to the central Maven
repo. Thus, it is necessary to first run the following command in 
the [minum framework](https://github.com/byronka/minum): `make mvnrepo`)

To build and run:  

```shell
./mvnw compile exec:java
```

then visit http://localhost:8080

See the [Minum quick start](https://github.com/byronka/minum/docs/quick_start.md) for a comprehensive (but still speedy) step-by-step.
