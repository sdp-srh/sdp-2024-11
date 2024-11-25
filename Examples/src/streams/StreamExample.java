package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamExample {
	
	public static void main(String args[]) {
		int amount = 10;
		int highestValue = 100;
		
		// create a random list of values
		ArrayList<Integer> numbers = getRandomNumbers(amount, highestValue);
		System.out.println("Random Data");
		System.out.println(numbers);
		System.out.println();

		// filter out only the even numbers in our list
		List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println("Filtered even numbers");
		System.out.println(evenNumbers);
		System.out.println();
		
		
		// map all integers to strings
		List<String> numbersAsStrings = numbers.stream().map(n -> "Number: "+n ).collect(Collectors.toList());
		System.out.println("Numbers as String");
		System.out.println(numbersAsStrings);
		System.out.println();
		
		// return the square of all values as a new list
		List<Integer> squaredNumbers = numbers.stream().map(n -> n*n ).collect(Collectors.toList());
		System.out.println("squaredNumbers");
		System.out.println(squaredNumbers);
		System.out.println();

			
		// calculate to sum of all numbers
		int sum = numbers.stream().reduce(0, (result, num) -> result + num);
		System.out.println("Sum of all values is "+sum);

		
		// calculate the maximum value in the list
		int max = numbers.stream().reduce(0, (result, num) -> result < num ? num : result);
		System.out.println("Max value is "+max);	
		
		// calculate the minimum number of the list
		int min = numbers.stream().reduce(highestValue, (result, num) -> result > num ? num : result);
		System.out.println("Min value is "+min);			
	}
	
	public static ArrayList<Integer> getRandomNumbers(int amount, int max) {
		// initialize the random generator with the current time in milliseconds
		Random random = new Random(System.currentTimeMillis());
		// creates an array with random numbers
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i=0; i<amount; i++) {
			numbers.add(random.nextInt(max));
		}
		return numbers;
	}

}
