package christmas.model;

public class Discount {

    private boolean hasPresent;
    private String badge;
    private int discountPrice; // 할인금액

    public void eventCheck(){ // 이건 outputview 에 더 어울린다.
        //최소 주문금액 만족하는지

        // 디데이 할인 가격 받아오고

        // 평일 할인 or 주말 할인 정보 받아오고

        // 특별 할인 받아오고

        // 증정품 받아오고

        //체크해서 총 혜택을 더해준 뒤 discountPrice에 저장
    }
    public boolean checkMinOrderPrice(int total){ //최소주문금액 만족하는지

        return true;
    }

    public int calculateDayDiscount(int day){ //날짜별로 d데이 할인이 얼마나 되는지
        return -1;
    }

    public void checkPresent(int orderPrice){ // 12만원을 넘겼는지

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