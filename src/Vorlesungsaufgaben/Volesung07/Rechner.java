package Vorlesungsaufgaben.Volesung07;

public class Rechner {

	public void getBerechnung(Berechnung b) {
		for( int i = 0; i <= 10; i++ ) {
			System.out.println( i + b.berechne(i) );
		}
	}
	
	public static void main(String[] args) {
		
		Rechner rechner = new Rechner();
		rechner.getBerechnung( new Berechnung() {
			public double berechne(double x) {
				return x*x;
			}
		});
		
	}
	
}
