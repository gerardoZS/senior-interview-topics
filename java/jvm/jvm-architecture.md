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
The Class Loader component is responsible for loading the byte code from *class files* into the JVM Runtime Memory. 

When a Java application uses a type (class, interface, or enum) for the first time, the Class Loader component 
performs a class loading process. The class loading process has three phases: **loading**, **linking**, and 
**initialization**.

![img.png](./img/class-loader-component.png)

### Loading  
Loading phase involves looking for the required type based on its fully qualified name, and if was found,
taking its bytecode representation and load the type representation in memory, specifically in the *Method Area* that
belongs to the *Runtime Memory* component.
  
> **Method Area, Metaspace and Permgen**  
> TODO
  
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

### Bibliography  
https://www.freecodecamp.org/news/jvm-tutorial-java-virtual-machine-architecture-explained-for-beginners/  
https://www.ibm.com/docs/en/sdk-java-technology/7.1?topic=uc-class-loading  
https://www.geeksforgeeks.org/jvm-works-jvm-architecture/  
