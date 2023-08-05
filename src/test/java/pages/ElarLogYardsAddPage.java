package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogYardsAddPage {
    WebDriver driver;

    public ElarLogYardsAddPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@class='input-form border disabled-company disabled-not-ext']")
    public WebElement servicePhone;

    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement errorMassageServicePhone;

    @FindBy(xpath = "//span[@class='section-inp border-default']/input[@class='input-form border disabled-receiver disabled-case first-letter']")
    public WebElement contactNameField;

    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement errorMassageContName;////span[contains(text(),' Invalid input ')]

    @FindBy(xpath = "//input[@class='disabled-not-ext input-form border disabled-company']")
    public WebElement ownerPhone;

    @FindBy(xpath = "//span[contains(text(),' Min length is 12 characters, currently it is 11. ')]")
    public WebElement errorMassageOwnerPhone1;

    @FindBy(xpath = "(//span[@class='section-inp border-default']/input[@class='input-form border disabled-receiver disabled-case first-letter'])[2]")
    public WebElement contactNameForOwner;
    //div[@class='form-content']//div[1]//p[2]//span[1]//span[2]//input[1]

    @FindBy(xpath = "//input[@id='id_spots']")
    public WebElement spotsField;

    @FindBy(xpath = "//span[@class='input-errors']")
    public WebElement errorMessageForSpots;

    @FindBy(xpath = "//span[contains(text(),' Enter only digits. ')]")
    public WebElement errorMessageForSpotsOnlyDigits;

    @FindBy(xpath = "//span[@class='section-inp border-default']/textarea")
    public WebElement notesField;
}
