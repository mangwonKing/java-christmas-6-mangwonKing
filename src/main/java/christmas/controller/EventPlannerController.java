package christmas.controller;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Discount discount = new Discount();

    public void run() {
        outputView.printWelcom();
        DateInfomation dateInfomation = inputDate();
        OrderInfomation orderInfomation = inputOrder();

        outputView.printReserveMessage(dateInfomation.getDay());
        outputView.printOrder(orderInfomation);
        outputView.printBeforePrice(orderInfomation.calculateTotal());
        outputView.printHasPresent(discount.checkPresent(orderInfomation.getTotalPrice()));
        outputView.printDiscountDetails(discount, orderInfomation, dateInfomation);
        outputView.printTotalDiscount(discount);
        outputView.printAffterPrice(discount, orderInfomation);
        outputView.printBadge(discount.checkBadge());
    }
    private DateInfomation inputDate(){
        int date = inputView.readDate();
        DateInfomation dateInfomation = new DateInfomation(date);
        dateInfomation.checkDay();
        return dateInfomation;

    }
    private OrderInfomation inputOrder(){
        OrderInfomation orderInfomation = new OrderInfomation(inputView.readMenu());
        return orderInfomation;
    }
}
