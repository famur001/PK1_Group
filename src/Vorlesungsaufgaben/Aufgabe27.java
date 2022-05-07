package Vorlesungsaufgaben;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class Aufgabe27 {

	public static void main(String[] args) {

		File file1 = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file1.txt");
		File file2 = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file2.txt");
		
		copy(file1, file2);
		System.out.println("Datein wurden kopiert.");
		
	}
	
	public static void copy(File form, File to) {
		try (FileInputStream input = new FileInputStream(form);
				FileOutputStream output = new FileOutputStream(to);
				
				BufferedInputStream bis = new BufferedInputStream(input);
				BufferedOutputStream bos = new BufferedOutputStream(output)) {
			
			int zeichen;
			while( (zeichen = bis.read()) != -1 ) {
				bos.write(zeichen);
			}
			
		} catch (IOException exp) {
			System.out.println("File not founded");
		}
	}

}
