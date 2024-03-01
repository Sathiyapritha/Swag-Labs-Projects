import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        //features = ".", tags ="@sort")
        features = {"src/test/features/sortPrice.feature"},
        dryRun =!true,
    //glue ={"stepsDefinitions","Hooks"},
snippets = CucumberOptions.SnippetType.CAMELCASE)


public class RunTest {


}