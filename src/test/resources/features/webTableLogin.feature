Feature: User should be able to login by using correct credentials

  Background: user is on the login page
    Given user is on the web table of the app

  Scenario: Positive login scenario
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see the url contains orders


  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see the url contains orders

      #1 implement this new step
      #2 create Login method in WebTableLoginPage
        # This login method should have multiple different overloaded versions.

  Scenario: User should be able to see all 12 months in months dropdown
    When User enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see the url contains orders
