import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class CookieTest {
    @Test(description = "Авторизация через куки которые уже знаем :(")
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://karopka.ru/");

        driver.manage().addCookie(new Cookie("PHPSESSID", "t9gDz5nk2lILBH306ORtU2vwy4kjxKBx"));

        driver.navigate().refresh();

        String actualResult = driver.findElement(By.xpath("//a[@class='mypage']")).getText();
        Assert.assertEquals(actualResult, "Dima S (Damavik)");
        driver.close();
        driver.quit();
    }

    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://at-sandbox.workbench.lanit.ru/tickets/");
        String token = driver.manage().getCookieNamed("csrftoken").getValue();

        // MULTIPART потому что в PayLoad
        // Request URL:
        //https://at-sandbox.workbench.lanit.ru/login/
        //Request Method:
        //POST
        // username: admin
        //password: adminat
        //next: /
        //csrfmiddlewaretoken: Bscw8GTt7ymsbHQVyoben10NrEd5E1DvQvPcp5LdPPrHBDwSvE8NAO9ORXD9FnAa

        String sessionID = given()
                .contentType(ContentType.MULTIPART)
                .cookie("csrftoken", token)
                .multiPart("username", "admin")
                .multiPart("password", "adminat")
                .multiPart("next", "/")
                .multiPart("csrfmiddlewaretoken", token)
                .post("https://at-sandbox.workbench.lanit.ru/login/")
                .then().extract().cookie("sessionid");
        Date date = new Date();
        date.setTime(date.getTime() + (10000 * 10000));

        Cookie cookie = new Cookie("sessionid", sessionID, "at-sandbox.workbench.lanit.ru", "/", date);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        String result = driver.findElement(By.id("userDropdown")).getText();

        Assert.assertEquals(result, "admin");
        driver.close();
        driver.quit();
    }
}
