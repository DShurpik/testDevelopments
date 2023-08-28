package firstHW.task1.task1WithStar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class linkText {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.linkText("QATutor.com")).click();
        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.partialLinkText("Test")).click();
        Thread.sleep(3000);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.linkText("Python Source File")).click();
        Thread.sleep(3000);
    }
}
