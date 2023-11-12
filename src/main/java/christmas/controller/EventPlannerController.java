package christmas.controller;

import christmas.model.DateInfomation;
import christmas.view.InputView;

public class EventPlannerController {

    public void run(){
        InputView inputView = new InputView();
        int date = inputView.readDate();
        DateInfomation dateInfomation = new DateInfomation(date);



    }
}
