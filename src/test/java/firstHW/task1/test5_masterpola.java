package firstHW.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class test5_masterpola extends preconditions{

    @Test
    public void test1(){
        open("https://masterskayapola.ru/kalkulyator/laminata.html");
        WebElement setRoomWidth = findElement("calc_roomwidth");
        setRoomWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "4.4");
        WebElement setRoomHeight = findElement("calc_roomheight");
        setRoomHeight.sendKeys(Keys.chord(Keys.CONTROL, "a"), "5.5");
        WebElement setLaminateWidth = findElement("calc_lamwidth");
        setLaminateWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1600");
        WebElement setLaminateHeight = findElement("calc_lamheight");
        setLaminateHeight.sendKeys(Keys.chord(Keys.CONTROL, "a"), "250");
        WebElement setInpack = findElement("calc_inpack");
        setInpack.sendKeys(Keys.chord(Keys.CONTROL, "a"), "25");
        WebElement setPrice = findElement("calc_price");
        setPrice.sendKeys(Keys.chord(Keys.CONTROL, "a"), "850");
        Select selectDirect = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirect.selectByValue("toh");
        WebElement setBias = findElement("calc_bias");
        setBias.sendKeys(Keys.chord(Keys.CONTROL, "a"), "650");
        WebElement setWallDist = findElement("calc_walldist");
        setWallDist.sendKeys(Keys.chord(Keys.CONTROL, "a"), "100");
        WebElement submit = getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        submit.click();
        List<String> expectedResult = Arrays.asList(
                "22.26 м2.", "62 шт.", "3 шт.", "25500 руб.", "13 шт.", "6 шт."
        );
        Assert.assertEquals(expectedResult, getActualResult());
    }

    @Test
    public void test2() {
        open("https://masterskayapola.ru/kalkulyator/laminata.html");
        enter("calc_roomwidth", "14");
        enter("calc_roomheight", "7");
        enter("calc_lamwidth", "1500");
        enter("calc_lamheight", "250");
        enter("calc_inpack", "10");
        enter("calc_price", "500");
        select("calc_direct", "toh");
        enter("calc_bias", "100");
        enter("calc_walldist", "15");
        click("Рассчитать");

        List<String> expectedResult = Arrays.asList(
                "97.37 м2.", "264 шт.", "27 шт.", "50625 руб.", "6 шт.", "19 шт."
        );
        Assert.assertEquals(getActualResult(), expectedResult);
    }

    public WebElement enter(String name, String value){
        getWebDriver().findElement(By.name(name)).sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
        return getWebDriver().findElement(By.name(name));
    }

    public void click(String name) {
        getWebDriver().findElement(By.xpath("//input[@value='"+name+"']")).click();
    }

    public void select(String name, String value){
        Select selectDirect = new Select(getWebDriver().findElement(By.name(name)));
        selectDirect.selectByValue(value);
    }

    public List<String> getActualResult(){
        String squareLam = getWebDriver().findElement(By.id("s_lam")).getText();
        String numPan = getWebDriver().findElement(By.id("l_count")).getText();
        String numPack = getWebDriver().findElement(By.id("l_packs")).getText();
        String allPrice = getWebDriver().findElement(By.id("l_price")).getText();
        String overEnd = getWebDriver().findElement(By.id("l_over")).getText();
        String trashEnd = getWebDriver().findElement(By.id("l_trash")).getText();
        List<String> actualResult = Arrays.asList(
                squareLam, numPan, numPack, allPrice, overEnd, trashEnd
        );
        return actualResult;
    }

    private WebElement findElement(String name){
        getWebDriver().findElement(By.name(name));
        getWebDriver().findElement(By.name(name)).click();
        return getWebDriver().findElement(By.name(name));
    }
}
