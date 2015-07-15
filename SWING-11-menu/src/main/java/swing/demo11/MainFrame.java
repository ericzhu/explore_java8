package swing.demo11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

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
		
		// Set menu bar
		
		setJMenuBar(createMenuBar());

		// Create components and add them to the content pane
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		
		
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(formPanel, BorderLayout.WEST);

		toolbar.setTextEmitter(new TextEmitter() {
			
			@Override
			public void emitText(String text) {
				textPanel.appendText(text + "\n"); 
			}
		});
		
		formPanel.setFormEventListener(new FormEventListener() {
			
			@Override
			public void eventOccure(FormEvent event) {
				String name = event.getName();
				String occupation = event.getOccupation();
				
				textPanel.appendText(name + " : " + occupation + "\n");
			}
		});
	}
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem exportDataItem = new JMenuItem("Export Data ...");
		fileMenu.add(exportDataItem);
		
		JMenuItem importDataItem = new JMenuItem("Import Data ...");
		fileMenu.add(importDataItem);
		
		JMenuItem exitItem = new JMenuItem("exit");
		fileMenu.add(exitItem);
		
		
		JMenu windowMenu = new JMenu("Window");
		
		
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showPersonForm = new JCheckBoxMenuItem("Person Form");
		showPersonForm.setSelected(true);
		
		showPersonForm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem =  (JCheckBoxMenuItem)e.getSource();
				if(menuItem.isSelected()) {
					formPanel.setVisible(true);
				} else {
					formPanel.setVisible(false);
				}
			}
		});
		
		showMenu.add(showPersonForm);
		
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		
		return menuBar;
	}
}
