package pageFactory.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.basePage.BasePage;
import pageObject.storePages.NavigationItem;

import java.util.List;

import static Utils.ConfigProvider.readConfigDemoblaze;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    private WebElement allProducts;

    public MainPage() {
        load(readConfigDemoblaze().getString("url"));
        PageFactory.initElements(driver, this);
    }

    public MainPage navigateTo(NavigationItem navigationItem ){
        click(getByLink(navigationItem.getItem()));
        return this;
    }

    public Integer getSize() {
        pause(1);
        List<WebElement> elements = allProducts.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
        System.out.println("Size of elements = " + elements.size());
        return elements.size();
    }

    public String getPrice(ProductItems product) {
        pause(2);
        return driver.findElement(By.xpath(".//a[text()=" + product.getItem() + "]/../../h5")).getText();
    }

    public String getPrice(String product) {
        pause(2);
        //return driver.findElement(By.xpath(".//a[text()=" + product + "]/../../h5")).getText();
        return driver.findElement(By.xpath(".//a[contains(text(), '" + product + "')]/../../h5")).getText();
    }
}
