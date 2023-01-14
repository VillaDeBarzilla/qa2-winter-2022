Feature: Ticket reservation
  Scenario: Successful ticket reservation for a flight
    Given Order tickets for a two adults and one children
    And choose arrival and departure
    And take four bags
    And enter discount code
    And select date
    When all input fields is filled
    And and button is clicked
    Then we will see successful registration text
