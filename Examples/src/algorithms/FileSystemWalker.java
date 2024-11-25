package algorithms;

import java.io.File;
import java.util.ArrayList;

public class FileSystemWalker {
	
	// for ease of use the main function is in the calls
	public static void main(String args[]) {
		FileSystemWalker fsw = new FileSystemWalker();
		fsw.readFolder(new File("C:\\srh\\github\\course-2023-11\\Examples\\src"));
		fsw.printEntries();
	}
	
	// a list of all found entries
	ArrayList<String> entries = new ArrayList<String>();

	public FileSystemWalker() {
		// intializes the list
		entries = new ArrayList<String>();
	}
	
	public void readFolder(File folder) {
		// check if it is really a folder
		if (!folder.isDirectory()) {
			System.out.println("Only folders can be parsed");
			// throwing an exception would be a better solution
			return;
		}
		File[] files = folder.listFiles();
		for (File f : files) {
			// we add each entry
			this.entries.add(f.getAbsolutePath());
			if (f.isDirectory()) {
				// read the sub folder content
				this.readFolder(f);
			}
		}
	}
	
	public void printEntries() {
		for (int i=0;i<this.entries.size();i++) {
			System.out.println(this.entries.get(i));
		}
		// System.out.println("Files: "+(this.entries.size()-this.foldersCount));
		// System.out.println("Folders: "+this.foldersCount);
	}
}
