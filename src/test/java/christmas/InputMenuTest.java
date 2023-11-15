package christmas;

import christmas.model.OrderInfomation;
import christmas.view.InputView;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputMenuTest {
    private final String testOrder = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

    private OrderInfomation orderInfomation;
    private Map<String,Integer> order = new HashMap<>();
    @Test
    void 총주문금액계산(){
        order.put("티본스테이크",1);
        order.put("바비큐립",1);
        order.put("초코케이크",2);
        order.put("제로콜라",1);

        orderInfomation = new OrderInfomation(order);
        int result = orderInfomation.calculateTotal();
        assertThat(result).isEqualTo(142000);
    }
}
