package swing.demo10;

import java.io.Serializable;

public class AgeCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String description;

	public AgeCategory(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}
