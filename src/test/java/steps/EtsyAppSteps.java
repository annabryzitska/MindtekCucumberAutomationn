package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyMainPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class EtsyAppSteps {
    WebDriver driver = Driver.getDriver();
    EtsyMainPage etsyMainPage = new EtsyMainPage();

    @Given("User navigates to Etsy application")
    public void user_navigates_to_etsy_application() {
        driver.get(ConfigReader.getProperty("EtsyURL"));

    }
    @When("User searches for {string}")
    public void user_searches_for(String itemName) {
        etsyMainPage.searchBar.sendKeys(itemName + Keys.ENTER);


    }
    @Then("User validates search result contains")
    public void user_validates_search_result_contains(DataTable data) {

        List<String> keywords = data.asList();
        for (WebElement item: etsyMainPage.item){
            String itemDiscription = item.getText();
            boolean isFound = false;
           String wordFound="";
            for(int i =0;i<keywords.size();i++){
               if(itemDiscription.toLowerCase().contains(keywords.get(i))){
                   isFound=true;
               }else {
                  wordFound=keywords.get(i);
               }
            }
            Assert.assertTrue("[" + itemDiscription + "] does not contain keyword: " + wordFound,isFound);
       }
    }

    @When("User selects price range over {double}")
    public void user_selects_price_range_over(Double priceRange) {
        etsyMainPage.allFilterBtn.click();
        etsyMainPage.btnOver1000.click();
        etsyMainPage.applyBtn.click();
    }


    @Then("User validates price range for items over {double}")
    public void user_validates_price_range_for_items_over(Double priceRange) {
        driver.navigate().refresh();
        for(WebElement price:etsyMainPage.prices){
            System.out.println(price.getText());
           Double priceDouble = Double.parseDouble(price.getText().replace(",",""));
           Assert.assertTrue(priceDouble+"is less than" + priceRange,priceDouble>=priceRange);
        }
    }

    @When("User clicks on {string} module")
    public void user_clicks_on_module(String module) {
        if(module.equals("Fashion Favorites")){
            etsyMainPage.fashionFavoritesTab.click();
        }else if(module.equals("Jewelry & Accessories")){
            etsyMainPage.jewelryAccessoriesTab.click();
        } else if (module.equals("Clothing & Shoes")) {
            etsyMainPage.clothingShoes.click();
        }else if(module.equals("Home & Living")){
            etsyMainPage.homeLiving.click();
        }else if (module.equals("Wedding & Party")){
            etsyMainPage.weddingParty.click();
        }else if(module.equals("Toys & Entertainment")){
            etsyMainPage.toysEntertainment.click();
        }else if(module.equals("Art & Collectibles")){
            etsyMainPage.artCollectibles.click();
        }else if(module.equals("Craft Supplies")){
            etsyMainPage.craftSupplies.click();
        }else if(module.equals("Gifts & Gift Cards")){
            etsyMainPage.giftsGiftCards.click();
        }
    }


    @Then("User validates the {string} title")
    public void user_validates_the_title(String title) {
        Assert.assertEquals("Title is incorrect",title,driver.getTitle());

    }


}
