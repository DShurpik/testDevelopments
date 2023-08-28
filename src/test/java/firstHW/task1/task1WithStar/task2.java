package firstHW.task1.task1WithStar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class task2 {

    WebDriver driver;
    String email;
    String password;

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
    public void test() throws InterruptedException {
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("email")).sendKeys("JohnDoe@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("qwerty");
        driver.findElement(By.name("password2")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        email = driver.findElement(By.xpath("//table[@border]//b")).getText();
        password = driver.findElement(By.xpath("(//table[@border]//tr//td)[4]")).getText();
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//td)[12]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//a[@href])[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Shopping Cart")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='q'][@type='text']")).clear();
        driver.findElement(By.xpath("//input[@name='q'][@type='text']")).sendKeys("20");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='submit'][@value='Update']")).click();
        Thread.sleep(3000);

        // этот элемент берем из CSS во вкладке Propertyes с именем defaultValue
        String quantity = driver.findElement(By.xpath("//input[@name='q'][@type='text']")).getAttribute("defaultValue");

        //String quantity = driver.findElement(By.xpath("//input[@name='q'][@type='text']")).getAttribute("value");

        System.out.println(quantity + " quantity string");
        String price = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[4]")).getText();
        System.out.println(price + " price string");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        System.out.println(discount + " discount string");

        double quantityDouble = Double.parseDouble(quantity);
        System.out.println(quantityDouble + " quantity Double");
        double priceDouble = Double.parseDouble(price);
        System.out.println(priceDouble + " price Double");
        double discountDouble = Double.parseDouble(discount);
        System.out.println(discountDouble + " discount Double");

        /** Формула скидки равна: кол-во товара * цену - (кол-во товара * цену / 100 * % скидки)
         *  В нашем случае в расчете баг, т.к сумма скидки прибавляется к сумме заказа*/

        double totalExpected = quantityDouble * priceDouble - (quantityDouble * priceDouble / 100 * discountDouble);
        System.out.println(totalExpected + " total expected double");
        /** При моих данных, количестве книг 20шт и скидке в 2% итоговая сумма должна получиться 196 */

        String totalActual = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[7]")).getText();
        System.out.println(totalActual + " Total actual string");
        double totalActualDouble = Double.parseDouble(totalActual);
        System.out.println(totalActualDouble + " Total actual double");

        Assert.assertEquals(totalActualDouble, totalExpected, "Сравниваем 2 значения");
    }
}
