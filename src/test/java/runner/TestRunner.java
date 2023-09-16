package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/cucumber"},
        plugin = {"pretty"},
        glue = {"cucumber", "runner"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
