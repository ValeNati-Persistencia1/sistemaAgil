package ar.sarm.unq.sga.model;

import javax.persistence.Entity;

@Entity
public class Project extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private Backlog backlog;

	public Project(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	
}
