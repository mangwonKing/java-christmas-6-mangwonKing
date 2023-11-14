package christmas.model;

public class DateInfomation {
    private int day;
    private boolean isWeekend;
    private boolean isStar;
    public DateInfomation(int day) {
        this.day = day;
        checkDay();
    }
    public void checkDay() {
        isWeekend = SpecialDay.checkWeekend(day);
        isStar = SpecialDay.checkSpecial(day);
    }
    public int getDay() {
        return day;
    }
    public boolean getIsWeekend(){
        return isWeekend;
    }
    public boolean getIsStar(){
        return isStar;
    }
}
