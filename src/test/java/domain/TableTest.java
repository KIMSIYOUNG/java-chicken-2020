package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {
	private final Menu menu = MenuRepository.menus().get(0);

	@Test
	@DisplayName("테이블에 정상적으로 메뉴를 추가할 수 있다.")
	void addMenu() {
		Table table = new Table(7);
		table.addOrder(menu, 10);
		assertThat(table.calculateMoney()).isEqualTo(Money.wons(160_000));
	}

	@Test
	@DisplayName("테이블에 주문된 주문 목록을 초기화 할 수 있다.")
	void clear() {
		Table table = new Table(7);
		table.addOrder(menu, 10);
		table.clear();
		assertThat(table.calculateMoney()).isEqualTo(Money.wons(0));
	}

	@Test
	void isSameIdByInt() {
		assertThat(new Table(1).isSameId(1)).isTrue();
	}

	@Test
	void isNotSameIdByInt() {
		assertThat(new Table(1).isSameId(3)).isFalse();
	}

	@Test
	void isSameIdByString() {
		assertThat(new Table(3).isSameId("3")).isTrue();
	}
}