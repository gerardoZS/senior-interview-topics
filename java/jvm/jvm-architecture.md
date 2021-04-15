# JVM Architecture

A Java application runs over a virtual machine, the JVM. A *virtual machine* is a virtual representation of a physical
machine. Therefore, the JVM makes it possible the WORA (Write once, run anywhere) approach.  

## But... How is this possible?

Let's see the short explanation.

In programming languages like C and C++, the code is first compiled into platform-specific machine code. These are
*compiled languages*.

On the other hand, in languages like JavaScript and Python, each line of code is executed directly on the computer.
These are *interpreted languages*.

Java uses a combination of both techniques. The source code, from a *java file*, is first **compiled** into *byte code*
to generate a *class file*. Then *byte code* instructions of the *class file* are **interpreted** by the JVM for the
underlying platform. So, the same *class file* can be executed on different platforms, which obviously, have a
compatible JRE.  
<br>

> **NOTE**  
> The JVM was initially designed to support only Java. However, over time, many other languages such as Scala, Kotlin,
> and Groovy run on the JVM. All of these languages are collectively known as JVM languages.

<br>
We can deduce that the JVM contains an interpreter, but it isn't so simple. Below we'll analyze the different
components that compose the JVM.

## Which are the components of the JVM?

The JVM consists of three main components:

1. Class Loader
2. Runtime Memory
2. Execution Engine

![jvm-architecture.png](./img/jvm-architecture.png)

## The Class Loader component
The Class Loader component is responsible for the class loading process. The class loading process has three phases: 
**loading**, **linking**, and **initialization**. 

When a Java application uses a type (class, interface, enum, etc) for the first time, the Class Loader component
performs a class loading process. 

![class-loader-component.png](./img/class-loader-component.png)

### Loading  
The loading phase involves looking for a required type based on its *binary name*, and if was found, taking its bytecode
representation and creates its representation as a `java.lang.Class` instance.  
<br>

> Any class name provided as a `String` parameter to methods in `ClassLoader` must be a *binary name* as defined by
> The Java™ Language Specification. Examples of valid class names include:
> 
> - "java.lang.String" -> The binary name of a top level type is its canonical name.
> - "javax.swing.JSpinner$DefaultEditor" -> The binary name of an inner class.
> - "java.security.KeyStore$Builder$FileBuilder$1" -> The binary name of an anonymous class.
> 
> According to the `java.lang.Class` documentation, the instances of this class represent a type (class, interface,
> enum, annotation, arrays, and even the Java primitive types and the keyword `void`). 
>   
> The class `Class` has no public constructor, instead, `Class` objects are constructed by the JVM during the
> loading phase with a call to method `ClassLoader.defineClass`.
> 
> Every `Class` object contains a reference to the `ClassLoader` object that defined it.

<br>
For the loading phase, the JVM uses a parent-delegation model and a hierarchy of three built-in class loaders.  

The parent-delegation model states that any request for a class loader to load a given type is first delegated to
its parent class loader, and so on until reaching the hierarchy's root class loader. If the hierarchy's root class
loader finds the requested type, then loads it and returns it; otherwise transfers the control to the class loader
below on the hierarchy, which repeats the same process: loads the type successfully or transfers the control to the
"child" class loader in otherwise. If the originally requested class loader cannot load the type it throws 
`NoClassDefFoundError` or `ClassNotFoundException`.  
<br>
  
![class-loader-parent-delegation-model.png](./img/class-loader-parent-delegation-model.png)  
<br>

> What is the difference between **NoClassDefFoundError** and **ClassNotFoundException**?
>
> - **NoClassDefFoundError**  
> This **error** is thrown when a type was present at compile time, but it's not present at runtime.    
> <br>
> - **ClassNotFoundException**  
> This **checked exception** is thrown when you try to load a class using its fully qualified name (with the methods
> `Class.forName`, `ClassLoader.loadClass` or `ClassLoader.findSystemClass`) and the required class cannot be found.

<br>
The three built-in classloaders are explained below:  
<br>

- **Bootstrap Class Loader**  
  This is the hierarchy's root class loader and is implemented in languages like C or C++. It's the parent class loader
  of *Extension Class Loader*. The *Bootstrap Class Loader* is responsible for loading types that belong to the standard
  libraries of Java (Java SE API). These libraries are present in the `$JAVA_HOME/jre/lib` directory.  
  <br>
- **Extension Class Loader**  
  The *Extension Class Loader* is implemented with Java and is the parent class loader of *Application Class Loader*.
  This class loader is responsible for loading types from "extensions" of the standard libraries of Java. Any *jar* in
  the `$JAVA_HOME/jre/lib/ext` directory is treated as an extension.  
  <br>
- **Application Class Loader**  
  The *Application Class loader* is implemented with Java and is responsible for loading types from the application
  classpath.

### Bibliography  
- https://www.freecodecamp.org/news/jvm-tutorial-java-virtual-machine-architecture-explained-for-beginners/
- https://www.ibm.com/docs/en/sdk-java-technology/7.1?topic=uc-class-loading
- https://www.geeksforgeeks.org/jvm-works-jvm-architecture/  
- https://dzone.com/articles/java-classnotfoundexception-vs-noclassdeffounderro
- https://docs.oracle.com/javase/tutorial/ext/basics/install.html
- https://blogs.oracle.com/sundararajan/understanding-java-class-loading
- https://blogs.oracle.com/sundararajan/jvm-talks
- https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html
- https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html