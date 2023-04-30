# Precedence and Associativity of Operators


Precedence and associative rules are used when dealing with hybrid equations involving more than one type of operator. In such cases, these rules determine which part of the equation to consider first, as there can be many different valuations for the same equation. The below table depicts the precedence of operators in decreasing order as magnitude, with the top representing the highest precedence and the bottom showing the lowest precedence.





| Operators | Associativity | Type |
|:--- | :---: | :---: |
| `++` `--` | Right to left | Unary postfix |
| `++` `--` `+` `-` `!` (type) |  Right to left | Unary prefix |
| `/` `*` `%` | Left to right | Multiplicative |
| `+` `-` | Left to right | Additive |
| `<` `<=` `>` `>=` | Left to right | Relational |
| `==` `!==` | Left to right | Equality |
| `&` | Left to right | Boolean Logical AND |
| `^` | Left to right | Boolean Logical Exclusive OR |
| `\|` | Left to right | Boolean Logical Inclusive OR |
| `&&` | Left to right | Conditional AND |
| `\|\|` | Left to right | Conditional OR |
| `?:` | Right to left | Conditional |
| `=` `+=` `-=` `*=` `/=` `%=` | Right to left | Assignment |





# References

https://www.geeksforgeeks.org/operators-in-java/

https://www.javatpoint.com/operators-in-java