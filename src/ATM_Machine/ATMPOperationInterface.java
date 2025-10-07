package ATM_Machine;

public interface ATMPOperationInterface {
	public void viewBalance();
	public void withdrawAmount(double withdrawAmount) throws InsufficientFundsException, InvalidAmountException;
	public void depositAmount(double depositAmount) throws InvalidAmountException;
	public void viewHistory();
}
