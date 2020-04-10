package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	private final BigDecimal amount;

	private Money(BigDecimal amount) {
		this.amount = amount;
	}

	public static Money wons(long amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public static Money wons(double amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return Objects.equals(amount, money.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}
}
