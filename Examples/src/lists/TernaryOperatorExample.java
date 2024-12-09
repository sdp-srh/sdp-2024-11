package lists;

public class TernaryOperatorExample {

	public static void main(String[] args) {
		int x = -11;
		// String s = x < 0 ? "negative" : x == 0 ? "zero" : "positive"
		String s = x < 0 ? "negative" : "positive";
		
		// the same with if else
		/*
		if (x < 0) {
			s = "Negative";
		}
		else {
			s = "Positive";
		}
	*/
		System.out.println(s);
	}
	
	public static String calculate(int x) {
		return "Result is "+x*x;
	}

}
