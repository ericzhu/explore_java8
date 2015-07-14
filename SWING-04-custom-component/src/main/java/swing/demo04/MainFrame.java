package swing.demo04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JButton button;
	private TextPanel textPanel;
	
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
		//add(textArea, BorderLayout.CENTER);
		add(textPanel, BorderLayout.CENTER);
		
		add(button, BorderLayout.SOUTH);
		
		// Add action listener to the button click
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Click Me !\n");
			}
		});
	}
}
