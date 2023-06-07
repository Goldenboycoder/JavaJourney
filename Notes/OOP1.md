# Object-Oriented Programming

## Class and Objects

A Java class is a set of object which shares common characteristics/ behavior and common properties/ attributes. There are certain points about Java Classes as mentioned below:

Class is not a real-world entity. It is just a template or blueprint or prototype from which objects are created.
Class does not occupy memory.
Class is a group of variables of different data types and a group of methods.

A Class in Java can contain:

- Data member
- Method
- Constructor
- Nested Class
- Interface


### Declare Class in Java
```
access_modifier class<class_name>
{  
    data member;  
    method;  
    constructor;
    nested class;
    interface;
}
```

```java
// Java Program for class example

class Student {
	// data member (also instance variable)
	int id;
	// data member (also instance variable)
	String name;

	public static void main(String args[])
	{
		// creating an object of
		// Student
		Student s1 = new Student();
		System.out.println(s1.id);
		System.out.println(s1.name);
	}
}

```

A class is a user-defined blueprint or prototype from which objects are created. It represents the set of properties or methods that are common to all objects of one type.



### Components of Java Classes

In general, class declarations can include these components, in order: 
- Modifiers: A class can be public or has default access (Refer this for details).
- Class keyword: class keyword is used to create a class.
- Class name: The name should begin with an initial letter (capitalized by convention).
- Superclass(if any): The name of the class’s parent (superclass), if any, preceded by the keyword extends. A class can only extend (subclass) one parent.
- Interfaces(if any): A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword implements. A class can implement more than one interface.
- Body: The class body is surrounded by braces, { }.


Constructors are used for initializing new objects. Fields are variables that provide the state of the class and its objects, and methods are used to implement the behavior of the class and its objects.
There are various types of classes that are used in real-time applications such as nested classes, anonymous classes, and lambda expressions.



## Objects in Java


It is a basic unit of Object-Oriented Programming and represents real-life entities. A typical Java program creates many objects, which as you know, interact by invoking methods. An object consists of : 

- State: It is represented by attributes of an object. It also reflects the properties of an object.
- Behavior: It is represented by the methods of an object. It also reflects the response of an object with other objects.
- Identity: It gives a unique name to an object and enables one object to interact with other objects.


![Object state](../Media/Objectstate.png)


### Declaring Objects (Also called instantiating a class)

When an object of a class is created, the class is said to be instantiated. All the instances share the attributes and the behavior of the class. 

But the values of those attributes, i.e. the state are unique for each object. A single class may have any number of instances.



![Instance of class](../Media/insantceofclass.png)



As we declare variables like (type name;). This notifies the compiler that we will use the name to refer to data whose type is type. With a primitive variable, this declaration also reserves the proper amount of memory for the variable. So for reference variables , the type must be strictly a concrete class name. In general, we can’t create objects of an abstract class or an interface.  

```java
Dog tuffy;
```

If we declare a reference variable(tuffy) like this, its value will be undetermined(null) until an object is actually created and assigned to it. Simply declaring a reference variable does not create an object.



### Initializing a Java object

The new operator instantiates a class by allocating memory for a new object and returning a reference to that memory. The new operator also invokes the class constructor. 

```java
// Class Declaration

public class Dog {
	// Instance Variables
	String name;
	String breed;
	int age;
	String color;

	// Constructor Declaration of Class
	public Dog(String name, String breed, int age,String color)
	{
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.color = color;
	}

	// method 1
	public String getName() { return name; }

	// method 2
	public String getBreed() { return breed; }

	// method 3
	public int getAge() { return age; }

	// method 4
	public String getColor() { return color; }

	@Override public String toString()
	{
		return ("Hi my name is " + this.getName()
				+ ".\nMy breed,age and color are "
				+ this.getBreed() + "," + this.getAge()
				+ "," + this.getColor());
	}

	public static void main(String[] args)
	{
		Dog tuffy
			= new Dog("tuffy", "papillon", 5, "white");
		System.out.println(tuffy.toString());
	}
}

```

Output
```
Hi my name is tuffy.
My breed,age and color are papillon,5,white
```


This class contains a single constructor. We can recognize a constructor because its declaration uses the same name as the class and it has no return type. 

The Java compiler differentiates the constructors based on the number and the type of the arguments. The constructor in the Dog class takes four arguments. The following statement provides “tuffy”, “papillon”,5, and “white” as values for those arguments:

```
Dog tuffy = new Dog("tuffy","papillon",5, "white");
```


**Note**: All classes have at least one constructor. If a class does not explicitly declare any, the Java compiler automatically provides a no-argument constructor, also called the default constructor. 

This default constructor calls the class parent’s no-argument constructor (as it contains only one statement i.e `super();`), or the Object class constructor if the class has no other parent (as the Object class is the parent of all classes either directly or indirectly). 


### Ways to Create an Object of a Class

There are four ways to create objects in Java. Strictly speaking, there is only one way(by using a new keyword), and the rest internally use a new keyword. 

#### Using new keyword
It is the most common and general way to create an object in Java. 

Example:
```
// creating object of class Test
Test t = new Test();
```

#### Using Class.forName(String className) method

There is a pre-defined class in java.lang package with name Class. The forName(String className) method returns the Class object associated with the class with the given string name. We have to give a fully qualified name for a class. On calling the new Instance() method on this Class object returns a new instance of the class with the given string name.
```
// creating object of public class Test
// consider class Test present in com.p1 package
Test obj = (Test)Class.forName("com.p1.Test").newInstance();
```


#### Using clone() method
clone() method is present in the Object class. It creates and returns a copy of the object.
```   
// creating object of class Test
Test t1 = new Test();

// creating clone of above object
Test t2 = (Test)t1.clone();
```

#### Deserialization
De-serialization is a technique of reading an object from the saved state in a file. Refer to Serialization/De-Serialization in Java

```        
FileInputStream file = new FileInputStream(filename);
ObjectInputStream in = new ObjectInputStream(file);
Object obj = in.readObject();
```

### Creating multiple objects by one type only (A good practice) 

In real-time, we need different objects of a class in different methods. Creating a number of references for storing them is not a good practice and therefore we declare a static reference variable and use it whenever required. In this case, the wastage of memory is less. The objects that are not referenced anymore will be destroyed by the Garbage Collector of Java. 

Example:

``` java      
Test test = new Test();
test = new Test();
```
In the inheritance system, we use a parent class reference variable to store a sub-class object. In this case, we can switch into different subclass objects using the same referenced variable. 


Example:
```java
class Animal {}

class Dog extends Animal {}
class Cat extends Animal {}

public class Test
{
    // using Dog object
    Animal obj = new Dog();

    // using Cat object
    obj = new Cat();
}       

```


#### Anonymous Objects in Java
Anonymous objects are objects that are instantiated but are not stored in a reference variable.  

- They are used for immediate method calls.
- They will be destroyed after method calling.
- They are widely used in different libraries. For example, in AWT libraries, they are used to perform some action on capturing an event(eg a key press).
- In the example below, when a key button(referred to by the btn) is pressed, we are simply creating an anonymous object of EventHandler class for just calling the handle method.

```java
btn.setOnAction(new EventHandler()
{
    public void handle(ActionEvent event)
    {
        System.out.println("Hello World!");
    }
});
```


## Instantiation and the life cycle of an object

Already discussed previously [Instance variables and Memory Lifecycle](./Variables.md)


## Declaring Classes
You've seen classes defined in the following way:
```
class MyClass {
    // field, constructor, and 
    // method declarations
}
```


This is a class declaration. The class body (the area between the braces) contains all the code that provides for the life cycle of the objects created from the class: constructors for initializing new objects, declarations for the fields that provide the state of the class and its objects, and methods to implement the behavior of the class and its objects.

The preceding class declaration is a minimal one. It contains only those components of a class declaration that are required. You can provide more information about the class, such as the name of its superclass, whether it implements any interfaces, and so on, at the start of the class declaration. For example,
```
class MyClass extends MySuperClass implements YourInterface {
    // field, constructor, and
    // method declarations
}
```

means that MyClass is a subclass of MySuperClass and that it implements the YourInterface interface.

You can also add modifiers like public or private at the very beginning—so you can see that the opening line of a class declaration can become quite complicated. The modifiers public and private, which determine what other classes can access MyClass, are discussed later in this lesson. The lesson on interfaces and inheritance will explain how and why you would use the extends and implements keywords in a class declaration. For the moment you do not need to worry about these extra complications.

In general, class declarations can include these components, in order:

- Modifiers such as public, private, and a number of others that you will encounter later. (However, note that the private modifier can only be applied to Nested Classes.)
- The class name, with the initial letter capitalized by convention.
- The name of the class's parent (superclass), if any, preceded by the keyword extends. A class can only extend (subclass) one parent.
- A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword implements. A class can implement more than one interface.
- The class body, surrounded by braces, `{}`.


Now implementing a class comes down to filling the body with functionality while adhering tot he signature of the methods provided by the interface or the methods signature them selfs when no interface is provided , more on interfaces later.


# Access Modifiers

Access modifiers are object-oriented programming that is used to set the accessibility of classes, constructors, methods, and other members of Java.
Using the access modifiers we can set the scope or accessibility of these classes, methods, constructors, and other members. 


### Four Types of Access Modifiers

- **Private** : We can access the private modifier only within the same class and not from outside the class.
- **Default** : We can access the default modifier only within the same package and not from outside the package. And also, **if we do not specify any access modifier it will automatically consider it as default**.
- **Protected** : We can access the protected modifier within the same package and also from outside the package with the help of the child class. If we do not make the child class, we cannot access it from outside the package. **So inheritance is a must for accessing it from outside the package.**
- **Public** : We can access the public modifier from anywhere. We can access public modifiers from within the class as well as from outside the class and also within the package and outside the package.



### Which all members of Java can be assigned with the access modifiers



|Members of JAVA|	Private|	Default|	Protected|	Public
|:---|:---|:---|:---|:---|
Class	|No	|Yes	|No	|Yes
Variable|	Yes	|Yes|	Yes|	Yes
Method	|Yes	|Yes	|Yes	|Yes
Constructor	|Yes	|Yes	|Yes	|Yes
interface	|No	|Yes	|No	|Yes
Initializer Block|	NOT ALLOWED|||


### Scope of each Access Modifier


|  | Accessibility	|Private	|Default	|Protected	|Public
|:---|:---|:---|:---|:---|:---|
Same Package|	Same Class|	Yes|	Yes|	Yes|	Yes
Without Inheritance|	No|	Yes|	Yes	|Yes
With Inheritance|	No|	Yes|	Yes|	Yes
Different Package|	Without Inheritance|	No|	No	|No|	Yes
With Inheritance|	No|	No	|Yes	|Yes


## Data Members



Member variables are known as instance variables in java.

- Instance variables are declared in a class, but outside a method, constructor or any block.

- When space is allocated for an object in the heap, a slot for each instance variable value is created.

- Instance variables are created when an object is created with the use of the keyword 'new' and destroyed when the object is destroyed.

- Instance variables hold values that must be referenced by more than one method, constructor or block, or essential parts of an object's state that must be present throughout the class.

- Instance variables can be declared in a class level before or after use.

- Access modifiers can be given for instance variables.

- The instance variables are visible for all methods, constructors, and block in the class. Normally, it is recommended to make these variables private (access level). However, visibility for subclasses can be given for these variables with the use of access modifiers.

- Instance variables have default values. For numbers, the default value is 0, for Booleans it is false, and for object references it is null. Values can be assigned during the declaration or within the constructor.

- Instance variables can be accessed directly by calling the variable name inside the class. However, within static methods (when instance variables are given accessibility), they should be called using the fully qualified name. ObjectReference.VariableName.



## Constructors 

Java constructors or constructors in Java is a terminology used to construct something in our programs. A constructor in Java is a special method that is used to initialize objects. The constructor is called when an object of a class is created. It can be used to set initial values for object attributes.

### What are Constructors in Java?

In Java, Constructor is a block of codes similar to the method. It is called when an instance of the class is created. At the time of calling the constructor, memory for the object is allocated in the memory. It is a special type of method that is used to initialize the object. Every time an object is created using the new() keyword, at least one constructor is called.

**Note**: It is not necessary to write a constructor for a class. It is because the java compiler creates a default constructor (constructor with no arguments) if your class doesn’t have any.


Each time an object is created using a new() keyword, at least one constructor (it could be the default constructor) is invoked to assign initial values to the data members of the same class. Rules for writing constructors are as follows:

- The constructor(s) of a class must have the same name as the class name in which it resides.
- A constructor in Java can not be abstract, final, static, or Synchronized.
- Access modifiers can be used in constructor declaration to control its access i.e which other class can call the constructor.

### Types of constructors in java

Now is the correct time to discuss the types of the constructor, so primarily there are three types of constructors in Java are mentioned below:

- Default Constructor
- Parameterized Constructor
- Copy Constructor


### Default Constructor in Java

A constructor that has no parameters is known as default the constructor. A default constructor is invisible. And if we write a constructor with no arguments, the compiler does not create a default constructor. It is taken out. It is being overloaded and called a parameterized constructor. The default constructor changed into the parameterized constructor. But Parameterized constructor can’t change the default constructor.

### Parameterized Constructor in Java

A constructor that has parameters is known as parameterized constructor. If we want to initialize fields of the class with our own values, then use a parameterized constructor.

```java
// Java Program for Parameterized Constructor
import java.io.*;
class Geek {
	// data members of the class.
	String name;
	int id;
	Geek(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
}
class GFG {
	public static void main(String[] args)
	{
		// This would invoke the parameterized constructor.
		Geek geek1 = new Geek("avinash", 68);
		System.out.println("GeekName :" + geek1.name
						+ " and GeekId :" + geek1.id);
	}
}

```

Now the most important topic that comes into play is the strong incorporation of OOPS with constructors known as constructor overloading. Just like methods, we can overload constructors for creating objects in different ways. 

The compiler differentiates constructors on the basis of the number of parameters, types of parameters, and order of the parameters. 



```java
// Java Program to illustrate constructor overloading
// using same task (addition operation ) for different
// types of arguments.

import java.io.*;

class Geek {
	// constructor with one argument
	Geek(String name)
	{
		System.out.println("Constructor with one "
						+ "argument - String : " + name);
	}

	// constructor with two arguments
	Geek(String name, int age)
	{

		System.out.println(
			"Constructor with two arguments : "
			+ " String and Integer : " + name + " " + age);
	}

	// Constructor with one argument but with different
	// type than previous..
	Geek(long id)
	{
		System.out.println(
			"Constructor with one argument : "
			+ "Long : " + id);
	}
}

class GFG {
	public static void main(String[] args)
	{
		// Creating the objects of the class named 'Geek'
		// by passing different arguments

		// Invoke the constructor with one argument of
		// type 'String'.
		Geek geek2 = new Geek("Shikhar");

		// Invoke the constructor with two arguments
		Geek geek3 = new Geek("Dharmesh", 26);

		// Invoke the constructor with one argument of
		// type 'Long'.
		Geek geek4 = new Geek(325614567);
	}
}

```


### Copy Constructor in Java

Unlike other constructors copy constructor is passed with another object which copies the data available from the passed object to the newly created object.

```java
// Java Program for Copy Constructor
import java.io.*;

class Geek {
	// data members of the class.
	String name;
	int id;

	// Parameterized Constructor
	Geek(String name, int id)
	{
		this.name = name;
		this.id = id;
	}

	// Copy Constructor
	Geek(Geek obj2)
	{
		this.name = obj2.name;
		this.id = obj2.id;
	}
}
class GFG {
	public static void main(String[] args)
	{
		// This would invoke the parameterized constructor.
		System.out.println("First Object");
		Geek geek1 = new Geek("avinash", 68);
		System.out.println("GeekName :" + geek1.name
						+ " and GeekId :" + geek1.id);

		System.out.println();

		// This would invoke the copy constructor.
		Geek geek2 = new Geek(geek1);
		System.out.println(
			"Copy Constructor used Second Object");
		System.out.println("GeekName :" + geek2.name
						+ " and GeekId :" + geek2.id);
	}
}
```

## Nested Class





# References

https://www.geeksforgeeks.org/classes-objects-java/

https://docs.oracle.com/javase/tutorial/java/javaOO/classdecl.html

https://docs.oracle.com/javase/tutorial/java/IandI/usinginterface.html

https://www.mygreatlearning.com/blog/the-access-modifiers-in-java/

https://www.geeksforgeeks.org/access-modifiers-java/

https://www.geeksforgeeks.org/constructors-in-java/

https://www.geeksforgeeks.org/nested-classes-java/