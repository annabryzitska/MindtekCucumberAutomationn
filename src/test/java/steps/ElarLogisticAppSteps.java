package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElarLogisticHomePage;
import pages.ElarLogisticLoginPage;
import pages.ElarLogisticsAddCompPage;
import pages.ElarLogisticsListOfCompPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;


import java.util.*;
import java.util.List;

public class ElarLogisticAppSteps {
    WebDriver driver = Driver.getDriver();
    ElarLogisticLoginPage elarLogisticLoginPage = new ElarLogisticLoginPage();
    ElarLogisticHomePage elarLogisticHomePage = new ElarLogisticHomePage();
    ElarLogisticsListOfCompPage elarLogisticsListOfCompPage = new ElarLogisticsListOfCompPage();
    ElarLogisticsAddCompPage elarLogisticsAddCompPage = new ElarLogisticsAddCompPage();
    List<Map<String, Object>> data = new ArrayList<>();


    @Given("User navigates to ElarLogistics application")
    public void user_navigates_to_elar_logistics_application() {
        driver.get(ConfigReader.getProperty("ElarLogisticsURL"));
    }

    @When("User logs in with  username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String userName, String password) {
        elarLogisticLoginPage.inputUserName.sendKeys(userName);
        elarLogisticLoginPage.inputPassword.sendKeys(password);
    }

    @Then("User clicks on Log in button")
    public void user_clicks_on_log_in_button() {
        elarLogisticLoginPage.LogInButton.click();
    }

    @Then("User clicks on Company button")
    public void user_clicks_on_company_button() {
        elarLogisticHomePage.companyButton.click();
    }


    @Then("User clicks on Add Company button")
    public void user_clicks_on_add_company_button() {
        elarLogisticsListOfCompPage.addCompanyButton.click();
    }

    @When("User create company with data")
    public void user_create_company_with_data(io.cucumber.datatable.DataTable dataTable) {
        Random randNum = new Random();
        int num = randNum.nextInt(118746548);
        data = dataTable.asMaps(String.class, Object.class);
//        for(int i =0;i<data.size();i++){
        elarLogisticsAddCompPage.nameField.sendKeys(data.get(0).get("NAME").toString());
        BrowserUtils.selectDropDownByValue(elarLogisticsAddCompPage.companyTypeDropDown, data.get(0).get("COMPANY TYPE").toString());
        BrowserUtils.selectDropDownByValue(elarLogisticsAddCompPage.statusDropDown, data.get(0).get("STATUS").toString());
        elarLogisticsAddCompPage.numberOfMc.sendKeys(data.get(0).get("MC#").toString() + num);
        elarLogisticsAddCompPage.numberOfDot.sendKeys(data.get(0).get("DOT#").toString() + num);
        BrowserUtils.selectDropDownByValue(elarLogisticsAddCompPage.numberOfIftaDropDown, data.get(0).get("IFTA").toString());
        elarLogisticsAddCompPage.phoneNumb.sendKeys(data.get(0).get("PHONE").toString());
        elarLogisticsAddCompPage.street.sendKeys(data.get(0).get("STREET").toString());
        elarLogisticsAddCompPage.city.sendKeys(data.get(0).get("CITY").toString());
        BrowserUtils.selectDropDownByValue(elarLogisticsAddCompPage.state, data.get(0).get("STATE").toString());
        elarLogisticsAddCompPage.zipCode.sendKeys(data.get(0).get("ZIP CODE").toString());
        elarLogisticsAddCompPage.eMail.sendKeys(data.get(0).get("EMAIL").toString());
        elarLogisticsAddCompPage.insuranceProdCompName.sendKeys(data.get(0).get("INSURANCE").toString());
        elarLogisticsAddCompPage.producedPhone.sendKeys(data.get(0).get("PRODUCER PHONE").toString());
        elarLogisticsAddCompPage.producerStreet.sendKeys(data.get(0).get("PRODUCER STREET").toString());
        elarLogisticsAddCompPage.producerCity.sendKeys(data.get(0).get("PRODUCER CITY").toString());
        elarLogisticsAddCompPage.producerState.sendKeys(data.get(0).get("PRODUCED STATE").toString());
        elarLogisticsAddCompPage.producerZibCode.sendKeys(data.get(0).get("PRODUCED ZIP CODE").toString());
        elarLogisticsAddCompPage.producerEmail.sendKeys(data.get(0).get("PRODUCER EMAIL").toString());
        elarLogisticsAddCompPage.employerIdNumber.sendKeys(data.get(0).get("EMPLOYER ID NUMBER").toString());
        //BrowserUtils.selectDropDownByValue(elarLogisticsAddCompPage.otherLicenses,data.get(0).get("OTHER INSURANCE").toString());
        elarLogisticsAddCompPage.notes.sendKeys(data.get(0).get("NOTES").toString());
    }

    @When("User clicks on Add Company button in company creating page")
    public void user_clicks_on_add_company_button_in_company_creating_page() {
        elarLogisticsAddCompPage.addCompButton.click();
        driver.get("http://3.137.169.132/#/panel/companies/list");
    }

    @When("User clicks on Search  button")
    public void user_clicks_on_search_button() {
        elarLogisticsListOfCompPage.searchButton.click();
    }

    @Then("User validates the search engine appear")
    public void user_validates_the_search_engine_appear() {
        Assert.assertTrue("Search engine is not appearing", elarLogisticsListOfCompPage.searchEngine.isEnabled());
    }

    @When("User type any match {string}")
    public void user_type_any_match(String nameOfComp) {
        elarLogisticsListOfCompPage.searchEngine.sendKeys(nameOfComp+ Keys.ENTER);
    }


    @Then("Validates List of companies with match {string}")
    public void validates_list_of_companies_with_match(String nameOfComp) {
     for(WebElement el : elarLogisticsListOfCompPage.listOfCompanies){
         Assert.assertTrue(el.getText().toLowerCase().contains(nameOfComp));
     }
    }


    @Given("User clicks on Name tag")
    public void user_clicks_on_name_tag() {
        elarLogisticsListOfCompPage.tagName.click();
    }


    @When("Clicks on Search engine and types beginning of the value {string}")
    public void clicks_on_search_engine_and_types_beginning_of_the_value(String nameOfComp) {
      elarLogisticsListOfCompPage.searchEngine.sendKeys(nameOfComp + Keys.ENTER);
    }


    @Then("Validates list of companies with the beginning of the value {string}")
    public void validates_list_of_companies_with_the_beginning_of_the_value(String nameOfComp) {
         for(WebElement el :elarLogisticsListOfCompPage.listOfCompanies){
             Assert.assertTrue(el.getText().toLowerCase().contains(nameOfComp));
         }
    }



}
