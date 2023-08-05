@regression  @ui @smoke  @MB-70
Feature: Validating Login Functionality

 @smoke @loginPositive @MB-70
  Scenario: Validating Login Functionality with valid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    Then User is successfully logged in and lands on the home page

 @smoke @loginNegative @MB-70
    Scenario: Validating login functionality with invalid credentials
      Given User navigates to application
      When User logs in with username "Tester" and password "Tester"
      Then User validates error message "Invalid Login or Password."