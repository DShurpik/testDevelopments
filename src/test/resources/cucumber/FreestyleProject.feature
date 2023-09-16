Feature: Freestyle job

  Scenario: Successful login with valid credentials
    When Open web site
    Then Open phone tabs
    And Click add to cart button
    And Accept alert

  Scenario: Open laptops
    When Open web site
    And Open laptops tab
    Then Open MacBook Pro link