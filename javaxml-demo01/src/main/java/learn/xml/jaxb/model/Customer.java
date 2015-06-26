package learn.xml.jaxb.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = { "name", "phone", "about", "age", "balance", "active",
		"joined" })
public class Customer {

	private int id;
	private String name;
	private String phone;
	private String about;
	private int age;
	private BigDecimal balance;
	private boolean active;
	private Date joined;

	public static final String ID = "id", //
			NAME = "name", //
			PHONE = "phone", //
			ABOUT = "about", //
			AGE = "age", //
			BALANCE = "balance", //
			ACTIVE = "active", //
			JOINED = "joined";

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}
}
