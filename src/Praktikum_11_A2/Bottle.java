package Praktikum_11_A2;

public class Bottle {

	private Lable lable;
	
	public void setLable(Lable lable) {
		this.lable = lable;
	}
	
	public void printLable() {
		System.out.println(lable.getType() + " mindestens haltbat bis " + lable.getBestBefore());
	}
	
}
