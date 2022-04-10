package Praktikum_01;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		Angestellter a1 = new Angestellter("Ahmad", 5000);
		Angestellter a2 = new Angestellter("Mohammed", 5000);
		//System.out.println(a1);
		
		ArrayList<Angestellter> liste = new ArrayList<Angestellter>();
		liste.add(a1);
		liste.add(a2);
		//liste.add("Abc");
		//liste.remove(a1); liste.remove(0);
		
		/*for( int i = 0; i < liste.size(); i++ ) {
			System.out.println( liste.get(i) );
		}*/
		Angestellter aa = liste.get(1);
		//System.out.println(aa);
		
		/*Iterator<Angestellter> it = liste.iterator();
		while( it.hasNext() ) {
			System.out.println(it.next());
		}*/
		
		for( Angestellter a: liste ) {
			System.out.println(a);
		}
		
	}
	
}
