package domain;

public class Table {
	private final Orders orders;
	private final int number;

	public Table(final int number) {
		this.orders = new Orders();
		this.number = number;
	}

	public void addOrder(Menu menu, int count) {
		orders.addOrder(menu, count);
	}

	public Money calculateMoney() {
		return orders.calculateMoney();
	}

	public void clear() {
		orders.clear();
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}
}
