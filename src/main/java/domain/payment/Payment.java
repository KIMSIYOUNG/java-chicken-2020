package domain.payment;

import domain.Money;
import domain.Table;

public class Payment {
	private final DiscountPolicy discountPolicy;
	private final PaymentType paymentType;
	private final Table table;

	public Payment(DiscountPolicy discountPolicy, PaymentType paymentType, Table table) {
		this.discountPolicy = discountPolicy;
		this.paymentType = paymentType;
		this.table = table;
	}

	public Money calculate() {
		Money raw = table.calculateMoney();
		Money discountMo = discountPolicy.getDiscountMoney(table.getOrders());
		return paymentType.calculate(raw.minus(discountMo));
	}
}
