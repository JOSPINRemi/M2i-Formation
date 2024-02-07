Feature: Delete book

  Scenario: Delete an existing book
    Given there is book with the id 1 in the library
    When I delete the book with id 1
    Then empty list should be returned