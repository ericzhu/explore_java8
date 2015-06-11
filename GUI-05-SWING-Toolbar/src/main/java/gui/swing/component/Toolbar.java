package gui.swing.component;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton helloBtn;
	private JButton goodbyeBtn;
	
	public Toolbar() {
		helloBtn = new JButton("Hello");
		goodbyeBtn = new JButton("Goodbye");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(helloBtn);
		this.add(goodbyeBtn);
	}

}
