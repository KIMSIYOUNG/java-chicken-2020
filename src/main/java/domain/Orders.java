package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import exception.InvalidOrderCountException;

public class Orders {
	private static final int INIT = 0;
	private static final int MAX_COUNT = 99;

	private final Map<Menu, Integer> orders = new HashMap<>();

	public Orders() {
		for (Menu menu : MenuRepository.menus()) {
			orders.put(menu, INIT);
		}
	}

	public void addOrder(Menu menu, int count) {
		validateCount(menu, count);
		orders.computeIfPresent(menu, (key, value) -> value + count);
	}

	private void validateCount(Menu menu, int count) {
		if (orders.get(menu) + count > MAX_COUNT) {
			throw new InvalidOrderCountException("한 메뉴의 최대주문 수량은 99개입니다.");
		}
	}

	public Money calculateMoney() {
		return Money.wons(orders.entrySet().stream()
			.mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
			.sum());
	}

	public void clear() {
		orders.clear();
	}

	public Map<Menu, Integer> getOrders() {
		return Collections.unmodifiableMap(orders);
	}
}
