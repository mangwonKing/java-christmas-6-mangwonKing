package christmas.model;

import java.util.List;

public class SpecialDay {

    private List<Integer> weekend = List.of(1,2,8,9,15,16,22,23,29,30);
    private List<Integer> special = List.of(3,10,17,24,25,31);

    public boolean checkWeekend(int day){
        return weekend.contains(day);
    }
    public boolean checkSpecial(int day){
        return special.contains(day);
    }
}
