package domain;

import java.util.Arrays;

import controller.ExitController;
import controller.PaymentController;
import controller.PosController;
import controller.RegisterController;

public enum Command {
	REGISTER(1, new RegisterController()),
	PAY(2, new PaymentController()),
	EXIT(3, new ExitController());

	private final int id;
	private final PosController model;

	Command(int id, PosController model) {
		this.id = id;
		this.model = model;
	}

	public static Command of(String input) {
		return of(Integer.parseInt(input));
	}

	public static Command of(int input) {
		return Arrays.stream(values())
			.filter(value -> value.id == input)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("커멘드 관련 입력은 1,2,3번만 가능합니다."));
	}

	public void run() {
		this.model.run();
	}
}
