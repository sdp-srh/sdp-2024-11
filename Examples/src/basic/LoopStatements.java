package basic;

public class LoopStatements {

	public static void main(String[] args) {
		
		
		// loop statement
		
		for (int i = 0; i <= 10; i++) {
			System.out.println(i*i);
		}
		
	
		// example with string
		String text = "SRH SDP";
		for (int i = 0; i < text.length(); i++) {
			System.out.println(""+i+":"+text.charAt(i));
		}
		
		int x = 15;
		while (x > 0) {
			System.out.println(x + " left");
			x = x - 1; // x-- or x -= 1 are the shorter forms
		}
		
		int y = 0;
		do {
			System.out.println("Y is "+y);
			y--;
		} while (y > 0);

		
		String[] names = {"Donald", "Daisy", "Dagobert", "Micky"};
		
		for (String name : names) {
			System.out.println("Name: " + name);
		}
	
		for (int i = 0; i < names.length; i++) {
			System.out.println("Name("+i+"): " + names[i]);
		}
		
				
		
	}

}
