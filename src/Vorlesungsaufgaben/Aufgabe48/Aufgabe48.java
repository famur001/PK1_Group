package Vorlesungsaufgaben.Aufgabe48;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BinaryOperator;

public class Aufgabe48 {

	public static int fold(Collection<Integer> liste, int identity,
			BinaryOperator<Integer> op) {
		return liste.stream().reduce(identity, op);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println("Summe: " + fold(list, 0, (a,b) -> a+b));
		System.out.println("Produkt: " + fold(list, 1, (a,b) -> a*b));
	}
	
	
}
