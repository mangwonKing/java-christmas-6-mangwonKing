package christmas.model;


import christmas.system.Badge;
import christmas.system.BadgeDiscount;

import java.text.DecimalFormat;

import static christmas.system.Badge.*;
import static christmas.system.BadgeDiscount.*;

public class Discount {
    private final int MINIMUM_ORDER_PRICE = 10000;
    private final int PRESENT_ORDER_PRICE = 120000;
    private final int CHRISTMAS = 25;
    private final int initDiscount = 1000;

    private boolean hasPresent = false;
    private String badge = "없음";
    private int discountPrice = 0;
    private int totalBenefit = 0;
    DecimalFormat formatter = new DecimalFormat("###,###");

    public int checkSpecialDay(DateInfomation dateInfomation){
        int discount = 0;
        if(dateInfomation.getIsStar()){
            discount += 1000;
            discountPrice += discount;
            System.out.println("특별 할인: -"+formatter.format(discount)+"원");
        }

        return discount;
    }
    public int calculateDayDiscount(DateInfomation dateInfomation){
        int day = dateInfomation.getDay();
        if(day > CHRISTMAS){
            return 0;
        }
        int discount = initDiscount + ((day-1)* 100);
        discountPrice += discount;
        System.out.println("크리스마스 디데이 할인: -" + formatter.format(discount)+"원");
        return discount;
    }
    public int checkWeekendDay(DateInfomation dateInfomation, OrderInfomation orderInfomation){
        int benefit = 0;
        if(dateInfomation.getIsWeekend()){
            benefit =2023*orderInfomation.countCategory("메인");
            discountPrice += benefit;
            if(benefit > 0){
                System.out.println("주말 할인: -"+formatter.format(benefit) +"원");
            }
            return benefit;
        }
        benefit = 2023 * orderInfomation.countCategory("디저트");
        discountPrice += benefit;
        if(benefit > 0){
            System.out.println("평일 할인: -"+formatter.format(benefit)+"원");
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
