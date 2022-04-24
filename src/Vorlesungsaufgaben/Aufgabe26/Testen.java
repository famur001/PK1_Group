package Vorlesungsaufgaben.Aufgabe26;

import java.io.File;

public class Testen {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1");
		
		File[] files = file.listFiles();
		for( File f: files ) {
			System.out.println(f.getName());
			if(f.isDirectory()) {
				File[] file2 = f.listFiles();
				for(File f2: file2) {
					System.out.println("   "+f2.getName());
					if(f2.isDirectory()) {
						File[] files3 = f2.listFiles();
						for(File f3: files3) {
							System.out.println("      "+f2.getName());
						}
					}
				}
			}
		}
	}
	
}
