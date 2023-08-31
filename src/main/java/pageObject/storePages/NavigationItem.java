package pageObject.storePages;

public enum NavigationItem {
    PHONES("Phones"),
    LAPTOPS ("Laptops"),
    MONITORS ("Monitors"),
    MACBOOK_PRO ("MacBook Pro"),
    ASUS_FULL_HD ("ASUS Full HD"),
    APPLE_MONITOR_24 ("Apple monitor 24"),
    SONY_VAIO_I5 ("Sony vaio i5"),
    SAMSUNG_GALAXY_S6 ("Samsung galaxy s6"),
    CONTACT ("Contact"),
    ABOUT_US ("About us"),
    CART ("Cart"),
    LOG_IN ("Log in"),
    SIGN_UP ("Sign up");

    private String item;

    NavigationItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
