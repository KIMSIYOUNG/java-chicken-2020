package domain;

public class Menu {
	private final int id;
	private final String name;
	private final Category category;
	private final int price;

	public Menu(final int id, final String name, final Category category, final int price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public boolean isChicken() {
		return category.isChicken();
	}

	public boolean isNotChicken() {
		return !isChicken();
	}

	public boolean isSameId(String menuId) {
		return this.id == Integer.parseInt(menuId);
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return category + " " + id + " - " + name + " : " + price + "원";
	}
}
