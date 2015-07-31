package swing.demo15.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import swing.demo15.model.Gender;
import swing.demo15.model.Person;

public class PersonTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public static String[] columnNames = { "ID", "NAME", "AGE CATEGORY", "EMPLOYEE CATEGORY", "GENDER" };

	private List<Person> people;

	public PersonTableModel() {
	}

	public PersonTableModel(List<Person> people) {
		this.people = people;
	}

	@Override
	public int getRowCount() {
		return people.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {

		Class<?> result;

		switch (columnIndex) {
		case 0:
			result = String.class;
			break;
		case 1:
			result = String.class;
			break;
		case 2:
			result = String.class;
			break;
		case 3:
			result = String.class;
			break;
		case 4:
			result = Gender.class;
			break;
		default:
			result = String.class;
		}

		return result;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Person p = people.get(rowIndex);
		Object result = null;

		switch (columnIndex) {
		case 0:
			result = p.getId();
			break;
		case 1:
			result = p.getName();
			break;
		case 2:
			result = p.getAgeCategory();
			break;
		case 3:
			result = p.getEmpCat();
			break;
		case 4:
			result = p.getGender();
		default:
			break;
		}

		return result;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setData(List<Person> people) {
		this.people = people;
	}

}
