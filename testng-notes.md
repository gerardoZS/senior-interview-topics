# TestNG
TestNG is a testing framework.

Writing a test with TestNG is typically a three-step process:
- Write your test in a TestNG class.
- Add the information about your test in a `testng.xml`file.
- Run the test.

The main concepts around TestNG are:
- A **suite** is represented by one XML file. It can contain one or more tests and is defined by the `<suite>` tag.
- A **test** is represented by the `<test>` tag and can contain one or more TesnNG classes.
- A **TestNG class** is a Java class that contains one or more test methods and has at least one TestNG annotation. It is represented by the `<class>` tag,
- A **test method** is a Java method annotated by `@Test`.
