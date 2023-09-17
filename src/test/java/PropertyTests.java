import utils.ConfigProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static utils.ConfigProvider.readConfig;

public class PropertyTests {

    @Test
    public void propertyTest1() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("apps.properties"));

        String userName = System.getProperty("userName");
        String userSurname = System.getProperty("userSurname");

        System.out.println(userName + " " + userSurname);
    }

    @Test
    public void confFileTest() {
        String userName = readConfig().getString("userName");
        String surname = readConfig().getString("userSurname");
        Integer age = readConfig().getInt("age");
        System.out.println(userName);
        System.out.println(surname);
        System.out.println(age);

    }

    @Test
    public void confFileTest1() {
        String adminName = readConfig().getString("usersParams.admin.login");
        String adminSurname = readConfig().getString("usersParams.admin.password");
        Boolean isAdmin = readConfig().getBoolean("usersParams.admin.isAdmin");
        System.out.println(adminName);
        System.out.println(adminSurname);
        System.out.println(isAdmin);
    }

    @Test
    public void confFileTest2() {
        String adminName = ConfigProvider.readConfig().getString("usersParams.simpleUser.login");
        String adminSurname = ConfigProvider.readConfig().getString("usersParams.simpleUser.password");
        Boolean isAdmin = ConfigProvider.readConfig().getBoolean("usersParams.simpleUser.isAdmin");
        System.out.println(adminName);
        System.out.println(adminSurname);
        System.out.println(isAdmin);
    }

    @Test
    public void confFileTest3() {
        if (ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")) {
            System.out.println("Yes, this user is admin");
        } else {
            System.out.println("No, this user is not admin");
        }
    }
}
