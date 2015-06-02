package javafx.ch05.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {
	private StringProperty fullname = new SimpleStringProperty(this, "fullname", "");
	
	public Contact() {
		
	}
	
	public Contact(String fullname) {
		this.fullname.set(fullname);
	}
	
	public final void setFullname(String fullname) {
		this.fullname.set(fullname);
	}
	
	public final String getFullname() {
		return this.fullname.get();
	}
	
	public StringProperty fullnameProperty() {
		return this.fullname;
	}
	
	
	@Override
	public String toString() {
		return "Contact [name: " + getFullname() + "]";
	}
	
	
	public static void main(String[] args) {
		Contact johnContact = new Contact("John");
		System.out.println(johnContact);
		StringProperty fullname = new SimpleStringProperty("");
		fullname.bindBidirectional(johnContact.fullnameProperty());
		System.out.println(johnContact);
		fullname.set("Eric");
		System.out.println(johnContact);
		
		johnContact.setFullname("John");
		System.out.println(fullname.get());
		
			
		
	}
}
