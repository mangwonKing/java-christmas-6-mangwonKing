package christmas.system;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타");
    private final String badge;

    Badge(String badge){
        this.badge = badge;
    }

    public String getBadge(){
        return badge;
    }
}
