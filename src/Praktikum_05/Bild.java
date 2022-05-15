package Praktikum_05;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Bild extends Medium {

	private String ort;
	
	public Bild( String titel, int jahr, String ort ) {
		super(titel, jahr);
		this.ort = ort;
	}

	@Override
	public void druckeDaten(OutputStream stream) {
		PrintWriter pw = new PrintWriter(stream);
		pw.printf( "ID = %d \"%s\" aufgenommen im Jahr %d in %s", super.getId(), super.getTitel(), super.getJahr(),this.ort );
		pw.flush();
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
