package learn.javafx.mvc.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	public enum AgeCategory {
		BABY, CHILD, TEEN, ADULT, SENIOR, UNKNOWN
	};

	private final ReadOnlyIntegerWrapper personId = new ReadOnlyIntegerWrapper(
			this, "personId", personSequence.incrementAndGet());
	private final StringProperty firstName = new SimpleStringProperty(this,
			"firstName", null);
	private final StringProperty lastName = new SimpleStringProperty(this,
			"lastName", null);
	private final ObjectProperty<LocalDate> birthDate = new SimpleObjectProperty<>(
			this, "birthDate", null);

	// Keeps track of last generated person id
	private static AtomicInteger personSequence = new AtomicInteger(0);

	public Person() {
		this(null, null, null);
	}

	public Person(String firstName, String lastName, LocalDate birthDate) {
		this.firstName.set(firstName);
		this.lastName.set(lastName);
		this.birthDate.set(birthDate);
	}

	/* personId Property */
	public final int getPersonId() {
		return personId.get();
	}

	public final ReadOnlyIntegerProperty personIdProperty() {
		return personId.getReadOnlyProperty();
	}

	/* firstName Property */
	public final String getFirstName() {
		return firstName.get();
	}

	public final void setFirstName(String firstName) {
		firstNameProperty().set(firstName);
	}

	public final StringProperty firstNameProperty() {
		return firstName;
	}

	/* lastName Property */
	public final String getLastName() {
		return lastName.get();
	}

	public final void setLastName(String lastName) {
		lastNameProperty().set(lastName);
	}

	public final StringProperty lastNameProperty() {
		return lastName;
	}

	/* birthDate Property */
	public final LocalDate getBirthDate() {
		return birthDate.get();
	}

	public final void setBirthDate(LocalDate birthDate) {
		birthDateProperty().set(birthDate);
	}

	public final ObjectProperty<LocalDate> birthDateProperty() {
		return birthDate;
	}
}
