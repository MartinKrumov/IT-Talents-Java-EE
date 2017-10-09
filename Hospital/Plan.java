package hospital;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Plan {
	
	private static final String[] MEDS = {"Aspirin", "Analgin", "Paracetamol", "Vitamin C"};
	public static String getRandomMeds(){
		return MEDS[new Random().nextInt(MEDS.length)];
	}

	private String diagnose;
	private ArrayList<String> medsArray;
	public Plan(String diagnose, String... meds) {
		this.diagnose = diagnose;
		medsArray = new ArrayList<>();
		for(String s : meds){
			medsArray.add(s);
		}
	}
	
	public String getDiagnose() {
		return diagnose;
	}
	public List<String> getMedsForTreatment() {
		return Collections.unmodifiableList(medsArray);
	}
}
