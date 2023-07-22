# Association

Association is a relation between two separate classes which establishes through their Objects. Association can be one-to-one, one-to-many, many-to-one, many-to-many. In Object-Oriented programming, an Object communicates to another object to use functionality and services provided by that object. Composition and Aggregation are the two forms of association. 


![Composition Aggregation Association](../Media/Associatn.png)

# Composition

The composition is a design technique in java to implement a has-a relationship. Java Inheritance is used for code reuse purposes and the same we can do by using composition. The composition is achieved by using an instance variable that refers to other objects. 

If an object contains the other object and the contained object cannot exist without the existence of that object, then it is called composition. In more specific words composition is a way of describing reference between two or more classes using instance variable and an instance should be created before it is used.


The benefits of using Composition is as follows: 

- Composition allows the reuse of code.
- Java doesn’t support multiple inheritances but by using composition we can achieve it.
- Composition offers better test-ability of a class.
- By using composition, we are flexible enough to replace the implementation of a composed class with a better and improved version.
- By using composition, we can also change the member objects at run time, to dynamically change the behaviour of your program.


Do remember the certain key points of composition in java which are as follows:

- It represents a has-a relationship.
- In composition, both entities are dependent on each other.
- When there is a composition between two entities, the composed object cannot exist without the other entity. For example, A library can have no. of books on the same or different subjects. So, If the Library gets destroyed then All books within that particular library will be destroyed. This is because books can not exist without a library.
- The composition is achieved by using an instance variable that refers to other objects.
- We have to favour Composition over Inheritance.

# Aggregation
It is a special form of Association where:  

- It represents Has-A’s relationship.
- It is a unidirectional association i.e. a one-way relationship. For example, a department can have students but vice versa is not possible and thus unidirectional in nature.
- In Aggregation, **both entries can survive individually** which means ending one entity will not affect the other entity.



# SOLID


SOLID is an acronym for the first five object-oriented design (OOD) principles by Robert C. Martin (also known as Uncle Bob).

These principles establish practices that lend to developing software with considerations for maintaining and extending as the project grows. Adopting these practices can also contribute to 
avoiding code smells, 
refactoring code, 
and Agile or Adaptive software development.

SOLID stands for:

- S - Single-responsiblity Principle
- O - Open-closed Principle
- L - Liskov Substitution Principle
- I - Interface Segregation Principle
- D - Dependency Inversion Principle


## Single-Responsiblity Principle


Single-responsibility Principle (SRP) states:

> A class should have one and only one reason to change, meaning that a class should have only one job.


For example, consider an application that takes a collection of shapes—circles, and squares—and calculates the sum of the area of all the shapes in the collection.

First, create the shape classes and have the constructors set up the required parameters.

For squares, you will need to know the `length` of a side:

```
class Square
{
    public int length;

    public function construct(int length)
    {
        this.length = length;
    }
}
```

For circles, you will need to know the `radius`:

```
class Circle
{
    public int radius;

    public function construct(int radius)
    {
        this.radius = radius;
    }
}
```


Next, create the `AreaCalculator` class and then write up the logic to sum up the areas of all provided shapes. The area of a square is calculated by length squared. The area of a circle is calculated by pi times radius squared.

```java
import java.util.ArrayList;
import java.util.List;

interface Shape {
    double calculateArea();
}

class Square implements Shape {
    protected double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return Math.pow(length, 2);
    }
}

class Circle implements Shape {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class AreaCalculator {
    private List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }

    public String output() {
        return "\nSum of the areas of provided shapes: " + sum() + "\n";
    }
}

```


To use the `AreaCalculator` class, you will need to instantiate the class and pass in an array of shapes and display the output at the bottom of the page.



Here is an example with a collection of three shapes:
a circle with a radius of 2
a square with a length of 5
a second square with a length of 6

```
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2));
        shapes.add(new Square(5));
        shapes.add(new Square(6));

        AreaCalculator areas = new AreaCalculator(shapes);

        System.out.println(areas.output());
    }
}
```


The **problem** with the output method is that the AreaCalculator handles the logic to output the data.


Consider a scenario where the output should be converted to another format like JSON.

All of the logic would be handled by the `AreaCalculator` class. This would violate the single-responsibility principle. The AreaCalculator class should only be concerned with the sum of the areas of provided shapes. It should not care whether the user wants JSON or HTML.

To address this, you can create a separate `SumCalculatorOutputter` class and use that new class to handle the logic you need to output the data to the user:

```java
import com.google.gson.Gson;

class SumCalculatorOutputter {
    private AreaCalculator calculator;

    public SumCalculatorOutputter(AreaCalculator calculator) {
        this.calculator = calculator;
    }

    public String JSON() {
        double sum = this.calculator.sum();
        Gson gson = new Gson();
        return gson.toJson(new SumData(sum));
    }

    public String HTML() {
        return "\nSum of the areas of provided shapes: " + this.calculator.sum() + "\n";
    }

    private static class SumData {
        private double sum;

        public SumData(AreaCalculator calculator) {
            this.sum = calculator.sum();
        }

        public double getSum() {
            return sum;
        }
    }
}

```

The `SumCalculatorOutputter` class would work like this:

```
public static void main(String[] args) {
    List<Shape> shapes = new ArrayList<>();
    shapes.add(new Circle(2));
    shapes.add(new Square(5));
    shapes.add(new Square(6));

    AreaCalculator areas = new AreaCalculator(shapes);
    SumCalculatorOutputter output = new SumCalculatorOutputter(areas);

    System.out.println(output.JSON());
    System.out.println(output.HTML());
}
```

Now, the logic you need to output the data to the user is handled by the SumCalculatorOutputter class.

That satisfies the single-responsibility principle.



## Open-Closed Principle

Open-closed Principle (OCP) states:

> Objects or entities should be open for extension but closed for modification.

This means that a class should be extendable without modifying the class itself.

Let’s revisit the `AreaCalculator` class and focus on the sum method:


```java
class AreaCalculator {
    private List<Shape> shapes;

    public AreaCalculator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public double sum() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                totalArea += ((Square) shape).calculateArea();
            } else if (shape instanceof Circle) {
                totalArea += ((Circle) shape).calculateArea();
            }
        }
        return totalArea;
    }
}
```


Consider a scenario where the user would like the sum of additional shapes like triangles, pentagons, hexagons, etc. You would have to constantly edit this file and add more if/else blocks. That would violate the open-closed principle.

A way you can make this sum method better is to remove the logic to calculate the area of each shape out of the AreaCalculator class method and attach it to each shape’s class.

Now, you can create another shape class and pass it in when calculating the sum without breaking the code.

However, another problem arises. How do you know that the object passed into the `AreaCalculator` is actually a shape or if the shape has a method named `area`?

Coding to an interface is an integral part of SOLID, like the above `Shape` interface.


## Liskov Substitution Principle

Liskov Substitution Principle states:

> Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

This means that every subclass or derived class should be substitutable for their base or parent class.

Building off the example `AreaCalculator` class, consider a new `VolumeCalculator` class that extends the `AreaCalculator` class:

```java
class VolumeCalculator extends AreaCalculator {
    public VolumeCalculator(List<Shape> shapes) {
        super(shapes);
    }

    public double sum() {
        double summedData = 0;
        for (Shape shape : shapes) {
           
            summedData += shape.calculateArea();   
        }
        return summedData;
    }
}
```

That satisfies the Liskov substitution principle.



## Interface Segregation Principle

Interface segregation principle states:

> A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.


Still building from the previous ShapeInterface example, you will need to support the new three-dimensional shapes of Cuboid and Spheroid, and these shapes will need to also calculate volume.

Let’s consider what would happen if you were to modify the ShapeInterface to add another contract:

```java
interface ShapeInterface {
    double area();
    double volume();
}

```

Now, any shape you create must implement the volume method, but you know that squares are flat shapes and that they do not have volumes, so this interface would force the Square class to implement a method that it has no use of.


This would violate the interface segregation principle. Instead, you could create another interface called ThreeDimensionalShapeInterface that has the volume contract and three-dimensional shapes can implement this interface:

```java
interface ShapeInterface {
    double area();
}

interface ThreeDimensionalShapeInterface {
    double volume();
}

class Cuboid implements ShapeInterface, ThreeDimensionalShapeInterface {
    @Override
    public double area() {
        // Calculate the surface area of the cuboid
        // Add your calculation logic here
    }

    @Override
    public double volume() {
        // Calculate the volume of the cuboid
        // Add your calculation logic here
    }
}

```


This is a much better approach, but a pitfall to watch out for is when type-hinting these interfaces. Instead of using a ShapeInterface or a ThreeDimensionalShapeInterface, you can create another interface, maybe ManageShapeInterface, and implement it on both the flat and three-dimensional shapes.



## Dependency Inversion Principle


Dependency inversion principle states:

> Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.


This principle allows for decoupling.

Here is an example of a `PasswordReminder` that connects to a MySQL database:


```java
class MySQLConnection {
    public String connect() {
        // Handle the database connection
        return "Database connection";
    }
}

class PasswordReminder {
    private MySQLConnection dbConnection;

    public PasswordReminder(MySQLConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}

```



while the PasswordReminder is high level, but according to the definition of D in SOLID, which states to Depend on abstraction, not on concretions. This snippet above violates this principle as the PasswordReminder class is being forced to depend on the MySQLConnection class.

Later, if you were to change the database engine, you would also have to edit the PasswordReminder class, and this would violate the open-close principle.

The PasswordReminder class should not care what database your application uses. To address these issues, you can code to an interface since high-level and low-level modules should depend on abstraction:

```java
interface DBConnectionInterface
{
    public String connect();
}
```


The interface has a connect method and the `MySQLConnection` class implements this interface. Also, instead of directly type-hinting `MySQLConnection` class in the constructor of the `PasswordReminder`, you instead type-hint the `DBConnectionInterface` and no matter the type of database your application uses, the `PasswordReminder` class can connect to the database without any problems and open-close principle is not violated.


```java
class MySQLConnection implements DBConnectionInterface {
    public String connect() {
        // Handle the database connection
        return "Database connection";
    }
}

class PasswordReminder {
    private MySQLConnection dbConnection;

    public PasswordReminder(DBConnectionInterface dbConnection) {
        this.dbConnection = dbConnection;
    }
}

```

This code establishes that both the high-level and low-level modules depend on abstraction.






# References

https://www.geeksforgeeks.org/association-composition-aggregation-java/

https://www.geeksforgeeks.org/composition-in-java/

https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design