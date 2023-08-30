import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.demoblaze.MainPage;
import pageObject.basePage.BaseTestForPageFactory;

import static Utils.ConfigProvider.readConfigDemoblaze;
import static pageObject.storePages.NavigationItem.*;

public class DemoblazePFTests extends BaseTestForPageFactory {

    @Test(description = "Phones equal 7")
    public void test1() {
        new MainPage()
                .open(readConfigDemoblaze().getString("url"))
                .navigateTo(PHONES)
                .equalSize(7);
    }

    @Test(description = "Phone Samsung Galaxy S6 price is $360")
    public void test2() {
        MainPage mainPage = new MainPage();

        mainPage.open(readConfigDemoblaze().getString("url"))
                .navigateTo(PHONES);

        Assert.assertEquals(mainPage.getPrice(), "$360");
    }

}
