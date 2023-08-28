package firstHW.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test1_Google extends preconditions{

    @Test
    public void test1(){
        open("https://www.google.com/");
        String titleName = getWebDriver().getTitle();
        String actualUrl = getWebDriver().getCurrentUrl();

        System.out.println(titleName);
        System.out.println(actualUrl);

        String expectedUrl = "https://www.google.com/";
        String expectedTitle = "Google";

        Assert.assertEquals(actualUrl, expectedUrl);
        Assert.assertEquals(titleName, expectedTitle);
    }

    @Test()
    public void test2(){
        open("https://www.google.com/");
        getWebDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("“*//*”", Keys.ENTER);;

        WebElement resultSearch = getWebDriver().findElement(By.xpath("//p[@aria-level='3']"));
        System.out.println(resultSearch.getText());
        String actualResult = resultSearch.getText();
        String expectedResult = "По запросу “*//*” ничего не найдено. ";

        Assert.assertEquals(actualResult, expectedResult);
    }
}
