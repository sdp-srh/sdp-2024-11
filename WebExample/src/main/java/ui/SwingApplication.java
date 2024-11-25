package ui;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import application.DBHandler;
import data.Person;

public class SwingApplication extends JFrame implements ChangeListener {
	
	// this is our main panel
	private JPanel contentPanel;
	// here we have tabs for displaying data and creating data
	private JTabbedPane tabbedPane;
	// own class to display persons
	private PersonListPanel personListPanel;
	// own class to create persons
	private CreatePersonPanel createPersonPanel;
	
	public SwingApplication() {
		// call the constructor of superclass (JFrame) with a title
		super("Project Example 2023");
		// set the window size
		this.setSize(600,400);
		// create the UI
		this.createContentPanel();
		// set the tabbed pane and show the window
		this.setContentPane(tabbedPane);
		this.setVisible(true);
	}
	
	public void createContentPanel() {
		tabbedPane = new JTabbedPane();
		personListPanel = new PersonListPanel();
		createPersonPanel = new CreatePersonPanel();
		// create two tabs with the list and the create from
		tabbedPane.add("Persons", personListPanel);
		tabbedPane.add("New Person", createPersonPanel);
		// add an event listener (this class) to react on choosing a tab
		tabbedPane.addChangeListener(this);
		// load and display the person list
		this.loadAndDisplayData();
	}
	
	
	public void loadAndDisplayData() {
		// loads the data from the database
		DBHandler dbh = new DBHandler();
		ArrayList<Person> personsFromDB = dbh.readPersons();
		// displays the person on the panel
		personListPanel.showPersons(personsFromDB);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// reacts on the state change of the tabbedPane
		if (tabbedPane.getSelectedComponent() == personListPanel) {
			this.loadAndDisplayData();
		}
		
	}	
	
    public static void main(String[] args)
    {       
    	try {
    		// set the system look and feel
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		// create our own application based on a jframe
    		new SwingApplication();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    
    


}
