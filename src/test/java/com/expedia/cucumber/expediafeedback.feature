Feature: User Feedback on Expedia.co.in

  @Feedback_provider
  Scenario: Provide Feedback
    Given I am on the Expedia.co.in feedback website
    When I click on the "Website Feedback" link
    When I filled the details
    And click on submit button
    Then I should see a confirmation message that my feedback has been submitted successfully
