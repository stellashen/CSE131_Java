package studio8;

public class Time {
	
	private final int hour, min;
	private final boolean fmt;
	
	public Time(int hour, int min, boolean fmt) {
		this.hour = hour;
		this.min = min;
		this.fmt = fmt;
	}

	@Override
	public String toString() {
		// true: 24hr; false:12hr
	
		if (fmt==true){
		return "Time [hour=" + hour + ", min=" + min + " (24hr format)]";
	}
		else {
			if (hour < 12){
				return "Time [hour=" + hour + "am, min=" + min + " (12hr format)]";
			}
			else{
				return "Time [hour=" + (hour-12) + "pm, min=" + min + " (12hr format)]";
			}
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (fmt ? 1231 : 1237);
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
		if (fmt != other.fmt)
			return false;
		if (hour != other.hour)
			return false;
		if (min != other.min)
			return false;
		return true;
	}
	
	public boolean isEarlierThan(Time other){
		if (this.fmt == other.fmt){
			if (this.hour<other.hour){
				return true;
			}
			else{
				if (this.hour==other.hour && this.min<other.min){
					return true;
				}
				else {
					return false;
				}
			}
		}
		
		else {
			if (this.fmt == true){
				
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.println(new Time(23,20,false));
		Time t1 = new Time(1,2,true);
		Time t2 = new Time(1,2,true);
		System.out.println(t1.equals(t2));
	}
}
