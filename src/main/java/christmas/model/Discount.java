package christmas.model;


import christmas.system.Badge;
import christmas.system.BadgeDiscount;

import java.text.DecimalFormat;

import static christmas.system.Badge.*;
import static christmas.system.BadgeDiscount.*;
import static christmas.system.BenefitMessage.*;
import static christmas.system.Date.*;

public class Discount {
    private final int MINIMUM_ORDER_PRICE = 10000;
    private final int PRESENT_ORDER_PRICE = 120000;
    private final int initDiscount = 1000;
    private final int ZERO = 0;
    private boolean hasPresent = false;
    private String badge = "없음";
    private int discountPrice = 0;
    private int totalBenefit = 0;
    DecimalFormat formatter = new DecimalFormat("###,###");

    public int checkSpecialDay(DateInfomation dateInfomation){
        int discount = ZERO;
        if(dateInfomation.getIsStar()){
            discount += 1000;
            discountPrice += discount;
            System.out.println(SPECIAL_DISCOUNT.getBenefit() +formatter.format(discount)+UNIT.getBenefit());
        }

        return discount;
    }
    public int calculateDayDiscount(DateInfomation dateInfomation){
        int day = dateInfomation.getDay();
        if(day > CHRISTMAS.getDate()){
            return ZERO;
        }
        int discount = initDiscount + ((day-1)* 100);
        discountPrice += discount;
        System.out.println(DDAY_DISCOUNT.getBenefit() + formatter.format(discount)+UNIT.getBenefit());
        return discount;
    }
    public int checkWeekendDay(DateInfomation dateInfomation, OrderInfomation orderInfomation){
        int benefit = 0;
        if(dateInfomation.getIsWeekend()){
            benefit =YEAR.getDate()*orderInfomation.countCategory(WEEKEND_DISCOUNT_CATEGORY.getBenefit());
            discountPrice += benefit;
            if(benefit > ZERO){
                System.out.println(WEEKEND_DISCOUNT.getBenefit() +formatter.format(benefit) +UNIT.getBenefit());
            }
            return benefit;
        }
        benefit = YEAR.getDate() * orderInfomation.countCategory(NORMAL_DISCOUNT_CATEGORY.getBenefit());
        discountPrice += benefit;
        if(benefit > ZERO){
            System.out.println(NORMAL_DISCOUNT.getBenefit() +formatter.format(benefit)+UNIT.getBenefit());
        }
        return benefit;
    }
    public boolean checkMinOrderPrice(int total){

        if(total >= MINIMUM_ORDER_PRICE){
            return true;
        }
        return false;
    }
    public boolean checkPresent(int total){
        if(total >= PRESENT_ORDER_PRICE){
            totalBenefit += 25000;
            hasPresent = true;
            return hasPresent;
        }
        return hasPresent;
    }
    public String checkBadge(){
        if(totalBenefit >= MIN_STAR.getMinDiscount() && totalBenefit < MIN_TREE.getMinDiscount()){
            badge = STAR.getBadge();
        }
        if(totalBenefit >= MIN_TREE.getMinDiscount() && totalBenefit < MIN_SANTA.getMinDiscount()){
            badge = TREE.getBadge();
        }
        if(totalBenefit >= MIN_SANTA.getMinDiscount()){
            badge = SANTA.getBadge();
        }
        return badge;
    }
    public int totalDiscount(){
        totalBenefit += discountPrice;
        return totalBenefit;
    }
    public int resultPrice(OrderInfomation orderInfomation){
        int beforePrice = orderInfomation.getTotalPrice();
        beforePrice -= discountPrice;
        return  beforePrice;
    }
    public boolean getHasPresent(){
        return hasPresent;
    }

}
