import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/LogIn.feature"},
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "junit:target/cucumber-reports/Cucumber.xml"}
)
public class Runner {}
