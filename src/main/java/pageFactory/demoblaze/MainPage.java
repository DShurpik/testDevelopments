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

    @FindBy(xpath = "//h5[text()='$360']")
    private WebElement galaxyS6Price;

    @FindBy(xpath = ".//a[text()='Dell i7 8gb']/../../h5")
    private WebElement dellI7Price;

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

    public String getPrice() {
        pause(2);
        return galaxyS6Price.getText();
    }

    public String getPriceDellI7() {
        pause(2);
        return dellI7Price.getText();
    }

}
