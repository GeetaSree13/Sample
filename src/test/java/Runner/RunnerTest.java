package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import Steps.Search;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html"},
        features = "src/test/resources/Feature/login.feature",
        glue = "Steps",
        tags = "@Sanity"
)
public class RunnerTest {
}
