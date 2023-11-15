package christmas.view;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;

import java.text.DecimalFormat;

import static christmas.system.BenefitMessage.*;
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

        System.out.println(formatter.format(total) + OUT_UNIT.getMessage());
    }

    public void printHasPresent(boolean hasPresent) {
        System.out.println(OUT_PRESENT.getMessage());
        if (!hasPresent) {
            System.out.println(NOTHING.getMessage());
            return;
        }
        System.out.println(OUT_PRESENT_DETAIL.getMessage());

    }

    public void printDiscountDetails(Discount discount, OrderInfomation orderInfomation, DateInfomation dateInfomation) { // list 이름 고칠것 , 혜택내역 출력
        System.out.println(OUT_BENEFIT.getMessage());
        if (!discount.checkMinOrderPrice(orderInfomation.getTotalPrice())) {
            System.out.println(NOTHING.getMessage());
            return;
        }
        printDdayDiscount(discount.calculateDayDiscount(dateInfomation));
        printWeekendDiscount(discount.checkWeekendDay(dateInfomation, orderInfomation), dateInfomation.getIsWeekend());
        printSpecialDiscount(discount.checkSpecialDay(dateInfomation));
        printPresentDiscount(discount.getHasPresent());
    }

    private void printPresentDiscount(boolean hasPresent) {
        if (hasPresent) {
            System.out.println(OUT_PRESENT_DISCOUNT.getMessage());
        }
    }

    private void printSpecialDiscount(int benefitPrice) {
        if (benefitPrice != ZERO) {
            System.out.println(SPECIAL_DISCOUNT.getBenefit() + formatter.format(benefitPrice) + UNIT.getBenefit());
        }
    }

    private void printWeekendDiscount(int benefitPrice, boolean isWeekend) {
        if (benefitPrice != ZERO && isWeekend) {
            System.out.println(WEEKEND_DISCOUNT.getBenefit() + formatter.format(benefitPrice) + UNIT.getBenefit());
        }
        if (benefitPrice != ZERO && !isWeekend) {
            System.out.println(NORMAL_DISCOUNT.getBenefit() + formatter.format(benefitPrice) + UNIT.getBenefit());
        }
    }

    private void printDdayDiscount(int benefitPrice) {
        if (benefitPrice != ZERO) {
            System.out.println(DDAY_DISCOUNT.getBenefit() + formatter.format(benefitPrice) + UNIT.getBenefit());
        }
    }

    public void printTotalDiscount(Discount discount) {
        System.out.println(OUT_DISCOUNT_PRICE.getMessage());
        int benefit = discount.totalDiscount();
        if (benefit > ZERO) {
            System.out.println(MINUS.getMessage() + formatter.format(benefit) + OUT_UNIT.getMessage());
            return;
        }
        System.out.println(NOTHING.getMessage());

    }

    public void printAffterPrice(Discount discount, OrderInfomation orderInfomation) {
        System.out.println(OUT_AFFTER_DISCOUNT.getMessage());
        int result = discount.resultPrice(orderInfomation);
        if (result > ZERO) {
            System.out.println(formatter.format(result) + OUT_UNIT.getMessage());
            return;
        }
        System.out.println(NOTHING.getMessage());

    }

    public void printBadge(String badge) {
        System.out.println(OUT_BADGE.getMessage());
        System.out.println(badge);
    }
}
