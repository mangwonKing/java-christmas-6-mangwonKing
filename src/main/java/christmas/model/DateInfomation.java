package christmas.model;

public class DateInfomation {
    private int day;
    private boolean isWeekend;
    private boolean isStar;


    public DateInfomation(int day) {
        this.day = day;
    }

    public void checkDay() {
        isWeekend = SpecialDay.checkWeekend(day);
        isStar = SpecialDay.checkSpecial(day);
        //System.out.println(isWeekend); 테스트용 , 구현 완료 후 제거할것
        //System.out.println(isStar);
    }
}
