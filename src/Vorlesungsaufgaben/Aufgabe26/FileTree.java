package Vorlesungsaufgaben.Aufgabe26;

import java.io.File;

public class FileTree {

	private DirVisitor dv;
	
	public FileTree(DirVisitor dv) {
		this.dv = dv;
	}
	
	public void traverse(File dir) {
		
		if(dir.isDirectory()) {
			
			dv.enter(dir);
			
			File[] listFiles = dir.listFiles();
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
