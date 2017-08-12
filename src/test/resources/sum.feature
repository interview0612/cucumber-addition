Feature: the sum of two numbers is
  Scenario: client makes call to GET /sum
    When the client calls /sum with "5" and "50"
    Then the client receives status code of 200
    And the client receives sum 55
   