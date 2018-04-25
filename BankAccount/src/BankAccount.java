import java.util.*;

public class BankAccount {
	private String account_Number;
	private Double checking_balance = 0.00;
	private Double savings_balance = 0.00;
	public static int accountsCreated = 0;
	public static int moneyStored = 0;

	public BankAccount() {
		this.account_Number = accountNumber();
		accountsCreated++;
	}
	private String accountNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(9000000) + 1000000000;
        String result = String.valueOf(number);
        System.out.println(result);
        return result;
    }


	public Double getChecking_balance() {
		return checking_balance;
	}

	public void addChecking(Double amount) {
		this.checking_balance += amount;
		moneyStored+=amount;
	}

	public Double getSavings_balance() {
		return savings_balance;
	}

	public void addSavings(Double amount ) {
		this.savings_balance += amount ;
		moneyStored+=amount ;
	}
	public void withdraw(String account, Double amount) {
		if (account == "savings"){
			this.savings_balance -= amount;
		}
		else {
			this.checking_balance -= amount;
		}
		moneyStored-=amount;
	}
	public String total(){
		String Result = "The checking has "+checking_balance+"and the Savings has "+savings_balance;
		return Result;
	}
	

}
