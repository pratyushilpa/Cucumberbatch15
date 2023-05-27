package TestRunner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
        glue="StepDefinitions" ,
        dryRun = false,
        tags="@database",

       plugin={"pretty","html:target/Cucumber.html","json:target/Cucumber.json","rerun:target/failed.txt"}
)

public class SmokeRunner {
}
