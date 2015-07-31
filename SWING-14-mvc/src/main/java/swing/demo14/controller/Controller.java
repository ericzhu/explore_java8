package swing.demo14.controller;

import swing.demo14.gui.FormEvent;
import swing.demo14.model.AgeCategory;
import swing.demo14.model.Database;
import swing.demo14.model.EmploymentCategory;
import swing.demo14.model.Gender;
import swing.demo14.model.Person;

public class Controller {
	
	Database db = new Database();
	
	public void addPerson(FormEvent event) {
		String name = event.getName();
		String occupation = event.getOccupation();
		
		Person person = new Person(1, name, occupation, AgeCategory.adult, EmploymentCategory.employed, "tax001", true, Gender.female);
		db.addPerson(person);
	}
}
