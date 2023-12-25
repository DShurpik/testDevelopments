package pageObject.basePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static driver.SingletonDriver.closeDriver;

public abstract class BaseTestForPageFactory {

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void closeWebDriver() {
        closeDriver();
    }
}
