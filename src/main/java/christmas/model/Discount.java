package christmas.model;

import java.text.DecimalFormat;

public class Discount {
    private final int MINIMUM_ORDER_PRICE = 10000;
    private final int PRESENT_ORDER_PRICE = 120000;
    private final int CHRISTMAS = 25;
    private final int initDiscount = 1000;
    private boolean hasPresent = false;
    private String badge = "없음";
    private int discountPrice = 0; // 할인금액
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
    public int calculateDayDiscount(DateInfomation dateInfomation){ //날짜별로 d데이 할인이 얼마나 되는지
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
    public boolean checkMinOrderPrice(int total){ //최소주문금액 만족하는지
        if(total >= MINIMUM_ORDER_PRICE){
            return true;
        }
        return false;
    }
    public boolean checkPresent(int total){ // 12만원을 넘겼는지
        if(total >= PRESENT_ORDER_PRICE){
            totalBenefit += 25000;
            hasPresent = true;
            return hasPresent;
        }
        return hasPresent;
    }
    public String checkBadge(){
        //총 혜택 금액으로 뱃지 판별해서 저장
        if(totalBenefit >= 5000 && totalBenefit < 10000){
            badge = "별";
        }
        if(totalBenefit >= 10000 && totalBenefit < 20000){
            badge = "트리";
        }
        if(totalBenefit >= 20000){
            badge = "산타";
        }
        return badge;
    }
    public int totalDiscount(){
        //최종 혜택금액을 계산하는 기능 혜택금액은 디스카운트 + 증정품(이미 토탈 배네핏에 추가되어 있음)
        totalBenefit += discountPrice;
        return totalBenefit;
    }
    public int resultPrice(OrderInfomation orderInfomation){ //최종 결제금액 계산
        int beforePrice = orderInfomation.getTotalPrice();
        beforePrice -= discountPrice;
        return  beforePrice;
    }
    public boolean getHasPresent(){
        return hasPresent;
    }

}
