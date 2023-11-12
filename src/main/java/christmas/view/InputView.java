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
                int size = menus.size();
                saveOrder(menus, menuDetail);
                checkRedundant(size,menuDetail);
                checkTotal(menuDetail);
                checkCategory(menuDetail);
                return menuDetail;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
    private void checkCategory(Map<String,Integer> menuDetail){ // 음료만 시킨 경우인지 확인한다.
        boolean categoryFlag = false;
        for(String menuName : menuDetail.keySet()){
            for (Menu menu : Menu.values()){ //****** 메서드 분리 리팩토링 필요 ****
                if(menu.nameCheck(menuName)){
                    if(!menu.getCategory().equals("음료")){
                        categoryFlag = true;
                        break;
                    }
                }
            }
        }
        if(!categoryFlag){
            throw new IllegalArgumentException();
        }
    }
    private void checkTotal(Map<String,Integer> menuDetail){//총 개수를 확인한다.
        int sum = 0;
        for(int count : menuDetail.values()){
            sum += count;
        }
        if(sum > 20){
            throw new IllegalArgumentException();
        }
    }
    private void checkRedundant(int size,Map<String,Integer> menuDetail){ //중복된 주문이 없는지 확인한다.
        if(size != menuDetail.size()){
            throw new IllegalArgumentException();
        }
    }
    private void saveOrder(List<String> menus,Map<String,Integer> menuDetail){

        for(String getMenu : menus){
            String[] menuInfo = getMenu.split("-");
            checkOrder(menuInfo.length);
            String menuName = menuInfo[0];
            int countMenu = Integer.parseInt((menuInfo[1]));
            checkCount(countMenu);
            checkName(menuName);

            menuDetail.put(menuName,countMenu);
        }
    }
    private void checkOrder(int size){ // 주문형식이 정상적인지 확인한다.
        if(size != 2){
            throw new IllegalArgumentException();
        }
    }
    private void checkName(String name){ // 메뉴의 이름을 검사한다.
        boolean nameFlag = false;
        for(Menu menuName : Menu.values()){
            if(menuName.nameCheck(name)){
                nameFlag = true;
                break;
            }
        }
        if(!nameFlag){
            throw new IllegalArgumentException();
        }
    }
    private void checkCount(int count){ //각 메뉴의 개수를 검사한다.
        if(count < 1 ){
            throw new IllegalArgumentException();
        }
    }


}
