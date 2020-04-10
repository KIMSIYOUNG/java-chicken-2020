package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuTest {
	@Test
	void isSameIdTest() {
		Menu menu = MenuRepository.findById("1");
		assertThat(menu.isSameId("1")).isTrue();
	}

	@Test
	void getNameTest() {
		Menu menu = MenuRepository.findById("1");
		assertThat(menu.getName()).isEqualTo("후라이드");
	}

	@Test
	void toStringTest() {
		Menu menu = MenuRepository.findById("1");
		assertThat(menu.toString()).isEqualTo("[치킨] 1 - 후라이드 : 16000원");
	}
}