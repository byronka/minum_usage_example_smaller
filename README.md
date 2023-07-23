Minum example - small
====================

This is a small project meant to demonstrate use of the [Minum framework](https://github.com/byronka/minum).
Check out the [code](src/main/java/com/renomad/Main.java). 

Here it is:

```java
  // Register some endpoints
  fs.getWebFramework().registerPath(
          StartLine.Verb.GET,
          "",
          request -> Response.htmlOk("<p>Hi there world!</p>"));
```

Quick start:
------------


* To build and test: `mvn install`
* To build without testing: `mvn clean compile assembly:single`
* To run after build: `java --enable-preview -jar target/minum_usage_example_smallest-1.0.0-jar-with-dependencies.jar`
  and then visit http://localhost:8080

System requirements: 
--------------------

- [JDK version 20](https://jdk.java.net/20/) is _required_, for the new virtual threads it provides.
- Maven

Step-by-step guide for installing Java on Windows:
--------------------------------------------------

1. Download the binary by clicking [here](https://download.java.net/java/GA/jdk20.0.1/b4887098932d415489976708ad6d1a4b/9/GPL/openjdk-20.0.1_windows-x64_bin.zip).
2. Uncompress the zip file
3. Add the home directory to your path.  The home directory of Java is the one with "bin" 
   and "conf" directories, among others. if you, for example, uncompressed the 
   directory to C:\java\jdk-20.0.1, then in Windows you should add it to your path,
   following these instructions:

   * Click the Windows start icon
   * Type env to get the system properties window
   * Click on Environment Variables
   * Under user variables, click the New button
   * For the variable name, enter JAVA_HOME, and for the value, enter C:\java\jdk-20.0.1
   * Edit your Path variable, click New, and add %JAVA_HOME%\bin


