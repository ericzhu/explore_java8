package swing.demo15.controller;

import java.util.List;

import swing.demo15.gui.FormEvent;
import swing.demo15.model.AgeCategory;
import swing.demo15.model.Database;
import swing.demo15.model.EmploymentCategory;
import swing.demo15.model.Gender;
import swing.demo15.model.Person;

public class Controller {
	
	Database db = new Database();
	
	public List<Person> getPeople() {
		return db.getPeople();
	}
	
	public void addPerson(FormEvent event) {
		String name = event.getName();
		String occupation = event.getOccupation();
		
		Person person = new Person(1, name, occupation, AgeCategory.adult, EmploymentCategory.employed, "tax001", true, Gender.female);
		db.addPerson(person);
	}
}
