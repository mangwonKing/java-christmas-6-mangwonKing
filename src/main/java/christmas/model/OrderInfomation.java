package christmas.model;

import christmas.system.Menu;

import java.util.*;

import static christmas.system.Benefit.*;

public class OrderInfomation {
    private final Map<String, Integer> order;
    private final String SPACE = " ";
    private final String UNIT = "개";
    private final int ZERO = 0;
    private int totalPrice = 0;

    public OrderInfomation(Map<String, Integer> order) {
        this.order = order;
    }

    public void printOrder() {
        for (String menu : order.keySet()) {
            System.out.println(menu + SPACE + order.get(menu) + UNIT);
        }
    }

    public String getCategory(String name) {
        Menu menu = Menu.findMenu(name);
        return menu.getCategory();
    }

    public int countCategory(String category) {
        int count = ZERO;
        for (String menuName : order.keySet()) {
            if (category.equals(getCategory(menuName))) {
                count += order.get(menuName);
            }
        }
        return count;
    }

    public int calculateTotal() {
        for (String menuName : order.keySet()) {
            Menu menu = Menu.findMenu(menuName);
            totalPrice += (menu.getPrice() * order.get(menuName));
        }
        return totalPrice;
    }

    public boolean checkMinimunPrice() {
        if (MINIMUM_ORDER_PRICE.getPrice() > totalPrice) {
            return false;
        }
        return true;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
