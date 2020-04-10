package view;

import java.util.List;
import java.util.Map;

import domain.Menu;
import domain.Money;
import domain.Table;

public class OutputView {
	private static final String NEW_LINE = System.lineSeparator();
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String BOTTOM_LINE_WITH_ORDER = "└ ₩ ┘";

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printBottom(tables);
		System.out.println();
	}

	private static void printBottom(List<Table> tables) {
		for (Table table : tables) {
			if (table.isNotOrdered()) {
				System.out.print(BOTTOM_LINE);
				continue;
			}
			System.out.print(BOTTOM_LINE_WITH_ORDER);
		}
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printCommands() {
		StringBuilder sb = new StringBuilder();
		sb.append("1 - 주문등록")
			.append(NEW_LINE)
			.append("2 - 결제하기")
			.append(NEW_LINE)
			.append("3 - 시스템 종료")
			.append(NEW_LINE)
			.append("원하시는 기능을 입력해주세요.");
		System.out.println(sb.toString());
	}

	public static void printException(Exception e) {
		System.out.println(e.getMessage());
	}

	public static void printOrders(Table table) {
		StringBuilder sb = new StringBuilder();
		sb.append("## 주문 내역")
			.append(NEW_LINE)
			.append("메뉴  수량  금액")
			.append(NEW_LINE);
		printOrderedMenus(sb, table.getRawOrders());
		System.out.println(sb.toString());
	}

	private static void printOrderedMenus(StringBuilder sb, Map<Menu, Integer> rawOrders) {
		rawOrders.forEach((key, value) ->
			sb.append(key.getName() + " ")
				.append(value.toString() + " ")
				.append(key.getPrice() * value));
	}

	public static void printPaymentStart(Table table) {
		System.out.println(NEW_LINE + table.getId() + "번 테이블의 결제를 진행합니다.");
		System.out.println("## 신용카드는 1번, 현금은 2번을 입력해주세요.");
	}

	public static void printTotalMoney(Money money) {
		System.out.println("##최종 결제금액은 " + NEW_LINE + money + "입니다.");
	}
}
