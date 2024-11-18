package basic;

public class Calculator {

	public static void main(String[] args) {
		String str = "test";
		System.out.println(str.length());
		int a = 5;
		int b = 1;
		System.out.println("Values: "+a+", "+b);
		System.out.println();
		System.out.println("add: \t\t" + add(a,b));
		System.out.println("substract: \t" + substract(a,b));
		System.out.println("multiply: \t" + multiply(a,b));
		System.out.println("divide: \t" + divide(a,b));
	}
	
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static int substract(int x, int y) {
		return x - y;
	}
	
	public static int multiply(int x, int y) {
		return x * y;
	}
	
	public static int divide(int x, int y) {
		return x / y;
	}	

}
