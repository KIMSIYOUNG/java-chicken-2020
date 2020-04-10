package exception;

public class InvalidOrderCountException extends RuntimeException {
	public InvalidOrderCountException(String message) {
		super(message);
	}
}
