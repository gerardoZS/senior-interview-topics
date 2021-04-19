# What is Spring Boot?
Spring Boot helps you to create stand-alone, production-grade Spring-based Applications that you can run. We take an 
opinionated view of the Spring platform and third-party libraries, so that you can get started with minimum fuss.
Most Spring Boot applications need very little Spring configuration.

Also provide a command line tool that runs “spring scripts”.

## Getting Started

Primary goals are:
- Provide a radically faster and widely accessible getting-started experience for all Spring development.
- Provide a range of non-functional features that are common to large classes of projects 
  (such as embedded servers, security, metrics, health checks, and externalized configuration).
- Absolutely no code generation and no requirement for XML configuration.

> **Current Version:** Spring Boot 2.4.5
> 
> Requirements:
> - Java 8 (is compatible up to Java 16)
> - Spring Framework 5.3.6 or above
> 
> Supported build tools:
> - Maven 3.3 or above
> - Gradle 6.3 or above
> 
> Supported Servlet Containers:
> - Tomcat 9.0 (Servlet 4.0)
> - Jetty 9.4 (Servlet 3.1)
> - Undertow 2.0 (Servlet 4.0)

### Maven Installation
Spring Boot dependencies use the `org.springframework.boot` *groupId*. Typically, your Maven POM file inherits from the
`spring-boot-starter-parent` project and declares dependencies to one or more “Starters”. Spring Boot also provides an
optional Maven plugin to create executable jars.

### Gradle Installation
Spring Boot dependencies can be declared by using the `org.springframework.boot` *group*. Typically, your project
declares dependencies to one or more “Starters”. Spring Boot provides a useful Gradle plugin that can be used to
simplify dependency declarations and to create executable jars.

> **IMPORTANT**
> 
> Since this point, this article assumes that we will use Maven like build tool.

### Adding Classpath Dependencies
Spring Boot provides a number of “Starters” that let you add jars to your classpath. The parent project 
`spring-boot-starter-parent` is considered also a starter. It provides useful Maven defaults, such a 
`dependency-management` section so that you can omit version tags for “blessed” dependencies.

Other “Starters” provide dependencies that you are likely to need when developing a specific type of application. For
example, for developing a RESTful API will use the `spring-boot-starter-web` dependency.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

> The `mvn dependency:tree` command prints a tree representation of your project dependencies.

### The @RestController and @RequestMapping annotations
The `@RestController` is known as a *stereotype* annotation, which means that it provides hints for people reading the
code and for Spring that the class plays a specific role. The `@RestController` indicates that a class is a REST
controller, so Spring considers it when handling incoming web requests.

The `@RequestMapping` tells Spring that any HTTP requests that match with the specified path should be mapped to the 
annotated method.

### The @EnableAutoConfiguration annotation
This annotation tells Spring Boot to “guess” how you want to configure Spring, based on the project's jar dependencies.
For example, the `spring-boot-starter-web` dependency adds Tomcat and Spring MVC, so the auto-configuration assumes that
you are developing a web application and sets up Spring accordingly.

> **Starters and Auto-configuration**
> Auto-configuration is designed to work well with “Starters”, but the two concepts are not directly tied. You are free
> to pick and choose jar dependencies outside of the starters. Spring Boot still does its best to auto-configure your
> application.

### The main method
The `main` method is the entry point of a Java application. In Spring Boot the `main` method must invoke the 
`SpringApplication.run` method. `SpringApplication` bootstraps the application, starting Spring, which, in turn, starts
the auto-configuration process.

```java
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class, args);
    }
}
```

### Running a Spring Boot application
Spring Boot provides the useful `spring-boot-maven-plugin` maven plugin that allows:

- Run Spring Boot applications.
- Package executable jar or war archives.
- Generate build information and start your Spring Boot application prior to running integration tests.

If, as usual, the application's POM inherits from `spring-boot-starter-parent`, the project inherits the 
`<pluginManagement>` section, but to use the plugin is necessary to set it up in the `<build>` section as follows:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

The `spring-boot-maven-plugin` plugin provides the goal `spring-boot:run` for running a Spring Boot application.

### Creating an Executable Jar
The `spring-boot-maven-plugin` plugin allows creating a self-contained executable jar file that we could run. 
Executable jars (sometimes called “fat jars”) are archives containing your compiled classes along with all the jar
dependencies that your code needs to run.

//TODO -> Completar esta parte

## Using Spring Boot

### Build Systems

#### Dependency Management
Each release of Spring Boot provides a curated list of dependencies that it supports. In practice, you do not need to 
provide a version for any of these dependencies in your build configuration, as Spring Boot manages that for you. 
When you upgrade Spring Boot itself, these dependencies are upgraded as well in a consistent way.

The curated list contains all the Spring modules that you can use with Spring Boot as well as a refined list of third
party libraries. The list is available as a standard Bills of Materials (spring-boot-dependencies) that can be used
with both Maven and Gradle.

> Each release of Spring Boot is associated with a base version of the Spring Framework. We highly recommend that you
> not specify its version.

#### Starters
Starters are a set of convenient dependency descriptors that you can include in your application. You get a one-stop
shop for all the Spring and related technologies that you need without having to copy-paste loads of dependency
descriptors.

The starters contain a lot of the dependencies that you need to get a project up and running quickly and with a
consistent, supported set of managed transitive dependencies.

> **Starters names**  
> All official starters follow a similar naming pattern; `spring-boot-starter-*`, where `*` is a particular type of
> application.

### Structuring Your Code
Spring Boot does not require any specific code layout to work. However, there are some best practices that help.

We recommend that you follow Java’s recommended package naming conventions and use a reversed domain name 
(for example, `com.example.project).

#### Locating the Main Application Class
We generally recommend that you locate your main application class in a root package above other classes. 
The `@SpringBootApplication` annotation is often placed on your main class, and it implicitly defines a base 
“search package”. Using a root package also allows component scan to apply only on your project.

### Configuration Classes
Spring Boot favors Java-based configuration. Although it is possible to use `SpringApplication` with XML sources,
we recommend that your primary source be a single `@Configuration` class. Usually the class that defines the main 
method is a good candidate as the primary `@Configuration`.

#### Importing Additional Configuration Classes
You need not put all your `@Configuration` into a single class. The `@Import` annotation can be used to import
additional configuration classes. Alternatively, you can use `@ComponentScan` to automatically pick up all Spring
components, including `@Configuration` classes.

#### Auto-configuration
Spring Boot auto-configuration attempts to automatically configure your Spring application based on the jar dependencies
that you have added. For example, if HSQLDB is on your classpath, and you have not manually configured any database
connection beans, then Spring Boot auto-configures an in-memory database.

You need to opt-in to auto-configuration by adding the `@EnableAutoConfiguration` or `@SpringBootApplication`
annotations to one of your `@Configuration` classes.

> You should only ever add one `@SpringBootApplication` or `@EnableAutoConfiguration` annotation. We generally recommend
> that you add one or the other to your primary `@Configuration` class only.

#### Gradually Replacing Auto-configuration
Auto-configuration is non-invasive. At any point, you can start to define your own configuration to replace specific
parts of the auto-configuration.

If you need to find out what auto-configuration is currently being applied, and why, start your application with the 
`--debug` switch. Doing so enables debug logs for a selection of core loggers and logs a conditions report to the
console.

#### Spring Beans and Dependency Injection
You are free to use any of the standard Spring Framework techniques to define your beans and their injected 
dependencies. We often find that using `@ComponentScan` (to find your beans) and using `@Autowired` (to do constructor
injection) works well.

The following example shows a `@Service` bean that uses constructor injection to obtain a required `RiskAssessor` bean:

```java
@Service
public class DatabaseAccountService implements AccountService {

    private final RiskAssessor riskAssessor;

    @Autowired
    public DatabaseAccountService(RiskAssessor riskAssessor) {
        this.riskAssessor = riskAssessor;
    }

    // ...

}
```

####  Using the @SpringBootApplication Annotation
Many developers like their apps to use auto-configuration, component scan and be able to define extra configuration on
their "application class". A single `@SpringBootApplication` annotation can be used to enable those three features,
that is:

- `@EnableAutoConfiguration`: enable Spring Boot’s auto-configuration mechanism.
- `@ComponentScan`: enables `@Component` scan on the package where the application is located (root package).
- `@Configuration`: allows to register extra beans in the context or import additional configuration classes.

`@SpringBootApplication` also provides aliases to customize the attributes of `@EnableAutoConfiguration` and 
`@ComponentScan`.
