import io.qameta.allure.*;
import loader.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.basePage.BaseTest;

import static confOwnerUtils.ConfigurationManager.config;
import static utils.PropertyReader.getProperties;

public class OwnersTest extends BaseTest {

    @Step("Type {0} into 'Password' textbox")
    public static String typePassword(final String password) {
        return password;
    }

    @Owner("John Doe")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Addition Test Case")
    @Test
    @Step("Checking values from the default config file.")
    public void test1() {
        Assert.assertEquals(typePassword(config().rolesAdminUserName()), "dev_admin_user");
        Assert.assertEquals(typePassword(config().rolesUserUserName()), "dev_regular_user");
    }

    @Owner("John Doe")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Addition Test Case")
    @Test
    @Step("Checking values from the default config file.")
    public void test2() {
        String dbUrl = ConfigLoader.getProperty("db.url");
        String dbUsername = ConfigLoader.getProperty("db.username");
        String dbPassword = ConfigLoader.getProperty("db.password");

        System.out.println("Connecting to database: " + dbUrl);
        System.out.println("Username: " + dbUsername);
        System.out.println("Password: " + dbPassword);
    }

    @Owner("John Doe")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Values from different property files")
    @Test
    public void test3() {
        // Profiles values
        String dbUrl = ConfigLoader.getProperty("db.url");
        String dbUsername = ConfigLoader.getProperty("db.username");
        String dbPassword = ConfigLoader.getProperty("db.password");

        System.out.println("Connecting to database: " + dbUrl);
        System.out.println("Profile username: " + dbUsername);
        System.out.println("Profile password: " + dbPassword);

        // Property reader values
        String userName = getProperties().getProperty("userName");
        String password = getProperties().getProperty("password");

        System.out.println("User name from property reader: " + userName);
        System.out.println("Password from property reader: " + password);
    }


}
