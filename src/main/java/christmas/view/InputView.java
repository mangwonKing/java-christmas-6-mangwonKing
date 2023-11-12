package christmas.view;

import camp.nextstep.edu.missionutils.Console;

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


    public static String readMenu(){ //메뉴정보 입력문구 출력 후 메뉴정보 입력받고 값 넘겨주기
        System.out.println(IN_MENU.getMessage());
        return Console.readLine();
    }
}
