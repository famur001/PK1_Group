package Vorlesungsaufgaben;

import java.util.Comparator;

public class NamenVergleich implements Comparator<Angestellter> {

	@Override
	public int compare(Angestellter o1, Angestellter o2) {
		return o1.name.compareTo(o2.name);
	}
	
}