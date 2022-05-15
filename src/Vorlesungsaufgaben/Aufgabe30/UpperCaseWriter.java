package Vorlesungsaufgaben.Aufgabe30;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UpperCaseWriter {

	public static void wandleZuGroßbuchstaben(String zeichen, File file) {
		try (FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw)) {
			
			char[] chars = zeichen.toCharArray();
			for(int i = 0; i < chars.length; i++)
				pw.print(Character.toUpperCase(chars[i]));
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
}
