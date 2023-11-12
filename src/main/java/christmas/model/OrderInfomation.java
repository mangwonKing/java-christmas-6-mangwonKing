package christmas.model;

import christmas.system.Menu;

import java.util.*;

public class OrderInfomation {

    private Map<String,Integer> order = new HashMap<>();
    private int totalPrice;


    public OrderInfomation(Map<String,Integer> order){
        this.order = order;
    }
    public void checkMenu(String name){

    }
    public List<Integer> getValue(){
        List<Integer> list = new ArrayList<>(order.values());
        return list;
    }
    public Set<String> getKey(){
        return order.keySet();
    }
    public String checkCategory(String name){
        Menu menu = Menu.findMenu(name);
        return menu.getCategory();
    }

    public int calculateTotal(){

        return -1;
    }
}
