package Vorlesungsaufgaben.Aufgabe26;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		DirPrinter dp = new DirPrinter();
		FileTree ft = new FileTree(dp);
		
		File file = new File("C:\\Users\\fathi\\OneDrive\\Desktop\\PK1");
		ft.traverse(file);
	}

}
