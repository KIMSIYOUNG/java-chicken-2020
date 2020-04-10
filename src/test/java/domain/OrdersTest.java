package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.InvalidOrderCountException;

class OrdersTest {
	private final Menu menu = MenuRepository.menus().get(0);

	@Test
	@DisplayName("동일 메뉴에 대해 한번에 99개 이상 주문할 수 없다.")
	void overRangeOf99() {
		Orders orders = new Orders();
		assertThatThrownBy(() -> {
			orders.addOrder(menu, 100);
		}).isInstanceOf(InvalidOrderCountException.class)
			.hasMessageMatching("한 메뉴의 최대주문 수량은 99개입니다.");
	}

	@Test
	@DisplayName("동일 메뉴에 대해 99개 이상 주문할 수 없다.")
	void overRangeOf99OneMoreAdd() {
		Orders orders = new Orders();
		orders.addOrder(menu, 50);
		assertThatThrownBy(() -> {
			orders.addOrder(menu, 50);
		}).isInstanceOf(InvalidOrderCountException.class)
			.hasMessageMatching("한 메뉴의 최대주문 수량은 99개입니다.");
	}

	@Test
	@DisplayName("주문한 상품에 대한 가격을 정확하게 반환한다.")
	void calculateTest() {
		Orders orders = new Orders();
		orders.addOrder(menu, 10);
		orders.addOrder(MenuRepository.menus().get(7), 10);
		assertThat(orders.calculateMoney()).isEqualTo(Money.wons(170_000));
	}
}