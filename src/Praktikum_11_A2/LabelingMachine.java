package Praktikum_11_A2;

public class LabelingMachine implements Runnable {

	private int delay;
	private Converyor conveyor;
	
	public LabelingMachine(Converyor converyor, int delay) {
		this.conveyor = converyor;
		this.delay = delay;
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
			synchronized (conveyor) {
				while(this.conveyor.isEmpty()) {
					System.out.println("Etikettiermaschine: Warten, da Foerderband leer.");
					this.conveyor.wait();
				}
				Bottle toTakeBottle = this.conveyor.withdraw();
				Lable lable = new Lable("RedBull", 2023);
				toTakeBottle.setLable(lable);
				System.out.print("Etikettiermaschine: ");
				toTakeBottle.printLable();
				this.conveyor.notifyAll();
				Thread.sleep(delay);
			}
			} catch (InterruptedException exp) {
				Thread.currentThread().interrupt();
			}
			
		}
		
	}
		
}
