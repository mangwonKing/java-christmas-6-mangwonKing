package christmas.model;

import christmas.system.Menu;

import java.util.*;

public class OrderInfomation {
    private final int MINIMUM_ORDER_PRICE = 10000;
    private Map<String, Integer> order = new HashMap<>();
    private int totalPrice = 0;

    public OrderInfomation(Map<String, Integer> order) {
        this.order = order;
    }

    public void printOrder() {
        for (String menu : order.keySet()) {
            System.out.println(menu + " " + order.get(menu) + "개");
        }
    }

    public List<Integer> getValue() {
        List<Integer> list = new ArrayList<>(order.values());
        return list;
    }

    public Set<String> getKey() {
        return order.keySet();
    }

    public String getCategory(String name) {
        Menu menu = Menu.findMenu(name);
        return menu.getCategory();
    }

    public int countCategory(String category) {
        int count = 0;
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
        if (MINIMUM_ORDER_PRICE > totalPrice) {
            return false;
        }
        return true;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
