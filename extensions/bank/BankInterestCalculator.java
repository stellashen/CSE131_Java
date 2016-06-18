package bank;

public class BankInterestCalculator {

	public static void main(String[] args) {
		double money = 4000;
		System.out.println("Day	Type		Amount		Balance");
		for (int i=0; i < 30;++i){
			System.out.print(i+1);
			if (Math.random()<0.5){
				System.out.print("	Deposit 	$200.50");
				money = money + 200.5;
			}
			else {
				System.out.print("	Withdraw	$100.00");
				money = money - 100;
			}
			System.out.println("		$"+ money+"0");
		}
		double interest = Math.round(money * 0.02 * 100)/100;
		System.out.println();
		System.out.println("Interest earned: " + interest);
		System.out.println("Money after one month's interest: " + (interest + money));
	}

}
