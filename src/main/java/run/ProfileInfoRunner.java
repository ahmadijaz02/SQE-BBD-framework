package run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\4A\\Downloads\\abbbc\\src\\main\\java\\feature\\profileUpdate.feature",
    glue = {"stepDefination"},
    plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true
)

public class ProfileInfoRunner {

}