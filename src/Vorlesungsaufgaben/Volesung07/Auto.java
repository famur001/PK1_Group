package Vorlesungsaufgaben.Volesung07;

// Aeussere Klasse
public class Auto {

	private int ps = 0;
	Motor m = new Motor();
	
	public void getMotor() {
		m.power();
	}
	
	// innere Klasse
	public class Motor {
		private int ps; // Ueberdecken von Attributen der Auesseren Klasse
		public void power() {
			this.ps = 220;
			Auto.this.ps = 200;
			System.out.println(Auto.this.ps);
		}
	}
	
}
