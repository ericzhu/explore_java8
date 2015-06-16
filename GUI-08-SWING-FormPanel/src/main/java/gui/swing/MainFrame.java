package gui.swing;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.swing.component.FormPanel;
import gui.swing.component.StringListener;
import gui.swing.component.TextPanel;
import gui.swing.component.Toolbar;

/**
 * This MainFrame class act as a controller of the application
 * 
 * @author xiaoyu.zhu
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private TextPanel textPanel;
	private JButton button;
	private Toolbar toolbar;
	private FormPanel formPanel;

	private int clickCount = 0;

	public MainFrame() {

		// Initialize the frame
		super("Hello Toolbar");
		setSize(800, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		toolbar = new Toolbar();
		textPanel = new TextPanel();
		button = new JButton("Click Me!");
		formPanel = new FormPanel();

		// Set layout and add component
		setLayout(new BorderLayout());

		add(toolbar, BorderLayout.NORTH);
		add(textPanel);
		add(button, BorderLayout.SOUTH);
		add(formPanel, BorderLayout.WEST);
		
		toolbar.setStringListener(new StringListener() {
			
			@Override
			public void emitText(String text) {
				textPanel.appendText(text + "\n");
			}
		});

		// Add listener to respond to button click
		button.addActionListener(event -> textPanel.appendText("Button is cliked ! " + clickCount++ + "\n"));
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new MainFrame());
	}

}
