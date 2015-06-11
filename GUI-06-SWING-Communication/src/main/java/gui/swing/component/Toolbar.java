package gui.swing.component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JButton helloBtn;
	private JButton goodbyeBtn;
	
	private TextPanel textPanel;
	
	
	public Toolbar() {
		helloBtn = new JButton("Hello");
		goodbyeBtn = new JButton("Goodbye");
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(helloBtn);
		this.add(goodbyeBtn);
		
		this.helloBtn.addActionListener(this);
		this.goodbyeBtn.addActionListener(this);
	}

	public void setTextPanel(TextPanel textPanel) {
		this.textPanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedBtn =  (JButton)e.getSource();
		if(clickedBtn == helloBtn) {
			this.textPanel.appendText("Hello\n");
		}
		
		if(clickedBtn == goodbyeBtn) {
			this.textPanel.appendText("Goodbye\n");
		}
	}

}
