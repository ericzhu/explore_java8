package gui.swing;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.swing.component.TextPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private TextPanel textPanel;
	private JButton button;
	private int clickCount = 0;

	public MainFrame() {
		
		// Initialize the frame
		super("Hello Swing layout");
		this.setSize(800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set layout and add component
		this.setLayout(new BorderLayout());
		this.textPanel = new TextPanel();
		button = new JButton("Click Me!");
		this.add(textPanel);
		this.add(button, BorderLayout.SOUTH);
		
		// Add listener to respond to button click
		this.button.addActionListener(event -> textPanel.appendText("Button is cliked ! " + clickCount++ + "\n"));
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new MainFrame());
	}

}
