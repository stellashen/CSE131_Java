package studio8;

public class Appointment implements Working{

	private final Date d;
	private final Time t;

	public Appointment(Date d, Time t) {
		this.d = d;
		this.t = t;
	}

	public Date getD() {
		return d;
	}

	public Time getT() {
		return t;
	}
	
	@Override
	public boolean amWorking() {
		if (d.amWorking()==true && t.amWorking()==true ){
			return true;
		}
		else return false;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment date: " + d + " time: " + t;
	}

	public static void main(String[] args) {
		Date d1 = new Date(1,1,2010,true);
		Time t1 = new Time(10,20,true);
		Appointment a1 = new Appointment(d1,t1);
		System.out.println(a1);
	}

}
