package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.system.Menu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.system.Date.*;
import static christmas.system.Message.*;
import static christmas.system.ErrorMessage.*;

public class InputView {
    public int readDate() {
        System.out.println(IN_DATE.getMessage());
        while (true) {
            try {
                int date = Integer.parseInt(Console.readLine());
                validate(date);
                return date;
            } catch (IllegalArgumentException e) {
                System.out.println(DATE_ERROR.getErrorMessage());
            }
        }
    }

    private void validate(int date) {
        if (date > LAST_DAY.getDate() || date < FIRST_DAY.getDate()) {
            throw new IllegalArgumentException();
        }
    }


    public Map<String, Integer> readMenu() {
        System.out.println(IN_MENU.getMessage());
        Map<String, Integer> menuDetail = new HashMap<>();
        while (true) {
            try {
                String order = Console.readLine();
                List<String> menus = Arrays.asList(order.split(","));
                int size = menus.size();
                saveOrder(menus, menuDetail);
                checkRedundant(size, menuDetail);
                checkTotal(menuDetail);
                checkCategory(menuDetail);
                return menuDetail;
            } catch (IllegalArgumentException e) {
                System.out.println(ORDER_ERROR.getErrorMessage());
            }
        }
    }

    private void checkCategory(Map<String, Integer> menuDetail) {
        boolean categoryFlag = false;
        for (String menuName : menuDetail.keySet()) {
            for (Menu menu : Menu.values()) { //****** 메서드 분리 리팩토링 필요 ****
                if (menu.nameCheck(menuName)) {
                    if (!menu.getCategory().equals("음료")) {
                        categoryFlag = true;
                        break;
                    }
                }
            }
        }
        if (!categoryFlag) {
            throw new IllegalArgumentException();
        }
    }

    private void checkTotal(Map<String, Integer> menuDetail) {
        int sum = 0;
        for (int count : menuDetail.values()) {
            sum += count;
        }
        if (sum > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRedundant(int size, Map<String, Integer> menuDetail) {
        if (size != menuDetail.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void saveOrder(List<String> menus, Map<String, Integer> menuDetail) {

        for (String getMenu : menus) {
            String[] menuInfo = getMenu.split("-");
            checkOrder(menuInfo.length);
            String menuName = menuInfo[0];
            int countMenu = Integer.parseInt((menuInfo[1]));
            checkCount(countMenu);
            checkName(menuName);

            menuDetail.put(menuName, countMenu);
        }
    }

    private void checkOrder(int size) {
        if (size != 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkName(String name) {
        boolean nameFlag = false;
        for (Menu menuName : Menu.values()) {
            if (menuName.nameCheck(name)) {
                nameFlag = true;
                break;
            }
        }
        if (!nameFlag) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException();
        }
    }


}
