package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookAddFriendSteps extends BaseTest {

    

    @Given("I am logged into Facebook for adding a friend")
    public void i_am_logged_into_facebook() {
     
    	initializeDriver("chrome");

        
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("03266899737");  
        driver.findElement(By.id("pass")).sendKeys("ayesha123@");   
        driver.findElement(By.name("login")).click();
    }

    @When("I navigate to the friend's profile link")
    public void i_navigate_to_friends_profile() throws InterruptedException {
        
        Thread.sleep(5000);

        driver.get("https://www.facebook.com/ahmad.ijaz.908132");

        Thread.sleep(3000);
    }

    @When("I add the friend from their profile")
    public void i_add_friend() throws InterruptedException {
        // Click the "Add Friend" button
        WebElement addFriendButton = driver.findElement(By.className("x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft"));
        addFriendButton.click();

        Thread.sleep(3000);
    }

    @Then("the friend request should be sent successfully")
    public void the_friend_request_should_be_sent_successfully() throws InterruptedException {
        Thread.sleep(3000);
        WebElement requestSentMessage = driver.findElement(By.xpath("//button[contains(text(), 'Friend Request Sent')]"));
        if (requestSentMessage.isDisplayed()) {
            System.out.println("Friend request sent successfully.");
        } else {
            System.out.println("Failed to send friend request.");
        }

        driver.quit();
    }
}
