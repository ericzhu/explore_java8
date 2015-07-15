package swing.demo08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton helloBtn;
	private JButton byeBtn;

	private TextEmitter textEmitter;

	public Toolbar() {
		helloBtn = new JButton("Hello");
		byeBtn = new JButton("Bye");

		helloBtn.addActionListener(this);
		byeBtn.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		setBorder(BorderFactory.createEtchedBorder());
		
		add(helloBtn);
		add(byeBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn == helloBtn) {
			textEmitter.emitText("Hello");
		} else if(btn == byeBtn) {
			textEmitter.emitText("Bye");
		}
	}

	public void setTextEmitter(TextEmitter textEmitter) {
		this.textEmitter = textEmitter;
	}
}
