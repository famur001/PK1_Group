package Praktikum_02_Gerenics;

public class App {

	public static void main(String[] args) {
		
		Medienverwaltung mv = new Medienverwaltung();
		
		Audio audio1 = new Audio("It Means Nothing", 2007, "Steroephonics", 229);
		Bild bild1 = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		
		mv.aufnehmen(audio1);
		mv.aufnehmen(bild1);
		
		mv.zeigeMedien();
		System.out.println(mv.berechneErscheinungsjahr());
		
		mv.sucheNeuesMedium();
		
		
	}

}
