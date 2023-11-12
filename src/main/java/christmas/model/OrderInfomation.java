package christmas.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderInfomation {

    private Map<String,Integer> order = new HashMap<>();
    private int totalPrice;


    public OrderInfomation(Map<String,Integer> order){
        this.order = order;
    }
    public void checkMenu(String name){

    }

    public void checkCategory(){

    }

    public int calculateTotal(){

        return -1;
    }
}
