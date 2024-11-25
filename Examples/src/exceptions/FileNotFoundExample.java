package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExample {

	
	public static File readMyFile(String path) throws MyFileNotFoundException {
		File f = new File(path);
		if (!f.exists()) {
			throw new MyFileNotFoundException();
		}
		return f;
	}
	
	public static void main(String args[]) {
		try {
			//File file = new File("C://xyz.txt");
			//FileReader fr = new FileReader(file);
			File file2 = readMyFile("C://xyz.txt");
			
		} catch (MyFileNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		
			System.out.println("Finished");
	}
}
