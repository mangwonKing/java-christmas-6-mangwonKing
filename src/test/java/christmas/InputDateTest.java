package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.model.DateInfomation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class InputDateTest {
    private DateInfomation dateInfomation;
    private int weekendTestDay = 2;
    private int normalTestDay = 4;
    private int specialTestDay = 3;

    @Test
    void 주말_확인(){
        dateInfomation = new DateInfomation(weekendTestDay);
        boolean result = dateInfomation.getIsWeekend();
        assertThat(result).isEqualTo(true);
    }
    @Test
    void 평일_확인(){
        dateInfomation = new DateInfomation(normalTestDay);
        boolean result = dateInfomation.getIsWeekend();
        assertThat(result).isEqualTo(false);
    }
}
