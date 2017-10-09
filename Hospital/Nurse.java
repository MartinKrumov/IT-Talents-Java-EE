package hospital;

public class Nurse extends Person {

	private int exp;
	private Department dep;
	
	public Nurse(String firstName, String lastName, String phone, int exp, Department dep) {
		super(firstName, lastName, phone);
		this.exp = exp;
		this.dep = dep;
	}

	public Department getDep() {
		return dep;
	}
	
	public void giveMeds(){
		for(Room r : dep.getRooms()){
			for(Patient p : r.getOccupants()){
				p.receiveMeds(this);
			}
		}
	}
	
}
