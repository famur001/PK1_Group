package Praktikum_02_Array;

import java.util.Objects;

public class Bild extends Medium {

	private String ort;
	
	public Bild( String titel, int jahr, String ort ) {
		super(titel, jahr);
		this.ort = ort;
	}

	@Override
	public void druckeDaten() {
		System.out.println( "ID = " + super.getId() + " \"" + super.getTitel() + "\" aufgenommen im Jahr " + super.getJahr() + " in " + this.ort );
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Override
	public int hashCode() {
		return Objects.hash( super.hashCode(), ort );
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
		Bild other = (Bild) o;
		if( super.equals(other)
			&& other.getOrt().equals(this.getOrt()) ) {
			return true;
		}
		return false;
	}
	
}
