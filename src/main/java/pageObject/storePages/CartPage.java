package pageObject.storePages;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObject.basePage.BasePage;

public class CartPage extends BasePage {

    private final By totalPrice = By.xpath("//h3[@id='totalp']");
    private final By placeOrder = By.xpath("//button[@data-toggle='modal']");
    private final By nameField = By.id("name");
    private final By countryField = By.id("country");
    private final By cityField = By.id("city");
    private final By creditCardField = By.id("card");
    private final By monthField = By.id("month");
    private final By yearField = By.id("year");
    private final By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private final By succesBuy = By.xpath("//h2[text()='Thank you for your purchase!']");
    private final By okBtn = By.xpath("//button[text()='OK']");

    public CartPage checkAddProduct(String productName) {
        Assert.assertEquals(getNameProduct(), productName);
        return this;
    }

    public CartPage checkTotalProduct(String expectedPrice) {
        Assert.assertEquals(getPriceProduct(), expectedPrice);
        return this;
    }

    public String getNameProduct() {
        String str = driver.findElement(By.xpath("(//tr[@class='success']/td)[2]")).getText();
        return str;
    }

    public String getPriceProduct() {
        pause(2);
        String price = driver.findElement(totalPrice).getText();
        System.out.println(price);
        return price;
    }

    public CartPage clickOnPlaceOrder() {
        click(placeOrder);
        return this;
    }

    public CartPage enterName(String text) {
        System.out.println(text);
        enterText(nameField, text);
        return this;
    }

    public CartPage enterCountry(String text) {
        enterText(countryField, text);
        return this;
    }

    public CartPage enterCity(String text) {
        enterText(cityField, text);
        return this;
    }

    public CartPage enterCreditCard(String text) {
        enterText(creditCardField, text);
        return this;
    }

    public CartPage enterMonth(String text) {
        enterText(monthField, text);
        return this;
    }

    public CartPage enterYear(String text) {
        enterText(yearField, text);
        return this;
    }

    public CartPage clickOnPurchaseBtn() {
        click(purchaseBtn);
        return this;
    }

    public CartPage succesBuy() {
        elementIsDisplayed(succesBuy);
        click(okBtn);
        return this;
    }
}
