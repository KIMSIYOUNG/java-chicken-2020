package domain.payment.discount;

import java.util.Map;

import domain.Money;
import domain.Orders;

public class ChickenDiscountPolicy implements DiscountPolicy {
	private static final int PER_CHICKEN = 10;
	private static final int DISCOUNT_MONEY = 10000;

	@Override
	public Money getDiscountMoney(Orders orders) {
		int chickenAmount = orders.getOrders().entrySet().stream()
			.filter(entry -> entry.getKey().isChicken())
			.mapToInt(Map.Entry::getValue)
			.sum();
		return Money.wons((chickenAmount / PER_CHICKEN) * DISCOUNT_MONEY);
	}
}
