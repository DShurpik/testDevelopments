package pageObject.basePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.ConfigProvider.readConfigDemoblaze;
import static driver.SingletonDriver.closeDriver;

public abstract class BaseTestForPageFactory {

    @BeforeMethod
    public void setUp() {
        readConfigDemoblaze();
    }

    @AfterMethod
    public void closeWebDriver() {
        closeDriver();
    }
}
