package swing.demo15.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import swing.demo15.model.Gender;
import swing.demo15.model.Person;

public class TablePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private PersonTableModel personTableModel;
	private List<Person> people = new ArrayList<>();

	public TablePanel() {
		personTableModel = new PersonTableModel();

		personTableModel.setData(people);

		this.table = new JTable(personTableModel);

		this.table.setDefaultRenderer(Gender.class, new TableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JComboBox combox = new JComboBox(Gender.values());
				combox.setSelectedItem(value);
				return combox;
			}
		});

		this.table.setDefaultEditor(Gender.class, new GenderEditor());

		table.setRowHeight(20);

		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(table), BorderLayout.CENTER);

	}

	public void setData(List<Person> people) {
		this.people = people;
	}

	public void refresh() {
		personTableModel.setData(people);
		personTableModel.fireTableDataChanged();
	}
}

class GenderEditor extends AbstractCellEditor implements TableCellEditor {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isCellEditable(EventObject e) {
		return true;
	}

}
