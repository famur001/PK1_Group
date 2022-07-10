package Praktikum_11_A1;

public class Zeitansage extends Application {

	public void start() {
		
		TimerListener tl = new TimerValue();
		int delay = 1000; // 1000ms = 1s
		
		Thread timer = new Thread(new Timer(tl, delay));
		
		
		
	}
	
}
