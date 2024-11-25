package ui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Person;

public class PersonListPanel extends JPanel {
	
	public PersonListPanel() {
		// creates an empty panel
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void showPersons(ArrayList<Person> persons) {
		// remove the current content on the pane
		this.removeAll();
		// for each person create a new text with first an last name
		for (Person p: persons) {
			String personText = p.getFirstName()+" "+p.getLastName();
			JLabel label = new JLabel(personText);
			this.add(label);
		}
	}
}
