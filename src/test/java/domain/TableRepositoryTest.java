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

	@Test
	@DisplayName("인트 파라미터로 아이디를 입력하면 해당 테이블을 반환한다.")
	void findByIdByInt() {
		Table table = TableRepository.findById(1);
		assertThat(table.isSameId(1));
	}

	@Test
	@DisplayName("존재하지 않는 아이디는 예외를 반환한다.")
	void invalidIdException() {
		assertThatThrownBy(() -> {
			TableRepository.findById(7);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("없는 테이블입니다. 테이블은 1~6번까지만 선택할 수 있습니다.");
	}

	@Test
	@DisplayName("인트 파라미터로 아이디를 입력하면 해당 테이블을 반환한다.")
	void findByIdByString() {
		Table table = TableRepository.findById("3");
		assertThat(table.isSameId(3));
	}
}