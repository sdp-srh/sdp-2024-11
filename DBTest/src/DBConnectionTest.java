import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


// the class extends the jframe class and implements the action listener interface
public class DBConnectionTest extends JFrame implements ActionListener {
	JPanel mainPanel;
	
	public DBConnectionTest() {
		// initialize the frame (application)
		super("DB Connection Test Application");
		this.setSize(800, 600);
		
		// define the main panel on which we add the components
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		// create the load button and assign an action listener
		JButton loadButton = new JButton("Load my data");
		loadButton.addActionListener(this);
		mainPanel.add(loadButton);
		
		// set the main panel for the frame
		this.setContentPane(mainPanel);
		this.setVisible(true);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// react on events (here we have only one, the load button click)
		System.out.println("The event was received");
		// load the list of name from the database
		ArrayList<String> names = this.loadDataFromDB();
		for (String name: names) {
			// create for each name a label
			JLabel label = new JLabel(name);
			mainPanel.add(label);
		}
		// activate and show the changes
		this.revalidate();
	}	
	
	public ArrayList<String> loadDataFromDB() {
		// our result list
		ArrayList<String> results = new ArrayList<String>();
		try {
			System.out.println("Connecting to a database");	
	        Class.forName("org.postgresql.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectworksample","postgres", "admin");	        
	        conn.setAutoCommit(false);
	        // create a statement
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM \"Person\"");
	        
	        while (rs.next()) {
	        	// add first and last name to the results
	        	results.add(rs.getString(1)+"  "+rs.getString(2));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return the results
		return results;		
	}
	
	public static void main(String[] args) {
    	try {
    		// set the system look and feel
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		// create our own application based on a jframe
    		new DBConnectionTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
