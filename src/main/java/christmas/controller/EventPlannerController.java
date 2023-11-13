package christmas.controller;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;
import christmas.view.InputView;

public class EventPlannerController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int date = inputView.readDate();
        DateInfomation dateInfomation = new DateInfomation(date);
        dateInfomation.checkDay();
        OrderInfomation orderInfomation = new OrderInfomation(inputView.readMenu());
        for(String name : orderInfomation.getKey()){
            System.out.println(orderInfomation.getCategory(name));
            System.out.println(orderInfomation.getKey());
            System.out.println(orderInfomation.getValue());
        }
        orderInfomation.calculateTotal();
        Discount discount = new Discount();
        discount.checkMinOrderPrice(orderInfomation.getTotalPrice());
        System.out.println("할인받을 금액은");
        System.out.println(discount.calculateDayDiscount(dateInfomation.getDay()));
        discount.checkWeekendDay(dateInfomation.getDay(),orderInfomation);

    }
    public void run(){


    }
}
