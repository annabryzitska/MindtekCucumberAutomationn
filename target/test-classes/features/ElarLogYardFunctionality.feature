@regression @elarLogistic2
  Feature: Add Yard_Service phone_Contact name_Owner phone_Contact name_Spots_Note
    Background: Login in to App
      Given User navigates to application ElarLogistic
      When User logs in with userName "student@mindtekbootcamp.com" and password "ilovejava"
      And User clicks on Log in button
      And User clicks on pYards Button
      And User clicks on Add Yard Button


      Scenario: Validation Service Phone with valid data(min value 12 numbs)
        And User will fill out Service phone field "123-456-7890" with length 12
        Then User will validate Service phone field with "123-456-7890"


    Scenario:Validating Service phone with invalid data (11-numbers)
      And User will fill out Service phone field "123-456-789" with length 11
      Then User will validate error massage "Min length is 12 characters, currently it is 11."


    Scenario: Validating Service phone with invalid data (13-numbers)
      And User will fill out Service phone field "123-456-78901" with length 13
      Then User will validate 12 digits "123-456-7890"


    Scenario: Validating Contact name with valid data maximum value "35 numbers | letters | space | dash"
      And User will fill out Service phone field "123-456-7890" with length 12
      And User will fill out Contact name field "qwertyuiopasdfghjklzxcqertyuiopp123" with length 35
      Then User will validate Contact name field with "qwertyuiopasdfghjklzxcqertyuiopp123"


    Scenario:Validating Contact name with invalid data, "36 numbers | letters | space | dash"
      And User will fill out Service phone field "123-456-7890" with length 12
      And User will fill out Contact name field "qwertyuiopasdfghjklzxcqertyuiopp1234" with length 36
      Then User will validate Contact name field with maximum value 35 characters of length "qwertyuiopasdfghjklzxcqertyuiopp123"



    Scenario: Validating Contact name with invalid data "with special character$"
      And User will fill out Service phone field "123-456-7890" with length 12
      And User will fill out Contact name field with "Azamat$"
      Then User will validate error massage under field "Invalid input"


    Scenario: Validating Owner phone with valid data maximum value "12-numbers"
      And User will fill out Owner phone field "123-456-7890" with length 12
      Then User will validate Owner phone field with "123-456-7890"


    Scenario: Validating Owner  phone with "invalid data", "11-numbers"
      And User will fill out Owner phone field "123-456-789" with length 11
      Then User will validate error massage for Owner phone field "Min length is 12 characters, currently it is 11."


    Scenario: Validating Owner  phone with invalid data, "13-numbers"
      And User will fill out Owner phone field "123-456-78901" with length 13
      Then User will validate Owner phone field "123-456-7890" with length 12


    Scenario: Validating Contact name with "valid data" maximum value "35 numbers | letters | space | dash"
      And User will fill out Owner phone field "123-456-7890" with length 12
      And User will fill out Contact name field for owner "qwertyuiopasdfghjklzxcqertyuiopp123" with length 35
      Then User will validate Contact name field for owner "qwertyuiopasdfghjklzxcqertyuiopp123" with length 35


    Scenario: Validating Contact name with "valid data", "36 numbers | letters | space | dash"
      And User will fill out Owner phone field "123-456-7890" with length 12
      And User will fill out Contact name field for owner "qwertyuiopasdfghjklzxcqertyuiopp1234" with length 36
      Then User will validate Contact name field for owner "qwertyuiopasdfghjklzxcqertyuiopp123" with length 35


    Scenario: Validating Contact name with "invalid data"
      And User will fill out Owner phone field "123-456-7890" with length 12
      And User will fill out Contact name field for owner "Azamat$"
      Then User will validate error massage under Contact name field for owner "Invalid input"


    Scenario: Validating Spots with "valid data", "6-numbers"
      And User will fill out Spots field "123456" with length 6
      Then User will validate Spots field "123456" with length 6


    Scenario: Validating Spots with "None data'
      And User will type "1" digit and then deleted it
      Then User will validate error message under Spots field "This field is required."


    Scenario: Validating Spots with "invalid data", "6-letters"
      And User will input "absdef" with length 6
      Then User will validate error message under Spots field for digits only "Enter only digits."


    Scenario: Validating Spots with "invalid data", "7-numbers"
      And User will input "1234567" with length 7
      Then User will validate Spots field "123456" with length 6


    Scenario: Validating Notes with "valid data", "250-Any characters, letters, and numbers"
      And User will fill out Notes "dsgdhsbmdbjsh djkdjsflkdsjsldzjdli dsytukwadhkufehsusey kfjawdyuweiu7repwoa;ri573785837vdj fgjkdhfksugdjrkldgjgddfgkgdf,jdlkfbc fekjsfhfsekjfhewslfjwi afekjfhfjsvhsgsjjslidsisjnbsgahjsfdvgfjhsdgfhjsgdhjdsgdjfhcsdgdjshdbsgjhsccgcdshcbmsdhbcdzmfhkszruy" with length 250
      Then User will validate Notes field "dsgdhsbmdbjsh djkdjsflkdsjsldzjdli dsytukwadhkufehsusey kfjawdyuweiu7repwoa;ri573785837vdj fgjkdhfksugdjrkldgjgddfgkgdf,jdlkfbc fekjsfhfsekjfhewslfjwi afekjfhfjsvhsgsjjslidsisjnbsgahjsfdvgfjhsdgfhjsgdhjdsgdjfhcsdgdjshdbsgjhsccgcdshcbmsdhbcdzmfhkszruy" with length 250


    Scenario: Validating Notes with "invalid data", "251-Any characters, letters, and numbers"
      And User will fill out Notes "dsgdhsbmdbjsh djkdjsflkdsjsldzjdli dsytukwadhkufehsusey kfjawdyuweiu7repwoa;ri573785837vdj fgjkdhfksugdjrkldgjgddfgkgdf,jdlkfbc fekjsfhfsekjfhewslfjwi afekjfhfjsvhsgsjjslidsisjnbsgahjsfdvgfjhsdgfhjsgdhjdsgdjfhcsdgdjshdbsgjhsccgcdshcbmsdhbcdzmfhkszruy1" with length 251
      Then User will validate Notes field  with data "dsgdhsbmdbjsh djkdjsflkdsjsldzjdli dsytukwadhkufehsusey kfjawdyuweiu7repwoa;ri573785837vdj fgjkdhfksugdjrkldgjgddfgkgdf,jdlkfbc fekjsfhfsekjfhewslfjwi afekjfhfjsvhsgsjjslidsisjnbsgahjsfdvgfjhsdgfhjsgdhjdsgdjfhcsdgdjshdbsgjhsccgcdshcbmsdhbcdzmfhkszruy" with length 250