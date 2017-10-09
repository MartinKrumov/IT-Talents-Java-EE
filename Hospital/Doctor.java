package hospital;

import java.util.HashSet;

public class Doctor extends Person implements Runnable {

	public static Object cloningLock = new Object();
	
	private String spec;
	private boolean busy = false;
	public volatile boolean dayStarted = false;//because it`s modified by another thread
	public static Hospital h;
	
	
	public Doctor(String firstName, String lastName, String phone, String spec) {
		super(firstName, lastName, phone);
		this.spec = spec;
	}


	@Override
	public void run() {
		while(true){
			if(dayStarted){
				HashSet<Patient> cloning;
				synchronized (cloningLock) {
					cloning = (HashSet<Patient>) h.getDocs().get(this).clone();
				}
				for(Patient p : cloning){
					visit(p);
				}
				this.dayStarted = false;
			}
		}
	}
	
	public void makePlan(Patient p){
		Plan plan = new Plan(
				Hospital.getRandomDiagnose(), 
				Plan.getRandomMeds(), 
				Plan.getRandomMeds());
		p.setPlan(plan);
		p.setDoctor(this);
	}
	
	private void visit(Patient p){
		synchronized (h) {
			this.busy = true;
			String dep = h.getDep(p.getPlan().getDiagnose()).getName();
			System.out.println("Lekar " + this + " poseti pacient " + p + " v staq " + p.getRoom().hashCode() + "ot otdelenie " + dep);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
			this.busy = false;
			h.notifyAll();	
		}
	}
	
	public boolean isBusy(){
		return h.getDocs().get(this).size() == 5 || busy;
	}

}
