package test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features="src/test/resources/features",
        glue="test.cucumber.stepdefs")
        //    src\test\java\test\cucumber\stepdefs\ScanMaltaStepDefs.java

//@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features", glue = "test.cucumber.stepdefs")
public class CucumberRunner {

}
