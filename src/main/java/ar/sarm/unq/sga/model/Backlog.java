package ar.sarm.unq.sga.model;

import javax.persistence.Entity;

@Entity
public class Backlog extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;

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

}
