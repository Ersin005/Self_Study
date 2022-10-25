Feature: Wikipedia search functionality and verifications

  #WSF+45234 ==> A potential jira ticket number for this Feature can be given just to use as a reference.


  Scenario: Wikipedia Search Functionality Title Verification

    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title


  Scenario:  Wikipedia Search Functionality Header Verification

    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header


  Scenario: Wikipedia Search Functionality Image Header Verification

    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header


  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification

    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header

    @List1
    Examples: search values we are going to be using in this scenario is as below
      | searchValue     | expectedTitle   | expectedMainHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         |
      | Elon Musk       | Elon Musk       | Elon Musk          |
      | Bob Marley      | Bob Marley      | Bob Marley         |
      | Chuck Norris    | Chuck Norris    | Chuck Norris       |

    @List2
    Examples: search values we are going to be using in this scenario is as below
      | searchValue     | expectedTitle   | expectedMainHeader |
      | Anthony Hopkins | Anthony Hopkins | Anthony Hopkins    |
      | Marie Curie     | Marie Curie     | Marie Curie        |
      | Lady Gaga       | Lady Gaga       | Lady Gaga          |
      | Kate Winslet    | Kate Winslet    | Kate Winslet       |