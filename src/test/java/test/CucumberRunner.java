package test;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features="<path of feature file>", glue="<path of step defs class>")

public class CucumberRunner {
    //test push
}
