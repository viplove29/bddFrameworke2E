package testSteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverFactory;

/** GoogleSearchTestSteps validates search results. */
public class GoogleSearchTestSteps {
  private WebDriver driver;

  public GoogleSearchTestSteps() {
    this.driver = DriverFactory.getDriver();
  }

  public void verifyTitleContains(String expected) {
    String actualTitle = driver.getTitle();
    Assert.assertTrue(actualTitle.contains(expected), "Page title does not contain expected text.");
  }
}
