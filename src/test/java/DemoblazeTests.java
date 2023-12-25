import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageObject.basePage.BaseTest;
import pageObject.storePages.CartPage;
import pageObject.storePages.MainPage;
import pageObject.storePages.ProductPage;

import static pageObject.storePages.NavigationItem.*;

@Log4j2
public class DemoblazeTests extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DemoblazeTests.class.getName());

    @Test
    public void test11() {
        log.debug("LOG DEBUG");
        log.info("LOG INFO");
        LOGGER.info("LOGGER INFO");
        LOGGER.debug("LOGGER DEBUG");
    }

    @Test(description = "Phones equal 7")
    @TmsLink("TMS link here")
    @Owner("D.Shurpik")
    @Feature("UI")
    @Description("Phones equal 7")
    @Severity(SeverityLevel.CRITICAL)
    public void test1(){
        MainPage mainPage = new MainPage();
        log.info("LOG!!!!!!!!!!!!!!!!!!!!!!!");
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.open();
        mainPage.navigateTo(PHONES);
        mainPage.equalSize(7);
    }

    @Test(description = "Laptops equal 6")
    public void test2(){
        System.out.println("TEST 2");
        new MainPage()
                .open()
                .navigateTo(LAPTOPS)
                .equalSize(6);
    }

    @Test(description = "Monitors equal 2")
    public void test3(){
        System.out.println("TEST 3");
        new MainPage()
                .open()
                .navigateTo(MONITORS)
                .equalSize(2);
    }

    @Test(description = "Check product navigation")
    public void test4() {
        System.out.println("TEST 4");
        new MainPage()
                .open()
                .navigateTo(MONITORS)
                .checkProduct(APPLE_MONITOR_24)
                .navigateTo(LAPTOPS)
                .checkProduct(SONY_VAIO_I5)
                .navigateTo(PHONES)
                .checkProduct(SAMSUNG_GALAXY_S6);
    }

    @Test(description = "Check header navigation")
    public void test5() {
        System.out.println("TEST 5");
        new MainPage()
                .open()
                .checkCategories()
                .navigateTo(CONTACT)
                .checkContact()
                .navigateTo(ABOUT_US)
                .checkAboutUs()
                .navigateTo(CART)
                .checkCart()
                .navigateTo(LOG_IN)
                .checkLogIn()
                .navigateTo(SIGN_UP)
                .checkSignUp();
    }


    @Test(description = "Registration user")
    public void test6() {
        new MainPage()
                .open()
                .navigateTo(SIGN_UP)
                .enterUserNameForReg(properties.getProperty("userName"), properties.getProperty("password"))
                .navigateTo(LOG_IN)
                .enterUserNameForAuth(properties.getProperty("userName"), properties.getProperty("password"))
                .equalNameUser("Welcome " + properties.getProperty("userName"));
    }

    @Test(description = "Check auth and check log out")
    public void test7() {
        new MainPage()
                .open()
                .navigateTo(LOG_IN)
                .enterUserNameForAuth(properties.getProperty("userName"), properties.getProperty("password"))
                .equalNameUser("Welcome " + properties.getProperty("userName"))
                .clickLogOut()
                .equalNameUserAfterLogIn("Sign up");
    }

    @Test(description = "Add product to cart and check it")
    public void test8() {
        new MainPage()
                .open()
                .navigateTo(PHONES)
                .navigateTo(SAMSUNG_GALAXY_S6);
        new ProductPage()
                .addProductToCart()
                .checkAlert()
                .navigateTo(CART);
        new CartPage()
                .checkAddProduct("Samsung galaxy s6");
    }

    @Test(description = "Add three MacBook PRO to the cart and check price equal 3300")
    public void test9() {
        new MainPage()
                .open()
                .navigateTo(LAPTOPS)
                .navigateTo(MACBOOK_PRO);
        new ProductPage()
                .addProductToCart(3)
                .navigateTo(CART);
        new CartPage()
                .checkTotalProduct("3300");
    }

    @Test(description = "Add product to cart and check it")
    public void test10() {
        new MainPage()
                .open()
                .navigateTo(MONITORS)
                .navigateTo(ASUS_FULL_HD);
        new ProductPage()
                .addProductToCart()
                .checkAlert()
                .navigateTo(CART);
        new CartPage()
                .clickOnPlaceOrder()
                .enterName("firstName")
                .enterCountry("America")
                .enterCity("Boston")
                .enterCreditCard("5800 0000 1111 2222")
                .enterMonth("January")
                .enterYear("2022")
                .clickOnPurchaseBtn()
                .succesBuy();
    }
}
