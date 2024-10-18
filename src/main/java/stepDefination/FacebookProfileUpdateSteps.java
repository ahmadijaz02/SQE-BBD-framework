package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FacebookProfileUpdateSteps extends BaseTest{

    

public class FacebookProfileUpdateSteps {

    WebDriver driver;


    @Given("I am logged into Facebook for profile update")
    public void i_am_logged_into_facebook() {

    	initializeDriver("chrome");

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("03266899737");  
        driver.findElement(By.id("pass")).sendKeys("ayesha123@");   

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Open Facebook and log in
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("03266899737");  
        driver.findElement(By.id("pass")).sendKeys("ayesha123@");   

        driver.findElement(By.name("login")).click();
    }

    @When("I navigate to the profile settings page")
    public void i_navigate_to_my_profile_page_directly() throws InterruptedException {

        Thread.sleep(5000);

        driver.get("https://www.facebook.com/profile.php?id=61566930432422");

        // Wait for login to complete
        Thread.sleep(5000);

        // Navigate directly to your profile using the provided link
        driver.get("https://www.facebook.com/profile.php?id=61566930432422");

        // Wait for profile page to load

        Thread.sleep(3000);
    }

    @When("I update my profile information")
    public void i_update_my_profile_information() throws InterruptedException {

        WebElement editProfileButton = driver.findElement(By.cssSelector("#mount_0_0_jW > div > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x78zum5.xdt5ytf.x1t2pt76 > div > div > div.x6s0dn4.x78zum5.xdt5ytf.x193iq5w > div.x9f619.x193iq5w.x1talbiv.x1sltb1f.x3fxtfs.x1swvt13.x1pi30zi.xw7yly9 > div > div.x9f619.x1n2onr6.x1ja2u2z.xeuugli.xs83m0k.xjl7jj.x1xmf6yo.x1emribx.x1e56ztr.x1i64zmx.xnp8db0.x1d1medc.x7ep2pv.x1xzczws > div.x7wzq59 > div > div:nth-child(1) > div > div > div > div > div.xieb3on > div:nth-child(1) > div > div.xw7yly9 > div > div > div.x6s0dn4.x78zum5.xl56j7k.x1608yet.xljgi0e.x1e0frkt"));
        editProfileButton.click();
        
        Thread.sleep(3000);

        // Click the "Edit Profile" button (ensure this XPath is correct for your profile)
        WebElement editProfileButton = driver.findElement(By.cssSelector("#mount_0_0_jW > div > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x78zum5.xdt5ytf.x1t2pt76 > div > div > div.x6s0dn4.x78zum5.xdt5ytf.x193iq5w > div.x9f619.x193iq5w.x1talbiv.x1sltb1f.x3fxtfs.x1swvt13.x1pi30zi.xw7yly9 > div > div.x9f619.x1n2onr6.x1ja2u2z.xeuugli.xs83m0k.xjl7jj.x1xmf6yo.x1emribx.x1e56ztr.x1i64zmx.xnp8db0.x1d1medc.x7ep2pv.x1xzczws > div.x7wzq59 > div > div:nth-child(1) > div > div > div > div > div.xieb3on > div:nth-child(1) > div > div.xw7yly9 > div > div > div.x6s0dn4.x78zum5.xl56j7k.x1608yet.xljgi0e.x1e0frkt"));
        editProfileButton.click();
        
        // Wait for the edit profile page to load
        Thread.sleep(3000);


        WebElement aboutField = driver.findElement(By.cssSelector("#mount_0_0_jW > div > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x78zum5.xdt5ytf.x1t2pt76 > div > div > div.x6s0dn4.x78zum5.xdt5ytf.x193iq5w > div.x9f619.x193iq5w.x1talbiv.x1sltb1f.x3fxtfs.x1swvt13.x1pi30zi.xw7yly9 > div > div.x9f619.x1n2onr6.x1ja2u2z.xeuugli.xs83m0k.xjl7jj.x1xmf6yo.x1emribx.x1e56ztr.x1i64zmx.xnp8db0.x1d1medc.x7ep2pv.x1xzczws > div.x7wzq59 > div > div:nth-child(1) > div > div > div > div > div.xieb3on > div:nth-child(1) > div > div > label > div > textarea"));
        aboutField.clear();
        aboutField.sendKeys("Updated bio for automation testing.");

        WebElement saveButton = driver.findElement(By.cssSelector("#mount_0_0_jW > div > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x78zum5.xdt5ytf.x1t2pt76 > div > div > div.x6s0dn4.x78zum5.xdt5ytf.x193iq5w > div.x9f619.x193iq5w.x1talbiv.x1sltb1f.x3fxtfs.x1swvt13.x1pi30zi.xw7yly9 > div > div.x9f619.x1n2onr6.x1ja2u2z.xeuugli.xs83m0k.xjl7jj.x1xmf6yo.x1emribx.x1e56ztr.x1i64zmx.xnp8db0.x1d1medc.x7ep2pv.x1xzczws > div.x7wzq59 > div > div:nth-child(1) > div > div > div > div > div.xieb3on > div:nth-child(1) > div > div > div.x6s0dn4.x78zum5.x1qughib.x1gslohp > div:nth-child(2) > div.x1i10hfl.xjbqb8w.x1ejq31n.xd10rxx.x1sy0etr.x17r0tee.x972fbf.xcfux6l.x1qhh985.xm0m39n.x1ypdohk.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x16tdsg8.x1hl2dhg.xggy1nq.x1o1ewxj.x3x9cwd.x1e5q0jg.x13rtm0m.x87ps6o.x1lku1pv.x1a2a7pz.x9f619.x3nfvp2.xdt5ytf.xl56j7k.x1n2onr6.xh8yej3 > div > div.x6s0dn4.x78zum5.xl56j7k.x1608yet.xljgi0e.x1e0frkt > div > span > span"));
        saveButton.click();
    }

    @Then("the profile information should be updated successfully")
    public void the_profile_information_should_be_updated_successfully() throws InterruptedException {

        Thread.sleep(3000);

        // Wait for the changes to be saved
        Thread.sleep(3000);

        // Verify the updated information

        WebElement bio = driver.findElement(By.xpath("//div[contains(text(), 'Updated bio for automation testing.')]"));
        if (bio.isDisplayed()) {
            System.out.println("Profile information updated successfully.");
        } else {
            System.out.println("Failed to update profile information.");
        }

        driver.quit();
    }
}
