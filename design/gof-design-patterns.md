# Gang of Four (GoF) Design Patterns

Gang of Four Design Patterns is a collection of 23 design patterns from the book “Design Patterns: Elements of Reusable Object-Oriented Software” published in 1994 by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides.

A design pattern is a well-proven solution for a particular object-oriented design problem, so, it describes when it applies, the interfaces and classes required to implement it (and how they are related), and its trade-offs. There is no one best pattern, and its selection must be based on the design problem and context. Multiple design patterns can solve the same problem.

The GoF Design Patterns are divided into three categories:

- **Behavioral**: Describe how objects **interact** and distribute **responsability**.
- **Creational**: Provide strategies to create objects. 
- **Structural**: Discuss how objects are wired together.

Below I will talk about some GoF design patterns I have used as a software developer.

## Behavioral patterns

### Strategy

The Strategy pattern changed my life as Software Developer! I don't lie.

After finishing my university education I had no clear idea about OOP principles, so I used Java in a structuring programming fashion. At my second job, my boss, who was an architect, asked me to build a prototype that retrieves XML messages from a queue and sends them to different targets according to metadata contained in each XML message. I began to build the solution and I made a mess... The solution was too complicated and didn't work (I was using reflection...). My boss explained to me that in my MessageProcessor class, I should use an interface called MessageSender that defines a method for sending the message. Then I should implement different sending strategies in concrete classes such as EmailMessageSender, SmsMessageSender, and so on. The interface represents the intent, sending a message (this is abstraction), allowing the client class to use a generic reference at compile time for invoking concrete strategies of an algorithm at runtime (this is polymorphism); and finally concrete classes implement the interface (this is inheritance).  

The Strategy pattern groups a family of algorithms for interchangeable use. This sounds like the Liskov substitution principle, isn't it?

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
