Feature: Search Flight
	@Flights_round_trip
  Scenario: round trip search
    Given the user is in Expedia search page
    When the user enters trip details
    Then the result page should be displayed
