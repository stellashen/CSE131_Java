package studio8;

import java.util.HashSet;
import java.util.Set;

public class Calendar {
	
	final private Set<Appointment> collectionAppointments;
	
	public Calendar() {
		this.collectionAppointments = new HashSet<Appointment>();
	}
	
	public void addAppointment(Appointment a){
		collectionAppointments.add(a);
	}
	
	public Set<Appointment> getAppointments(){
		return this.collectionAppointments;
	}
	
	public void cancelAppointment(Appointment a){
		collectionAppointments.remove(a);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collectionAppointments == null) ? 0 : collectionAppointments.hashCode());
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
		Calendar other = (Calendar) obj;
		if (collectionAppointments == null) {
			if (other.collectionAppointments != null)
				return false;
		} else if (!collectionAppointments.equals(other.collectionAppointments))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calendar [collectionAppointments=" + collectionAppointments + "]";
	}

	public static void main(String[] args) {
		Calendar c1 = new Calendar();
		
		// add new appointments
		Appointment a1 = new Appointment(new Date(1,1,2010,true), new Time(10,20,true));
		Appointment a2 = new Appointment(new Date(1,1,2010,true), new Time(10,20,true));
		Appointment a3 = new Appointment(new Date(1,2,2010,false), new Time(10,30,false));
		c1.addAppointment(a1);
		c1.addAppointment(a2);
		c1.addAppointment(a3);
		System.out.println(c1);
		
		// cancel one appointment
		c1.cancelAppointment(a3);
		System.out.println(c1);
		

	}

}
