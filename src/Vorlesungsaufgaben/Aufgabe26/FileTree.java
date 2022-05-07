package Vorlesungsaufgaben.Aufgabe26;

import java.io.File;
import java.io.FileFilter;

public class FileTree {

	private DirVisitor dv;
	
	public FileTree(DirVisitor dv) {
		this.dv = dv;
	}
	
	public void traverse(File dir) {
		
		if(dir.isDirectory()) {
			
			dv.enter(dir);
			FileFilter ft = new PdfFilter();
			File[] listFiles = dir.listFiles(ft);
			for( File f: listFiles ) {
				if(f.isFile()) {
					dv.visitFile(f);
				} else { // Wenn ein Folder
					traverse(f);
				}
			}
			dv.exit(dir);
		}
		
	}
	
}
