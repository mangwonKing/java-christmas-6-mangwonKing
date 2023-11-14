package christmas.system;

public enum Message {

    INTRO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    IN_DATE("12월 중 식당 예상 방문 날짜는 언제인가요?(숫자만 입력해 주세요!)"),
    IN_MENU("주문하실 메뉴를 메뉴와 개수를 알려주세요. (e.g. 해순물파스타-2,레드와인-1,초코케이크-1)"),
    OUT_RESERVE("12월 %d 일에 우테코 식당에서 받을 이벤트 혜택 미리보기!"),
    OUT_MENU("<주문 메뉴>"),
    OUT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    OUT_PRESENT("<증정 메뉴>"),
    OUT_BENEFIT("<혜택 내역>"),
    OUT_DISCOUNT_PRICE("<총혜택 금액>"),
    OUT_AFFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    OUT_BADGE("<12월 이벤트 배지>"),
    NOTHING("없음"),
    OUT_PRESENT_DETAIL("샴페인 1개"),
    OUT_PRESENT_DISCOUNT("증정 이벤트: -25,000원"),
    MINUS("-"),
    UNIT("원");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message,args);
    }
}
