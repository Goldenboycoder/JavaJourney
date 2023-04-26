# What are Data Types in Java?

Java is statically typed and also a strongly typed language because, in Java, each type of data (such as integer, character, hexadecimal, packed decimal, and so forth) is predefined as part of the programming language and all constants or variables defined for a given program must be described with one of the data types.

Data types in Java are of different sizes and values that can be stored in the variable that is made as per convenience and circumstances to cover up all test cases. Java has two categories in which data types are segregated 

1. **Primitive Data Type**: such as boolean, char, int, short, byte, long, float, and double
2. **Non-Primitive Data Type or Object Data type**: such as String, Array, etc.



## Primitive Data Types in Java

Primitive data are only single values and have no special capabilities.  There are 8 primitive data types. They are depicted below in tabular format below as follows:

| Type | Description | Default | Size | Example Literals | Range of Values |
| :--: |    :--:     |  :--:   | :--: |      :--:        |      :--:       |
| boolean | true or false | false | 1 bit | true, false | true, false |
| byte  | twos-complement integer | 0 | 8 bits | (none) | -128 to 127 |
| char  | Unicode character | \u0000 | 16 bits | ‘a’, ‘\u0041’, ‘\101’, '\\\\',‘\’, ‘\n’, ‘β’ | characters representation of ASCII values 0 to 255 |
| short | twos-complement integer | 0 | 16 bits | (none) | -32,768 to 32,767 |
| int | twos-complement integer | 0 | 32 bits | -2,-1,0,1,2 | -2,147,483,648 to 2,147,483,647 |
| long | twos-complement integer | 0 | 64 bits | -2L,-1L,0L,1L,2L | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| float | IEEE 754 floating point | 0.0 | 32 bits | 1.23e100f , -1.23e-100f , .3f ,3.14F | up to 7 decimal digits |
| double | IEEE 754 floating point | 0.0 | 64 bits | 1.23456e300d , -123456e-300d , 1e1d | up to 16 decimal digits |
---

</br></br>

Let us discuss and implement each one of the following data types that are as follows:


### Boolean

Boolean data type represents only one bit of information either true or false which is intended to represent the two truth values of logic and Boolean algebra, but the size of the boolean data type is virtual machine-dependent. Values of type boolean are not converted implicitly or explicitly (with casts) to any other type. But the programmer can easily write conversion code.

Syntax: 
```java
boolean booleanVar;
```
Size: Virtual machine dependent

### Byte Data Type
The byte data type is an 8-bit signed two’s complement integer. The byte data type is useful for saving memory in large arrays.

Syntax: 
```java
byte byteVar;
```
Size: 1 byte (8 bits)

### Short Data Type
The short data type is a 16-bit signed two’s complement integer. Similar to byte, use a short to save memory in large arrays, in situations where the memory savings actually matters.

Syntax: 
```java
short shortVar;
```
Size: 2 bytes (16 bits)

### Integer Data Type
It is a 32-bit signed two’s complement integer.

Syntax: 
```java
int intVar;
```
Size: 4 bytes ( 32 bits )

**N.B**: In Java SE 8 and later, we can use the int data type to represent an unsigned 32-bit integer, which has a value in the range [0, 2^(32)-1]. Use the Integer class to use the int data type as an unsigned integer. 


### Long Data Type
The range of a long is quite large. The long data type is a 64-bit two’s complement integer and is useful for those occasions where an int type is not large enough to hold the desired value. The size of the Long Datatype is 8 bytes (64 bits).

Syntax: 
```java
long longVar;
```

**N.B**: In Java SE 8 and later, you can use the long data type to represent an unsigned 64-bit long, which has a minimum value of 0 and a maximum value of 2^(64)-1. The Long class also contains methods like comparing Unsigned, divide Unsigned, etc to support arithmetic operations for unsigned long. 


### Float Data Type
The float data type is a single-precision 32-bit IEEE 754 floating-point. Use a float (instead of double) if you need to save memory in large arrays of floating-point numbers. The size of the float data type is 4 bytes (32 bits).

Syntax: 
```java
float floatVar;
```

### Double Data Type
The double data type is a double-precision 64-bit IEEE 754 floating-point. For decimal values, this data type is generally the default choice. The size of the double data type is 8 bytes or 64 bits.

Syntax:
```java
double doubleVar;
```

**N.B**: Both float and double data types were designed especially for scientific calculations, where approximation errors are acceptable. If accuracy is the most prior concern then, it is recommended not to use these data types and use BigDecimal class instead. 

It is recommended to go through [rounding off errors in java](https://www.geeksforgeeks.org/rounding-off-errors-java/).


### Char Data Type
The char data type is a single 16-bit Unicode character with the size of 2 bytes (16 bits).

Syntax: 
```java
char charVar;
```

#### Why is the Size of char 2 bytes in Java? 
So, other languages like C/C++ use only ASCII characters, and to represent all ASCII characters 8 bits is enough. But java uses the Unicode system not the ASCII code system and to represent the Unicode system 8 bits is not enough to represent all characters so java uses 2 bytes for characters. Unicode defines a fully international character set that can represent most of the world’s written languages. It is a unification of dozens of character sets, such as Latin, Greek, Cyrillic, Katakana, Arabic, and many more.


```java
// Java Program to Demonstrate Char Primitive Data Type

// Class
class GFG {

	// Main driver method
	public static void main(String args[])
	{

		// Creating and initializing custom character
		char a = 'G';

		// Integer data type is generally
		// used for numeric values
		int i = 89;

		// use byte and short
		// if memory is a constraint
		byte b = 4;

		// this will give error as number is
		// larger than byte range
		// byte b1 = 7888888955;

		short s = 56;

		// this will give error as number is
		// larger than short range
		// short s1 = 87878787878;

		// by default fraction value
		// is double in java
		double d = 4.355453532;

		// for float use 'f' as suffix as standard
		float f = 4.7333434f;

		// need to hold big range of numbers then we need
		// this data type
		long l = 12121;

		System.out.println("char: " + a);
		System.out.println("integer: " + i);
		System.out.println("byte: " + b);
		System.out.println("short: " + s);
		System.out.println("float: " + f);
		System.out.println("double: " + d);
		System.out.println("long: " + l);
	}
}

```
```
Output
char: G
integer: 89
byte: 4
short: 56
float: 4.7333436
double: 4.355453532
long: 12121
```

## Non-Primitive data types or Reference Data types

In Java, non-primitive data types are known as reference types. In other words, a variable of class type is called reference data type. It contains the address (or reference) of dynamically created objects. For example, if Demo is a class and we have created its object d, then the variable d is known as a reference type.

It refers to objects. It is not pre-defined. It is created by the programmer if required. The reference types hold the references of objects. All reference types are a subclass of type `java.lang.Object`. It provides access to the objects stored in the memory.

The examples of reference data types are class, interface, String, Arrays, etc.

There are the following five types of reference types in Java:
| Reference Type | Description |
|:--:|:--:|
| Class | It is a set of instructions. It describes the content of the object. |
| Array | It provides the fixed-size data structure that stores the elements of the same type. |
| Annotations | It provides a way to associate metadata with program elements. |
| Interface | It is implemented by Java classes. |
| Enumeration | It is a special kind of class that is type-safe. Each element inside the enum is an instance of that enum. |


### Reference vs Primitive Data Types

| Reference Type | Primitive Type |
|:--:|:--:|
| It is not pre-defined except the String | It is pre-defined in Java |
| It is not pre-defined except the String | It is pre-defined in Java |
| All reference type begins with Uppercase letter | All primitive type begins with a lowercase letter|
| Non-primitive types have all the same size | The size of a primitive type depends on the data type |
| It is used to invoke or call methods | We cannot invoke the method with a primitive type |
| It can be null | It cannot be null. It always has value |
| Examples of reference data types are class, Arrays, String, Interface, etc | Examples of primitive data types are int, float, double, Boolean, long, etc |
| JVM allocates 8 bytes for each reference variable, by default | Its size depends on the data type |
| Example: Demo d1; | Example: int num=78; |



### Memory Allocation and Garbage Collection
In Java, the new keyword is used to create an instance of the class. In other words, it instantiates a class by allocating memory for a new object and returning a reference to that memory. Objects occupy memory in the Java heap space. We can also use the new keyword to create the array object.
```java
ClassName objectName = new ClassName();  
```
If there are no references to an object, the memory used by that object can be reclaimed during the garbage collection process.

### Conversion Between Primitive Type and Reference Type

The conversion of primitive type to reference type is called [autoboxing](https://www.javatpoint.com/autoboxing-and-unboxing) and the conversion of reference type to primitive type is called unboxing.

The automatic conversion of primitive data types into its equivalent Wrapper type is known as boxing and opposite operation is known as unboxing. This is the new feature of Java5. So java programmer doesn't need to write the conversion code.

Examples:

Boxing
```java
class BoxingExample1{  
  public static void main(String args[]){  
    int a=50;  
	Integer a2=new Integer(a);//Boxing  

	Integer a3=5;//Boxing  
		
	System.out.println(a2+" "+a3);  
 }   
}  
```

Unboxing

```java
class UnboxingExample1{  
  public static void main(String args[]){  
    Integer i=new Integer(50);  
	int a=i;  // unboxing
		
	System.out.println(a);  
 }   
}  
```

Internal unboxing
```java
class UnboxingExample2{  
  public static void main(String args[]){  
    Integer i=new Integer(50);  
          
	if(i<100){            //unboxing internally  
	System.out.println(i);  
	}  
 }   
}  
```

### Autoboxing/Unboxing Rules


In method overloading, boxing and unboxing can be performed. There are some rules for method overloading with boxing:
- Widening beats boxing
- Widening beats varargs
- Boxing beats varargs



#### Example of Autoboxing where widening beats boxing 
If there is possibility of widening and boxing, widening beats boxing.

```java
class Boxing1{  
	static void m(int i){System.out.println("int");}  
	static void m(Integer i){System.out.println("Integer");}  
  
  	public static void main(String args[]){  
		short s=30;  
		m(s);  
 	}   
}  
```
Output
```
int
```

#### Example of Autoboxing where widening beats varargs

If there is possibility of widening and varargs, widening beats var-args.

```java
class Boxing2{  
  static void m(int i, int i2){System.out.println("int int");}  
  static void m(Integer... i){System.out.println("Integer...");}  
  
  public static void main(String args[]){  
   short s1=30,s2=40;  
   m(s1,s2);  
 }   
}  
```
Output
```
int int
```

#### Example of Autoboxing where boxing beats varargs

Let's see the program where boxing beats variable argument:
```java   
class Boxing3{  
  static void m(Integer i){System.out.println("Integer");}  
  static void m(Integer... i){System.out.println("Integer...");}  
  
  public static void main(String args[]){  
   int a=30;  
   m(a);  
 }   
}  
```
Output
```
Integer
```

#### Method overloading with Widening and Boxing

Widening and Boxing can't be performed as given below:

```java
class Boxing4{  
  static void m(Long l){System.out.println("Long");}  
  
  public static void main(String args[]){  
   int a=30;  
   m(a);  
 }   
}  
```
Output
```
Compile Time Error
```


### Comparing Reference types

We can also compare the reference types in Java. Java provides two ways to compare reference types:

#### By using the equal (==) operator

It compares the memory locations of the objects. If the memory address (reference) of both objects is the same, the objects are equal. 

**Note** that it does not compare the contents of the object. For example:
```java
Demo d1 = new Demo("Atlanta"); //creating a reference of Demo class  
Demo d2 = d1; //assigning the reference d1 into d2  
if(d1==d2) //comparing reference   
```

#### By using the String.equals() Method

The method belongs to the String class. It overrides the equals() method of the Object class. It also uses the equal operator (==) for comparing the reference type. For example, consider the following code snippet:

```java
String str1="JAVA";    
String str2="JAVA";    
String str3="java";    
System.out.println(str1.equals(str2));     //returns true because content and case is same    
System.out.println(str1.equals(str3));   //returns false because case is not same    
```


### Copying Reference Type

There are two possibilities when we copy reference types, either a copy of the reference to an object is made or an actual copy (creating a new copy) of the object is made.

In the following example, we have assigned a reference to the object. If we made any changes in the object, it will also reflect the reference and vice-versa.

```java
Sum s1 = new Sum();  
Sum s2= s1;  
```


### Casting

Type casting is when you assign a value of one primitive data type to another type.

In Java, there are two types of casting:
**Widening Casting (automatically)** - converting a smaller type to a larger type size
```
	byte -> short -> char -> int -> long -> float -> double
```

**Narrowing Casting (manually)** - converting a larger type to a smaller size type
```
	double -> float -> long -> int -> char -> short -> byte
```
```java
int myInt = (int) myDouble; // Manual casting: double to int
```

## Final Variables

In Java, we can use final keyword with variables, methods, and classes. When the final keyword is used with a variable of primitive data types such as int, float, etc... , the value of the variable cannot be changed. 

Example 1: Usage of final with primitive datatype

```java
// Java Program to illustrate Use of Final Keyword
// With Primitive Datatypes

// Main class
class GFG {

	// Main driver method
	public static void main(String args[])
	{

		// Final primitive variable
		final int i = 10;
		i = 30;

		// Error will be generated above
	}
}

```

error: cannot assign a value to final variable

Now you must be wondering what if we do use final keyword non-primitive variables, let us explore the same as we did above with the help of an example. 

**Note**: Non-primitive variables are always references to objects in Java, the members of the referred object can be changed. final for non-primitive variables just means that they cannot be changed to refer to any other object.

Example 2: Usage of final with primitive datatype 

```java
// Java Program to illustrate Use of Final Keyword
// With Primitive Datatypes

// Class 1
class Helper {
	int i = 10;
}

// Class 2
// main class
class GFG {

	// Main driver method
	public static void main(String args[])
	{

		final Helper t1 = new Helper();
		t1.i = 30; // Works

		// Print statement for successful execution of
		// Program
		System.out.print("Successfully executed");
	}
}

```
Output
```
Successfully executed
```

A final variable that have no value it is called blank final variable or uninitialized final variable. It can be initialized **in the constructor only**. 

The blank final variable **can be static** also which will be **initialized in the static block only**. We will have detailed learning of these. Let's first learn the basics of final keyword.



### Java final method
If you make any method as final, you cannot override it.

Example of final method
```java
class Bike{  
  final void run(){System.out.println("running");}  
}  
     
class Honda extends Bike{  
   void run(){System.out.println("running safely with 100kmph");}  
     
   public static void main(String args[]){  
   Honda honda= new Honda();  
   honda.run();  
   }  
}  
```
Output
```
Compile Time Error
```

### Java final class
If you make any class as final, you cannot extend it.

Example of final class
```java
final class Bike{}  
  
class Honda1 extends Bike{  
  void run(){System.out.println("running safely with 100kmph");}  
    
  public static void main(String args[]){  
  Honda1 honda= new Honda1();  
  honda.run();  
  }  
}  
```

1. **Q**:Is final method inherited?
	- **A**: Yes, final method is inherited but you cannot override it.

2. **Q**: Can we initialize blank final variable?
	- **A**: Yes, but only in constructor

3. **Q**: What is final parameter?
	- **A**: If you declare any parameter as final, you cannot change the value of it.

4. **Q**: Can we declare a constructor final?
	- **A**: No, because constructor is never inherited.


## Local variable inference

Java 10 introduced a new feature called local variable type inference, which allows you to use the keyword `var` in front of a new variable.

With this feature, Java will infer (that is, guess automatically) the data type from the local context. Type inference is controversial since it contrasts the previously explained verbosity of defining variables. 

The advantages and disadvantages of such a feature are disputable, but the fact is that other statically typed languages, such as C++, support type inference.


In any case, type inference cannot completely replace the use of data types because it works only with local variables, which are variables inside a method. Let’s look at an example with `var`:
```java
var hello = "Hello";
System.out.println(hello);
```
You declare the variable hello with the var keyword in order to instruct Java to detect its data type. 
After that, you print it to the console in the usual way to confirm it works as expected

Type inference happens during the compilation process — that is, when you compile the code. 

The compilation process turns plain text source code into machine code and applies various optimizations, including type inference. This ensures that the correct amount of system memory is available for the type inferred variables. 

Thus, the machine code that you run after compiling is fully optimized, as if you have manually specified all the data types.


In this example, the `var` keyword works because the variable is local, and the `var` data type works only with local variables. Local variables are defined inside methods and are accessible only inside the methods, which is why they’re called “local”.

To show that `var` can only be used for local variables, try placing it outside the main method, like so:

```java
public class Hello {
	var hello = "Hello";
	public static void main(String[] args) {
		// example code
	}
}
```

Output
```
|  Error:
|  'var' is not allowed here
|  	var hello = "Hello";
|   ^-^
```

`var` is not allowed there because hello is outside a method and it is no longer considered local. Thus, type inference does not work for non-local variables because the context cannot be used reliably to detect the data type.

While using `var` can be challenging and is not required, you will likely come across it so it is useful to know about it.


## Reserved Keywords

When declaring variables in Java, there is one more important rule to know. There are reserved keywords that you cannot use for variables names. For example, you cannot declare a primitive of type `int` and name it `new`like this:
```java
int new = 1;
```
If you try this example, you will get compilation errors because `new` is a reserved keyword.

Output
```
|  Error:
|  '.class' expected
|  int new = 1;
|      ^
|  Error:
|  <identifier> expected
|  int new = 1;
|         ^
|  Error:
|  '(' or '[' expected
|  int new = 1;
|          ^
|  Error:
|  unexpected type
|    required: value
|    found:    class
|  int new = 1;
|  ^--^
|  Error:
|  missing return statement
|  int new = 1;
|  ^----------^
```

The keyword new is used for creating new objects and Java is not expecting it at this position. In the list of errors in the previous output, the first part is the most important:

Output
```
|  Error:
|  '.class' expected
|  int new = 1;
|      ^
```

The error `'.class' expected` means that when you use the `new` keyword, Java expects that a class will follow. At this point, Java is not able to interpret the statement and the rest of the errors follow.


The rest of the reserved keywords, such as `abstract`, `continue`, `default`, `for`, and `break`, also have specific meanings in Java and cannot be used for variables names. 

The full list of the reserved keywords can be found on [the Java Language Keywords page](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html). Even if you don’t remember all the reserved keywords, you can use compilation errors to identify the issue.

# References

https://www.geeksforgeeks.org/data-types-in-java/

https://www.javatpoint.com/java-data-types

https://www.javatpoint.com/reference-data-types-in-java

https://www.javatpoint.com/autoboxing-and-unboxing

https://www.geeksforgeeks.org/final-variables-in-java/

https://www.javatpoint.com/final-keyword

https://www.digitalocean.com/community/tutorials/understanding-data-types-in-java