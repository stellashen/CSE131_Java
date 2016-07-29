package studio8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import exercises8.Point;

public class Date {

	private final int month, day, year;
	private final boolean holiday;

	public Date(int month, int day, int year, boolean holiday) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return "Date [month=" + month + ", day=" + day + ", year=" + year + ", holiday=" + holiday + "]";
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

	public static void main(String[] args) {
		System.out.println(new Date(6,1,2011,true));
		Date d1 = new Date(1,1,2010,true);
		Date d2 = new Date(1,1,2010,true);
		Date d3 = new Date(1,5,2010,false);
		Date d4 = new Date(1,4,2010,false);
		Date d5 = new Date(1,2,2010,false);
		System.out.println(d1.equals(d2));

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
		
		
		
	}
	




}
