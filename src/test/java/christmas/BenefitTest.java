package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BenefitTest extends NsTest{
    private final int TOTAL_ORDER_PRICE = 119000;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private Discount discount;
    @BeforeEach
    void setUp(){
        discount = new Discount();
    }

    @Test
    void 증정품_여부_판단(){
        boolean result = discount.checkPresent(TOTAL_ORDER_PRICE);
        assertThat(result).isEqualTo(false);
    }
    @Test
    void 뱃지_확인(){
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>" + LINE_SEPARATOR + "산타");
        });
    }
    @Test
    void 총_혜택_계산(){
        assertSimpleTest(() -> {
            run("6", "티본스테이크-2,레드와인-1,초코케이크-3");
            assertThat(output()).contains("<총혜택 금액>" + LINE_SEPARATOR + "-32,569원");
        });
    }
    @Test
    void 최종_결제금액_계산(){
        assertSimpleTest(() -> {
            run("25", "티본스테이크-1,제로콜라-3");
            assertThat(output()).contains("<할인 후 예상 결제 금액>" + LINE_SEPARATOR + "59,600원");
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
