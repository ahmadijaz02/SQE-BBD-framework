package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookCommentSteps extends BaseTest{

public class FacebookCommentSteps {

    WebDriver driver;

    WebDriverWait wait;

    @Given("I am logged into Facebook")
    public void i_am_logged_into_facebook() {

    	initializeDriver("chrome");

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("03266899737");
        driver.findElement(By.id("pass")).sendKeys("ayesha123@");
        driver.findElement(By.name("login")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Facebook']")));
    }

    @Given("I see a post on my timeline")
    public void i_see_a_post_on_my_timeline() {

        WebElement post = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-pagelet, 'FeedUnit')]")));
        if (post.isDisplayed()) {
            System.out.println("Post is visible on the timeline.");
        }
    }

    @When("I write a comment on the post")
    public void i_write_a_comment_on_the_post() {

        WebElement commentBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'Write a comment')]")));
        commentBox.click();
        commentBox.sendKeys("This is an automated comment!");
    }

    @When("I click the comment button")
    public void i_click_the_comment_button() {

        WebElement commentBox = driver.findElement(By.xpath("//div[contains(@aria-label,'Write a comment')]"));
        commentBox.sendKeys("\n");
    }

    @Then("my comment should appear under the post")
    public void my_comment_should_appear_under_the_post() {

        WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'This is an automated comment!')]")));
        if (comment.isDisplayed()) {
            System.out.println("Comment successfully posted.");
        } else {
            System.out.println("Comment was not posted.");
        }

        driver.quit(); 

        driver.quit(); 

    }
}
