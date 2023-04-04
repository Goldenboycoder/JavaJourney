# The Java Programming Language

The Java programming language is a high-level language that can be characterized by all of the following words:


<details>
<summary> Simple, Object Oriented, and Familiar </summary>

Primary characteristics of the Java programming language include a simple language that can be programmed without extensive programmer training while being attuned to current software practices. T

The Java programming language is designed to be object oriented .The needs of distributed, client-server based systems coincide with the encapsulated, message-passing paradigms of object-based software. To function within increasingly complex, network-based environments, programming systems must adopt object-oriented concepts.

Programmers using the Java programming language can access existing libraries of tested objects that provide functionality ranging from basic data types through I/O and network interfaces to graphical user interface toolkits. These libraries can be extended to provide new behavior.

Even though C++ was rejected as an implementation language, keeping the Java programming language looking like C++ as far as possible results in it being a familiar language, while removing the unnecessary complexities of C++. Having the Java programming language retain many of the object-oriented features and the "look and feel" of C++ means that programmers can migrate easily to the Java platform and be productive quickly.

</details>

</br>

<details>
<summary> Robust and Secure </summary>

The Java programming language is designed for creating highly reliable software. It provides extensive compile-time checking, followed by a second level of run-time checking. Language features guide programmers towards reliable programming habits.

The memory management model is extremely simple: objects are created with a new operator. There are no explicit programmer-defined pointer data types, no pointer arithmetic, and automatic garbage collection.

This simple memory management model eliminates entire classes of programming errors that bedevil C and C++ programmers. You can develop Java code with confidence that the system will find many errors quickly and that major problems won't lay dormant until after your production code has shipped.

Java technology is designed to operate in distributed environments, which means that security is of paramount importance. With security features designed into the language and run-time system, Java technology lets you construct applications that can't be invaded from outside.

</details>

</br>


<details>
<summary> Architecture Neutral and Portable </summary>

Java technology is designed to support applications that will be deployed into heterogeneous network environments. In such environments, applications must be capable of executing on a variety of hardware architectures. Within this variety of hardware platforms, applications must execute atop a variety of operating systems and interoperate with multiple programming language interfaces. To accommodate the diversity of operating environments, the Java Compiler TM product generates bytecodes--an architecture neutral intermediate format designed to transport code efficiently to multiple hardware and software platforms. The interpreted nature of Java technology solves both the binary distribution problem and the version problem; the same Java programming language byte codes will run on any platform.

Architecture neutrality is just one part of a truly portable system. Java technology takes portability a stage further by being strict in its definition of the basic language. Java technology puts a stake in the ground and specifies the sizes of its basic data types and the behavior of its arithmetic operators. Your programs are the same on every platform--there are no data type incompatibilities across hardware and software architectures.

The architecture-neutral and portable language platform of Java technology is known as the Java virtual machine. It's the specification of an abstract machine for which Java programming language compilers can generate code. Specific implementations of the Java virtual machine for specific hardware and software platforms then provide the concrete realization of the virtual machine. The Java virtual machine is based primarily on the POSIX interface specification--an industry-standard definition of a portable system interface. Implementing the Java virtual machine on new architectures is a relatively straightforward task as long as the target platform meets basic requirements such as support for multithreading.

</details>

</br>


<details>
<summary> High Performance </summary>

Performance is always a consideration. The Java platform achieves superior performance by adopting a scheme by which the interpreter can run at full speed without needing to check the run-time environment. The automatic garbage collector runs as a low-priority background thread, ensuring a high probability that memory is available when required, leading to better performance. Applications requiring large amounts of compute power can be designed such that compute-intensive sections can be rewritten in native machine code as required and interfaced with the Java platform. In general, users perceive that interactive applications respond quickly even though they're interpreted.

</details>

</br>

<details>
<summary> Interpreted, Threaded, and Dynamic </summary>

The Java interpreter can execute Java bytecodes directly on any machine to which the interpreter and run-time system have been ported. In an interpreted platform such as Java technology-based system, the link phase of a program is simple, incremental, and lightweight. You benefit from much faster development cycles--prototyping, experimentation, and rapid development are the normal case, versus the traditional heavyweight compile, link, and test cycles.

Java technology's multithreading capability provides the means to build applications with many concurrent threads of activity. Multithreading thus results in a high degree of interactivity for the end user.

The Java platform supports multithreading at the language level with the addition of sophisticated synchronization primitives: the language library provides the Thread class, and the run-time system provides monitor and condition lock primitives. At the library level, moreover, Java technology's high-level system libraries have been written to be thread safe: the functionality provided by the libraries is available without conflict to multiple concurrent threads of execution.

While the Java Compiler is strict in its compile-time static checking, the language and run-time system are dynamic in their linking stages. 

Classes are linked only as needed. New code modules can be linked in on demand from a variety of sources, even from sources across a network. 

</details>


>[Java whitepaper](https://www.oracle.com/java/technologies/introduction-to-java.html#334)


# Compilation

In the Java programming language, all source code is first written in plain text files ending with the .java extension. 

Those source files are then compiled into .class files by the javac compiler. 

A .class file does not contain code that is native to your processor; it instead contains bytecodes — the machine language of the Java Virtual Machine1 (Java VM). 

The java launcher tool then runs your application with an instance of the Java Virtual Machine.

```mermaid
graph TD;
    .java-->Compiler;
    Compiler-->.class;
    .class-->JVM;
    JVM-->Binary Code;
```

Because the Java VM is available on many different operating systems, the same .class files are capable of running on Microsoft Windows, Linux, or Mac OS. Some versions of the JVM include various tasks such as finding performance bottlenecks and recompiling (to native code) frequently used sections of code.

```mermaid
graph TD;
    Java Program --> Compiler;
    Compiler --> JVM;
    JVM --> Windows;
    JVM --> UNIX;
    JVN --> MacOS;
```

## Build

To compile the .java code you should have installed the JDK then run the `javac` command giving it the driver / program starting file

```cmd
javac MyProgram.java
```

>[Java docs](https://docs.oracle.com/javase/tutorial/getStarted/intro/definition.html)

