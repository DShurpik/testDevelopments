package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static driver.SingletonDriver.closeDriver;

public class CucumberDriver {

    @Before
    public static void before(Scenario scenario) {

    }

    @After
    public static void after(Scenario scenario) {
        closeDriver();
    }
}
