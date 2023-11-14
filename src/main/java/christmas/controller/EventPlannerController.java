package christmas.controller;

import christmas.model.DateInfomation;
import christmas.model.Discount;
import christmas.model.OrderInfomation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlannerController {
    public void run() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Discount discount = new Discount();
        outputView.printWelcom();
        int date = inputView.readDate();
        DateInfomation dateInfomation = new DateInfomation(date);
        dateInfomation.checkDay();
        OrderInfomation orderInfomation = new OrderInfomation(inputView.readMenu());
        outputView.printReserveMessage(dateInfomation.getDay());
        outputView.printOrder(orderInfomation);
        outputView.printBeforePrice(orderInfomation.calculateTotal());
        outputView.printHasPresent(discount.checkPresent(orderInfomation.getTotalPrice()));

        outputView.printDiscountList(discount, orderInfomation, dateInfomation);
        outputView.printTotalDiscount(discount);
        outputView.printAffterPrice(discount, orderInfomation);
        outputView.printBadge(discount.checkBadge());

    }
}
