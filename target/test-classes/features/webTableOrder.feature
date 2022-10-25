Feature: Web table user order feature


#    For the parameterized solution
  Scenario: User should be able to place order and order seen on the web table

    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "MasterCard"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in the first row of the web table


#  @wip
  #    Same scenario for the scenario outline solution, we can use Scenario Template: instead of Scenario Outline:
  Scenario Template: User should be able to place order and order seen on the web table

    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
#    since quantity is int, we don't provide "", when we are writing examples, it'll be shown highlighted.
  #    There is no need to create snippeds. When we enter a value, it will return normal.
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<country>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expiryDate>"
    And user enters process order button
    Then user should see "<expectedName>" in the first row of the web table

    @femaleScientists
    Examples: Famous female scientists
      | productType | quantity | customerName       | street      | city   | country | zipCode | cardType | cardNumber      | expiryDate | expectedName       |
      | MoneyCog    | 2        | Maria Curie        | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Maria Curie        |
      | Familybea   | 3        | Rosalind Franklin  | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Rosalind Franklin  |
      | Screenable  | 4        | Lise Meitner       | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Lise Meitner       |
      | MoneyCog    | 5        | Barbara McClintock | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Barbara McClintock |
      | MoneyCog    | 6        | Ada Lovelace       | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Ada Lovelace       |

    @maleScientists
    Examples: Famous male scientists
      | productType | quantity | customerName          | street      | city   | country | zipCode | cardType | cardNumber      | expiryDate | expectedName          |
      | MoneyCog    | 2        | ersin                 | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Charles Darwin        |
      | Familybea   | 3        | Albert Einstein       | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Albert Einstein       |
      | Screenable  | 4        | C.V. Raman            | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | C.V. Raman            |
      | MoneyCog    | 5        | kubi                  | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Galileo               |
      | MoneyCog    | 6        | Isaac Newton          | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Isaac Newton          |
      | MoneyCog    | 6        | Arnold Schwarzenegger | London Str. | London | England | 50505   | visa     | 111122221213334 | 12/24      | Arnold Schwarzenegger |