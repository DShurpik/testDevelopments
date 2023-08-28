package firstHW.task1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class onliner extends preconditions{


    @Test
    public void test1() throws InterruptedException {
        open("https://www.onliner.by/");
        Thread.sleep(4000);

        //driver.findElement(By.linkText("Форум")).click();
        //Thread.sleep(4000);

        getWebDriver().findElement(By.partialLinkText("Фо")).click();
        Thread.sleep(3000);
    }
}
