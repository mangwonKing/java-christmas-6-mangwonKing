package christmas.model;


import java.text.DecimalFormat;

import static christmas.system.Badge.*;
import static christmas.system.BadgeDiscount.*;
import static christmas.system.BenefitMessage.*;
import static christmas.system.Date.*;
import static christmas.system.Benefit.*;

public class Discount {
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int DAY_DISCOUNT = 100;
    private boolean hasPresent = false;
    private int discountPrice = 0;
    private int totalBenefit = 0;
    DecimalFormat formatter = new DecimalFormat("###,###");

    public int checkSpecialDay(DateInfomation dateInfomation) {
        int discount = ZERO;
        if (dateInfomation.getIsStar()) {
            discount += SPECIAL_DISCOUNT_PRICE.getPrice();
            discountPrice += discount;
        }

        return discount;
    }

    public int calculateDayDiscount(DateInfomation dateInfomation) {
        int day = dateInfomation.getDay();
        if (day > CHRISTMAS.getDate()) {
            return ZERO;
        }
        int discount = INIT_DISCOUNT.getPrice() + ((day - ONE) * DAY_DISCOUNT);
        discountPrice += discount;
        return discount;
    }

    public int checkWeekendDay(DateInfomation dateInfomation, OrderInfomation orderInfomation) {
        int benefit = ZERO;
        if (dateInfomation.getIsWeekend()) {
            benefit = YEAR.getDate() * orderInfomation.countCategory(WEEKEND_DISCOUNT_CATEGORY.getBenefit());
            discountPrice += benefit;
            return benefit;
        }
        benefit = YEAR.getDate() * orderInfomation.countCategory(NORMAL_DISCOUNT_CATEGORY.getBenefit());
        discountPrice += benefit;
        return benefit;
    }

    public boolean checkMinOrderPrice(int total) {

        if (total >= MINIMUM_ORDER_PRICE.getPrice()) {
            return true;
        }
        return false;
    }

    public boolean checkPresent(int total) {
        if (total >= PRESENT_ORDER_PRICE.getPrice()) {
            totalBenefit += PRESENT_PRICE.getPrice();
            hasPresent = true;
            return hasPresent;
        }
        return hasPresent;
    }

    public String checkBadge() {
        String badge = NON.getBadge();
        if (totalBenefit >= MIN_STAR.getMinDiscount() && totalBenefit < MIN_TREE.getMinDiscount()) {
            badge = STAR.getBadge();
        }
        if (totalBenefit >= MIN_TREE.getMinDiscount() && totalBenefit < MIN_SANTA.getMinDiscount()) {
            badge = TREE.getBadge();
        }
        if (totalBenefit >= MIN_SANTA.getMinDiscount()) {
            badge = SANTA.getBadge();
        }
        return badge;
    }

    public int totalDiscount() {
        totalBenefit += discountPrice;
        return totalBenefit;
    }

    public int resultPrice(OrderInfomation orderInfomation) {
        int beforePrice = orderInfomation.getTotalPrice();
        beforePrice -= discountPrice;
        return beforePrice;
    }

    public boolean getHasPresent() {
        return hasPresent;
    }

}
