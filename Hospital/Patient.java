package hospital;

import java.util.ArrayList;
import java.util.Random;

public class Patient extends Person implements Runnable {
	
	public static final ArrayList<String> GENDERS;
	public static Hospital h;
	private Room room;
	private Doctor doc;
	
	static{
		GENDERS = new ArrayList<>();
		GENDERS.add("Male");
		GENDERS.add("Female");
		GENDERS.add("Shemale");
		GENDERS.add("Transexual");
		GENDERS.add("Hermafrodit");
	}
	
	private int age;
	private Plan plan;
	private int daysLeft;
	private String gender;

	public Patient(String firstName, String lastName, String phone, int age, String gender) {
		super(firstName, lastName, phone);
		if(age > 0){
			this.age = age;
		}
		if(GENDERS.contains(gender)){
			this.gender = gender;
		}
	}
	
	public void setPlan(Plan plan) {
		this.plan = plan;
		this.daysLeft = new Random().nextInt(3) + 3;
	}

	@Override
	public void run() {
		h.acceptPatient(this);
	}

	public String getGender() {
		return gender;
	}

	public Plan getPlan() {
		return plan;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}

	public int getDaysLeft() {
		return daysLeft;
	}
	
	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public void clearRoom() {
		this.room.removePatient(this);
	}

	public void receiveMeds(Nurse n) {
		for(String med : plan.getMedsForTreatment()){
			System.out.println("Sestra " + n + "dade na pacient " + this + " v staq " + room.hashCode() + " ot otdelenie " + n.getDep().getName() + " lekarstvo " + med);
		}
	}

	public void setDoctor(Doctor doctor) {
		this.doc = doctor;
	}
	
	public Doctor getDoc() {
		return doc;
	}
	
	public Room getRoom() {
		return room;
	}
	
	@Override
	public String toString() {
		return super.toString() + " and days left " + daysLeft;
	}
}
