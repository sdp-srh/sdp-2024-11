package basic;

public class Circle {
	int radius; // Attributes
	String name;

	int calculateDiameter() { // Method
		return radius * 2;
	}
	
	public static void main(String args[]) {
		Circle circle = new Circle();
		circle.radius = 5; 
		int diam = circle.calculateDiameter();
		System.out.println(diam);
	}
}
