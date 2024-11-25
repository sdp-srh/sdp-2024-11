package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Person;

/**
 * this class is used to handle the database connection and reading/writing data
 * postgresql is used as database
 * https://www.tutorialspoint.com/postgresql/postgresql_environment.htm
 * @author srh
 *
 */
public class DBHandler {
	public static Connection conn = null;
	
	/**
	 * singleton to get the connection
	 * @return the connection to the database
	 */
	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectworksample","postgres", "admin");
	         conn.setAutoCommit(false);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
		}
		return conn;
	}
	
	/**
	 * inserts a new person in the database
	 * @param person the person with first and lastname
	 */
	public void insertPerson(Person person) {
		try {
			Statement stmt = DBHandler.getConnection().createStatement();
			String sql = "INSERT INTO \"Person\" (firstname,lastname) "
			            + "VALUES ('"+person.getFirstName()+"', '"+person.getLastName()+"');";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			DBHandler.getConnection().commit();
			System.out.println("New Person created");
		} catch (SQLException e) {
			System.out.println("An Error occured during insert Person");
			e.printStackTrace();
		}
	}
	
	/**
	 * reads the persons from the database table and creates an array list with objects of type person
	 * @return the list of persons
	 */
	public ArrayList<Person> readPersons() {
		ArrayList<Person> result = new ArrayList<Person>();
		try {
			Statement stmt = DBHandler.getConnection().createStatement();
			String sql = "SELECT * FROM \"Person\"";
			ResultSet rs = stmt.executeQuery(sql);
	        while ( rs.next() ) {
	            String firstname = rs.getString("firstname");
	            String lastname  = rs.getString("lastname");
	            Person p = new Person(firstname, lastname);
	            result.add(p);
	         }	
	        rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("An Error occured during read Persons");
			e.printStackTrace();
		}
		return result;
	}
}
