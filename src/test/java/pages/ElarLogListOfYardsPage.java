package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogListOfYardsPage {
    WebDriver driver;
    public ElarLogListOfYardsPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='link-btm-menu']")
    public WebElement addYardButton;


}
