package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class FacebookLoginSteps extends BaseTest {

  

    @Given("I am on the Facebook login page")
    public void i_am_on_the_facebook_login_page() {
    	initializeDriver("chrome");
        driver.get("https://www.facebook.com/");
    }

    @When("I enter a valid email and password")
    public void i_enter_a_valid_email_and_password() {
        driver.findElement(By.id("email")).sendKeys("03266899737");
        driver.findElement(By.id("pass")).sendKeys("ayesha123@");
    }

    @When("I enter an invalid email and password")
    public void i_enter_an_invalid_email_and_password() {
        driver.findElement(By.id("email")).sendKeys("invalidemail@example.com");
        driver.findElement(By.id("pass")).sendKeys("InvalidPassword");
    }

    @When("I leave the email and password fields empty")
    public void i_leave_the_email_and_password_fields_empty() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("pass")).clear();
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.name("login")).click();
    }

    @Then("I should be redirected to the Facebook homepage")
    public void i_should_be_redirected_to_homepage() {
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Facebook")) {
            System.out.println("Login successful, redirected to homepage.");
        } else {
            System.out.println("Login failed or not redirected to homepage.");
        }
        driver.quit();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        try {
            boolean isErrorDisplayed = driver.findElement(By.xpath("//div[contains(text(),'The email or phone number you’ve entered doesn’t match any account.')]")).isDisplayed();
            if (isErrorDisplayed) {
                System.out.println("Error message displayed.");
            } else {
                System.out.println("Error message not displayed.");
                takeScreenshot(); 
            }
            driver.quit();
        } catch (Exception e) {
            takeScreenshot(); 
        }
      
    }

    @Then("I should see a validation error")
    public void i_should_see_a_validation_error() {
        try {
            boolean isValidationErrorDisplayed = driver.findElement(By.xpath("//div[contains(text(),'The email or phone number you’ve entered doesn’t match any account.')]")).isDisplayed();
            if (isValidationErrorDisplayed) {
                System.out.println("Validation error displayed.");
            } else {
                System.out.println("Validation error not displayed.");
                takeScreenshot(); 
            }
            driver.quit();
        } catch (Exception e) {
            takeScreenshot(); 
        }
        
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
