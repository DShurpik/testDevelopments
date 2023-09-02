package pageFactory.demoblaze;

public enum ProductItems {

    SAMSUNG_GALAXY_S6_PRODUCT ("'Samsung galaxy s6'"),
    DELL_I7_8GB ("'Dell i7 8gb'"),
    APPLE_MONITOR ("'Apple monitor 24'");

    private String item;

    ProductItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
