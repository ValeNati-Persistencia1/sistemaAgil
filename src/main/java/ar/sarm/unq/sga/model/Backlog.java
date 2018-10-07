package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Backlog extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;
	
	@OneToMany(mappedBy="backlog", cascade= CascadeType.PERSIST)
	private List<UserStory>userStories=new ArrayList<>();

	public Backlog(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	
	

}
