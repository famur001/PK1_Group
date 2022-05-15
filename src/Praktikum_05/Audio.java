package Praktikum_05;

import java.io.OutputStream;
import java.io.PrintWriter;
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
	public void druckeDaten(OutputStream stream) {
		PrintWriter pw = new PrintWriter(stream);
		pw.printf("Id = %d \"%s\" von %s aus %d Spieldauer %d sek.", super.getId(),  super.getTitel(), this.interpret,  super.getJahr(), this.dauer);
		pw.flush();
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
