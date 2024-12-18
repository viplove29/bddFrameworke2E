# BDD Framework for Selenium and Cucumber

This framework implements a Behavior-Driven Development (BDD) approach using Selenium, Cucumber, testNg and JUnit. It is designed to be modular, maintainable, and scalable for testing web applications.

---

## **Project Structure**

```plaintext
src/
  main/
    java/
      pages/                  # Page Object classes
     
      utils/                  # Utility classes (DriverFactory, ConfigReader, etc.)
  test/
    java/
      runners/                # Cucumber test runners
    stepdefinitions/        # Cucumber step definitions
    teststeps/              # Test assertions
config/
  config.properties           # Centralized configuration
features/
  *.feature                   # Gherkin feature files
```

---

## **Key Features**

1. **Modular Design**: Uses Page Object Model (POM) for reusable page interactions.
2. **Configurable**: Centralized configuration in `config/config.properties`.
3. **Cross-Browser Support**: Supports Chrome and Firefox browsers via WebDriverManager.
4. **Behavior-Driven Development**: Gherkin syntax for writing test scenarios.
5. **Cucumber Reporting**: Generates HTML reports for test results.
6. **GitHub Actions**: Includes CI/CD workflow for running tests and sending email notifications.

---

## **Configuration**

### **`config/config.properties`**

```properties
base.url=https://www.google.com
browser=chrome
```

Update the properties file to set the base URL and browser type (e.g., Chrome, Firefox).

---

## **How to Use**

### **1. Clone the Repository**

```bash
git clone <repository-url>
cd <repository-folder>
```

### **2. Set Up Dependencies**

Ensure Maven is installed and Java 17+ is set up on your system.

```bash
mvn clean install
```

### **3. Update Configuration**

Modify `config/config.properties` as needed.

### **4. Run Tests**

Execute the tests using Maven:

```bash
mvn clean test
```

---

## **Framework Components**

### **Page Object Classes**

Page Object classes encapsulate web elements and their interactions.

**Example:** `GoogleHomePage.java`

```java
public void enterSearchQuery(String query) {
    driver.findElement(searchBox).sendKeys(query);
}
```

### **Step Definitions**

Maps Gherkin steps to Java methods.

**Example:** `GoogleSteps.java`

```java
@When("the user searches for {string}")
public void searchForQuery(String query) {
    googleHomePage.enterSearchQuery(query);
    googleHomePage.clickSearchButton();
}
```

### **Hooks**

Setup and teardown actions using `@Before` and `@After` hooks.

**Example:** `Hooks.java`

```java
@Before
public void setup() {
    DriverFactory.getDriver();
}

@After
public void teardown() {
    DriverFactory.quitDriver();
}
```

### **Test Runner**

Executes feature files and generates reports.

**Example:** `TestRunner.java`

```java
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
```

### **GitHub Actions Workflow**

Automates test execution and email notifications upon code pushes.

**Example:** `.github/workflows/test-and-email.yml`

```yaml
jobs:
  build:
    runs-on: windows-latest
    steps:
    - name: Run Tests
      run: mvn clean test
```

---

## **Writing Tests**

### **Feature Files**

Write scenarios in Gherkin syntax under the `features/` directory.

**Example:** `GoogleSearch.feature`

```gherkin
Feature: Google Search
  Scenario: Verify Google search functionality
    Given the user is on the Google home page
    When the user searches for "Selenium WebDriver"
    Then the page title should contain "Selenium WebDriver"
```

---

## **Dependencies**

Include the following in `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.12.1</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.14.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.14.0</version>
    </dependency>
</dependencies>
```

---

## **CI/CD Integration**

This framework includes a GitHub Actions workflow for automated testing and reporting. Customize the workflow in `.github/workflows/test-and-email.yml` to suit your CI/CD pipeline.

---

## **Contributing**

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

---
Dependencies
1.	Cucumber Dependencies
o	cucumber-junit-platform-engine:
Integrates Cucumber with the JUnit 5 platform, allowing you to run Cucumber scenarios as JUnit tests.
o	cucumber-java:
Provides support for writing step definitions in Java.
o	cucumber-junit:
Enables Cucumber tests to run using JUnit 4 (if not using JUnit 5).
o	cucumber-testng:
Allows integration of Cucumber with TestNG for running tests.
2.	TestNG Dependency
o	testng:
A testing framework for running tests in parallel, setting up configurations, and defining groups for tests.
3.	Selenium Dependency
o	selenium-java:
Provides the Selenium WebDriver library for browser automation in Java.
4.	WebDriverManager Dependency
o	webdrivermanager:
Automates the management of browser drivers (e.g., ChromeDriver, GeckoDriver) to avoid manual setup.
5.	Logging Dependencies
o	logback-classic:
A popular implementation of SLF4J for logging, useful for debugging and monitoring.
o	log4j-slf4j-impl:
Bridges SLF4J logging to Log4j 2, giving you the flexibility to use Log4j's advanced logging features.
________________________________________
Plugins
1.	Maven Compiler Plugin
o	maven-compiler-plugin:
Specifies the Java version for compiling your code (e.g., Java 11 in this configuration).
2.	Maven Surefire Plugin
o	maven-surefire-plugin:
Runs unit and integration tests during the build process. Configured here to use a testng.xml file.
3.	Spotless Maven Plugin
o	spotless-maven-plugin:
Enforces code formatting rules in your project using Google Java Format.
________________________________________
Key Use Cases
•	Cucumber Dependencies: Enable behavior-driven development (BDD) by writing tests in plain English.
•	TestNG & Maven Surefire: Provide flexibility for managing and running test suites.
•	Selenium & WebDriverManager: Automate browser testing efficiently without worrying about driver compatibility.
•	Logging: Helps trace issues and debug during test execution.
•	Spotless Plugin: Maintains consistent code style across the project.
# BDD Framework for Selenium and Cucumber
