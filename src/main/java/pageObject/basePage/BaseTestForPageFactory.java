package pageObject.basePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Utils.ConfigProvider.readConfigDemoblaze;
import static driver.SimpleDriver.closeDriver;
import static driver.SimpleDriver.*;

public abstract class BaseTestForPageFactory {


    @BeforeMethod
    public void setUp() {
        readConfigDemoblaze();
        createDriver();
        //setWebDriver();
    }

    @AfterMethod
    public void closeWebDriver() {
        closeDriver();
    }


}
