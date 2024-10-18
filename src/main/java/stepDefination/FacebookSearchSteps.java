package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSearchSteps extends BaseTest {

   
    WebDriverWait wait;

    @Given("I log into Facebook for search")
    public void i_log_into_facebook_for_search() {
        
    	initializeDriver("chrome");
        driver.get("https://www.facebook.com/");
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        
        driver.findElement(By.id("email")).sendKeys("03266899737"); 
        driver.findElement(By.id("pass")).sendKeys("ayesha123@"); 
        driver.findElement(By.name("login")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Facebook']")));
    }

    @When("I enter a valid search term in the search bar")
    public void i_enter_a_valid_search_term_in_the_search_bar() {
        
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Facebook']")));
        
        searchBar.sendKeys("Facebook");
        searchBar.sendKeys(Keys.RETURN);
    }

    @When("I enter an invalid search term in the search bar")
    public void i_enter_an_invalid_search_term_in_the_search_bar() {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Facebook']")));
        
        searchBar.sendKeys("thistermdoesnotexist");
        searchBar.sendKeys(Keys.RETURN);
    }


    @Then("I should see search results related to the term")
    public void i_should_see_search_results_related_to_the_term() {
        
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Facebook - Search Results | Facebook")) {
            System.out.println("Search results displayed for the valid term.");
        } else {
            System.out.println("No search results found.");
        }
        driver.quit();
    }

    @Then("I should see a message indicating no results found")
    public void i_should_see_a_message_indicating_no_results_found() {
    	 String pageTitle = driver.getTitle();
         if (pageTitle.contains("thistermdoesnotexist - Search Results | Facebook")) {
             System.out.println("No results found message displayed for the invalid term.");
         } else {
             System.out.println("Search results displayed unexpectedly.");
         }
         driver.quit();
    }
}
