package swing.demo02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	private JButton button;
	
	public MainFrame() {
		
		// Initialize the frame
		super("Hello World!");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Set layout
		setLayout(new BorderLayout());
		
		// Create components and add them to the content pane
		textArea = new JTextArea();
		button = new JButton("Click Me !");
		add(textArea, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}
}
