package pageObject.basePage;

import lombok.extern.log4j.Log4j2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObject.UIElement;

import java.time.Duration;
import java.util.Properties;

import static utils.PropertyReader.getProperties;
import static driver.SingletonDriver.getInstance;
@Log4j2
public abstract class BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BasePage.class.getName());

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
        LOGGER.info(String.format("Page %s opened", url));
        LOGGER.debug(String.format("Page %s opened", url));
        log.debug("Open page " + url);
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
