import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;


public class JobMassImport {
	
	
	public static Connection conn = null;
	
	/**
	 * singleton to get the connection
	 * @return the connection to the database
	 */
	public static Connection getConnection() {
		if (conn == null) {
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
	
	// we use the job table, it has following columns:
	// id: uuid
	// name: text
	// description: text
	
	
	public static void importJobsFromFile(String filename) throws IOException {
		// read each line in the csv file
		List<String> lines = FileUtils.readLines(new File(filename), StandardCharsets.UTF_8);
		 for (String line: lines) {
			 // now we need to split between name and description
			 String[] values = line.split(";");
			 insertJob("TEST"+ values[0], values[1]);
		 }
	}
	
	
	// C: create operation
	public static void insertJob(String name, String description) {
		UUID uuid = UUID. randomUUID();
		String id = uuid.toString();
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "INSERT INTO \"Job\" (id,name,description) "
			+ "VALUES ('"+id+"', '"+name+"','"+description+"');";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			getConnection().commit();
		} catch (SQLException e) {
			System.out.println("An Error occured during INSERT");
			e.printStackTrace();
		}			
	}
	
	// R: read operation
	public static void readJobs() {
		// reads and prints the jobs
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM \"Job\"";
			ResultSet rs = stmt.executeQuery(sql);
	        while ( rs.next() ) {
	            String jobId = rs.getString("id");
	            String jobName  = rs.getString("name");
	            String jobDescription  = rs.getString("description");
	            System.out.println(jobId+", "+jobName+", "+jobDescription);
	         }	
	        rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("An Error occured during READ");
			e.printStackTrace();
		}		
	}
	
	// D: delete operation
	public static void deleteJobs() {
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "DELETE FROM \"Job\"";
			stmt.execute(sql);
			stmt.close();
			getConnection().commit();
		} catch (SQLException e) {
			System.out.println("An Error occured during DELTE");
			e.printStackTrace();
		}			
	}
	
	public static void main(String args[]) {
		// clean  db
		System.out.println("");
		System.out.println("** Delete all jobs **");
		deleteJobs();
		
		// read and print the jobs
		System.out.println("** Importing jobs **");
		// relative filename inside the projects folder
		String filename = "res/jobs.csv";
		try {
			importJobsFromFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read and print the jobs
		System.out.println("");
		System.out.println("** Read jobs **");
		readJobs();
	}

}
