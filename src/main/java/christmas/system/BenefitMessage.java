package christmas.system;

public enum BenefitMessage {
    SPECIAL_DISCOUNT("특별 할인: -"),
    WEEKEND_DISCOUNT("주말 할인: -"),
    NORMAL_DISCOUNT("평일 할인: -"),
    DDAY_DISCOUNT("크리스마스 디데이 할인: -"),
    UNIT("원"),
    WEEKEND_DISCOUNT_CATEGORY("메인"),
    NORMAL_DISCOUNT_CATEGORY("디저트");

    private final String benefit;

    BenefitMessage(String benefit) {
        this.benefit = benefit;
    }

    public String getBenefit() {
        return benefit;
    }

}
