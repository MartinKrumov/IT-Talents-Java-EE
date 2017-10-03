package rakia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Statistician extends Thread {

	public Statistician() {
		setDaemon(true);
	}

	@Override
	public void run() {
		try (PrintWriter pw = new PrintWriter(new File("stats.txt"))) {
			pw.println("Nai-bran plod" + Selo.getInstance().naiBranPlod());
			pw.println("Nai-varena rakiq" + Selo.getInstance().naiBranPlod());
			pw.println(Selo.getInstance().naiBranPlod());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
