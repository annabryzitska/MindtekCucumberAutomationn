@regression @elarLogistics
  Feature: Validation search functionality
   Background:Logging in and  adding company
     Given User navigates to ElarLogistics application
     When User logs in with  username "student@mindtekbootcamp.com" and password "ilovejava"
     And User clicks on Log in button
     And User clicks on Company button
     And User clicks on Add Company button
     And User create company with data
       | NAME | COMPANY TYPE   | STATUS | MC# | DOT# | IFTA | PHONE      | STREET           | CITY    | STATE    | ZIP CODE | EMAIL                    | INSURANCE   | PRODUCER PHONE | PRODUCER STREET     | PRODUCER CITY | PRODUCED STATE | PRODUCED ZIP CODE | PRODUCER EMAIL       | EMPLOYER ID NUMBER | OTHER LICENSES | NOTES              |
       | ABCddd  | broker company | active | 1   | 0    | true | 7733153678 | 5441 Main Avenue | Chicago | IL | 60539    | marielagongales@gmail.com | Progressive | 7753153677     | 4567 Levaine Avenue | Lombard       | Illinois       | 45789             | ginapistol@gmail.com | 12-3456789         | false          | please Pay in time |
     And User clicks on Add Company button in company creating page
     And User clicks on Search  button


    @elarLogistics1
    Scenario: Validation the search engine appear
    Then User validates the search engine appear


    Scenario: Validate Search engine with any match
#    And User clicks on appeared Search engine
    And User type any match "abc"
    Then Validates List of companies with match "abc"


    Scenario: Validating Search engine's "Name" tag with beginning of the value
        Given User clicks on Name tag
        When Clicks on Search engine and types beginning of the value "ABC"
        Then Validates list of companies with the beginning of the value "ABC"

#
#    Scenario: Validating Search engine's "MC#" tag with beginning of the value
#          Given User clicks on MC# tag
#          When Clicks on Search engine
#          And User types beginning of the value <4563>
#          Then User validates list of companies with beginning of the value <4563>
#
#    Scenario: Validating Search engine's "MC#" tag by searching a data that doesn't exist
#      Given User clicks on MC# tag
#      When Clicks on Search engine
#      And User types beginning of the value "CRS"
#      Then User validates list of companies with beginning of the value "CRS"
#
#    Scenario: Validating Search engine's "DOT#" tag with beginning of the value
#      Given User clicks on DOT# tag
#      When Clicks on Search engine
#      And User types beginning of the value <098>
#      Then User validates list of companies with beginning of the value <098>
#
#    Scenario: Validating Search engine's "DOT#" tag by searching a data that doesn't exist
#      Given User clicks on MC# tag
#      When Clicks on Search engine
#      And User types beginning of the value "hpo"
#      Then User validates list of companies with beginning of the value "hpo"
#
#    Scenario: Validating Search engine's "Phone" tag by searching existing phone number
#      Given User clicks on Phone tag
#      When Clicks on Search engine
#      And User types beginning of the value <773-315-3678>
#      Then User validates list of companies with beginning of the value <773-315-3678>
#
#
#    Scenario: Validating Search engine's "Phone" tag by searching a data that doesn't exist
#      Given User clicks on Phone tag
#      When Clicks on Search engine
#      And User types beginning of the value "Phone"
#      Then User validates list of companies with invalid data "Phone"
#
#
#    Scenario: Validating Search engine's "Email" tag with beginning of the value
#      Given User clicks on Email tag
#      When Clicks on Search engine
#      And User types beginning of the value "mariela"
#      Then Validates list of companies with the beginning of the value "mariela"
#
#
#    Scenario: Validating Search engine's "Address" tag with beginning of the value
#      Given User clicks on Address tag
#      When Clicks on Search engine
#      And User types beginning of the value "Main"
#      Then Validates list of companies with the beginning of the value "Main"
#
#
#    Scenario: Validating Search engine's "Notes" tag with beginning of the value
#      Given User clicks on Notes tag
#      When Clicks on Search engine
#      And User types beginning of the value "please"
#      Then Validates list of companies with the beginning of the value "please"









   