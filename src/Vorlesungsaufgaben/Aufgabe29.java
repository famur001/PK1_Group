package Vorlesungsaufgaben;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Aufgabe29 {

	public static void main(String[] args) {

		Angestellter angestellter = new Angestellter("Ahmad", 5000);
		File file = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file2.txt");
		
		schreiben(angestellter, file);
	}

	public static void schreiben(Angestellter a, File f) {
		try ( FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw) ) {
			
			pw.print("Name: " + a.name + "\nGehalt: " + a.gehalt);
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
}
