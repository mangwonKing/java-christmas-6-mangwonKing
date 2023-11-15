package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BenefitTest {

    private Discount discount;
    private final int TOTAL_ORDER_PRICE = 119000;
    @BeforeEach
    void setUp(){
        discount = new Discount();
    }

    @Test
    void 증정품_여부_판단(){
        boolean result = discount.checkPresent(TOTAL_ORDER_PRICE);
        assertThat(result).isEqualTo(false);
    }
}
