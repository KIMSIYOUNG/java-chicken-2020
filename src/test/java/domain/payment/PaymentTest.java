package domain.payment;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.MenuRepository;
import domain.Money;
import domain.Table;

class PaymentTest {
	@Test
	@DisplayName("치킨 10마리 이상과, 현금으로 결제하는 경우 계산을 올바르게 수행")
	void over10ChickenAndCash() {
		Table table = new Table(7);
		table.addOrder(MenuRepository.menus().get(0), 30);
		Payment payment = new Payment(new ChickenDiscountPolicy(), PaymentType.CASH, table);
		assertThat(payment.calculate()).isEqualTo(Money.wons(String.format("%.1f", 427500.00)));
	}

	@Test
	@DisplayName("치킨 10마리 이하와, 현금으로 결제하는 경우 계산을 올바르게 수행")
	void less10ChickenAndCash() {
		Table table = new Table(7);
		table.addOrder(MenuRepository.menus().get(0), 5);
		Payment payment = new Payment(new ChickenDiscountPolicy(), PaymentType.CASH, table);
		assertThat(payment.calculate()).isEqualTo(Money.wons(76000.0));
	}

	@Test
	@DisplayName("치킨 10마리 이상와, 카드으로 결제하는 경우 계산을 올바르게 수행")
	void over10ChickenAndCard() {
		Table table = new Table(7);
		table.addOrder(MenuRepository.menus().get(0), 10);
		Payment payment = new Payment(new ChickenDiscountPolicy(), PaymentType.CARD, table);
		assertThat(payment.calculate()).isEqualTo(Money.wons(150000.0));
	}

	@Test
	@DisplayName("치킨 10마리 이하와, 카드으로 결제하는 경우 계산을 올바르게 수행")
	void less10ChickenAndCard() {
		Table table = new Table(7);
		table.addOrder(MenuRepository.menus().get(0), 5);
		Payment payment = new Payment(new ChickenDiscountPolicy(), PaymentType.CARD, table);
		assertThat(payment.calculate()).isEqualTo(Money.wons(80000.0));
	}
}