package controller;

public class ExitController implements PosController {
	private static final int EXIT_NO = 0;

	@Override
	public void run() {
		System.exit(EXIT_NO);
	}
}
