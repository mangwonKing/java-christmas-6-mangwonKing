package christmas.controller;

import christmas.model.DateInfomation;
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
            System.out.println(orderInfomation.checkCategory(name));
            System.out.println(orderInfomation.getKey());
            System.out.println(orderInfomation.getValue());
        }
        orderInfomation.calculateTotal();

    }
    public void run(){


    }
}
