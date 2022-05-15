package Vorlesungsaufgaben.Aufgabe30;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Aufgabe30 {

	public static void main(String[] args) {
		
		String zeichen = "Hello World!";
		File file = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\pk\\txt.txt");
		
		UpperCaseWriter.wandleZuGroßbuchstaben(zeichen, file);
		
	}

}
