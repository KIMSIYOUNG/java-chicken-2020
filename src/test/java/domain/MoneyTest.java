package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	@DisplayName("double을 생성자 파라미터로 Money를 생성할 수 있다.")
	void doubleConstructorTest() {
		assertThat(Money.wons(1500.0)).isInstanceOf(Money.class);
	}

	@Test
	@DisplayName("long을 생성자 파라미터로 Money를 생성할 수 있다.")
	void longConstructorTest() {
		assertThat(Money.wons(1500)).isInstanceOf(Money.class);
	}
}