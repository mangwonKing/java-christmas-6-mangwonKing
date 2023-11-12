package christmas.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderInfomation {

    private Map<String,String> order = new HashMap<>();
    private int totalPrice;


    public OrderInfomation(String menu){
        List<String> menus = Arrays.asList(menu.split(","));
        System.out.println(menus);

        for(String getMenu : menus){
            String[] menuInfo =  getMenu.split("-");
            //예외처리
            order.put(menuInfo[0],menuInfo[1]);
        }
        System.out.println(order.keySet());
    }
    public void checkCategory(){

    }

    public int calculateTotal(){

        return -1;
    }
}
