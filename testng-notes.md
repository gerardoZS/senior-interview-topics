# TestNG
## Introduction

TestNG is a testing framework.

Writing a **TestNG test** is typically a three-step process:
- Write your test.
- Add the information about your test in a `testng.xml`file.
- Run the test.

The main concepts around TestNG are:
- A **suite** is represented by one XML file. It can contain one or more tests and is defined by the `<suite>` tag.
- A **test** is represented by the `<test>` tag and can contain one or more TesnNG classes.
- A **TestNG class** is a Java class that contains one or more test methods and has at least one TestNG annotation. It is represented by the `<class>` tag,
- A **test method** is a Java method annotated by `@Test`.


TestNG Suite -> TestNG Test -> TestNG Class -> Test method

A **TestNG test** can be configured by `@BeforeXXX`and `@AfterXXX` annotations which allows performing some logic before and after a certain point, that can be a TestNG Suite, TestNG Test, TestNG Class, or test method.
