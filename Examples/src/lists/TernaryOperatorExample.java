package lists;

public class TernaryOperatorExample {

	public static void main(String[] args) {
		int x = 9;
		String s = x < 0 ? "negative" : "positive";
		
		// the same with if else
	
		if (x < 0) {
			s = "Negative";
		}
		else {
			s = "Positive";
		}
	
		System.out.println(s);
	}
	
	public static String calculate(int x) {
		return "Result is "+x*x;
	}

}
