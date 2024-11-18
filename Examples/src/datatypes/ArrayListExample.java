package datatypes;

import java.util.*;

public class ArrayListExample {

	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Mango");// Adding object in arraylist
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");
		// Printing the arraylist object
		System.out.println(list);
		
		// Traversing list through Iterator
		Iterator<String> itr = list.iterator();// getting the Iterator
		while (itr.hasNext()) {// check if iterator has the elements
			System.out.println(itr.next());// printing the element and move to next
		}
		
		System.out.println("");
		for (String element : list) {
			System.out.println(element);
		}
		
		// reversed order
		System.out.println("");
		for (int i= list.size()-1;i>=0;i--) {
			System.out.println(""+i+" : "+list.get(i));
		}
		
	}

}
