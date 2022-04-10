package Praktikum_01;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Medium {

	private int id;
	private static int idZaehler = 0;
	private String titel;
	private int jahr;
	
	public Medium(String titel, int jahr) {
		id = idZaehler++;
		this.titel = titel;
		this.jahr = jahr;
	}
	
	public int alter() {
		LocalDate currentTime = LocalDate.now();
		return currentTime.getYear() - this.jahr;
	}
	public abstract void druckeDaten();

	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash( titel, jahr );
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
		Medium other = (Medium) o;
		if( other.getTitel().equals(this.getTitel())
				&& other.getJahr() == this.getJahr() ) {
			return true;
		}
		return false;
	}
	
}
