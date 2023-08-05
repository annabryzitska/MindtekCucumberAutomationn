package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BrowserUtils {

    /**
     * This method generate random emails
     * Es:
     *    .getRandomEmail();  -> returns   userjkaiornnnnnn@gmail.com
     */

    public static String getRandomEmail(){
        UUID uuid = UUID.randomUUID();
        return  "user"+uuid+"@gmail.com";
    }
    /**
     * This method takes screenshots
     * Ex:
     *      .takeScreenshot("NameOfScreenshot");
     */

    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/"+testName+".png";
        File file = new File(path);
        FileUtils.copyFile(screenshot,file);
    }
    /**
     * This method accepts a WebElement and a String value to select
     * an option from a DropDown by value
     * Ex:
     *      .selectDropdownByValue(WebElement dropdown,String value);
     */

    public static void selectDropDownByValue(WebElement dropDown,String value){
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }
    /**
     * This method will create a WebDriver object and wait for certain text
     * to be present in a WebElement
     * Ex:
     *       .waitForTextToBePresentInElement(WebElement element,String expectedText);
     */

    public static void waitForTextToBePresentInElement(WebElement element,String expectedText){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.textToBePresentInElement(element,expectedText));
    }

    /**
     * This method wait for certain element to be clickable.
     * Ex:
     *                .waitForTextToBeClickable(WebElement element);
     * @param element
     */
    public static void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method scroll down by [num] px.
     * Ex:
     *      .scrollDownBy(int numOfPixels);
     */

    public static void scrollDownBy(Integer numOfPixels){
        JavascriptExecutor  jse = ((JavascriptExecutor) Driver.getDriver());
        jse.executeScript("window.scrollBy(0,"+numOfPixels+")");

    }
}
