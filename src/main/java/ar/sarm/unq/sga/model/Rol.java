package ar.sarm.unq.sga.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class Rol extends Persistible {

	static final long serialVersionUID = 1L;

	@ManyToOne
	private Project project;
	
	private String nombreRol;

	
	public Rol (String nombre){
		this.nombreRol=nombre;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombre) {
		this.nombreRol = nombre;
	}

	


	

}
