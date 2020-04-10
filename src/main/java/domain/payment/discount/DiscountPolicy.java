package domain.payment.discount;

import domain.Money;
import domain.Orders;

public interface DiscountPolicy {
	Money getDiscountMoney(Orders orders);
}
