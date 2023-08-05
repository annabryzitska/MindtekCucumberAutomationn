@regression @ui @etsy
Feature:Validating Search Functionality

  #Background will run steps below once for each Scenario.
Background: Repeated Steps
  Given User navigates to Etsy application
  When User searches for "carpet"

@itemDescription
  Scenario: Validating Search result matches the searched item
    Then User validates search result contains
      | carpet  | rug     |
      | turkish | persian |
      # The values above in a DataTable format. @Then sten will accept value that are below in pipes(vartecal bar)

  @priceRange
  Scenario: Validating price range functionality for searched item
    And User selects price range over 1000.00
    Then User validates price range for items over 1000

