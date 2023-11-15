package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.DateInfomation;
import christmas.model.Discount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CalculateDiscountTest {

    private Discount discount;
    private DateInfomation dateInfomation;
    private final int testDate = 10;
    @BeforeEach
    void setUp(){
        discount = new Discount();
        dateInfomation = new DateInfomation(testDate);
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

}
