package basic;

/**
 * class for absolute value calculation
 */
public class AbsoluteValue {
	
	public static void main(String args[]) {

		int number = 500;
		
		if (isNegativeNumber(number)) {
			number = number * (-1);
		}
		System.out.println("Absolute Value is "+number);
		
		/*
		System.out.println("Print all all square numbers up 20 ");
		for (int base=1; base <= 20; base++ ) {
			// a square number is the number multiplied with itself
			int squareNumber = base * base;
			System.out.println("The square number of "+base+" is "+squareNumber);
		}

		System.out.println("This program calculates absolute values");
		*/
	}
	
	public static boolean isNegativeNumber(int value) {
		return value < 0;
	}
}
