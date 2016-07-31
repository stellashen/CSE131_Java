package exercises8;

public class PersonalProperty implements Valuable {
	
	private final int initialValue;
	private int yearsOld;

	public PersonalProperty(int initialValue) {
		this.initialValue = initialValue;
	}
	
	public int depreciatedValue(){
		// according to a formula
		return (int)(this.initialValue*Math.pow(0.80, yearsOld));
	}
	
	public void yearOlder(){
		this.yearsOld = this.yearsOld + 1;
	}
	
	public String toString(){
		return "Initial value: " + this.initialValue + " current value: " + this.depreciatedValue();
	}

	@Override
	public int getLiquidValue() {
		return this.depreciatedValue();
	}
	
}
