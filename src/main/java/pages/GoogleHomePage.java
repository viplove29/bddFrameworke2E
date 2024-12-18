package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverFactory;

/** GoogleHomePage contains locators and methods for interacting with Google's home page. */
public class GoogleHomePage {

  private WebDriver driver;
  // Locators
  private By searchBox = By.name("q");
  private By searchButton = By.name("btnK");

  // Constructor
  public GoogleHomePage() {
    this.driver = DriverFactory.getDriver();
  }

  // Methods
  public void openHomePage() {
    driver.get(ConfigReader.getProperty("base.url"));
  }

  public void enterSearchQuery(String query) {
    driver.findElement(searchBox).sendKeys(query);
  }

  public void clickSearchButton() {
    driver.findElement(searchButton).submit();
  }
}
