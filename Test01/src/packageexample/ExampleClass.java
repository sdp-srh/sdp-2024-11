package packageexample;

public class ExampleClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 8;
		int y = 2000;
		
		int z = x * y;
		
		System.out.println("Multiplacation result is "+ z);
		
		if (x < y) {
			System.out.println("x is smaller");
		}
		else {
			System.out.println("y is smaller");
		}
		
		for (int i = 0; i < x; i++) {
			System.out.println(i * i);
		}
	}

}
