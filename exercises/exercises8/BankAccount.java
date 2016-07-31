package exercises8;

public class BankAccount implements Valuable{
	
	private int balance;
	
	public BankAccount(int initialBal){
		this.balance = initialBal;
	}
	
	public int getBalance(){
		return this.balance;
	}
	
	public void deposit(int funds){
		this.balance = this.balance + funds;
		this.balance = this.balance - 1;
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}

	@Override
	public int getLiquidValue() {
		return this.getBalance();
	}

}
