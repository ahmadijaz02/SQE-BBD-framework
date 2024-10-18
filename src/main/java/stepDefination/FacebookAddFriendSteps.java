package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookAddFriendSteps {

    WebDriver driver;

    @Given("I am logged into Facebook for adding a friend")
    public void i_am_logged_into_facebook() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Open Facebook and log in
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("03266899737");  // Use your login credentials
        driver.findElement(By.id("pass")).sendKeys("ayesha123@");   // Use your password
        driver.findElement(By.name("login")).click();
    }

    @When("I navigate to the friend's profile link")
    public void i_navigate_to_friends_profile() throws InterruptedException {
        // Wait for login to complete
        Thread.sleep(5000);

        // Navigate to friend's profile using the provided link
        driver.get("https://www.facebook.com/ahmad.ijaz.908132"); // Replace with actual friend's profile link

        // Wait for the friend's profile page to load
        Thread.sleep(3000);
    }

    @When("I add the friend from their profile")
    public void i_add_friend() throws InterruptedException {
        // Click the "Add Friend" button
        WebElement addFriendButton = driver.findElement(By.className("x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft"));
        addFriendButton.click();
        
        // Wait for the action to complete
        Thread.sleep(3000);
    }

    @Then("the friend request should be sent successfully")
    public void the_friend_request_should_be_sent_successfully() throws InterruptedException {
        // Wait for a moment to ensure the request has been processed
        Thread.sleep(3000);

        // Optionally, check if the button text changes to "Friend Request Sent" or similar
        WebElement requestSentMessage = driver.findElement(By.xpath("//button[contains(text(), 'Friend Request Sent')]"));
        if (requestSentMessage.isDisplayed()) {
            System.out.println("Friend request sent successfully.");
        } else {
            System.out.println("Failed to send friend request.");
        }

        // Close the browser
        driver.quit();
    }
}
