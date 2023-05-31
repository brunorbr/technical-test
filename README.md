# Automated Test Challenge
This automated test challenge was developed for a company hiring process.
The code on this repository was developed with Java 8, using Maven for dependency management.

### Dependencies:
The automated tests on this repository were developed using the following frameworks:

[Selenium](https://www.selenium.dev/documentation/overview/)

[WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

[JUnit 5](https://junit.org/junit5/)

[Allure Report](https://qameta.io/allure-report/)

More information on versions used can be found in the pom.xml file.

## Conversion Test
This challenge consists of a single and simple test, acessing a [Currency Converter tool](https://www.xe.com/currencyconverter/),  a value is inputed to check whether the conversion is corretcly done from Euro to British Pounds.
The test was parameterized to run with several values.
As for the conversion rate for the assertion of the test, the value is acquired at the home page of the application after selecting the Euro as the origin currency.

### Running the test and checking reports
To run the test open a terminal and type:
```
 mvn test 
```
After the tests are done running, go back to the terminal and type:
```
mvn allure:serve
```
The reports will be generated and displayed to the user in the default web browser.