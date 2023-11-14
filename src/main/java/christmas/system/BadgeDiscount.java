package christmas.system;

public enum BadgeDiscount {
    MIN_STAR(5000),
    MIN_TREE(10000),
    MIN_SANTA(20000);

    private final int minDiscount;

    BadgeDiscount(int minDiscount){
        this.minDiscount = minDiscount;
    }

    public int getMinDiscount(){
        return minDiscount;
    }
}
