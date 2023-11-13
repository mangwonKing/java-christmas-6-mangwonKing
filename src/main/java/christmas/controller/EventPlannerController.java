package christmas.controller;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    public void run(){
        InputView inputView = new InputView();
        int date = inputView.readDate();
        DateInfomation dateInfomation = new DateInfomation(date);
        dateInfomation.checkDay();
        OrderInfomation orderInfomation = new OrderInfomation(inputView.readMenu());
        OutputView outputView = new OutputView();
        outputView.printOrder(orderInfomation);
        outputView.printBeforePrice(orderInfomation.calculateTotal());

        Discount discount = new Discount();
        discount.checkMinOrderPrice(orderInfomation.getTotalPrice());
        System.out.println("할인받을 금액은");
        System.out.println(discount.calculateDayDiscount(dateInfomation.getDay()));
        discount.checkWeekendDay(dateInfomation.getDay(),orderInfomation);

    }
}
