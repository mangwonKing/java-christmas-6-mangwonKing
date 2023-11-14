package christmas.system;

public enum Date {
    CHRISTMAS(25),
    YEAR(2023);

    private int date;

    Date(int date){
        this.date= date;
    }
    public int getDate(){
        return date;
    }
}
