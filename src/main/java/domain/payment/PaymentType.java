package domain.payment;

import java.util.Arrays;

import domain.Money;

public enum PaymentType {
	CARD(1, 1),
	CASH(2, 0.95);

	private final int id;
	private final double discountRate;

	PaymentType(int id, double discountRate) {
		this.id = id;
		this.discountRate = discountRate;
	}

	public static PaymentType of(String input) {
		return of(Integer.parseInt(input));
	}

	public static PaymentType of(int input) {
		return Arrays.stream(values())
			.filter(value -> value.id == input)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public Money calculate(Money input) {
		return input.multiply(discountRate);
	}
}
