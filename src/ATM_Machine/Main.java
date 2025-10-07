package ATM_Machine;

import java.util.Scanner;

public class Main {
	private static boolean validate(int ATMnumber, int ATMpin, int userNumber, int userPin) {
		return (ATMnumber == userNumber) && (ATMpin == userPin);
	}
	public static void main(String[] args) {
		
		ATMPOperationInterface operation = new ATMPOperationImpl();
		
		int ATMnumber = 12345;
		int ATMpin = 123;
		
		Scanner input = new Scanner(System.in);
		
		try {
            System.out.println("Welcome to ATM Machine!!");
            System.out.print("Enter ATM Number : ");
            int userNumber = input.nextInt();
            System.out.print("Enter Pin : ");
            int userPin = input.nextInt();

            if (validate(ATMnumber, ATMpin, userNumber, userPin)) {
                while(true) {
                    System.out.println(
                        "\n1. View Available Balance\n"
                        + "2. Withdraw Amount\n"
                        + "3. Deposit Amount\n"
                        + "4. View History\n"
                        + "5. Exit");
                    System.out.print("Enter Choice : ");
                    int choice = input.nextInt();
                    
                    try {
                        switch(choice) {
                            case 1:
                                operation.viewBalance();
                                break;
                            case 2:
                                System.out.print("Enter Amount to Withdraw : ");
                                double withdrawAmount = input.nextDouble();
                                operation.withdrawAmount(withdrawAmount);
                                break;
                            case 3:
                                System.out.print("Enter Amount to Deposit : ");
                                double depositAmount = input.nextDouble();
                                operation.depositAmount(depositAmount);
                                break;
                            case 4:
                                operation.viewHistory();
                                break;
                            case 5:
                                System.out.println("Collect your ATM Card\n"
                                    + "Thank you for using the ATM Machine!");
                                System.exit(0);
                            default:
                                System.out.println("Please enter correct choice.");
                        }
                    } catch (InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (InvalidAmountException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("Incorrect ATM number or pin.");
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
	}

}
