package javafx.ch05.ex02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LazyPerson {
	private String _fullname;
	private StringProperty fullname = null;

	public StringProperty fullnameProperty() {
		if (fullname == null) {
			fullname = new SimpleStringProperty(this, "fullname", _fullname);
		}

		return this.fullname;
	}

	public final String getFullname() {
		if (this.fullname == null) {
			return _fullname;
		}

		return this.fullname.get();
	}
	
	public final void setFullname(String fullname) {
		if(this.fullname == null) {
			this._fullname = fullname;
		} else {
			this.fullname.set(fullname);
		}
	}
	
	@Override
	public String toString() {
		return getFullname();
	}
}
