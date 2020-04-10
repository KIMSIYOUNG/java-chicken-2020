package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableRepositoryTest {
	@Test
	@DisplayName("테이블의 갯수는 6개이다.")
	void createSizeTest() {
		List<Table> tables = TableRepository.tables();
		assertThat(tables).hasSize(6);
	}

	@Test
	@DisplayName("외부에서 임의로 테이블을 추가할 수 없다.")
	void createMoreTableTest() {
		List<Table> tables = TableRepository.tables();
		assertThatThrownBy(() -> {
			tables.add(new Table(7));
		}).isInstanceOf(UnsupportedOperationException.class);
	}
}