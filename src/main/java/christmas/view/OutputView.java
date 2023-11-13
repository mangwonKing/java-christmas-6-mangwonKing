package christmas.view;

import christmas.model.OrderInfomation;

import java.text.DecimalFormat;

import static christmas.system.Message.*;

public class OutputView {
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
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println( formatter.format(total) + "원" );
    }

    public void printHasPresent(boolean hasPresent){
        //증정샴페인 있는지 문구출력 후 출력 없으면 없다.
    }

    public void printDiscountList(){ // list 이름 고칠것 , 혜택내역 출력

    }

    public void printTotalDiscount(int discount){ // 총 혜택금액 출력

    }

    public void printAffterPrice(int discountPrice){
        // 예상 결제금액 출력
    }
    public void printBadge(String badge){
        //이벤트 뱃지 문구 출력 후 값 출력
    }
}
