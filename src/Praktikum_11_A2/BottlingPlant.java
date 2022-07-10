package Praktikum_11_A2;

public class BottlingPlant implements Runnable {

	private int delay;
	private Converyor conveyor;
	
	public BottlingPlant(Converyor converyor, int delay) {
		this.conveyor = converyor;
		this.delay = delay;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				synchronized(conveyor) {
					while(this.conveyor.isOverloaded()) {
						System.out.println("Abfuellanlage: Warte, Foederband ist voll");
						this.conveyor.wait();
					}
					Bottle b = new Bottle(); // bottle wurde gefuellt
					this.conveyor.load(b);
					this.conveyor.notifyAll();
					System.out.println("Abfuellanlage: Neue Flasche abgefuellt");
					Thread.sleep(delay);
				}
			} catch(InterruptedException exp) {
				Thread.currentThread().interrupt();
			}
			
		}
		
	}
	
}
