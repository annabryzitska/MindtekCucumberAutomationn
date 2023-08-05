package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.ElarLogListOfYardsPage;
import pages.ElarLogYardsAddPage;
import pages.ElarLogisticHomePage;
import pages.ElarLogisticLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Optional;

public class ElarLogYardSteps {
        WebDriver driver = Driver.getDriver();
        ElarLogisticLoginPage elarLogisticLoginPage = new ElarLogisticLoginPage();
        ElarLogisticHomePage elarLogisticHomePage = new ElarLogisticHomePage();
        ElarLogListOfYardsPage elarLogListOfYardsPage = new ElarLogListOfYardsPage();
        ElarLogYardsAddPage elarLogYardsAddPage = new ElarLogYardsAddPage();

        @Given("User navigates to application ElarLogistic")
        public void user_navigates_to_application_elar_logistic() {
            driver.get(ConfigReader.getProperty("ElarLogisticsURL"));

        }
        @When("User logs in with userName {string} and password {string}")
        public void user_logs_in_with_user_name_and_password(String userName, String password) {
           elarLogisticLoginPage.inputUserName.sendKeys(userName);
           elarLogisticLoginPage.inputPassword.sendKeys(password);
        }

        @When("User clicks on pYards Button")
        public void user_clicks_on_p_yards_button() {
          elarLogisticHomePage.pYardButton.click();
        }

        @When("User clicks on Add Yard Button")
        public void user_clicks_on_add_yard_button() {
           elarLogListOfYardsPage.addYardButton.click();
        }


    @When("User will fill out Service phone field {string} with length {int}")
    public void user_will_fill_out_service_phone_field_with_length(String servicePhone, int length) {
        elarLogYardsAddPage.servicePhone.sendKeys(servicePhone);
        Assert.assertEquals(length, servicePhone.length());
    }

    @Then("User will validate Service phone field with {string}")
    public void user_mill_validate_service_phone_field_with(String phoneNumber) {
        Assert.assertEquals(phoneNumber,elarLogYardsAddPage.servicePhone.getAttribute("value"));
    }

    @Then("User will validate error massage {string}")
    public void user_will_validate_error_massage(String massage) {
       Assert.assertEquals(massage,elarLogYardsAddPage.errorMassageServicePhone.getText());
    }
    @Then("User will validate {int} digits {string}")
    public void user_will_validate_digits(int length, String phoneNumber) {
        Assert.assertEquals(phoneNumber,elarLogYardsAddPage.servicePhone.getAttribute("value"));
        Assert.assertEquals(length, elarLogYardsAddPage.servicePhone.getAttribute("value").length());
    }

    @When("User will fill out Contact name field {string} with length {int}")
    public void user_will_fill_out_contact_name_field_with_length(String contactName, int length) {
        elarLogYardsAddPage.contactNameField.sendKeys(contactName);
        Assert.assertEquals(length, contactName.length());
    }



    @Then("User will validate Contact name field with {string}")
    public void user_will_validate_contact_name_field_with(String contactName) {
    Assert.assertEquals(contactName,elarLogYardsAddPage.contactNameField.getAttribute("value"));
    }


    @Then("User will validate Contact name field with maximum value {int} characters of length {string}")
    public void user_will_validate_contact_name_field_with_maximum_value_characters_of_length(int length, String contactName) {
        Assert.assertEquals(contactName,elarLogYardsAddPage.contactNameField.getAttribute("value"));
        Assert.assertEquals(length,elarLogYardsAddPage.contactNameField.getAttribute("value").length());

    }

    @When("User will fill out Contact name field with {string}")
    public void user_will_fill_out_contact_name_field_with(String contactName) {
        elarLogYardsAddPage.contactNameField.sendKeys(contactName);
    }

    @Then("User will validate error massage under field {string}")
    public void user_will_validate_error_massage_under_field(String expectedMassage) {
   Assert.assertEquals(expectedMassage,elarLogYardsAddPage.errorMassageContName.getText());
    }


    @When("User will fill out Owner phone field {string} with length {int}")
    public void user_will_fill_out_owner_phone_field_with_length(String ownerPhone, int length) {
        elarLogYardsAddPage.ownerPhone.sendKeys(ownerPhone);
        Assert.assertEquals(length,ownerPhone.length());
    }


    @Then("User will validate Owner phone field with {string}")
    public void user_will_validate_owner_phone_field_with(String ownerPhone) {
        Assert.assertEquals(ownerPhone,elarLogYardsAddPage.ownerPhone.getAttribute("value"));
    }


    @Then("User will validate error massage for Owner phone field {string}")
    public void user_will_validate_error_massage_for_owner_phone_field(String errorMessage) {
      Assert.assertEquals(errorMessage,elarLogYardsAddPage.errorMassageOwnerPhone1.getText());
    }

    @Then("User will validate Owner phone field {string} with length {int}")
    public void user_will_validate_owner_phone_field_with_length(String ownerPhone, int length) {
      Assert.assertEquals(ownerPhone,elarLogYardsAddPage.ownerPhone.getAttribute("value")); // 123-456-7890 == 123-456-7890
      Assert.assertEquals(length,elarLogYardsAddPage.ownerPhone.getAttribute("value").length()); // 12 length
    }

    @When("User will fill out Contact name field for owner {string} with length {int}")
    public void user_will_fill_out_contact_name_field_for_owner_with_length(String contactNameOwn, int length) {
            elarLogYardsAddPage.contactNameForOwner.sendKeys(contactNameOwn);
            Assert.assertEquals(length,contactNameOwn.length());
    }

    @Then("User will validate Contact name field for owner {string} with length {int}")
    public void user_will_validate_contact_name_field_for_owner_with_length(String contactNameOwn, int length) {
        Assert.assertEquals(contactNameOwn,elarLogYardsAddPage.contactNameForOwner.getAttribute("value"));
        Assert.assertEquals(length,elarLogYardsAddPage.contactNameForOwner.getAttribute("value").length());
    }

    @When("User will fill out Contact name field for owner {string}")
    public void user_will_fill_out_contact_name_field_for_owner(String contactNameOwn) {
      elarLogYardsAddPage.contactNameForOwner.sendKeys(contactNameOwn);
    }

    @Then("User will validate error massage under Contact name field for owner {string}")
    public void user_will_validate_error_massage_under_contact_name_field_for_owner(String errorMessageForConNameOwn) {
     Assert.assertEquals(errorMessageForConNameOwn,elarLogYardsAddPage.errorMassageContName.getText());
    }

    @When("User will fill out Spots field {string} with length {int}")
    public void user_will_fill_out_spots_field_with_length(String spots, int length) {
    elarLogYardsAddPage.spotsField.sendKeys(spots);
    Assert.assertEquals(length,spots.length());
    }

    @Then("User will validate Spots field {string} with length {int}")
    public void user_will_validate_spots_field_with_length(String spots, int length) {
       Assert.assertEquals(spots,elarLogYardsAddPage.spotsField.getAttribute("value"));
       Assert.assertEquals(length,elarLogYardsAddPage.spotsField.getAttribute("value").length());
    }


    @When("User will type {string} digit and then deleted it")
    public void user_will_type_digit_and_then_deleted_it(String digit) {
     elarLogYardsAddPage.spotsField.sendKeys(digit + Keys.BACK_SPACE);
    }

    @Then("User will validate error message under Spots field {string}")
    public void user_will_validate_error_message_under_spots_field(String errorMessageForSpots) {
      Assert.assertEquals(errorMessageForSpots,elarLogYardsAddPage.errorMessageForSpots.getText());
    }

    @When("User will input {string} with length {int}")
    public void user_will_input_with_length(String data, int length) {
        elarLogYardsAddPage.spotsField.sendKeys(data);
        Assert.assertEquals(length,data.length());
    }
    @Then("User will validate error message under Spots field for digits only {string}")
    public void user_will_validate_error_message_under_spots_field_for_digits_only(String errorMessage) {
       Assert.assertEquals(errorMessage,elarLogYardsAddPage.errorMessageForSpotsOnlyDigits.getText());
    }


    @When("User will fill out Notes {string} with length {int}")
    public void user_will_fill_out_notes_with_length(String dataForNotes, int length) {
        elarLogYardsAddPage.notesField.sendKeys(dataForNotes);
        Assert.assertEquals(length,dataForNotes.length());
    }


    @Then("User will validate Notes field {string} with length {int}")
    public void user_will_validate_notes_field_with_length(String dataForNotes, int length) {
      Assert.assertEquals(dataForNotes,elarLogYardsAddPage.notesField.getAttribute("value"));
      Assert.assertEquals(length,elarLogYardsAddPage.notesField.getAttribute("value").length());
    }


    @Then("User will validate Notes field  with data {string} with length {int}")
    public void user_will_validate_notes_field_with_data_with_length(String dataForNotes1,int length) {
      Assert.assertEquals(dataForNotes1,elarLogYardsAddPage.notesField.getAttribute("value"));
      Assert.assertEquals(length,elarLogYardsAddPage.notesField.getAttribute("value").length());
    }






}
