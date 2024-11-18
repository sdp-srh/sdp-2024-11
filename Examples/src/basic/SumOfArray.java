package basic;

public class SumOfArray {

	public static void main(String args[]) {
		
		int[] values = {1,2,3,5,6};
		System.out.println("Sum of numbers");
		int sum1 = 0;
		for (int i = 0; i < values.length; i++) {
			sum1 = sum1 + values[i];
		}
		System.out.println("The sum1 is: "+ sum1);
		
		int sum2 = 0;
		for (int value: values) {
			sum2 += value;
		}
		System.out.println("The sum2 is: "+ sum2);
		
		if (sum1 == sum2) {
			System.out.println(" The results are equal");
		}
	}
}
