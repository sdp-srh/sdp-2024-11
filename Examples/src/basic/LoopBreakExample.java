package basic;


public class LoopBreakExample {
	public static void main(String[] args) {
		for (int i=0; i<=10;i++) {
			System.out.println(i);
			if (i==1) {
				break;
			}
		}
	}
}
