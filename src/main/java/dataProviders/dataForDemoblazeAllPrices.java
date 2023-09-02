package dataProviders;

import org.testng.annotations.DataProvider;

public class dataForDemoblazeAllPrices {

    @DataProvider(name = "All products for checking prices")
    public static Object[][] getPhonePrices() {
        return new Object[][]{
                {"Samsung galaxy s6", "$360"},
                {"Nokia lumia 1520", "$820"},
                {"Nexus 6", "$650"},
                {"Samsung galaxy s7", "$800"},
                {"Iphone 6 32gb", "$790"},
                {"Sony xperia z5", "$320"},
                {"HTC One M9", "$700"},
        };
    }

    @DataProvider(name = "All laptops for checking prices")
    public static Object[][] getLaptopPrices() {
        return new Object[][] {
                {"Sony vaio i5", "$790"},
                {"Sony vaio i7", "$790"},
                {"MacBook air", "$700"},
                {"Dell i7 8gb", "$700"},
                {"2017 Dell 15.6 Inch", "$700"},
                {"MacBook Pro", "$1100"},
        };
    }

    @DataProvider(name = "All monitors for checking prices")
    public static Object[][] getMonitorPrices() {
        return new Object[][] {
                {"Apple monitor 24", "$400"},
                {"ASUS Full HD", "$230"},
        };
    }
}
