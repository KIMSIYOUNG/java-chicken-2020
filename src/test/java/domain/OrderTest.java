package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
	@Test
	@DisplayName("주문한 메뉴와 수량에 대한 가격을 정상적으로 계산하는지 테스트합니다.")
	void calculateEachOrderTest() {
		Menu chicken = MenuRepository.menus().get(0);
		Order order = new Order(chicken, 10);
		assertThat(order.calculate()).isEqualTo(Money.wons(160000));
	}
}