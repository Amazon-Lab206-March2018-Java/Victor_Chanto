
public class Main {

	public static void main(String[] args) {
		BankAccount chanto = new BankAccount();
		chanto.addChecking(5200.00);
		chanto.addSavings(1920.00);
		chanto.withdraw("savings", 500.00);
		System.out.println(chanto.getSavings_balance());
		System.out.println(chanto.getChecking_balance());
		System.out.println(chanto.total());
	}

}
