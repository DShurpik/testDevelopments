package firstHW.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ad{

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().minimize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        System.out.println("Driver open");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        System.out.println("Driver send text on user name field");

        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        System.out.println("Driver send text on password field");

        Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        System.out.println("Driver click on login button");

        Thread.sleep(3000);

        driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
        System.out.println("Driver click on add product to cart");

        Thread.sleep(3000);

        driver.findElement(By.className("shopping_cart_link")).click();
        System.out.println("Driver click on cart btn");

        Thread.sleep(3000);

        //driver.findElement(By.id("menu-item-16")).click();


    }
}
