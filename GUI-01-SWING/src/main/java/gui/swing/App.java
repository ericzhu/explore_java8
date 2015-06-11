package gui.swing;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) throws InvocationTargetException,
			InterruptedException {

		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Hello World");
				frame.setSize(600, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
		System.out.println("Program Exits");

	}
}
