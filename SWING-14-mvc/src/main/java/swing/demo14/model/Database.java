package swing.demo14.model;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private List<Person> people;

	public Database() {
		people = new ArrayList<>();
	}

	public void addPerson(Person person) {
		this.people.add(person);
	}
}