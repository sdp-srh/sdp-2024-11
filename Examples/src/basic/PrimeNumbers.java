package basic;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		System.out.println("Calculating the prime numbers");
		
		System.out.println("Enter the maximum number: ");
		Scanner scanner = new Scanner(System.in);
		int maxNumber = scanner.nextInt();
		 
		for (int checkNumber=2; checkNumber <= maxNumber; checkNumber++  ) {
			if (isPrime(checkNumber)) {
				System.out.println("" + checkNumber + " is a prime number");
			}
		}
	}
	
	public static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
