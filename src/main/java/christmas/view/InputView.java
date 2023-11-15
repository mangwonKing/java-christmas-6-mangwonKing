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

    private final int MIN_COUNT = 1;
    private final int PAIR = 2;
    private final int INDEX_ONE = 0;
    private final int INDEX_TWO = 1;
    private final int ZERO = 0;
    private final int MAX_ORDER = 20;
    private final String CATEGORY_CANT_ALONE = "음료";
    private final String SEPERATE_ORDER = "-";
    private final String SEPERATE_MENU = ",";


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
                checkMenu(order, menuDetail);
                return menuDetail;
            } catch (IllegalArgumentException e) {
                System.out.println(ORDER_ERROR.getErrorMessage());
            }
        }
    }

    private void checkMenu(String order, Map<String, Integer> menuDetail) {
        List<String> menus = Arrays.asList(order.split(SEPERATE_MENU));
        int size = menus.size();
        saveOrder(menus, menuDetail);
        checkRedundant(size, menuDetail);
        checkTotal(menuDetail);
        checkCategory(menuDetail);
    }

    private void checkCategory(Map<String, Integer> menuDetail) {
        for (String menuName : menuDetail.keySet()) {
            if (findNotDrink(menuName)) {
                return;
            }
        }
        throw new IllegalArgumentException();

    }

    private boolean findNotDrink(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.nameCheck(menuName) && !menu.getCategory().equals(CATEGORY_CANT_ALONE)) {
                return true;
            }
        }
        return false;
    }

    private void checkTotal(Map<String, Integer> menuDetail) {
        int sum = ZERO;
        for (int count : menuDetail.values()) {
            sum += count;
        }
        if (sum > MAX_ORDER) {
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
            String[] menuInfo = getMenu.split(SEPERATE_ORDER);
            checkOrder(menuInfo.length);
            String menuName = menuInfo[INDEX_ONE];
            int countMenu = Integer.parseInt((menuInfo[INDEX_TWO]));
            checkCount(countMenu);
            checkName(menuName);

            menuDetail.put(menuName, countMenu);
        }
    }

    private void checkOrder(int size) {
        if (size != PAIR) {
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
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException();
        }
    }


}
