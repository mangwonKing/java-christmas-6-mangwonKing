package christmas.model;

import java.util.List;

public class SpecialDay {

    private static List<Integer> weekend = List.of(1,2,8,9,15,16,22,23,29,30);
    private static List<Integer> special = List.of(3,10,17,24,25,31);

    public static boolean checkWeekend(int day){
        return weekend.contains(day);
    }
    public static boolean checkSpecial(int day){
        return special.contains(day);
    }
}
