package basic;

public class StringExample {

	public static void main(String[] args) {
		
		char[] ch={'s','d','p','s','r','h'};
		String s1 = new String(ch);
		System.out.println(s1);
		
		String s2= "sdpsrh";
		System.out.println(s2);

		
		String s3 = "sdp2023";
		String s4 = s3.replace("23", "24");
		System.out.println(s4);
		
		
		String s = "Sachin";
		s.concat(" Tendulkar");
		System.out.println(s);
		
		String sconcat = s.concat(" Tendulkar");
		System.out.println(sconcat);
		int x = 5;
		if (s == "Sachin") {
			System.out.println(s+" is Sachin");
		}
		
	}
	
	
}
