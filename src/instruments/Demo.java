package instruments;

public class Demo {

	public static void main(String[] args) {
		
		Shop s = new Shop("Talanti music stuff");
		s.sell("Fender", 2);
		s.sell("Fender", 20);
		s.sell("Fender", 2);
		s.sell("Orfei", 20);
		System.out.println(s.getMoney());
	}
}
