package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/** DriverFactory handles browser setup and WebDriver management. */
public class DriverFactory {
    // ThreadLocal to ensure each thread has its own instance of WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // Check if the driver is already initialized for the current thread
        if (driver.get() == null) {
            String browser = ConfigReader.getProperty("browser");
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            // Maximize the browser window
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void quitDriver() {
        // Quit the driver for the current thread and set it to null
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Remove the driver from ThreadLocal
        }
    }
}
