package algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class SortList {
	public static void main(String args[]) {
		ArrayList<String> list = getPersonList();
		
		Collections.sort(list);
		System.out.println("Collection Sort");
		for (String s : list) {
			System.out.println(s);
		}
		
		ArrayList<String> bubbleSortedList = bubbleSort(getPersonList());
		System.out.println("");
		System.out.println("Bubble Sort");
		for (String s : bubbleSortedList) {
			System.out.println(s);
		}
		
	}

	public static ArrayList<String> bubbleSort(ArrayList<String> values) {
		System.out.println("Starting Bubble Sort");
		ArrayList<String> list = new ArrayList<String>(values);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j - 1).compareTo(list.get(j)) > 0) {
					// Swap
					String tmp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, tmp);
					System.out.println(list);
				}
			}
		}
		return list;
	}

	public static ArrayList<String> getPersonList() {
		ArrayList<String> persons = new ArrayList<String>();
		persons.add("Pluto");
		persons.add("Donald");
		persons.add("Micky");
		persons.add("Minni");
		persons.add("Daisy");
		return persons;
	}
}
