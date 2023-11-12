package christmas.system;

public enum Menu {

    SOUP("양송이수프","에피타이저", 6000),
    TAPAS("타파스","에피타이저",5500),
    SALAD("시저샐러드","에피타이저",8000),
    T_BORN("티본스테이크","메인",55000),
    BBQ("바비큐립","메인",54000),
    PASTA("해산물파스타","메인",35000),
    CHRISTMAS_PASTA("크리스마스파스타","메인",25000),
    CAKE("초코케이크","디저트",15000),
    ICECREAM("아이스크림","디저트",5000),
    COLA("제로콜라","음료",3000),
    WINE("레드와인","음료",60000),
    CHAMPAGNE("샴페인","음료",25000);
    private final String name;
    private final String category;
    private final int price;

    Menu(String name, String category,int price){
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public boolean nameCheck(String menuName){ // 해당 메뉴가 존재하는지
        if(menuName.equals(name)){
            return true;
        }
        return false;
    }

    public String getName(){
        return name;
    }
    public String getCategory(String name){
        if(name.equals(this.name)){
            return category;
        }
        return null;
    }
    public int getPrice() {
        return price;
    }
}
