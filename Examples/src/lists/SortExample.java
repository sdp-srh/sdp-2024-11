package lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortExample {

	public static void main(String args[]) {
		//comparePersonsExample();
		//sortPersonListExample();
		sortPersonListWithComparatorExample();
	}
	
	public static void comparePersonsExample() {
		Person p1 = new Person("Donald", "Duck");
		Person p2 = new Person("Dagobert", "Duck");
		Person p3 = new Person("donald", "duck");
		
		int p1Top2 = p1.compareTo(p2);
		System.out.println("p1 compared to p2 returns "+p1Top2);
		
		int p2Top1 = p2.compareTo(p1);
		System.out.println("p1 compared to p2 returns "+p2Top1);		
		
		int p1Top3 = p1.compareTo(p3);
		System.out.println("p1 compared to p3 returns "+p1Top3);
		
	}
	
	
	public static void sortPersonListExample() {
		ArrayList<Person> persons = createPersonList();
		System.out.println("Persons before sorting");
		printPersonList(persons);
		System.out.println("");
		System.out.println("");
		// here we use the sorting implemented as part of persons
		Collections.sort(persons);
		System.out.println("****************");
		System.out.println("Persons after sorting based on person compare");
		printPersonList(persons);
	}
	
	public static void sortPersonListWithComparatorExample() {
		ArrayList<Person> persons = createPersonList();
		System.out.println("Persons before sorting");
		printPersonList(persons);
		System.out.println("");
		System.out.println("");
		// here we use our comparator class
		persons.sort(new PersonComparator());
		System.out.println("****************");
		System.out.println("Persons after sorting based on PersonComparator");
		printPersonList(persons);
	}
	
	public static ArrayList<Person> createPersonList() {
		ArrayList<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Minni", "Mouse"));
		persons.add(new Person("Micky", "Mouse"));
		persons.add(new Person("Donald", "Duck"));
		persons.add(new Person("Tick", "Duck"));
		persons.add(new Person("Trick", "Duck"));
		persons.add(new Person("Track", "Duck"));
		persons.add(new Person("Dagobert", "Duck"));
		return persons;
	}
	
	public static void printPersonList(ArrayList<Person> persons) {
		for (Person p: persons) {
			System.out.println(p.getLastName()+", "+p.getFirstName());
		}
	}
}
