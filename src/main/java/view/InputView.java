package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputTableNumber() {
		System.out.println("## 주문할 테이블을 선택하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static String inputCommandId() {
		return scanner.nextLine();
	}

	public static String inputMenuId() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		return scanner.nextLine();
	}

	public static int inputMenuCount() {
		System.out.println("## 메뉴의 수량을 입력하세요.");
		return Integer.parseInt(scanner.nextLine());
	}

	public static int inputPaymentId() {
		return Integer.parseInt(scanner.nextLine());
	}
}
