package swing.demo08;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton button;
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;

	public MainFrame() {

		// Initialize the frame
		super("Hello World!");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Set layout
		setLayout(new BorderLayout());

		// Create components and add them to the content pane
		textPanel = new TextPanel();
		button = new JButton("Click Me !");
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		
		
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);

		toolbar.setTextEmitter(new TextEmitter() {
			
			@Override
			public void emitText(String text) {
				textPanel.appendText(text + "\n"); 
			}
		});
		
		// Add action listener to the button click
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Click Me !\n");
			}
		});
	}
}
