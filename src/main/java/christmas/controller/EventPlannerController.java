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
        inputView.readMenu();

    }
    public void run(){


    }
}