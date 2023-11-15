package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {

    // 메뉴가 존재 하는지

    // 메뉴가 중복은 아닌지

    // 메뉴를 1개이상 시켰는지

    //총 주문 개수가 20개를 넘기지 않았는지

    //음료만 주문하지는 않았는지
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
