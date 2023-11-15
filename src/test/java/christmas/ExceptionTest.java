package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {

    // 메뉴가 존재 하는지
    @Test
    void 메뉴_존재_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3","해순물파스타-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    // 메뉴가 중복은 아닌지
    @Test
    void 메뉴_중복_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3","해산물파스타-1,제로콜라-2,해산물파스타-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    // 메뉴주문 양식이 올바르지 않은 경우
    @Test
    void 메뉴_잘못된_양식_예외_테스트() {
        assertSimpleTest(() -> {
            runException("4","해산물파스타+1,제로콜라+2");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }
    //총 주문 개수가 20개를 넘기지 않았는지

    //음료만 주문하지는 않았는지

    //1 이상 31 이하의 숫자가 아닌 다른 수가 입력되는 경우
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
