Feature: vyTrack app Login with different roles

  Background:
    Given user is on the login page

 @wip
  Scenario: Login as driver


    When user enters driver credentials
    Then user should see below navigations
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  @wip
  Scenario Outline: Login as sales manager and store manager


    When user enters "<role>" information
    Then user should see manager navigation options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

    Examples:
      | role  |
      | Sales |
      | Store |