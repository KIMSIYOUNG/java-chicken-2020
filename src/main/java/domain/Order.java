package domain;

public class Order {
	private final Menu menu;
	private final int count;

	public Order(Menu menu, int count) {
		this.menu = menu;
		this.count = count;
	}

	public Money calculate() {
		return Money.wons(menu.getPrice() * count);
	}
}
