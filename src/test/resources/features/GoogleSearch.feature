@smoke
Feature: Google Search

  Background:
    Given the user is on the Google home page

  @regression
  Scenario: Verify Google search functionality with my youtube channel
    When the user searches for "Viplove QA SDET"
    Then the page title should contain "Viplove QA SDET"

  @regression
  Scenario: Verify Google search functionality with my youtube channel
    When the user searches for "Viplove SDET QA"
    Then the page title should contain "Viplove SDET QA"