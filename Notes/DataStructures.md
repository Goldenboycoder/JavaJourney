# Array

Array in java is a group of like-typed variables referred to by a common name. Arrays in Java work differently than they do in C/C++. 
Following are some important points about Java arrays. 

- In Java, all arrays are dynamically allocated. (discussed below)
- Arrays are stored in contiguous memory [consecutive memory locations].
- Since arrays are objects in Java, we can find their length using the object property length. This is different from C/C++, where we find length using sizeof.
- A Java array variable can also be declared like other variables with [] after the data type.
- The variables in the array are ordered, and each has an index beginning with 0.
- Java array can also be used as a static field, a local variable, or a method parameter.
- The size of an array must be specified by int or short value and not long.
- The direct superclass of an array type is Object.
- Every array type implements the interfaces Cloneable and java.io.Serializable. 
- This storage of arrays helps us randomly access the elements of an array [Support Random Access].
- The size of the array cannot be altered(once initialized).  However, an array reference can be made to point to another array.

An array can contain primitives (int, char, etc.) and object (or non-primitive) references of a class depending on the definition of the array. In the case of primitive data types, the actual values are stored in contiguous memory locations. In the case of class objects, **the actual objects are stored in a heap segment**. 

## Creating, initializing, and accessing an Array

The general form of a one-dimensional array declaration is 
```
type var-name[];
OR
type[] var-name;
```

An array declaration has two components: the type and the name. type declares the element type of the array. The element type determines the data type of each element that comprises the array. Like an array of integers, we can also create an array of other primitive data types like char, float, double, etc., or user-defined data types (objects of a class). Thus, the element type for the array determines what type of data the array will hold. 


```
// both are valid declarations
int intArray[]; 
or int[] intArray; 

byte byteArray[];
short shortsArray[];
boolean booleanArray[];
long longArray[];
float floatArray[];
double doubleArray[];
char charArray[];

// an array of references to objects of
// the class MyClass (a class created by
// user)
MyClass myClassArray[]; 

Object[]  ao,        // array of Object
Collection[] ca;  // array of Collection
                     // of unknown type
```

Although the first declaration establishes that int Array is an array variable, no actual array exists. It merely tells the compiler that this variable (int Array) will hold an array of the integer type. To link int Array with an actual, physical array of integers, you must allocate one using new and assign it to int Array. 

## Instantiating an Array in Java

When an array is declared, only a reference of an array is created. To create or give memory to the array, you create an array like this: The general form of new as it applies to one-dimensional arrays appears as follows: 
```
var-name = new type [size];
```

Here, type specifies the type of data being allocated, size determines the number of elements in the array, and var-name is the name of the array variable that is linked to the array. To use new to allocate an array, you must specify the type and number of elements to allocate.

Example: 
```java
int intArray[];    //declaring array
intArray = new int[20];  // allocating memory to array

//OR 

int[] intArray = new int[20]; // combining both statements in one
```
**N.B**: The elements in the array allocated by new will automatically be initialized to zero (for numeric types), false (for boolean), or null (for reference types).
Obtaining an array is a two-step process. First, you must declare a variable of the desired array type. Second, you must allocate the memory to hold the array, using new, and assign it to the array variable. Thus, in Java, **all arrays are dynamically allocated**.



### Array Literal

In a situation where the size of the array and variables of the array are already known, array literals can be used. 
```java
 int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
 // Declaring array literal
```

The length of this array determines the length of the created array.
There is no need to write the new int[] part in the latest versions of Java.


### Accessing Java Array Elements using for Loop

Each element in the array is accessed via its index. The index begins with 0 and ends at (total array size)-1. All the elements of array can be accessed using Java for Loop.
```java
 // accessing the elements of the specified array
for (int i = 0; i < arr.length; i++)
  System.out.println("Element at index " + i + " : "+ arr[i]);
```

### Arrays of Objects
An array of objects is created like an array of primitive-type data items in the following way. 
```
Student[] arr = new Student[5]; //student is a user-defined class
```
Syntax:

1. data type[] arrName;

2. datatype arrName[];

3. datatype [] arrName;


### What happens if we try to access elements outside the array size?

JVM throws ArrayIndexOutOfBoundsException to indicate that the array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of an array.

Below code shows what happens if we try to access elements outside the array size.

```java
// Code for showing error "ArrayIndexOutOfBoundsException"

public class GFG {
	public static void main(String[] args)
	{
		int[] arr = new int[4];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;

		System.out.println(
			"Trying to access element outside the size of array");
		System.out.println(arr[5]);
	}
}

```
Output
```
Trying to access element outside the size of array
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4
```


## Multi Dimensional Arrays

In such case, data is stored in row and column based index (also known as matrix form).

Syntax to Declare Multidimensional Array in Java

dataType[][] arrayRefVar; (or)  
dataType [][]arrayRefVar; (or)  
dataType arrayRefVar[][]; (or)  
dataType []arrayRefVar[];  

Example to instantiate Multidimensional Array in Java
```java
int[][] arr=new int[3][3];//3 row and 3 column  
```
Example to initialize Multidimensional Array in Java
```java
arr[0][0]=1;  
arr[0][1]=2;  
arr[0][2]=3;  
arr[1][0]=4;  
arr[1][1]=5;  
arr[1][2]=6;  
arr[2][0]=7;  
arr[2][1]=8;  
arr[2][2]=9;  
```

Example of Multidimensional Java Array
Let's see the simple example to declare, instantiate, initialize and print the 2Dimensional array.
```java
//Java Program to illustrate the use of multidimensional array  
class Testarray3{  
public static void main(String args[]){  
//declaring and initializing 2D array  
int arr[][]={{1,2,3},{2,4,5},{4,4,5}};  
//printing 2D array  
for(int i=0;i<3;i++){  
 for(int j=0;j<3;j++){  
   System.out.print(arr[i][j]+" ");  
 }  
 System.out.println();  
}  
}}  
```
Output
```
1 2 3
2 4 5
4 4 5
```

### Jagged Array in Java

If we are creating different number of columns in a 2D array, it is known as a jagged array. In other words, it is an array of arrays with different number of columns.


```java
//Java Program to illustrate the jagged array  
class TestJaggedArray{  
    public static void main(String[] args){  
        //declaring a 2D array with odd columns  
        int arr[][] = new int[3][];  
        arr[0] = new int[3];  
        arr[1] = new int[4];  
        arr[2] = new int[2];  
        //initializing a jagged array  
        int count = 0;  
        for (int i=0; i<arr.length; i++)  
            for(int j=0; j<arr[i].length; j++)  
                arr[i][j] = count++;  
   
        //printing the data of a jagged array   
        for (int i=0; i<arr.length; i++){  
            for (int j=0; j<arr[i].length; j++){  
                System.out.print(arr[i][j]+" ");  
            }  
            System.out.println();//new line  
        }  
    }  
}  
```

Output
```
0 1 2 
3 4 5 6 
7 8 
```

## Passing Arrays to methods

Like variables, we can also pass arrays to methods. For example, the below program passes the array to method sum to calculate the sum of the array’s values.

```java
// Java program to demonstrate
// passing of array to method

public class Test {
	// Driver method
	public static void main(String args[])
	{
		int arr[] = { 3, 1, 2, 5, 4 };

		// passing array to method m1
		sum(arr);
	}

	public static void sum(int[] arr)
	{
		// getting sum of array values
		int sum = 0;

		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		System.out.println("sum of array values : " + sum);
	}
}

```


### Returning Arrays from Methods
As usual, a method can also return an array. For example, the below program returns an array from method m1. 

```java
// Java program to demonstrate
// return of array from method

class Test {
	// Driver method
	public static void main(String args[])
	{
		int arr[] = m1();

		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static int[] m1()
	{
		// returning array
		return new int[] { 1, 2, 3 };
	}
}

```


### Cloning of arrays

When you clone a single-dimensional array, such as Object[], a “deep copy” is performed with the new array containing copies of the original array’s elements as opposed to references.

```java
// Java program to demonstrate
// cloning of one-dimensional arrays

class Test {
	public static void main(String args[])
	{
		int intArray[] = { 1, 2, 3 };

		int cloneArray[] = intArray.clone();

		// will print false as deep copy is created
		// for one-dimensional array
		System.out.println(intArray == cloneArray);

		for (int i = 0; i < cloneArray.length; i++) {
			System.out.print(cloneArray[i] + " ");
		}
	}
}

```
Output
```
false
1 2 3 
```


A clone of a multi-dimensional array (like Object[][]) is a “shallow copy,” however, which is to say that it creates only a single new array with each element array a reference to an original element array, but subarrays are shared. 

```java
// Java program to demonstrate
// cloning of multi-dimensional arrays

class Test {
	public static void main(String args[])
	{
		int intArray[][] = { { 1, 2, 3 }, { 4, 5 } };

		int cloneArray[][] = intArray.clone();

		// will print false
		System.out.println(intArray == cloneArray);

		// will print true as shallow copy is created
		// i.e. sub-arrays are shared
		System.out.println(intArray[0] == cloneArray[0]);
		System.out.println(intArray[1] == cloneArray[1]);
	}
}

```
Output
```
false
true
true
```

# Collection Interface

# List



# References

https://www.geeksforgeeks.org/arrays-in-java/

https://www.javatpoint.com/array-in-java
