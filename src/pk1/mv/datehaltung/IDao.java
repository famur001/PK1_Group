package pk1.mv.datehaltung;

import java.util.List;
import pk1.mv.fachlogik.Medium;

public interface IDao {

	void speichern(List<Medium> liste) throws PersistenzException;
	
	List<Medium> laden() throws PersistenzException;
	
}
