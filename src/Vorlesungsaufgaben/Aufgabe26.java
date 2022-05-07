package Vorlesungsaufgaben;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Aufgabe26 {

	public static void main(String[] args) {
	
		File file = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file1.txt");
		cat(file);
		
	}
	
	public static void cat(File quelle) {
		try (RandomAccessFile raf = new RandomAccessFile(quelle, "r")) {
			/*for (int i = 0; i < raf.length(); i++) {
				System.out.print((char)raf.read());
			}*/
			
			int zeichen;
			while( (zeichen = raf.read()) != -1 ) {
				System.out.print((char)zeichen);
			}
		} catch(IOException exp) {
			exp.printStackTrace();
		}
	}
	
}
