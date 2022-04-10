package Praktikum_01;

import java.util.Objects;

public class Angestellter {

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
	
}
