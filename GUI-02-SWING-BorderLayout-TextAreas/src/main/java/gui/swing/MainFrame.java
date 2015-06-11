package gui.swing;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	private JButton button;

	public MainFrame() {
		super("Hello Swing layout");
		this.setSize(800, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		textArea = new JTextArea();
		button = new JButton("Click Me!");
		this.add(textArea, BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new MainFrame());
	}

}
