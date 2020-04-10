package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Money;

class PaymentTypeTest {
	@Test
	@DisplayName("String 1이 입력된 경우 Card객체를 리턴한다.")
	void ofCardStringTest() {
		assertThat(PaymentType.of("1")).isEqualTo(PaymentType.CARD);
	}

	@Test
	@DisplayName("Integer 1이 입력된 경우 Card객체를 리턴한다.")
	void ofCardIntegerTest() {
		assertThat(PaymentType.of(1)).isEqualTo(PaymentType.CARD);
	}

	@Test
	@DisplayName("String 2이 입력된 경우 Cash객체를 리턴한다.")
	void ofCashStringTest() {
		assertThat(PaymentType.of("2")).isEqualTo(PaymentType.CASH);
	}

	@Test
	@DisplayName("Integer 2이 입력된 경우 Cash객체를 리턴한다.")
	void ofCashIntegerTest() {
		assertThat(PaymentType.of(2)).isEqualTo(PaymentType.CASH);
	}

	@Test
	@DisplayName("1또는 2가 입력되지 않는 경우 예외를 반환한다.")
	void IllegalInputException() {
		assertThatThrownBy(() -> {
			PaymentType.of(3);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("현금할인을 정상적으로 수행한다.")
	void calculateCashTest() {
		assertThat(PaymentType.CASH.calculate(Money.wons(1000))).isEqualTo(Money.wons(950.0));
	}

	@Test
	@DisplayName("카드의 경우 할인을 제공하지 않는다.")
	void calculateCardTest() {
		assertThat(PaymentType.CARD.calculate(Money.wons(1000))).isEqualTo(Money.wons(1000.0));
	}
}