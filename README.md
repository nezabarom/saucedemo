# saucedemo-test-automation

## How to run the project

1. Clone the repository
2. Open the root directory in your terminal
3. Run the tests with the following command: ```mvn clean test```
4. Hold until tests are running, you can see what's going on in the terminal log.
5. Look for the report link in the end of test execution log.
6. See the generated test report.

## Configuration

In general - any property from [property files](/src/main/resources) can be overriden with Environmental Variables -
that's how the framework is designed. Here are some examples:

* -browser - specify browser to run tests on. Currently these browsers are supported: ```chrome```, ```firefox```

### Main frameworks that are used in this project

* [Java](https://www.java.com/en/) - programming language used in the project
* [TestNG](https://testng.org/doc/) - allows executing Java code as tests
* [Cucumber](https://cucumber.io/) - BDD testing engine. Allows automation test cases development using written text
  with Gherkin syntax
* [Selenide](https://selenide.org/) - UI testing engine. This is a comprehensive wrapper over the classic Selenium
  WebDriver, which allows creating robust and reliable UI automation tests
* [Report Portal](https://reportportal.io/) - report aggregation tool, used to review and analyze executed test suite