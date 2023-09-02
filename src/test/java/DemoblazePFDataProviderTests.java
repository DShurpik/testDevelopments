import dataProviders.dataForDemoblazeAllPrices;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.demoblaze.MainPage;
import pageObject.basePage.BaseTestForPageFactory;

import static pageObject.storePages.NavigationItem.*;

public class DemoblazePFDataProviderTests extends BaseTestForPageFactory {

    @Test(description = "Check all phone prices",
            dataProviderClass = dataForDemoblazeAllPrices.class,
            dataProvider = "All products for checking prices")
    public void test1(String phoneName, String phonePrice) {

        String price = new MainPage()
                .navigateTo(PHONES)
                .getPrice(phoneName);

        Assert.assertEquals(price, phonePrice);
    }

    @Test(description = "Check all laptop prices",
            dataProviderClass = dataForDemoblazeAllPrices.class,
            dataProvider = "All laptops for checking prices")
    public void test2(String laptopName, String laptopPrice) {

        String price = new MainPage()
                .navigateTo(LAPTOPS)
                .getPrice(laptopName);

        Assert.assertEquals(price, laptopPrice);
    }

    @Test(description = "Check all laptop prices",
            dataProviderClass = dataForDemoblazeAllPrices.class,
            dataProvider = "All monitors for checking prices")
    public void test3(String monitorName, String monitorPrice) {

        String price = new MainPage()
                .navigateTo(MONITORS)
                .getPrice(monitorName);

        Assert.assertEquals(price, monitorPrice);
    }

}
