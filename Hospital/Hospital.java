package hospital;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Hospital extends Thread {

	private static final String[] DIAGNOSES = {"Grip", "Broken heart", "Broken skull"};
	
	private HashMap<String, Department> deps;
	private HashSet<Nurse> nurses = new HashSet<>();
	
	public Department getDep(String diagnose){
		return deps.get(diagnose);
	}
	
	public static String getRandomDiagnose(){
		return DIAGNOSES[new Random().nextInt(DIAGNOSES.length)];
	}
	private HashMap<Doctor, HashSet<Patient>> docs;

	public Hospital() {
		docs = new HashMap<Doctor, HashSet<Patient>>();
		deps = new HashMap<>();
		deps.put(DIAGNOSES[0], new Department("Virusology"));
		deps.put(DIAGNOSES[1], new Department("Cardiology"));
		deps.put(DIAGNOSES[2], new Department("Ortopedy"));
		Patient.h = this;
		Doctor.h = this;
		docs.put(new Doctor("Dr", "Radeva", "969056", "Piene"), new HashSet());
		docs.put(new Doctor("Dr", "Dodeva", "356456", "Qdene"), new HashSet());
		docs.put(new Doctor("Dr", "Modeva", "234234", "Spane"), new HashSet());
		for(Doctor d : docs.keySet()){
			new Thread(d).start();
		}
		nurses.add(new Nurse("G-ca", "Georgieva", "234234", 3, deps.get(DIAGNOSES[0])));
		nurses.add(new Nurse("G-ca", "Buhleva", "2342234", 1, deps.get(DIAGNOSES[1])));
		nurses.add(new Nurse("G-ca", "Tuhleva", "234234", 6, deps.get(DIAGNOSES[2])));
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			beginDay();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("ops");
			}//24 hours
		}
	}

	private void beginDay() {
		for(Doctor d : docs.keySet()){
			d.dayStarted = true;
			System.out.println(d + " day started!!!");
			synchronized (Doctor.cloningLock) {
				for(Iterator<Patient> it = docs.get(d).iterator(); it.hasNext();){
					Patient p = it.next();
					if(p.getDaysLeft() == 0){
						it.remove();
						p.clearRoom();
						System.out.println(p + " ot pol " + p.getGender() + " s diagnoza " + p.getPlan().getDiagnose() + " beshe izpisan");
					}
					else{
						p.setDaysLeft(p.getDaysLeft()-1);
					}
				}
			}
		}
		for(Nurse n : nurses){
			n.giveMeds();
		}
	}
	
	public Map<Doctor, HashSet<Patient>> getDocs() {
		return Collections.unmodifiableMap(docs);
	}

	public synchronized void acceptPatient(Patient patient) {
		Doctor doc = null;
		while((doc = getFreeDoc()) == null){
			try {
				wait();
				//on notifyAll this thread starts from here
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		doc.makePlan(patient);
		String diagnose = patient.getPlan().getDiagnose();
		String gender = patient.getGender();
		Room room = getRoom(diagnose, gender);
		if(room != null){
			System.out.println(patient + " ot pol " + patient.getGender() + " e priet s diagnoza " + diagnose+". Lekuvash lekar: " + patient.getDoc());
			room.addPatient(patient);
			synchronized (Doctor.cloningLock) {
				docs.get(doc).add(patient);
			}
		}
	}
	
	private Room getRoom(String diagnose, String gender) {
		for(Room r : deps.get(diagnose).getRooms()){
			if(r.isEmpty() || r.getGender().equals(gender)){
				return r;
			}
		}
		return null;
	}

	private Doctor getFreeDoc(){
		Doctor freeDoc = null;
		for(Doctor d : docs.keySet()){
			if(!d.isBusy()){
				freeDoc  = d;
				break;
			}
		}
		return freeDoc;
	}
}
