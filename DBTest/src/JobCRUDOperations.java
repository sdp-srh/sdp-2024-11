import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;


public class JobCRUDOperations {
	
	
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
	
	
	// C: create operation
	public static void createJobs() {
		for (int i=0; i<3; i++) {
			UUID uuid = UUID.randomUUID();
			String id = uuid.toString();
			String name = "Job "+i;
			String description = "Job Description "+i;
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
	}
	
	// R: read operation
	public static ArrayList<Job> readJobs() {
		// reads and prints the jobs
		ArrayList<Job> results = new ArrayList<Job>();
		try {
			Statement stmt = getConnection().createStatement();
			String sql = "SELECT * FROM \"Job\"";
			ResultSet rs = stmt.executeQuery(sql);
	        while ( rs.next() ) {
	            String jobId = rs.getString("id");
	            String jobName  = rs.getString("name");
	            String jobDescription  = rs.getString("description");
	            System.out.println(jobId+", "+jobName+", "+jobDescription);
	            Job job = new Job(jobId, jobName, jobDescription);
	            results.add(job);
	         }	
	        rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println("An Error occured during READ");
			e.printStackTrace();
		}
		return results;
	}
	
	// U: update operation
	public static void updateJobs() {
		// we update only the description of the first job, we identify 
		try {
			String newDescription = "NEW DESCRIPTION";
			Statement stmt = getConnection().createStatement();
			// usually you update based on the id
			String sql = "UPDATE \"Job\" SET description='"+newDescription+"' WHERE name='Job 0'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			getConnection().commit();
		} catch (SQLException e) {
			System.out.println("An Error occured during UPDATE");
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
	
	public static void printListInformation(ArrayList<Job> jobs) {
		System.out.println("The database contains : "+jobs.size());
	}
	
	public static void main(String args[]) {

		
		deleteJobs();
		
		// create some jobs
		System.out.println("** Create the new job entries **");
		createJobs();
		
		// read and print the jobs
		System.out.println("");
		System.out.println("** Read jobs **");
		readJobs();
	
		
		System.out.println("");
		System.out.println("** Update description of Job 1 **");
		// update the first job
		updateJobs();
		
		
		
		System.out.println("");
		System.out.println("** Read jobs **");
		// read and print the jobs
		readJobs();
		
		
		ArrayList<Job> jobsInDB = readJobs();
		printListInformation(jobsInDB);		
	}
}
