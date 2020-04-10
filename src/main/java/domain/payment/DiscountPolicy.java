package domain.payment;

import domain.Money;
import domain.Orders;

public interface DiscountPolicy {
	Money getDiscountMoney(Orders orders);
}
