package studio8;

import java.util.LinkedList;
import java.util.List;

public class CountWorking {
	
	final private List<Working> dateTime;

	public CountWorking() {
		this.dateTime = new LinkedList<Working>();
	}
	
	public void addAppointment(Appointment a) {
		dateTime.add(a);
	}
	
	public List<Working> getDateTime() {
		return this.dateTime;
	}
	
	public int count(){
		int sum = 0;
		for (Working w : dateTime){
			if (w.amWorking() == true){
				sum = sum + 1;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		CountWorking dt1 = new CountWorking();
		
		// appointments
		Date d1 = new Date(1,1,2010,true);
		Time t1 = new Time(10,20,true);
		Appointment a1 = new Appointment(d1,t1);
		Date d2 = new Date(1,2,2010,true);
		Time t2 = new Time(12,20,true);
		Appointment a2 = new Appointment(d2,t2);
		Date d3 = new Date(1,2,2010,true);
		Time t3 = new Time(12,20,true);
		Appointment a3 = new Appointment(d3,t3);
		Date d4 = new Date(1,4,2010,true);
		Time t4 = new Time(13,20,true);
		Appointment a4 = new Appointment(d4,t4);
		
		dt1.addAppointment(a1);
		dt1.addAppointment(a2);
		dt1.addAppointment(a3);
		dt1.addAppointment(a4);
		System.out.println("Among the appointments, how many are during working date and time? " + dt1.count());
	}

}
