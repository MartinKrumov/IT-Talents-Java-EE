package rakia;

public class Demo {
	public static void main(String[] args) {
		try {
			for (int berach=1; berach <= 10; berach++) {
				new Thread(new Berach("Kiro Gela " + berach, berach*19)).start();
			}
			
			for (int berach=1; berach <= 10; berach++) {
				new Thread(new Rakidjiq("Hasan Taxito " + berach, berach*19)).start();
			}
			
			new Statistician().start();
		}	
		catch (Exception e) {}
	}
}
