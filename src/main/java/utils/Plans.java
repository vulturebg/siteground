package utils;

/**
 * Created by Branimir on 8/30/2017.
 */
public enum Plans {
    START_UP(1, "3.95 €/year", "StartUp"),
    GROW_BIG(2, "6.45 €/year", "GrowBig"),
    GO_GEEK(3, "11.95 €/year", "GoGeek");

    private int value;
    private String price;
    private String label;

    Plans(int value, String price, String label) {
        this.value = value;
        this.price = price;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String getPrice() {
        return this.price;
    }

    public String getLabel() { return this.label; }
}
