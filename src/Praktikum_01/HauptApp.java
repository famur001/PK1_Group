package Praktikum_01;

public class HauptApp {

	public static void main(String[] args) {
		
		Audio audio1 = new Audio("It Means Nothing", 2007, "Steroephonics", 229);
		Bild bild1 = new Bild("Gebaeude FB Informatik", 2019, "Dortmund");
		Audio audio2 = new Audio("It Means Nothing", 2007, "Steroephonics", 229);
		Audio audio3 = new Audio("It Means", 2007, "Steroephonics", 229);

		audio1.druckeDaten();
		bild1.druckeDaten();
		System.out.println( audio1.alter() );
		
		if( audio1.equals(audio2) ) {
			System.out.println("Die Objekte mit ID " + audio1.getId() + " und ID " + audio2.getId() + " sind (fachlich) gleich" );
			if(audio1.hashCode() == audio2.hashCode()) {
				System.out.println("Die gleichen Objekte haben den Hashcode " + audio1.hashCode());
			}
		}
		
		if( !audio1.equals(audio3) ) {
			System.out.println("Die Objekte mit ID " + audio1.getId() + " und ID " + audio2.getId() + " sind nicht gleich" );
			if( audio1.hashCode() != audio3.hashCode() ) {
				System.out.println("Die unterschiedlichen Objekte haben die Hashcodes " + audio1.hashCode() + " und " + audio3.hashCode());
			}
		}
		
	}

}
