package run;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\4A\\Downloads\\abbbc\\src\\main\\java\\feature\\search.feature",
    glue = {"stepDefination"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)

public class SearchRnner {

}
