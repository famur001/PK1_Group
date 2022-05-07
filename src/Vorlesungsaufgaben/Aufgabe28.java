package Vorlesungsaufgaben;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Aufgabe28 {

	public static void main(String[] args) {

		// Ausgabe auf der Konsole
		try {
			sayHallo(System.out);
		} catch(IOException exp) {
			
		}
		
		// In Datei speichern
		try {
			File file1 = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file2.txt");
			FileOutputStream fos = new FileOutputStream(file1);
			sayHallo(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void sayHallo(OutputStream out) throws IOException {
		String t = "Hello World";
		OutputStreamWriter sw = new OutputStreamWriter(out);
		
		sw.write(t.toCharArray());
		sw.flush();
	}

}
