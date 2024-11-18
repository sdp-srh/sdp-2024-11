package basic;

public class DecisionMakingStatements {

	public static void main(String[] args) {
		// variable definitions
		int x = 0;
		int y = 8;
		int z = 20;
		
		String universityName = "SRH Heidelberg";
		
		// simple if
		if (x >= 10 && y > 9) {
			System.out.println("x and y have more than one digit");
		}
		else {
			System.out.println("one of the numbers is less than 10");
		}
		
		if (universityName.startsWith("SRH")) {
			System.out.println("University is part of SRH Group");
		}
		
		// if else
		if (x > 10) {
			System.out.println("x has more than one digit");
		}
		else {
			System.out.println("x has one digit");
		}
		
		// if else if ladder
		if (x > 10) {
			System.out.println("x has more than one digit");
		}
		else if (x > 0)	{
			System.out.println("x has one digit");
		}
		else {
			System.out.println("x is zero");
		}
		// nested if
		if ( x > 0) {
			System.out.println("x is positive");
			if ( x % 2 == 0) {
				System.out.println("x is even");
			}
			else {
				System.out.println("x is odd");
			}
		}
		else {
			System.out.println("x is zero or less");
		}
		
		// switch case
		switch (x) {
			case 0: 
				System.out.println("value is zero");
				break;
			default: 
				System.out.println("value is positive");
		}
		
	}
	
	

}
