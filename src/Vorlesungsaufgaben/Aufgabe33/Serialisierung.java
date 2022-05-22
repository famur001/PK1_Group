package Vorlesungsaufgaben.Aufgabe33;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialisierung {

	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\Neuer Ordner\\ser.txt");
		
		Konto konto = new Konto(5000);
		Kunde kunde = new Kunde("Ahmad", konto);
		
		serialiserung(kunde, f);
		
		deserialisierung(f);
		
	}
	
	public static void serialiserung(Kunde k, File f) {
		
		try ( FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(k);
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}
		
	}
	
	public static void deserialisierung(File f) {
		Kunde k = null;
		try (FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			k = (Kunde) ois.readObject();
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}  catch(ClassNotFoundException exp) {
			exp.printStackTrace();
		}
		
		k.druckeDaten();
		
	}
	
}
