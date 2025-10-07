package ATM_Machine;

public class InvalidAmountException extends Exception {
	public InvalidAmountException(String message) {
        super(message);
    }
}
