package Vorlesungsaufgaben;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.imageio.IIOException;

public class Aufgabe25 {

	public static void main(String[] args) {

		File file1 = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file1.txt");
		File file2 = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1\\file2.txt");
		
		copyNew(file1, file2);
		System.out.println("Datein wurden kopiert.");

	}

	public static void copy(File form, File to) throws IOException {
		RandomAccessFile input = null;
		RandomAccessFile output = null;
		try {
			input = new RandomAccessFile(form, "r");
			output = new RandomAccessFile(to, "rw");
			for (int i = 0; i < input.length(); i++) {
				output.write(input.read());
			}
		} catch (IOException exp) {
			System.out.println("File not founded");
		} finally {
			input.close();
			output.close();
		}
	}

	// Try-With-Resoucrce Anweisung
	public static void copyNew(File form, File to) {
		try (RandomAccessFile input = new RandomAccessFile(form, "r");
				RandomAccessFile output = new RandomAccessFile(to, "rw")) {

			for (int i = 0; i < input.length(); i++) {
				output.write(input.read());
			}
		} catch (IOException exp) {
			System.out.println("File not founded");
		}
	}

}
