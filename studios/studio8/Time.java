package studio8;

public class Time implements Working{

	private final int hour, min;
	private final boolean fmt;

	// hour: 0-23; min: 0-59
	public Time(int hour, int min, boolean fmt) {
		this.hour = hour;
		this.min = min;
		this.fmt = fmt;
	}

	@Override
	public String toString() {
		// true: 24hr; false:12hr

		if (fmt==true){
			return hour + ":" + min + " (24hr format)";
		}
		else {
			if (hour < 12){
				return hour + ":" + min + "am (12hr format)";
			}
			else{
				return (hour-12) + ":" + min + "pm (12hr format)";
			}
		}
	}

	@Override
	public boolean amWorking() {
		if (this.hour>=9 && this.hour<17) return true;
		else if (this.hour==17&&this.min==0) return true;
		else return false;
	}

	// equality is based on hour and min, not fmt	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + min;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	public boolean isEarlierThan(Time other){
		if (this.hour < other.hour){
			return true;
		}
		else if (this.hour == other.hour){
			if (this.min < other.min){
				return true;
			}
			else return false;
		}
		else return false;

	}

	public static void main(String[] args) {
		System.out.println(new Time(23,20,false));
		Time t1 = new Time(10,20,true);
		Time t2 = new Time(10,20,true);
		Time t3 = new Time(10,20,false);
		System.out.println("Are " + t1 + " and " + t3 + " the same time (assuming on the same date)? " + t1.equals(t3));
		System.out.println("Is " + t1 + " an ealier time than " + t2 + "? " + t1.isEarlierThan(t2));
		System.out.println("Is " + t1 + " working time? " + t1.amWorking());	
	}
}
