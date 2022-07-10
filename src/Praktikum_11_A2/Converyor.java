package Praktikum_11_A2;

import java.util.ArrayList;
import java.util.List;

public class Converyor {

	private List<Bottle> conveyor;
	
	public Converyor() {
		this.conveyor = new ArrayList<>();
	}
	
	public void load(Bottle b) {
		this.conveyor.add(b);
	}
	
	public Bottle withdraw() {
		return this.conveyor.remove(0);
	}
	
	public boolean isEmpty() {
		return this.conveyor.isEmpty();
	}
	
	public boolean isOverloaded() {
		return this.conveyor.size() == 50 ? true : false;
	}
	
}
