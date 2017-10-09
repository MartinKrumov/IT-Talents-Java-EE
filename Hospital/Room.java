package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {

	private String gender;
	private static final int MAX_SPOTS = 3;
	private ArrayList<Patient> occupants = new ArrayList<>();
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isEmpty(){
		return occupants.size() == 0;
	}
	
	public void addPatient(Patient p){
		if(occupants.size() < MAX_SPOTS){
			if(isEmpty()){
				setGender(p.getGender());
			}
			if(this.gender.equals(p.getGender())){
				occupants.add(p);
				p.setRoom(this);
			}
		}
	}
	
	public String getGender() {
		return gender;
	}
	
	public void removePatient(Patient p){
		occupants.remove(p);
		if(isEmpty()){
			gender = null;
		}
	}
	
	public List<Patient> getOccupants() {
		return Collections.unmodifiableList(occupants);
	}
}
