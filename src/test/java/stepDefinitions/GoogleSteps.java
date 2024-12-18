package stepDefinitions;

import io.cucumber.java.en.*;
import pages.GoogleHomePage;
import testSteps.GoogleSearchTestSteps;

/** Step definitions for Google search feature. */
public class GoogleSteps {

    private GoogleHomePage googleHomePage;
    private GoogleSearchTestSteps googleSearchTestSteps;

    @Given("the user is on the Google home page")
    public void navigateToGoogleHomePage() {

        googleHomePage = new GoogleHomePage();
        googleHomePage.openHomePage();
        googleSearchTestSteps = new GoogleSearchTestSteps();
    }

    @When("the user searches for {string}")
    public void searchForQuery(String query) {
        googleHomePage.enterSearchQuery(query);
        googleHomePage.clickSearchButton();
    }

    @Then("the page title should contain {string}")
    public void verifyPageTitle(String expected) {
        googleSearchTestSteps.verifyTitleContains(expected);
    }
}
