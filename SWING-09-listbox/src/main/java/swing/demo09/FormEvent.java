package swing.demo09;

import java.util.EventObject;

public class FormEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String occupation;

	public FormEvent(Object source) {
		super(source);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	

}
