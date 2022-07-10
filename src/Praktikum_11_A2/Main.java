package Praktikum_11_A2;

public class Main {

	public static void main(String[] args) {
		
		Converyor converyor = new Converyor();
		int delay = 1000;
		
		Thread bolltingPlant = new Thread(new BottlingPlant(converyor, delay));
		Thread labelingMachine = new Thread(new LabelingMachine(converyor, delay));
		
		bolltingPlant.start();
		labelingMachine.start();
		
	}
	
}
