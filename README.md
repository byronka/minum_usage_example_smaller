Minum example - small
====================

This is a small project meant to demonstrate use of the [Minum framework](https://github.com/byronka/minum).
Check out the [code](src/main/example2/Main.java). 

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

* To run: `make run` and then visit http://localhost:8080
* For help: `make help`

System requirements: 
--------------------

[JDK version 20](https://jdk.java.net/20/) is _required_.

Developed in two environments:
* MacBook Pro with OS 12.0.1, with OpenJDK 20, GNU Make 3.81 and Rsync 2.6.9
* Windows 10 64-bit professional, on [Cygwin](https://www.cygwin.com/), OpenJDK 20, Gnu Make 4.4 and Rsync 3.2.7

Note that the build tool, _Gnu Make_, is already installed on Mac.  On Windows you can install
it through the Cygwin installer.  See [here](https://www.cygwin.com/packages/summary/make.html)


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


