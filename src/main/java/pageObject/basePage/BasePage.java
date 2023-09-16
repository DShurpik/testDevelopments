package pageObject.basePage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.UIElement;

import java.time.Duration;
import java.util.Properties;

import static Utils.PropertyReader.getProperties;
import static driver.SingletonDriver.getInstance;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Properties properties;

    public BasePage() {
        driver = getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        properties = getProperties();
    }

    protected void load(String url) {
        driver.get(url);
    }

    protected void click(By locator) {
        WebElement webElement = driver.findElement(locator);
        new UIElement(driver, wait, webElement).click();
    }

    protected void enterText(By locator, String string) {
        driver.findElement(locator).sendKeys(string);
    }

    protected void elementIsDisplayed(By locator) {
        System.out.println("element is displayed");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }

    protected void waitVisElem(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void verifyElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected By getByLink(String textLink){
        return By.partialLinkText(textLink);
    }

    protected void pause(Integer integer) {
        try {
            Thread.sleep(integer * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
