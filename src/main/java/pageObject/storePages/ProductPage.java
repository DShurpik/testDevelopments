package pageObject.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.basePage.BasePage;

public class ProductPage extends BasePage {

    private By addToCart = By.partialLinkText("Add to cart");

    public ProductPage addProductToCart() {
        click(addToCart);
        return this;
    }

    public ProductPage addProductToCart(Integer count) {
        for (int i = 1; i <= count; i++){
            click(addToCart);
            checkAlert();
        }
        return this;
    }

    public ProductPage checkAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }

    public ProductPage navigateTo(NavigationItem navigationItem ){
        click(getByLink(navigationItem.getItem()));
        pause(2);
        return this;
    }
}
