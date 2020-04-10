package domain.payment;

import java.util.Arrays;

import domain.Money;

public enum Payment {
	CARD(1, 1),
	CASH(2, 0.95);

	private final int id;
	private final double discountRate;

	Payment(int id, double discountRate) {
		this.id = id;
		this.discountRate = discountRate;
	}

	public static Payment of(String input) {
		return of(Integer.parseInt(input));
	}

	public static Payment of(int input) {
		return Arrays.stream(values())
			.filter(value -> value.id == input)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public Money calculate(long input) {
		return Money.wons(this.discountRate * input);
	}
}
