package exceptions;

public class CatchExample {
	
	public static void main(String args[]) {
		int a = 10;
		int b = 1;
		int result = -1;
				
		try {
			result = a/b;
			System.out.println("Hello");
		} catch (Exception e) {
			System.out.println("Catch is only executed, if an exception has occured");
			e.printStackTrace();
		}
		finally {
			if (result == -1) {
				result =0;
			}
			System.out.println("Finally is always executed");
		}
		
		System.out.println(result);
	}
}
