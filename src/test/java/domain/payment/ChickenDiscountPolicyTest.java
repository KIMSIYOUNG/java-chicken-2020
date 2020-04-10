package domain.payment;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Menu;
import domain.MenuRepository;
import domain.Money;
import domain.Orders;
import domain.payment.discount.ChickenDiscountPolicy;

class ChickenDiscountPolicyTest {
	private final Menu firstChicken = MenuRepository.menus().get(0);
	private final Menu secondChicken = MenuRepository.menus().get(1);

	@Test
	@DisplayName("치킨이 10마리 이상이 아닌 경우 할인금액이 0이 정상 반환되는지")
	void calculateNotOver10ChickenTest() {
		ChickenDiscountPolicy discount = new ChickenDiscountPolicy();
		Orders orders = new Orders();
		orders.addOrder(firstChicken, 4);
		orders.addOrder(secondChicken, 5);
		assertThat(discount.getDiscountMoney(orders)).isEqualTo(Money.wons(0));
	}

	@Test
	@DisplayName("치킨이 10마리 이상인 할인금액이 정상 반환되는지")
	void calculateOver10ChickenTest() {
		ChickenDiscountPolicy discount = new ChickenDiscountPolicy();
		Orders orders = new Orders();
		orders.addOrder(firstChicken, 7);
		orders.addOrder(secondChicken, 5);
		assertThat(discount.getDiscountMoney(orders)).isEqualTo(Money.wons(10_000));
	}

	@Test
	@DisplayName("한 종류만 10마리 이상인 경우에도 할인금액이 정상 반환되는지")
	void calculateOneChickenDiscount() {
		ChickenDiscountPolicy discount = new ChickenDiscountPolicy();
		Orders orders = new Orders();
		orders.addOrder(firstChicken, 30);
		assertThat(discount.getDiscountMoney(orders)).isEqualTo(Money.wons(30_000));
	}
}