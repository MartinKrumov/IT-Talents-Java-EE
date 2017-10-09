package test4e;

import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.KeyStore.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import test4e.Baraka.Vegetable;

public class Pisar extends Person{

	private static final String DB_IP = "192.168.8.22";
	private static final String DB_PORT = "3306";
	private static final String DB_DBNAME = "hr";
	private static final String DB_USER = "ittstudent";
	private static final String DB_PASS = "ittstudent-123";
	
	private ArrayList<Moma> momi;
	private ArrayList<Momuk> momci;
	private ArrayList<Baba> babi;
	private Baraka b;
	
	public Pisar(String name, ArrayList<Moma> momi, ArrayList<Momuk> momci, ArrayList<Baba> babi, Baraka b) {
		super(name, 40);
		
		this.momi = momi;
		this.momci = momci;
		this.babi = babi;
		this.b = b;
	}
	
	public void insertLutenica(String date, int quantity, String babaName)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found or failed to load. Check your libraries");
		}
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
			connection.setAutoCommit(false);
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO lutenica (​​date,​​ quantity, ​​baba_name) VALUES (?, ?, ?)");
			stmt.setString(1, date);
			stmt.setInt(2, quantity);
			stmt.setString(3, babaName);
			stmt.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Connection failed to open. Reason: " + e.getMessage());
		}
	}

	public void updateNabrano(String momaName, Vegetable v, int quantity) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found or failed to load. Check your libraries");
		}
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_DBNAME, DB_USER, DB_PASS);
				Statement stmt = connection.createStatement();) {

			ResultSet result = stmt.executeQuery("SELECT moma_name, ​​veggie_name, quantity FROM nabrano WHERE moma_name =" + momaName+" AND veggie_name ="+ v.toString() +";");
			String name = null;
			String veggie_name = null;
			int res = 0;
			while (result.next()) {
				name = result.getString("moma_name");
				veggie_name = result.getString("veggie_name");
				res = result.getInt("quantity");
			}
			
			if (name != null && veggie_name != null) {

				Statement stmt1 = connection.createStatement();
				stmt1.executeUpdate("UPDATE nabrano SET quantity ="+ res+" WHERE moma_name ="+ momaName+" AND veggie_name ="+ v +";");
			} else {
				PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO nabrano (​​moma_name,​​ quantity, ​​veggie_name) VALUES (?, ?, ?)");
				stmt2.setString(1, momaName);
				stmt2.setInt(2, quantity);
				stmt2.setString(3, v.toString());
				stmt2.executeUpdate();
				connection.commit();
			}
			
		} catch (SQLException e) {
			System.out.println("Connection failed to open. Reason: " + e.getMessage());
		}
	}
	
	public void pishiFaila(String name, int obraboteno) {
		System.err.println("============================================================");
		File f = new File("lutenica.txt");
		Scanner sc = null;
		try {
			 sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("opala");
		}
		
		HashMap<String, Integer> map = new HashMap<>();
		
		while(sc.hasNextLine()){
			String momuk = sc.next();
			int res = sc.nextInt();
			
			if (map.containsKey(momuk)) {
				map.put(momuk, map.get(momuk) + obraboteno);
			} else {
				map.put(name, 1);
			}
		}
		
		sc.close();
		
		try (PrintStream ps = new PrintStream(f)){
			for (java.util.Map.Entry<String, Integer> m : map.entrySet()) {
				ps.println(m.getKey() + " " + m.getValue());
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("opala");
		}
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			System.out.println("OPSA");
		}
		
		naiDobrataMoma();
		naiDobraqtMomuk();
		partaidiSpisuk();
		naiNabranZelenchuk();
		naiDoobrataBaba();
		srednaVuzrast();
	}

	private void partaidiSpisuk() {
		ArrayList<Partida> p = new ArrayList<>();
		for (Baba b : babi) {
			p.addAll(b.getKashon());
		}
		
		int res = 0;
		for (Partida partida : p) {
			res += partida.getQuantity();
		}
		System.out.println(p.get(0).getDate() + " - Partidi: " + p.size() + " kg: " + res);
	}

	private void naiNabranZelenchuk() {
		//select veggie_name m, sum(select quantity from nabrano where veggie_name = m) s   form nabrano
		System.out.println("Nai braniqt zelenchuk e: " + b.getNaiNabrano());
	}

	private void srednaVuzrast() {
		ArrayList<Person> p = new ArrayList<>();
		p.addAll(momi);
		p.addAll(momci);
		p.addAll(babi);
		
		double calcAge = 0.0;
		
		for (Person person : p) {
			calcAge += person.getAge();
		}
		
		System.out.println("Average age = " + (calcAge / p.size()));
		
	}

	private void naiDoobrataBaba() {
		//select baba_name m, sum(select quantity from lutenica where moma_name = m) s   form lutenica
		TreeSet<Baba> b = new TreeSet<>((b1, b2)-> b2.getKoli4stvo() - b1.getKoli4stvo());
		b.addAll(babi);
		
		System.out.println(b.first());
	}

	private void naiDobrataMoma() {
		//select moma_name m, sum(select quantity from nabrano where moma_name = m) s   form nabrano
		TreeSet<Moma> m = new TreeSet<>((m1, m2)-> m2.getNabrano() - m1.getNabrano());
		m.addAll(momi);
		
		System.out.println(m.first());
	}

	private void naiDobraqtMomuk() {
		
		File f = new File("lutenica.txt");
		Scanner sc = null;
		try {
			 sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("opala");
		}
		
		HashMap<String, Integer> map = new HashMap<>();
		
		while(sc.hasNextLine()){
			String momuk = sc.next();
			int res = sc.nextInt();
			
			if (map.containsKey(momuk)) {
				map.put(momuk, map.get(momuk) + res);
			} else {
				map.put(momuk, 1);
			}
		}
		
		sc.close();
		
		ArrayList<java.util.Map.Entry<String, Integer>> list = new ArrayList<>();
		
		list.addAll(map.entrySet());
		
		Collections.sort(list, (e1, e2)-> e2.getValue() - e1.getValue());
		
		try(PrintStream ps = new PrintStream(new File("most_common_word.txt"))){
			ps.println(list.get(0).getKey() + " " + list.get(0).getValue());
		} catch (FileNotFoundException e){
			System.out.println("opala");
		}
		
	}
	
}
