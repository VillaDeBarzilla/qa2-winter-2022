Feature: Tickets reservation

  Scenario: Successful ticket reservation
    Given flight info:
      | departure   | RIX        |
      | destination | BCN        |
      | discount    | 12345      |
      | adultCount  | 1          |
      | childCount  | 2          |
      | bagsCount   | 4          |
      | flightDate  | 13-05-2018 |
      | seatNr      | 16         |

    And passenger info is:
      | firstName | random    |
      | lastName  | Skywalker |


    And home page open

    When we are selecting airports
    Then selected airports appears on the next page

    When we are filling in passenger registration form
    And requesting price

    Then passenger name and airports appears
    And price is 280 EUR

    When we are pressing Book button
    And selecting seat

    Then correct seat number appears

    When we are booking selected ticket
    Then successful registration message appears

    When we are requesting reservations data
    Then current reservation is in the list
    And all reservation data is correct
