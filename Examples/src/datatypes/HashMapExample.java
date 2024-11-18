package datatypes;

import java.util.*;

public class HashMapExample {
	public static void main(String args[]) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();// Creating HashMap
		map.put(1, "Mango"); // Put elements in Map
		map.put(4, "Apple");
		map.put(3, "Orange");
		map.put(500, "Banana");
		map.put(501, "Kiwi");
		map.put(1, "Melon");

		System.out.println("Iterating Hashmap...");
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}