package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Money;

class PaymentTest {
	@Test
	@DisplayName("String 1이 입력된 경우 Card객체를 리턴한다.")
	void ofCardStringTest() {
		assertThat(Payment.of("1")).isEqualTo(Payment.CARD);
	}

	@Test
	@DisplayName("Integer 1이 입력된 경우 Card객체를 리턴한다.")
	void ofCardIntegerTest() {
		assertThat(Payment.of(1)).isEqualTo(Payment.CARD);
	}

	@Test
	@DisplayName("String 2이 입력된 경우 Cash객체를 리턴한다.")
	void ofCashStringTest() {
		assertThat(Payment.of("2")).isEqualTo(Payment.CASH);
	}

	@Test
	@DisplayName("Integer 2이 입력된 경우 Cash객체를 리턴한다.")
	void ofCashIntegerTest() {
		assertThat(Payment.of(2)).isEqualTo(Payment.CASH);
	}

	@Test
	@DisplayName("1또는 2가 입력되지 않는 경우 예외를 반환한다.")
	void IllegalInputException() {
		assertThatThrownBy(() -> {
			Payment.of(3);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("현금할인을 정상적으로 수행한다.")
	void calculateCashTest() {
		assertThat(Payment.CASH.calculate(1000)).isEqualTo(Money.wons(950.0));
	}

	@Test
	@DisplayName("카드의 경우 할인을 제공하지 않는다.")
	void calculateCardTest() {
		assertThat(Payment.CARD.calculate(1000)).isEqualTo(Money.wons(1000.0));
	}
}