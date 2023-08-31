import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.demoblaze.MainPage;
import pageObject.basePage.BaseTestForPageFactory;

import static pageObject.storePages.NavigationItem.*;

public class DemoblazePFTests extends BaseTestForPageFactory {

    @Test(description = "Phones count equal 7 items")
    public void test1() {

        int size = new MainPage()
                .navigateTo(PHONES)
                .getSize();

        Assert.assertEquals(size, 7);
    }

    @Test(description = "Phone Samsung Galaxy S6 price is $360")
    public void test2() {

        String price = new MainPage()
                .navigateTo(PHONES)
                .getPrice();

        Assert.assertEquals(price, "$360");
    }

    @Test(description = "Laptops count equal 6")
    public void test3() {
        int size = new MainPage()
                .navigateTo(LAPTOPS)
                .getSize();

        Assert.assertEquals(size, 6);
    }

    @Test(description = "Dell i7 8gb price is 700$")
    public void test4() {
        String price = new MainPage()
                .navigateTo(LAPTOPS)
                .getPriceDellI7();

        Assert.assertEquals(price, "$700");
    }


}
