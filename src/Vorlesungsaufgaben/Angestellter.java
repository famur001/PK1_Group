package Vorlesungsaufgaben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Angestellter implements Comparable<Angestellter> {

	public String name;
	public int gehalt;
	
	public Angestellter(String name, int gehalt) {
		this.name = name;
		this.gehalt = gehalt;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, gehalt);
	}
	
	@Override
	public boolean equals(Object o) {
		//.1
		if(o == this) {
			return true;
		}
		//.2
		if(o == null) {
			return false;
		}
		//.3
		if(o.getClass() == this.getClass()) {
			return true;
		}
		// .4
		Angestellter other = (Angestellter) o;
		// .5
		if( other.name.equals(this.name)
				&& other.gehalt == this.gehalt ) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name + ", " + gehalt;
	}

	@Override
	public int compareTo(Angestellter o) {
		
		// aufsteigend
		return Integer.compare(this.gehalt, o.gehalt);
		
		// absteigend
		//return Integer.compare(o.gehalt, this.gehalt);
		
		/*if( this.gehalt > o.gehalt ) {
			return 1;
		} else if( this.gehalt < o.gehalt ) {
			return -1;
		} else {
			return 0;
		}*/
	}
	
	public static void main(String[] args) {
		
		Angestellter a1 = new Angestellter("A", 5000);
		Angestellter a2 = new Angestellter("B", 10000);
		Angestellter a3 = new Angestellter("C", 7000);

		ArrayList<Angestellter> liste = new ArrayList<Angestellter>();
		liste.add(a1);
		liste.add(a2);
		liste.add(a3);
		
		Collections.sort(liste, new NamenVergleich());
		for( Angestellter a: liste ) {
			System.out.println(a);
		}
		
		
	}
	
}
