package swing.demo08;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel occupationLabel;
	private JTextField occupationTextField;
	private JButton okButton;
	
	private FormEventListener formEventListener;

	private static final long serialVersionUID = 1L;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		nameLabel = new JLabel("name:");
		nameTextField = new JTextField(10);
		occupationLabel = new JLabel("occupation:");
		occupationTextField = new JTextField(10);
		okButton = new JButton("OK");

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 1;

		Insets noInsets = new Insets(0, 0, 0, 0);
		Insets rightInsets = new Insets(0, 0, 0, 5);
		
		// ///////////////////// First Row ///////////////////
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = rightInsets;
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = noInsets;
		add(nameTextField, gc);

		// ///////////////////// Second Row ///////////////////
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = rightInsets;
		add(occupationLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = noInsets;
		add(occupationTextField, gc);

		// ///////////////////// Third Row ///////////////////
		gc.weighty = 20;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okButton, gc);
		
		// handle click event on OK button
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FormEvent formEvent = new FormEvent(e.getSource());
				formEvent.setName(nameTextField.getText());
				formEvent.setOccupation(occupationTextField.getText());
				formEventListener.eventOccure(formEvent);
			}
		});

	}

	public void setFormEventListener(FormEventListener formEventListener) {
		this.formEventListener = formEventListener;
	}
	
	

}
