package pageObject.storePages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObject.basePage.BasePage;

import java.util.List;
@Log4j
public class MainPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());

    private final By allProducts = By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']");
    private final By categoriesField = By.id("cat");
    private final By newMessage = By.xpath("//h5[@id='exampleModalLabel']");
    private final By closeNewMessage = By.xpath("(//button[@class='close'])[1]");
    private final By aboutUs = By.xpath("//h5[@id='videoModalLabel']");
    private final By aboutUsClose = By.xpath("(//button[@class='close'])[4]");
    private final By placeOrder = By.xpath("//button[@data-target='#orderModal']");
    private final By logIn = By.xpath("//h5[@id='logInModalLabel' and text()='Log in']");
    private final By closeLogIn = By.xpath("(//button[@data-dismiss='modal'])[7]");
    private final By signUp = By.xpath("//h5[@id='signInModalLabel']");
    private final By closeSignUp = By.xpath("(//button[@data-dismiss='modal'])[3]");
    private final By userNameFieldForReg = By.xpath("//input[@id='sign-username']");
    private final By passwordFieldForReg = By.xpath("//input[@id='sign-password']");
    private final By userNameFieldForAuth = By.xpath("//input[@id='loginusername']");
    private final By passwordFieldForAuth = By.xpath("//input[@id='loginpassword']");
    private final By nameOfUSer = By.xpath("//a[@id='nameofuser']");
    private final By signUpBtn = By.xpath("//button[@onclick='register()']");
    private final By logInBtn = By.xpath("//button[@onclick='logIn()']");
    private final By logOutBtn = By.xpath("//a[@id='logout2']");
    private final By signUpBtnFromMainPage = By.xpath("//a[@id='signin2']");

    @Step("Open site page")
    public MainPage open() {
        load("https://www.demoblaze.com/index.html");
        return this;
    }

    public MainPage equalNameUser(String string) {
        pause(5);
        System.out.println(driver.findElement(nameOfUSer).getText());
        Assert.assertEquals(driver.findElement(nameOfUSer).getText(), string);
        return this;
    }

    public MainPage equalNameUserAfterLogIn(String string) {
        pause(5);
        System.out.println(driver.findElement(signUpBtnFromMainPage).getText());
        Assert.assertEquals(driver.findElement(signUpBtnFromMainPage).getText(), string);
        return this;
    }

    @Step("Checking equal size")
    public MainPage equalSize(Integer count) {
        Assert.assertEquals(getSize(), count);
        log.debug(String.format("Phone count is %d", getSize()));
        return this;
    }

    public Integer getSize() {
        pause(1);
        List<WebElement> elements = driver.findElements(allProducts);
        return elements.size();
    }

    @Step("Navigate to")
    public MainPage navigateTo(NavigationItem navigationItem ){
        click(getByLink(navigationItem.getItem()));
        LOGGER.info(String.format("Navigate to %s", navigationItem));
        return this;
    }

    public MainPage checkProduct(NavigationItem navigationItem) {
        waitVisElem(getByLink(navigationItem.getItem()));
        System.out.println(getByLink(navigationItem.getItem()) + " Is displayed");
        Assert.assertTrue(driver.findElement(getByLink(navigationItem.getItem())).isDisplayed());
        return this;
    }

    public MainPage checkCategories() {
        elementIsDisplayed(categoriesField);
        return this;
    }

    public MainPage checkContact() {
        elementIsDisplayed(newMessage);
        click(closeNewMessage);
        return this;
    }

    public MainPage checkAboutUs() {
        elementIsDisplayed(aboutUs);
        click(aboutUsClose);
        return this;
    }

    public MainPage checkCart() {
        elementIsDisplayed(placeOrder);
        return this;
    }

    public MainPage checkLogIn() {
        elementIsDisplayed(logIn);
        click(closeLogIn);
        return this;
    }

    public MainPage checkSignUp() {
        elementIsDisplayed(signUp);
        click(closeSignUp);
        return this;
    }

    public MainPage enterUserNameForReg(String userName, String password) {
        enterText(userNameFieldForReg, userName);
        System.out.println(userName);
        enterText(passwordFieldForReg, password);
        System.out.println(password);
        click(signUpBtn);
        pause(5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }

    public MainPage enterUserNameForAuth(String userName, String password) {
        enterText(userNameFieldForAuth, userName);
        System.out.println(userName + " UserName for auth");
        enterText(passwordFieldForAuth, password);
        System.out.println(password + " Password for auth");
        click(logInBtn);
        return this;
    }

    public MainPage clickLogOut() {
        click(logOutBtn);
        return this;
    }


}
