package firstHW.task1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class test2_ShareLane extends preconditions{

    static String email;
    static String password;

    @Test(priority = 1)
    public void test1_positive(){
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
        getWebDriver().findElement(By.name("zip_code")).sendKeys("11111");
        getWebDriver().findElement(By.xpath("//input[@value='Continue']")).click();
        getWebDriver().findElement(By.xpath("//input[@value='Register']")).isDisplayed();
    }

    @Test(priority = 2)
    public void test2_negative(){
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
        getWebDriver().findElement(By.name("zip_code")).sendKeys("111");
        getWebDriver().findElement(By.xpath("//input[@value='Continue']")).click();
        getWebDriver().findElement(By.xpath("//span[@class='error_message']")).isDisplayed();
    }

    @Test(priority = 3)
    public void test3_registration_new_user(){
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
        getWebDriver().findElement(By.name("zip_code")).sendKeys("11111");
        getWebDriver().findElement(By.xpath("//input[@value='Continue']")).click();
        getWebDriver().findElement(By.name("first_name")).sendKeys("John");
        getWebDriver().findElement(By.name("last_name")).sendKeys("Doe");
        getWebDriver().findElement(By.name("email")).sendKeys("JohnDoe@gmail.com");
        getWebDriver().findElement(By.name("password1")).sendKeys("qwerty");
        getWebDriver().findElement(By.name("password2")).sendKeys("qwerty");
        getWebDriver().findElement(By.xpath("//input[@value='Register']")).click();
        email = getWebDriver().findElement(By.xpath("//table[@border]//b")).getText();
        password = getWebDriver().findElement(By.xpath("(//table[@border]//tr//td)[4]")).getText();
        getWebDriver().findElement(By.xpath("//span[@class='confirmation_message']")).isDisplayed();


        System.out.println(getWebDriver().findElement(By.xpath("(//td//b)[2]")).getText());
        System.out.println(getWebDriver().findElement(By.xpath("(//tbody//tr//td)[17]")).getText());
    }

    @Test(priority = 4)
    public void test4_authorization_user() throws InterruptedException {
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
        getWebDriver().findElement(By.xpath("//a[@href='./main.py']")).click();
        getWebDriver().findElement(By.name("email")).sendKeys(email);
        getWebDriver().findElement(By.name("password")).sendKeys(password);
        getWebDriver().findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
        getWebDriver().findElement(By.xpath("//span[@class='user']")).isDisplayed();
    }

    @Test(priority = 5)
    public void test5_add_book() throws InterruptedException {
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
        getWebDriver().findElement(By.xpath("//a[@href='./main.py']")).click();
        Thread.sleep(2000);
        getWebDriver().findElement(By.name("email")).sendKeys(email);
        getWebDriver().findElement(By.name("password")).sendKeys(password);
        getWebDriver().findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
        getWebDriver().findElement(By.xpath("//span[@class='user']")).isDisplayed();
        Thread.sleep(2000);
        getWebDriver().findElement(By.xpath("(//td)[12]")).click();
        Thread.sleep(2000);
        getWebDriver().findElement(By.xpath("(//a[@href])[4]")).click();
        Thread.sleep(2000);
        getWebDriver().findElement(By.xpath("//span[@class='confirmation_message']")).isDisplayed();
        getWebDriver().findElement(By.xpath("(//td//a)[2]")).click();
        getWebDriver().findElement(By.xpath("//input[@type='text'][@name='q']")).clear();
        getWebDriver().findElement(By.xpath("//input[@type='text'][@name='q']")).sendKeys("10");
        getWebDriver().findElement(By.xpath("//input[@type='submit'][@value='Update']")).click();
        Thread.sleep(2000);
        System.out.println(getWebDriver().findElement(By.xpath("(//td)[23]")).getText());
    }
}
