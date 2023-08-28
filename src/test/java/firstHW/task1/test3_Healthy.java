package firstHW.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test3_Healthy extends preconditions{

    @Test
    public void testHealth(){
        getWebDriver().get("https://healthunify.com/bmicalculator/");
        getWebDriver().findElement(By.name("wg")).sendKeys("80");
        getWebDriver().findElement(By.name("ht")).sendKeys("180");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "24.69";
        System.out.println(getWebDriver().findElement(By.name("si")).getAttribute("value"));
        Assert.assertEquals(getWebDriver().findElement(By.name("si")).getAttribute("value"), expectedResult);
    }

    @Test
    public void test2(){
        getWebDriver().get("https://healthunify.com/bmicalculator/");
        Select selectWeight = new Select(getWebDriver().findElement(By.name("opt1")));
        selectWeight.selectByValue("pounds");
        WebElement weightField = getWebDriver().findElement(By.name("wg"));
        weightField.clear();
        weightField.sendKeys("180");
        Select selectHeight1 = new Select(getWebDriver().findElement(By.name("opt2")));
        selectHeight1.selectByValue("6");
        Select selectHeight2 = new Select(getWebDriver().findElement(By.name("opt3")));
        selectHeight2.selectByValue("4");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "Your category is Obese";
        Assert.assertEquals(getWebDriver().findElement(By.name("desc")).getAttribute("value"), expectedResult);
    }
}
