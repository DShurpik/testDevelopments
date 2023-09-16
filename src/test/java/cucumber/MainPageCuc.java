package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static driver.SimpleDriver.*;

public class MainPageCuc {

    public MainPageCuc() {
        // Конструктор без аргументов
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Laptops")
    WebElement laptopsLink;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "MacBook Pro")
    WebElement macBookProFindBy;


    private final By nextBtn = By.xpath("//button[@id='next2']");
    private final By samsungS6 = By.xpath("//a[text()='Samsung galaxy s6']");
    private final By macBookPro = By.xpath("//a[text()='MacBook Pro']");
    private final By addToCartBtn = By.xpath("//a[@class='btn btn-success btn-lg']");


    @When("Open web site")
    public MainPageCuc openPage() throws InterruptedException {
        getDriver().get("https://www.demoblaze.com/");
        Thread.sleep(3000);
        return this;
    }

    @And("Click add to cart button")
    public MainPageCuc clickAddToCart() throws InterruptedException {
        getDriver().findElement(addToCartBtn).click();
        Thread.sleep(2000);
        return this;
    }

    @Then("Open phone tabs")
    public MainPageCuc navigateToPhone() throws InterruptedException {
        getDriver().findElement(samsungS6).click();
        Thread.sleep(3000);
        return this;
    }

    public MainPageCuc pressNextBtn() throws InterruptedException {
        WebElement element = getDriver().findElement(nextBtn);
        Actions actions = new Actions(getDriver());

        actions.scrollToElement(element);
        element.click();
        Thread.sleep(2000);
        return this;
    }

    @Then("Open MacBook Pro link")
    public MainPageCuc open_mac_book_pro_link() throws InterruptedException {
        Actions actions = new Actions(getDriver());

        actions.scrollToElement(macBookProFindBy);
        macBookProFindBy.click();
        Thread.sleep(2000);
        return this;
    }

    @And("Accept alert")
    public MainPageCuc acceptAlert() throws InterruptedException {
        getDriver().switchTo().alert().accept();
        Thread.sleep(2000);
        return this;
    }

    @And("Open laptops tab")
    public MainPageCuc open_laptops_tab() throws InterruptedException {
        laptopsLink.click();
        Thread.sleep(2000);
        return this;
    }
}
