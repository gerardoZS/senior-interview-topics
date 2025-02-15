# Object Oriented Programming Principles

The OOP have four principles: Abstraction, Encapsulation, Inheritance, and Polymorphism

## Abstraction

The abstraction principle guides us in defining what an object is for but hides the complexity of implementation details. In this way, we can use an object to obtain a service without thinking about how that object internally works. The abstraction aims to model real-world objects defining their responsibility and intent through name and public interface.

 I can relate this principle to the Single Responsibility, Liskov substitution, and Dependency Inversion SOLID principles. 

## Encapsulation
The encapsulation principle states that we must protect an object's data from direct access by the outside world. Some data can be accessed through public methods and others can be completely hidden. 

## Inheritance
The inheritance principle brings a way for extensibility, reusability, and "high cohesion". I can relate this principle to the Open-closed design principle. With inheritance, based on a type (class or interface), we can create subtypes that inherit shared attributes and methods, obtaining specialized pieces of software without code duplication that can augment or override behavior.


## Polymorphism
The polymorphism principle states that a reference variable can adopt "multiple forms". This is, in the code a reference variable of a type can refer to an object of the same type or an object of a subtype, and in compile time that reference variable behaves according to the public interface of its declared type, but in runtime the variable will behave according to the actual referenced object. That allows the invocation of methods of specific objects through generic references.