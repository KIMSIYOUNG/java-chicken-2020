package domain;

import java.util.Arrays;

import model.Exit;
import model.Pay;
import model.PosModel;
import model.Registration;

public enum Command {
	REGISTER(1, new Registration()),
	PAY(2, new Pay()),
	EXIT(3, new Exit());

	private final int id;
	private final PosModel model;

	Command(int id, PosModel model) {
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
