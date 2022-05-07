package Vorlesungsaufgaben.Aufgabe26;

import java.io.File;
import java.io.FileFilter;

public class PdfFilter implements FileFilter {

	public boolean accept(File pathname) {
		if(pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".pdf")) {
			return true;
		}
		return false;
	}
	
}