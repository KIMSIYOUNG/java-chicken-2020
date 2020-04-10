package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoryTest {
	@Test
	void isChickenTest() {
		assertThat(Category.CHICKEN.isChicken()).isTrue();
	}

	@Test
	void isNotChickenTest() {
		assertThat(Category.BEVERAGE.isChicken()).isFalse();
	}

	@Test
	void toStringTest() {
		assertThat(Category.CHICKEN.toString()).isEqualTo("[치킨]");
	}
}