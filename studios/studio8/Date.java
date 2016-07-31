package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Date implements Working {

	private final int month, day, year;
	private final boolean holiday;

	public Date(int month, int day, int year, boolean holiday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.holiday = holiday;
	}
	
	@Override
	public boolean amWorking() {
		if (this.day%2==0) return true;
		else return false;
	}

	@Override
	public String toString() {
		//return "Date [month=" + month + ", day=" + day + ", year=" + year + ", holiday=" + holiday + "]";
	if (holiday == true) return month+"/"+day+"/"+year+"(holiday)";
	else return month+"/"+day+"/"+year+"(not holiday)";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + (holiday ? 1231 : 1237);
		result = prime * result + month;
		result = prime * result + year;
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
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (holiday != other.holiday)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public boolean isEarlierThan(Date other){
		if (this.month < other.month){
			return true;
		}
		else if (this.month == other.month){
			if (this.day < other.day){
				return true;
			}
			else return false;
		}
		else return false;

	}

	public static void main(String[] args) {
		System.out.println(new Date(6,1,2011,true));
		Date d1 = new Date(1,1,2010,true);
		Date d2 = new Date(1,1,2010,true);
		System.out.println("Are " + d1 + " and " + d2 + " the same date? " + d1.equals(d2));

		List<Date> list = new LinkedList<Date>();
		list.add(d1);
		list.add(d2);
		list.add(d1);
		System.out.println(list);
		//the same date appear three times in the list

		HashSet<Date> set = new HashSet<Date>();
		set.add(d1);
		set.add(d2);
		set.add(d1);
		System.out.println(set);
		//the same date appear only once
		// difference: list allows duplicates while set doesn't 
		
		System.out.println("Is " + d1 + " an ealier date than " + d2 + "? " +d1.isEarlierThan(d2));
		System.out.println("Is " + d1 + " working day? " + d1.amWorking());	
	}

}
