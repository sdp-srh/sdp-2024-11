package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.DBHandler;
import data.Person;

/**
 * inherits from JPanel
 * and implemenets an action listener (enables state change on button click)
 * @author srh
 *
 */
public class CreatePersonPanel extends JPanel implements ActionListener {
	
	public static final String SAVE_PERSON_COMMAND = "SAVE_PERSON";
	// the fields are important to get the first and last name
	JTextField firstNameField;
	JTextField lastNameField;
	JButton saveButton;
	
	
	public CreatePersonPanel() {
		// create a layout in vertical arrangement
		BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(bl);
		
		// create label and field to first and lastname
		JLabel firstNameLabel = new JLabel("Firstname");
		this.add(firstNameLabel);
		firstNameField = new JTextField(20);
		// avoids larget text fields
		firstNameField.setMaximumSize( firstNameField.getPreferredSize() );
		this.add(firstNameField);   
		
		JLabel lastNameLabel = new JLabel("Lastname");
		this.add(lastNameLabel);
		lastNameField = new JTextField(20);
		lastNameField.setMaximumSize( lastNameField.getPreferredSize() );
		this.add(lastNameField);  	
		
		// creates the save button and assigns the event listener for the button click
		// the event listener is implemented in this class
		JButton saveButton = new JButton("Save");
		saveButton.setActionCommand(SAVE_PERSON_COMMAND);
		saveButton.addActionListener(this);
		this.add(saveButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// saves the person data in case the person command is provided
		if (SAVE_PERSON_COMMAND.equals(e.getActionCommand())) {
			Person newPerson = new Person();
			// get the data from the text fields
			newPerson.setFirstName(firstNameField.getText());
			newPerson.setLastName(lastNameField.getText());
			// save the new person to the database
			DBHandler dbh = new DBHandler();
			dbh.insertPerson(newPerson);
			System.out.println("New Person created");
		}
		
	}
	
	
	
}
