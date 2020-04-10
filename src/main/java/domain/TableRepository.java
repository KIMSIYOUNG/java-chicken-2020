package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
	private static final List<Table> tables = new ArrayList<>();

	static {
		tables.add(new Table(1));
		tables.add(new Table(2));
		tables.add(new Table(3));
		tables.add(new Table(5));
		tables.add(new Table(6));
		tables.add(new Table(8));
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}

	public static Table findById(int id) {
		return tables.stream()
			.filter(table -> table.isSameId(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("없는 테이블입니다. 테이블은 1~6번까지만 선택할 수 있습니다."));
	}

	public static Table findById(String id) {
		return tables.stream()
			.filter(table -> table.isSameId(id))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("없는 테이블입니다. 테이블은 1~6번까지만 선택할 수 있습니다."));
	}
}
