package lists;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person a, Person b) {
    	int lastNameCompare = a.getLastName().compareToIgnoreCase(b.getLastName());
    	int result = lastNameCompare != 0 ? lastNameCompare : a.getFirstName().compareToIgnoreCase(b.getFirstName());
		return result;
	}
}
