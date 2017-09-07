package customs;

import java.util.HashSet;

public class Demo {

	public static void main(String[] args) {
		
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("Slavi");
		list.add("Dimi");
		
		MyHashSet<Cucumber> set = new MyHashSet<>();
		System.out.println(set.size());
		Cucumber c1 = new Cucumber("Kisi");
		Cucumber c2 = new Cucumber("Kisi");
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		System.out.println(c1.equals(c2));
		set.add(c1);
		System.out.println(set.size());
		set.add(c2);
		System.out.println(set.size());
	}
}
