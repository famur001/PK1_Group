package Vorlesungsaufgaben;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_Test {

	public static void main(String[] args) {
		
		Exception_Test object = new Exception_Test();
		
		try {
			object.testMethod(-5);
		} catch(NegativException e) {
			e.printStackTrace();
		}
		
		System.out.println("Es geht weiter");
	
	}
	
	public void testMethod(int n) throws NegativException {
		if(n > 0) {
			System.out.println("Alles in Ordnung");
		} else {
			throw new NegativException("Eingabe in negativ");
		}
	}
}
