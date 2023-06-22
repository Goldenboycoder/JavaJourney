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

# References

https://www.geeksforgeeks.org/association-composition-aggregation-java/

https://www.geeksforgeeks.org/composition-in-java/