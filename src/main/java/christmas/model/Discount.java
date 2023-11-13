package christmas.model;

public class Discount {
    private final int MINIMUM_ORDER_PRICE = 10000;
    private final int PRESENT_ORDER_PRICE = 120000;
    private final int CHRISTMAS = 25;
    private final int initDiscount = 1000;
    private boolean hasPresent = false;
    private String badge;
    private int discountPrice = 0; // 할인금액



    public void eventCheck(){ // 이건 outputview 에 더 어울린다.
        //최소 주문금액 만족하는지

        // 디데이 할인 가격 받아오고

        // 평일 할인 or 주말 할인 정보 받아오고

        // 특별 할인 받아오고

        // 증정품 받아오고

        //체크해서 총 혜택을 더해준 뒤 discountPrice에 저장
    }

    public void checkSpecialDay(int day){
        if(SpecialDay.checkWeekend(day)){
            //주말할인 진행 - return 문 작성
        }
        if(SpecialDay.checkSpecial(day)){
            //이벤트데이 할인 진행 - return 문 작성 x
        }
        //평일할인 진행 - return 문 작성

    }
    public boolean checkMinOrderPrice(int total){ //최소주문금액 만족하는지
        if(total >= MINIMUM_ORDER_PRICE){
            return true;
        }
        return false;
    }

    public int calculateDayDiscount(int day){ //날짜별로 d데이 할인이 얼마나 되는지
        if(day > CHRISTMAS){
            return 0;
        }
        discountPrice = initDiscount + ((day-1)* 100);
        return discountPrice;
    }

    public boolean checkPresent(int orderPrice){ // 12만원을 넘겼는지
        if(orderPrice >= PRESENT_ORDER_PRICE){
            return true;
        }
        return false;
    }
    public void checkBadge(){
        //총 할인 금액으로 뱃지 판별해서 저장
    }
    public void totalDiscount(){
        //최종 혜택금액을 계산하는 기능
    }
    public int resultPrice(){ //최종 결제금액 계산
        return -1;
    }

}
