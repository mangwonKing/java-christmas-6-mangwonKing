package christmas.system;

public enum Benefit {
    MINIMUM_ORDER_PRICE(10000),
    PRESENT_ORDER_PRICE(120000),
    PRESENT_PRICE(25000),
    INIT_DISCOUNT(1000),
    SPECIAL_DISCOUNT_PRICE(1000);

    private final int price;

    Benefit(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
