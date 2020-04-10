package domain;

import java.util.Map;

public class Table {
	private final Orders orders;
	private final int id;

	public Table(final int id) {
		this.orders = new Orders();
		this.id = id;
	}

	public void addOrder(Menu menu, int count) {
		orders.addOrder(menu, count);
	}

	public Money calculateMoney() {
		return orders.calculateMoney();
	}

	public boolean isSameId(String id) {
		return isSameId(Integer.parseInt(id));
	}

	public boolean isSameId(int id) {
		return this.id == id;
	}

	public void clear() {
		orders.clear();
	}

	public Orders getOrders() {
		return orders;
	}

	public Map<Menu, Integer> getRawOrders() {
		return orders.getOrderedMenus();
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return Integer.toString(id);
	}
}
