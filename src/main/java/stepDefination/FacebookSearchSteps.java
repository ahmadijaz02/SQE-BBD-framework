package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSearchSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I log into Facebook for search")
    public void i_log_into_facebook_for_search() {
        // Set the ChromeDriver property
      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\4A\\Downloads\\abbbc\\src\\main\\resources\\drivers\\chromedriver.exe"); // Update the path accordingly

        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter username and password
        driver.findElement(By.id("email")).sendKeys("03266899737"); // Replace with valid email
        driver.findElement(By.id("pass")).sendKeys("ayesha123@"); // Replace with valid password

        // Click the login button
        driver.findElement(By.name("login")).click();

        // Wait for login to complete and check if the homepage is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Facebook']")));
    }

    @When("I enter a valid search term in the search bar")
    public void i_enter_a_valid_search_term_in_the_search_bar() {
        // Wait until the search bar is visible
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Facebook']")));
        searchBar.sendKeys("Facebook");

        // Simulate pressing "Enter" to trigger the search
        searchBar.sendKeys(Keys.RETURN);
    }

    @When("I enter an invalid search term in the search bar")
    public void i_enter_an_invalid_search_term_in_the_search_bar() {
        // Wait until the search bar is visible
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Facebook']")));
        searchBar.sendKeys("thistermdoesnotexist");

        // Simulate pressing "Enter" to trigger the search
        searchBar.sendKeys(Keys.RETURN);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        // Wait for the search button to be clickable and then click it
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Search']")));
        searchButton.click();
    }

    @Then("I should see search results related to the term")
    public void i_should_see_search_results_related_to_the_term() {
        // Wait for search results to appear and verify
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'results')]")));
        boolean isResultsDisplayed = searchResults.isDisplayed();
        if (isResultsDisplayed) {
            System.out.println("Search results displayed for valid term.");
        } else {
            System.out.println("No search results found.");
        }
    }

    @Then("I should see a message indicating no results found")
    public void i_should_see_a_message_indicating_no_results_found() {
        // Wait for the "No results found" message
        WebElement noResultsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'No results found')]")));
        boolean isNoResultsDisplayed = noResultsMessage.isDisplayed();
        if (isNoResultsDisplayed) {
            System.out.println("No results found message displayed for invalid term.");
        } else {
            System.out.println("Search results displayed unexpectedly.");
        }
    }
}
