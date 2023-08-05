package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticHomePage {
    WebDriver driver;
    public ElarLogisticHomePage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='side-link-company']")
    public WebElement companyButton;


    @FindBy(xpath = "//a[@class=\"side-link-yards\"]")
    public WebElement pYardButton;

////a[@class='router-link-active side-link-yards'],
// span[@class='aside-icon yards-aside'],
// input[@class='input-form border disabled-company disabled-not-ext']



}
