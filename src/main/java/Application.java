import domain.Command;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		OutputView.printCommands();
		while (true) {
			runProgram();
		}
	}

	private static void runProgram() {
		try {
			Command.of(InputView.inputCommandId()).run();
			OutputView.printCommands();
		} catch (Exception e) {
			OutputView.printException(e);
		}
	}
}
