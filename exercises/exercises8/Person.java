package exercises8;

import java.util.LinkedList;
import java.util.List;

public class Person {
	
	final private List<Valuable> assets;
	
	public Person(){
		this.assets = new LinkedList<Valuable>();
	}
	
	public void addAsset(Valuable v){
		assets.add(v);
	}

// use method addAsset(Valuable v) to replace the two methods below:
//	public void addStockHolding(StockHolding s){
//		assets.add(s);
//	}
//	
//	public void addPersonalProperty(PersonalProperty p){
//		assets.add(p);
//	}
	
	public List<Valuable> getAssets(){
		return this.assets;
	}
	
	public int getWorth(){
		int sum = 0;
		for (Valuable v:assets){
			sum = sum + v.getLiquidValue();
		}
		return sum;
	}
	
	public static void main(String[] args){
		Person p = new Person();
		p.addAsset(new BankAccount(1000));
		  StockHolding s = new StockHolding("IBM","Ron",131);
		  s.setNumShares(100);
		p.addAsset(s);
		  PersonalProperty pp = new PersonalProperty(100000);
		p.addAsset(pp);
		  for (int i=0; i < 10; ++i) pp.yearOlder(); //suppose it's 10 years
		System.out.println("Assets " + p.getAssets());
		System.out.println("Person is worth "+p.getWorth());
		pp.yearOlder();
		System.out.println("Person is (1yr later) worth " + p.getWorth());
	}
	
}
