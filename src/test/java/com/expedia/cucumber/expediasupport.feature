Feature: User clicks on Support and sees Cancel a Trip button

  @Support_for_trip_cancelation
  Scenario: User clicks on Support
    Given the user is on the homepage
    When the user clicks on the "Support" link
    Then the "Cancel your Trip" button should be displayed
