package algorithms;

import java.util.ArrayList;

public class FindInList {
	
	public static void main(String args[]) {
		ArrayList<String> list = getPersonList();
		// check if the list contains a value
		if (list.contains("Micky")) {
			System.out.println("Contains found Micky");
		}
		
		// get the position (index) of a value, -1 is the default if the value is not available
		int index = list.indexOf("Minni");
		if (index > -1) {
			System.out.println("Minni found at "+index);
		}
		
		// check if a value is in the list with an own method
		if (isValueInList(list, "Daisy")) {
			System.out.println("Daisy is in List");
		}
		
		String foundString = findValueInList(list, "Minni");
		if (foundString != null) {
			System.out.println("Found the value "+foundString);
		}
		
	}
	
	public static boolean isValueInList(ArrayList<String> list, String value) {
		for (String s : list) {
			if (s.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public static String findValueInList(ArrayList<String> list, String value) {
		for (String s : list) {
			if (s.equals(value)) {
				return s;
			}
		}
		return null;
	}
	
	public static ArrayList<String> getPersonList() {
		ArrayList<String> persons = new ArrayList<String>();
		persons.add("Donald");
		persons.add("Micky");
		persons.add("Minni");
		persons.add("Daisy");
		return persons;
	}
	
}
