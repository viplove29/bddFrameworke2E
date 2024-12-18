package stepDefinitions.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

/** Hooks manage preconditions and cleanup for Cucumber scenarios. */
public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver
        System.out.println("Starting a new test scenario.");
    }

    @After
    public void tearDown() {
        // Quit WebDriver
        DriverFactory.quitDriver();
        System.out.println("Test scenario completed.");
    }
}