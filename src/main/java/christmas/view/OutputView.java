package christmas.view;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;

import java.text.DecimalFormat;

import static christmas.system.Message.*;

public class OutputView {
    private final int ZERO = 0;
    DecimalFormat formatter = new DecimalFormat("###,###");

    public void printWelcom() { //시작 메세지
        System.out.println(INTRO.getMessage());
    }

    public void printReserveMessage(int day) { //혜택 미리보기 라인 출력
        System.out.println(OUT_RESERVE.getMessage(day));
    }

    public void printOrder(OrderInfomation orderInfomation) {
        System.out.println(OUT_MENU.getMessage());
        orderInfomation.printOrder();

    }

    public void printBeforePrice(int total) {
        System.out.println(OUT_BEFORE_DISCOUNT.getMessage());

        System.out.println(formatter.format(total) + UNIT.getMessage());
    }

    public void printHasPresent(boolean hasPresent) {
        System.out.println(OUT_PRESENT.getMessage());
        if (!hasPresent) {
            System.out.println(NOTHING.getMessage());
            return;
        }
        System.out.println(OUT_PRESENT_DETAIL);

    }

    public void printDiscountList(Discount discount, OrderInfomation orderInfomation, DateInfomation dateInfomation) { // list 이름 고칠것 , 혜택내역 출력
        int benefitPrice;
        System.out.println(OUT_BENEFIT.getMessage());
        if (!discount.checkMinOrderPrice(orderInfomation.getTotalPrice())) {
            System.out.println(NOTHING.getMessage());
            return;
        }
        discount.calculateDayDiscount(dateInfomation);
        discount.checkWeekendDay(dateInfomation, orderInfomation);
        discount.checkSpecialDay(dateInfomation);
        if (discount.getHasPresent()) {
            System.out.println(OUT_PRESENT_DISCOUNT);
        }
    }

    public void printTotalDiscount(Discount discount) {
        System.out.println(OUT_DISCOUNT_PRICE.getMessage());
        int benefit = discount.totalDiscount();
        if (benefit > ZERO) {
            System.out.println(MINUS.getMessage() + formatter.format(benefit) + UNIT.getMessage());
            return;
        }
        System.out.println(NOTHING.getMessage());

    }

    public void printAffterPrice(Discount discount, OrderInfomation orderInfomation) {
        System.out.println(OUT_AFFTER_DISCOUNT.getMessage());
        int result = discount.resultPrice(orderInfomation);
        if (result > ZERO) {
            System.out.println(formatter.format(result) + UNIT.getMessage());
            return;
        }
        System.out.println(NOTHING.getMessage());

    }

    public void printBadge(String badge) {
        System.out.println(OUT_BADGE.getMessage());
        System.out.println(badge);
    }
}
