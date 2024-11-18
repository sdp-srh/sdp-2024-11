package lists;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	
	public Person() {
		this.firstName = "";
		this.lastName = "";
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
    public int compareTo(Person otherPerson) {
		// this method implements to the compareable interface
		// we check if the lastname is different (ignoring upper and lowercase)
		// if they are identical, then we compare the firstname and return the result
    	int lastNameCompare = lastName.compareToIgnoreCase(otherPerson.getLastName());
    	int result = lastNameCompare != 0 ? lastNameCompare : firstName.compareToIgnoreCase(otherPerson.getFirstName());
    	// ternary comparator is equal to
    	/*
    	if (lastNameCompare != 0) {
    		result = lastNameCompare;
    	}
    	else {
    		result = firstName.compareToIgnoreCase(otherPerson.getFirstName());
    	}
    	 */
    	return result;
	}
	
}
