package vinetki;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo {

	public static void main(String[] args) {
		
		new Vinetka(VinetkaType.MONTHLY_TRUCK);
		TreeSet<Vinetka> set = new TreeSet<>(new Comparator<Vinetka>() {
		
			@Override
			public int compare(Vinetka o1, Vinetka o2) {
				return o1.getVinetkaType().stickyTime() - o2.getVinetkaType().stickyTime();
			}
		
		});
	}
}
