package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandTest {
	@Test
	@DisplayName("인트타입의 파라미터로 생성이 가능한지.")
	void intParameterConstructor() {
		assertThat(Command.of(1)).isEqualTo(Command.REGISTER);
	}

	@Test
	@DisplayName("String 타입의 파라미터로 생성이 가능한지.")
	void stringParameterConstructor() {
		assertThat(Command.of("2")).isEqualTo(Command.PAY);
	}

	@ParameterizedTest
	@ValueSource(strings = {"4", "0", "-1"})
	@DisplayName("1,2,3이외의 값에 대해 예외를 정상 반환하는지")
	void invalidInputException(String input) {
		assertThatThrownBy(() -> Command.of(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("커멘드 관련 입력은 1,2,3번만 가능합니다.");
	}
}