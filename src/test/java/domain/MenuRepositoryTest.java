package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {
	@Test
	@DisplayName("생성한 메뉴들의 사이즈에 대해 테스트합니다.")
	void createTest() {
		List<Menu> menus = MenuRepository.menus();
		assertThat(menus).hasSize(8);
	}

	@Test
	@DisplayName("생성한 메뉴중, 치킨은 6개 테스트합니다.")
	void createMenusTest() {
		List<Menu> menus = MenuRepository.menus();
		long chickenCount = menus.stream()
			.filter(Menu::isChicken)
			.count();
		assertThat(chickenCount).isEqualTo(6);
	}

	@Test
	@DisplayName("생성한 메뉴중, 음료는 2개인지 테스트합니다.")
	void createBeverageTest() {
		List<Menu> menus = MenuRepository.menus();
		long beverageCount = menus.stream()
			.filter(Menu::isNotChicken)
			.count();
		assertThat(beverageCount).isEqualTo(2);
	}

	@Test
	@DisplayName("Repository에서 생성된 메뉴판을 임의로 변경할 수 없는지 테스트합니다.")
	void menusTest() {
		List<Menu> menus = MenuRepository.menus();
		assertThatThrownBy(() -> {
			menus.add(new Menu(20, "카일치킨", Category.BEVERAGE, 1600));
		}).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("아이디를 기반으로 메뉴를 찾을 수 있는지 테스트합니다.")
	void idTest() {
		Menu menu = MenuRepository.findById("2");
		assertThat(menu.isSameId("2")).isTrue();
	}

	@Test
	@DisplayName("존재하지 않는 아이디는 예외를 반환합니다.")
	void notExistIdTest() {
		assertThatThrownBy(() -> MenuRepository.findById("30"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("존재하지 않는 메뉴입니다.");
	}
}