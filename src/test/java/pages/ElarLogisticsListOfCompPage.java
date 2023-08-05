package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ElarLogisticsListOfCompPage {
    WebDriver driver;

    public ElarLogisticsListOfCompPage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "btn-search-list")
    public WebElement searchButton;

    @FindBy(className = "faceted-input-search")
    public WebElement searchEngine;

    @FindBy(className = "link-btm-menu")
    public WebElement addCompanyButton;

    @FindBy(id = "checkbox1")
    public WebElement tagName;

    @FindBy(id = "checkbox2")
    public WebElement tagMC;

    @FindBy(id = "checkbox3")
    public WebElement tagDOT;

    @FindBy(id = "checkbox4")
    public WebElement tagPhone;

    @FindBy(id = "checkbox5")
    public WebElement tagEmail;

    @FindBy(id = "checkbox6")
    public WebElement tagAddress;

    @FindBy(id = "checkbox7")
    public WebElement tagNotes;

    @FindBy(xpath = "//td[@class='table-link show-popup-list']")//5 comp only////table[@class='table-company-content']/tr
    public List<WebElement> listOfCompanies;

    @FindBy(xpath = "//div/div[3]/div[2]/a[1]")////div[@class='success-title']/h5
    public WebElement createdCompSuccessMess;

    @FindBy(xpath = "//div[@id='success-popup']/div/div[3]/div[2]/a")
    public WebElement goToListComp;

    ////div/div[3]/div[2]/a[1]
    //(//div[@class='success-button']//a)[1]
    ////div[@class='success-button']//a[@class='link-cancel confirm-save'][normalize-space()='Go to list companies']



}
