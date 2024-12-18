package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/** Test runner for parallel execution using TestNG. */
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepDefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
    tags = "@smoke or @regression",
    monochrome = true)
public class ParallelTestRunnerTest extends AbstractTestNGCucumberTests {
  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
