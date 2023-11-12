package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.system.Menu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static christmas.system.Message.*;
public class InputView {

    public static void main(String[] args) { //출력을 확인할 임시 main 메서드

    }
    public int readDate(){ //방문날짜 입력 문구 출력 후 방문날짜 입력받고 값 넘겨주기
        System.out.println(IN_DATE.getMessage());
        while (true){
            try{
                int date = Integer.parseInt(Console.readLine());
                validate(date);
                return date;
            }catch (IllegalArgumentException e){
                System.out.println("에러 다시입력");
            }
        }
    }
    private void validate(int date){
        if(date > 31 || date < 1){
            throw new IllegalArgumentException();
        }
    }


    public Map<String,Integer> readMenu(){ //메뉴정보 입력문구 출력 후 메뉴정보 입력받고 값 넘겨주기
        System.out.println(IN_MENU.getMessage());
        Map<String,Integer> menuDetail = new HashMap<>();
        while (true) {
            try {
                String order = Console.readLine();
                List<String> menus = Arrays.asList(order.split(","));
                saveOrder(menus, menuDetail);

                return menuDetail;

            } catch (IllegalArgumentException e) {
                System.out.println("에러 메세지 출력");
            }
        }
    }

    private void saveOrder(List<String> menus,Map<String,Integer> menuDetail){
        for(String getMenu : menus){
            String[] menuInfo = getMenu.split("-");
            String menuName = menuInfo[0];
            int countMenu = Integer.parseInt((menuInfo[1]));

            checkName(menuName);
            menuDetail.put(menuName,countMenu);
        }
    }
    private void checkName(String name){
        boolean flag = false;
        for(Menu menuName : Menu.values()){
            if(menuName.nameCheck(name)){
                System.out.println(menuName.getName());
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new IllegalArgumentException();
        }
    }

}
