package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.DateInfomation;
import christmas.model.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CalculateDiscountTest  extends NsTest{
    private final int testDate = 10;
    private Discount discount;
    private DateInfomation dateInfomation;

    @BeforeEach
    void setUp(){
        discount = new Discount();
        dateInfomation = new DateInfomation(testDate);
    }
    @Test
    void 이벤트_대상_확인(){
        boolean result = discount.checkMinOrderPrice(9000);
        assertThat(result).isEqualTo(false);
    }
    @Test
    void 디데이_할인_계산(){
        int result = discount.calculateDayDiscount(dateInfomation);
        assertThat(result).isEqualTo(1900);
    }
    @Test
    void 스페셜_할인_계산(){
        int result = discount.checkSpecialDay(dateInfomation);
        assertThat(result).isEqualTo(1000);
    }

    @Test
    void 주말_할인_계산(){
        assertSimpleTest(() -> {
            run("1", "티본스테이크-1,제로콜라-3");
            assertThat(output()).contains("주말 할인: -2,023원");
        });
    }

    @Test
    void 평일_할인_계산(){
        assertSimpleTest(() -> {
            run("5", "티본스테이크-2,초코케이크-2");
            assertThat(output()).contains("평일 할인: -4,046원");
        });
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
