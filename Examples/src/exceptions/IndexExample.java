package exceptions;

public class IndexExample {
	public static void main(String args[]) {
		String[] array = {"Donald", "Daisy", "Micky"};
		String test = null;
		
		try {
			String s = "Test";
			int l = s.length();
			System.out.println(l);
			test = array[1];	
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("The size of the array is: "+array.length);
			test = array[array.length-1];
		} 
		finally {
			// DB close connection
			System.out.println("Finally we clean up the connections, etc...");
		}
		System.out.println("normal coding continues here");
		
		
		System.out.println("Test:"+test);
	}
}
