package christmas.view;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;

import java.text.DecimalFormat;

import static christmas.system.Message.*;

public class OutputView {
    DecimalFormat formatter = new DecimalFormat("###,###");
    public void printWelcom(){ //시작 메세지
        System.out.println(INTRO.getMessage());
    }
    public void printReserveMessage(int day){ //혜택 미리보기 라인 출력
        System.out.println("12월 "+day + "일에 우테코 식당에서 받을 이벤트 혜택 미리보기!");
    }
    public void printOrder(OrderInfomation orderInfomation){ // 주문 메뉴 출력
        System.out.println(OUT_MENU.getMessage());
        orderInfomation.printOrder();

    }

    public void printBeforePrice(int total){
        //할인 전 총 주문금액 문구 출력 후 값 출력
        System.out.println(OUT_BEFORE_DISCOUNT.getMessage());

        System.out.println( formatter.format(total) + "원" );
    }

    public void printHasPresent(boolean hasPresent){
        //증정샴페인 있는지 문구출력 후 출력 없으면 없다.
        System.out.println(OUT_PRESENT.getMessage());
        if(!hasPresent){
            System.out.println("없음");
            return;
        }
        System.out.println("샴페인 1개");

    }

    public void printDiscountList(Discount discount, OrderInfomation orderInfomation, DateInfomation dateInfomation){ // list 이름 고칠것 , 혜택내역 출력
        int benefitPrice;
        System.out.println(OUT_BENEFIT.getMessage());
        if(!discount.checkMinOrderPrice(orderInfomation.getTotalPrice())){
            System.out.println("없음");
            return;
        }
        discount.calculateDayDiscount(dateInfomation);
        discount.checkWeekendDay(dateInfomation,orderInfomation);
        discount.checkSpecialDay(dateInfomation);
        if(discount.getHasPresent()){
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    public void printTotalDiscount(Discount discount){ // 총 혜택금액 출력
        System.out.println(OUT_DISCOUNT_PRICE.getMessage());
        int benefit =discount.totalDiscount();
        if(benefit > 0){
            System.out.println("-"+formatter.format(benefit)+"원");
            return;
        }
        System.out.println("없음");

    }

    public void printAffterPrice(Discount discount,OrderInfomation orderInfomation){
        System.out.println(OUT_AFFTER_DISCOUNT.getMessage());
        int result = discount.resultPrice(orderInfomation);
        if(result > 0){
            System.out.println(formatter.format(result)+"원");
            return;
        }
        System.out.println("없음");

    }
    public void printBadge(String badge){
        System.out.println(OUT_BADGE.getMessage());
        System.out.println(badge);
    }
}
