package application;

import java.util.ArrayList;

public class DBConnectionTest {

	public static void main(String[] args) {
		System.out.println("Data Base Connection Example");
		
		Person newPerson = new Person();
		newPerson.setFirstName("Donald");
		newPerson.setLastName("Duck");
		
		Person newPerson2 = new Person();
		newPerson2.setFirstName("Micki");
		newPerson2.setLastName("Mouse");
		// save the new person to the database
		DBHandler dbh = new DBHandler();
		dbh.insertPerson(newPerson);
		dbh.insertPerson(newPerson2);
		
		ArrayList<Person> personsFromDB = dbh.readPersons();
		if (personsFromDB.size() == 0) {
			System.out.println("data base does not contain persons");
		}
		else {
			for (Person person: personsFromDB) {
				System.out.println(person.getFirstName()+" "+person.getLastName());
			}	
		}
		
	}
}
