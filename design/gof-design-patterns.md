# Gang of Four (GoF) Design Patterns

Gang of Four Design Patterns is a collection of 23 design patterns from the book “Design Patterns: Elements of Reusable Object-Oriented Software” published in 1994 by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides.

    A design pattern is a well-proven solution for a particular object-oriented design problem, so, it describes when it applies and its trade-offs. There is no one best pattern, and its selection must be based on the design problem and context. Multiple design patterns can solve the same problem.

The GoF Design Patterns are divided into three categories:

- **Behavioral**: Describe how objects **interact** and distribute **responsability**.
- **Creational**: Provide strategies to create objects. 
- **Structural**: Discuss how objects are wired together.

Below I will describe some of the GoF design patterns I have used as a software developer.

## Behavioral patterns

### Strategy

The Strategy pattern groups a family of algorithms for interchangeable use. I think that is the simplest pattern that illustrates the OOP principles: A client class uses an abstract type for doing "a task", and we can have several implementations of that abstract type to provide different strategies to perform the task. 

For example, maybe we need to send a message. We can have different strategies to send the message such as email, SMS, push notification, etc.


### Observer


## Creationals 

### Singleton
### Builder
### Factory method
### Abstract Factory


## Structurals

### Facade
### Adapter
### Decorator
