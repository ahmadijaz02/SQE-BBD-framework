package run;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\4A\\Downloads\\abbbc\\src\\main\\java\\feature\\login.feature",
    glue = {"stepDefination"},
    plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
    monochrome = true
)
public class TestRunner {
	
}
