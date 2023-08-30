package pageFactory.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.basePage.BasePage;
import pageObject.storePages.NavigationItem;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='col-lg-4 col-md-6 mb-4']")
    WebElement allProducts;

    @FindBy(xpath = "//h5[text()='$360']")
    WebElement galaxyS6Price;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public MainPage open(String url) {
        load(url);
        return this;
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

    public MainPage equalSize(Integer count) {
        Assert.assertEquals(getSize(), count);
        return this;
    }

    public String getPrice() {
        pause(2);
        return galaxyS6Price.getText();
    }

    public MainPage equalPrise(String price) {
        Assert.assertEquals(getPrice(), price);
        return this;
    }

}
