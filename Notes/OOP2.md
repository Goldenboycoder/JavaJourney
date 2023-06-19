# Inheritance

Inheritance in java is one of the core concepts of Object-Oriented Programming. Java Inheritance is used when we have **is-a** relationship between objects. **Inheritance** in Java is implemented using `extends` keyword.


Inheritance in Java is the method to create a hierarchy between classes by inheriting from other classes.

Java Inheritance is transitive - so if Sedan extends Car and Car extends Vehicle, then Sedan is also inherited from the Vehicle class. The Vehicle becomes the superclass of both Car and Sedan.

Inheritance is widely used in java applications, for example extending the Exception class to create an application-specific Exception class that contains more information such as error codes. For example NullPointerException.


Every class in java implicitly extends java.lang.Object class. So Object class is at the top level of inheritance hierarchy in java.

Let’s see how to implement inheritance in java with a simple example.

**Superclass: Animal**

```java
package com.journaldev.inheritance;

public class Animal {

	private boolean vegetarian;

	private String eats;

	private int noOfLegs;

	public Animal(){}

	public Animal(boolean veg, String food, int legs){
		this.vegetarian = veg;
		this.eats = food;
		this.noOfLegs = legs;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public String getEats() {
		return eats;
	}

	public void setEats(String eats) {
		this.eats = eats;
	}

	public int getNoOfLegs() {
		return noOfLegs;
	}

	public void setNoOfLegs(int noOfLegs) {
		this.noOfLegs = noOfLegs;
	}

}
```

The Animal is the base class here. Let’s create a Cat class that inherits from Animal class.

**Subclass: Cat**
```java
package com.journaldev.inheritance;

public class Cat extends Animal{

	private String color;

	public Cat(boolean veg, String food, int legs) {
		super(veg, food, legs);
		this.color="White";
	}

	public Cat(boolean veg, String food, int legs, String color){
		super(veg, food, legs);
		this.color=color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
```

Notice that we are using `extends` keyword to implement inheritance in java.


**Java Inheritance Test Program**

Let’s write a simple test class to create a Cat object and use some of its methods.

```java
package com.journaldev.inheritance;

public class AnimalInheritanceTest {

	public static void main(String[] args) {
		Cat cat = new Cat(false, "milk", 4, "black");

		System.out.println("Cat is Vegetarian?" + cat.isVegetarian());
		System.out.println("Cat eats " + cat.getEats());
		System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
		System.out.println("Cat color is " + cat.getColor());
	}

}
```

Cat class doesn’t have getEats() method but still, the program works because it’s inherited from Animal class.


## Important Points

1. Code reuse is the most important benefit of inheritance because subclasses inherits the variables and methods of superclass.

2. Private members of superclass are not directly accessible to subclass. As in this example, Animal variable noOfLegs is not accessible to Cat class but it can be indirectly accessible via getter and setter methods.

3. Superclass members with default access is accessible to subclass ONLY if they are in same package.

4. Superclass constructors are not inherited by subclass.

5. If superclass doesn’t have default constructor, then subclass also needs to have an explicit constructor defined. Else it will throw compile time exception. In the subclass constructor, call to superclass constructor is mandatory in this case and it should be the first statement in the subclass constructor.

6. **Java doesn’t support multiple inheritance**, a subclass can extends only one class. Animal class is implicitly extending Object class and Cat is extending Animal class but due to java inheritance transitive nature, Cat class also extends Object class.

7. We can create an instance of subclass and then assign it to superclass variable, this is called **upcasting**. Below is a simple example of upcasting:
```java
Cat c = new Cat(); //subclass instance
Animal a = c; //upcasting, it's fine since Cat is also an Animal
```

8. When an instance of Superclass is assigned to a Subclass variable, then it’s called **downcasting**. We need to explicitly cast this to Subclass. For example

```java
Cat c = new Cat();
Animal a = c;
Cat c1 = (Cat) a; //explicit casting, works fine because "c" is actually of type Cat
```
Note that Compiler won’t complain even if we are doing it wrong, because of explicit casting. Below are some of the cases where it will throw `ClassCastException` at runtime.

```java
Dog d = new Dog();
Animal a = d;
Cat c1 = (Cat) a; //ClassCastException at runtime

Animal a1 = new Animal();
Cat c2 = (Cat) a1; //ClassCastException because a1 is actually of type Animal at runtime
```

9. We can override the method of Superclass in the Subclass. However we should always annotate overridden method with `@Override` annotation. The compiler will know that we are overriding a method and if something changes in the superclass method, we will get a compile-time error rather than getting unwanted results at the runtime.


10. We can call the superclass methods and access superclass variables using super keyword. It comes handy when we have the same name variable/method in the subclass but we want to access the superclass variable/method. This is also used when Constructors are defined in the superclass and subclass and we have to explicitly call the superclass constructor.

11. We can use `instanceof` instruction to check the inheritance between objects, let’s see this with below example.

```
Cat c = new Cat();
Dog d = new Dog();
Animal an = c;

boolean flag = c instanceof Cat; //normal case, returns true

flag = c instanceof Animal; // returns true since c is-an Animal too

flag = an instanceof Cat; //returns true because a is of type Cat at runtime

flag = an instanceof Dog; //returns false for obvious reasons.
```

12. We can’t extend Final classes in java.
13. If you are not going to use Superclass in the code i.e your Superclass is just a base to keep reusable code then you can keep them as Abstract class to avoid unnecessary instantiation by client classes. It will also restrict the instance creation of base class.



## Multiple Inheritance (Through Interfaces)

In Multiple inheritances, one class can have more than one superclass and inherit features from all parent classes. **Please note that Java does not support multiple inheritances with classes**. In Java, we can achieve multiple inheritances only through Interfaces.


```java
// Java program to illustrate the
// concept of Multiple inheritance
import java.io.*;
import java.lang.*;
import java.util.*;

interface one {
	public void print_geek();
}

interface two {
	public void print_for();
}

interface three extends one, two {
	public void print_geek();
}
class child implements three {
	@Override public void print_geek()
	{
		System.out.println("Geeks");
	}

	public void print_for() { System.out.println("for"); }
}

// Drived class
public class Main {
	public static void main(String[] args)
	{
		child c = new child();
		c.print_geek();
		c.print_for();
		c.print_geek();
	}
}

```




# Polymorphism


Polymorphism is considered one of the important features of Object-Oriented Programming. Polymorphism allows us to perform a single action in different ways. 

In other words, polymorphism allows you to define one interface and have multiple implementations. The word “poly” means many and “morphs” means forms, So it means many forms.


## Types of Java polymorphism
In Java polymorphism is mainly divided into two types: 
- Compile-time Polymorphism
- Runtime Polymorphism

### Compile-Time Polymorphism

It is also known as static polymorphism. This type of polymorphism is achieved by function overloading or operator overloading. 

**Note: But Java doesn’t support the Operator Overloading.**

Method Overloading
When there are multiple functions with the same name but different parameters then these functions are said to be overloaded. Functions can be overloaded by changes in the number of arguments or/and a change in the type of arguments.

```java
// Java Program for Method overloading
// By using Different Types of Arguments

// Class 1
// Helper class
class Helper {

	// Method with 2 integer parameters
	static int Multiply(int a, int b)
	{

		// Returns product of integer numbers
		return a * b;
	}

	// Method 2
	// With same name but with 2 double parameters
	static double Multiply(double a, double b)
	{

		// Returns product of double numbers
		return a * b;
	}
}

// Class 2
// Main class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{

		// Calling method by passing
		// input as in arguments
		System.out.println(Helper.Multiply(2, 4));
		System.out.println(Helper.Multiply(5.5, 6.3));
	}
}

```

```java
// Java program for Method Overloading
// by Using Different Numbers of Arguments

// Class 1
// Helper class
class Helper {

	// Method 1
	// Multiplication of 2 numbers
	static int Multiply(int a, int b)
	{

		// Return product
		return a * b;
	}

	// Method 2
	// // Multiplication of 3 numbers
	static int Multiply(int a, int b, int c)
	{

		// Return product
		return a * b * c;
	}
}

// Class 2
// Main class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{

		// Calling method by passing
		// input as in arguments
		System.out.println(Helper.Multiply(2, 4));
		System.out.println(Helper.Multiply(2, 7, 3));
	}
}
```

### Subtypes of Compile-time Polymorphism

- **Function Overloading**:
It is a feature in C++ where multiple functions can have the same name but with different parameter lists. The compiler will decide which function to call based on the number and types of arguments passed to the function.

- **Operator Overloading**:
It is a feature in C++ where the operators such as +, -, *, etc. can be given additional meanings when applied to user-defined data types. (Not in java)

- **Template**:
it is a powerful feature in C++ that allows us to write generic functions and classes. A template is a blueprint for creating a family of functions or classes. (Not in java)



### Runtime Polymorphism

It is also known as Dynamic Method Dispatch. It is a process in which a function call to the overridden method is resolved at Runtime. This type of polymorphism is achieved by Method Overriding. 

Method overriding, on the other hand, occurs when a derived class has a definition for one of the member functions of the base class. That base function is said to be overridden.

```java
// Java Program for Method Overriding

// Class 1
// Helper class
class Parent {

	// Method of parent class
	void Print()
	{

		// Print statement
		System.out.println("parent class");
	}
}

// Class 2
// Helper class
class subclass1 extends Parent {

	// Method
	void Print() { System.out.println("subclass1"); }
}

// Class 3
// Helper class
class subclass2 extends Parent {

	// Method
	void Print()
	{

		// Print statement
		System.out.println("subclass2");
	}
}

// Class 4
// Main class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{

		// Creating object of class 1
		Parent a;

		// Now we will be calling print methods
		// inside main() method

		a = new subclass1();
		a.Print();

		a = new subclass2();
		a.Print();
	}
}

```

Output
```
subclass1
subclass2
```

### Subtype of Run-time Polymorphism

Java has the concept of virtual methods, although it is the default behavior for non-static, non-final, and non-private methods in Java classes.

In Java, all non-static methods are considered to be virtual by default, which means that the actual method implementation to be executed is determined at runtime based on the actual type of the object rather than the declared type of the reference variable.

When you have a reference variable of a superclass type that points to an object of a subclass type, the actual method implementation to be executed is determined by the runtime type of the object, rather than the declared type of the reference variable.

Here's an example to illustrate dynamic method dispatch in Java:

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Cat();
        Animal animal3 = new Dog();

        animal1.makeSound();  // Output: Animal makes a sound
        animal2.makeSound();  // Output: Cat meows
        animal3.makeSound();  // Output: Dog barks
    }
}

```

Under the hood, Java achieves dynamic method dispatch and resolution of function calls in a class hierarchy through the use of a data structure called the Virtual Method Table (VMT), also known as the vtable.

When a class is loaded by the Java Virtual Machine (JVM), it creates a vtable for that class. The vtable is an array of function pointers or method references that point to the actual implementations of the methods defined in that class. Each entry in the vtable corresponds to a particular method defined in the class.

Here's a simplified explanation of how dynamic method dispatch works using the vtable:

- When an object is created, memory is allocated for the object, including space for a hidden reference to the vtable.
- Each object of a class holds a reference to the vtable associated with that class.
- When a method is invoked on an object, the JVM uses the hidden reference to access the appropriate vtable for the object's class.
- The JVM then uses the vtable to determine the address of the actual method implementation for the method being called.
- The method implementation is executed, and the result is returned.


The vtable allows the JVM to efficiently resolve method calls at runtime based on the actual type of the object. Since each class has its own vtable, the JVM can easily locate the appropriate method implementation in the vtable of the object's class, even when the method is overridden in derived classes.

It's worth noting that the vtable is built during the class loading phase and remains fixed throughout the runtime of the program. If a method is overridden in a subclass, the vtable entry for that method in the subclass will be updated to point to the overriding method's implementation.

Dynamic method dispatch and the vtable enable Java's polymorphism and the ability to call overridden methods based on the actual type of the object, providing flexibility and extensibility within the class hierarchy.


# References

https://www.digitalocean.com/community/tutorials/inheritance-java-example

https://www.geeksforgeeks.org/inheritance-in-java/

https://www.geeksforgeeks.org/polymorphism-in-java/