package Praktikum_03;

import java.util.Objects;

public class Audio extends Medium {

	private String interpret;
	private int dauer;
	
	public Audio(String titel, int jahr, String interpret, int dauer ) {
		super(titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	@Override
	public void druckeDaten() {
		System.out.println( "ID = " + super.getId() + " \"" + super.getTitel() + "\" von " + this.interpret + " aus " + super.getJahr() + " Spieldauer: " + this.dauer + " sek." );
	}

	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	@Override
	public int hashCode() {
		return Objects.hash( super.hashCode(), interpret, dauer );
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null) {
			return false;
		}
		if(o.getClass() != this.getClass()) {
			return false;
		}
		Audio other = (Audio) o;
		if( super.equals(other) && other.getInterpret().equals(this.getInterpret())
			&& other.getDauer() == this.getDauer() ) {
			return true;
		}
		return false;
	}
	
}
