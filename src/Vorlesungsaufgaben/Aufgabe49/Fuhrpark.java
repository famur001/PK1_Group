package Vorlesungsaufgaben.Aufgabe49;

import java.util.ArrayList;
import java.util.List;

public class Fuhrpark {

	List<Auto> garage = new ArrayList<>();
	
	public void add(Auto auto) {
		this.garage.add(auto);
	}
	
	public boolean istHerstellerVorhanden(String hersteller) {
		return this.garage.stream()
				.map(a -> a.getHersteller().toLowerCase())
				.anyMatch( herst -> herst.equals(hersteller.toLowerCase()) );
	}
	
	public Auto neuestesBaujahr(String hersteller) {
		return this.garage.stream()
		.filter( auto -> auto.getHersteller().equals(hersteller) )
		.max( (auto1, auto2) -> Integer.compare(auto1.getBaujahr(), auto2.getBaujahr()) ).orElse(null);
	}
	
	public void druckeAutosBaujahr(int baujahr, int n) {
		this.garage.stream()
		.filter( auto -> auto.getBaujahr()==baujahr )
		.limit(n)
		.forEach(System.out::print);
	}
	
	public static void main(String[] args) {
		
		Fuhrpark fuhrpark = new Fuhrpark();
		fuhrpark.add(new Auto("BMW", 2022));
		fuhrpark.add(new Auto("BMW", 2020));
		fuhrpark.add(new Auto("Audi", 2022));
		fuhrpark.add(new Auto("Mercedes", 2022));
		
		System.out.println(fuhrpark.istHerstellerVorhanden("Bmw"));
		System.out.println(fuhrpark.neuestesBaujahr("BMW"));
		fuhrpark.druckeAutosBaujahr(2022, 3);
		
	}
	
}
