package pageObject.basePage;

import listeners.ListenerForProperty;
import org.testng.annotations.*;

import java.util.Properties;

import static Utils.PropertyReader.getProperties;
import static driver.SimpleDriver.*;

@Listeners(ListenerForProperty.class)

public abstract class BaseTest {
    protected Properties properties;

    @BeforeMethod
    public void setUp() {
        properties = getProperties();
        createDriver();
        //setWebDriver();
    }

    @AfterMethod
    public void closeWebDriver() {
        closeDriver();
    }


}
