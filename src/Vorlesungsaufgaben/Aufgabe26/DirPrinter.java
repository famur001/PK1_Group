package Vorlesungsaufgaben.Aufgabe26;

import java.io.File;

public class DirPrinter implements DirVisitor {

	String abstand = "";
	@Override
	// Folder ausgeben
	public void enter(File f) {
		System.out.println(abstand + "[" + f.getName() + "]");
		abstand += "   ";
	}

	@Override
	public void visitFile(File f) {
		//abstand += "   ";
		System.out.println(abstand + f.getName());
	}

	@Override
	public void exit(File f) {
		abstand = abstand.substring(3);
	}

	
	
}
