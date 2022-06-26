package pk1.mv.datehaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import pk1.mv.fachlogik.Medium;

public class Dao implements IDao {

	private String pfad = "C:\\Users\\fathi\\OneDrive\\Desktop\\medienliste.ser";
	private File file = new File(pfad);
	
	@Override
	public void speichern(List<Medium> liste) throws PersistenzException {
		try ( FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			oos.writeObject(liste);
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}
	}

	@Override
	public List<Medium> laden() throws PersistenzException {
		List<Medium> liste = null;
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			liste = (ArrayList<Medium>) ois.readObject();
			Medium.idZaehler = liste.size();
			
		} catch(IOException exp) {
			exp.printStackTrace();
		}  catch(ClassNotFoundException exp) {
			exp.printStackTrace();
		}
		return liste;
	}

	
	
}
