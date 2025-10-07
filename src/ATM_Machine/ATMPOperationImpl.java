package ATM_Machine;

import java.util.HashMap;
import java.util.Map;

public class ATMPOperationImpl implements ATMPOperationInterface {

	ATM atm = new ATM();
	
	Map<Double, String>  history = new HashMap<>();
	
	@Override
	public void viewBalance() {
		System.out.println("Available Balance : " + atm.getBalance() + " rs.");
		
	}

	@Override
	public void withdrawAmount(double withdrawAmount) throws InsufficientFundsException, InvalidAmountException  {
		if (withdrawAmount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (withdrawAmount % 100 != 0) {
            throw new InvalidAmountException("Please enter the amount in multiples of 100.");
        }
        if (atm.getBalance() < withdrawAmount) {
            throw new InsufficientFundsException("Insufficient Balance!");
        }
        
        history.put(withdrawAmount, " rs. withdrawn");
        System.out.println("Collect " + withdrawAmount + " rs.");
        atm.setBalance(atm.getBalance() - withdrawAmount);
        viewBalance();	
	}

	@Override
	public void depositAmount(double depositAmount) throws InvalidAmountException {
		if (depositAmount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        
        history.put(depositAmount, " rs. deposited");
        System.out.println(depositAmount + " rs. deposited successfully");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
	}

	@Override
	public void viewHistory() {
		for (Map.Entry<Double, String> statement : history.entrySet()) {
			System.out.println(statement.getKey() + " " + statement.getValue());
		}
		
	}
	
}
