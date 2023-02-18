Feature: Tickets reservation

  Scenario: Successful ticket reservation
    Given flight info:
      | departure   | RIX        |
      | destination | BCN        |
      | discount    | 12345      |
      | adults      | 1          |
      | children    | 2          |
      | luggage     | 4          |
      | date        | 13-05-2018 |
      | seat        | 16         |

    And passenger info is:
      | name    | Luke      |
      | surname | Skywalker |


    And home page open

    When we are selecting airports
    Then selected airports appears on the next page

    When we are filling in passenger registration form
    And requesting price

    Then passenger name and airports appears
    And price is 500 EUR

    When we are pressing Book button
    And selecting seat

    Then correct seat number appears

    When we are booking selected ticket
    Then successful registration message appears

    When we are requesting reservations data
    Then current reservation is in the list
    And all reservation data is correct
