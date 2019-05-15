package aca.bloger.domen;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private int id;
	private String value;
	@ManyToMany
	private Set<Artical> artical;
	
	public Tag() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<Artical> getArtical() {
		return artical;
	}

	public void setArtical(Set<Artical> artical) {
		this.artical = artical;
	}
	
	
	
}
