package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Project extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;
	@OneToOne
	private Backlog backlog;
	
	@ManyToMany
	private List<Developer> developers = new ArrayList<>();
//	@Enumerated(EnumType.STRING)
//	private TipoRol tipoRol;
//	@OneToMany
//	private List<Rol> roles = new ArrayList<>();

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

//	public List<Rol> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Rol> roles) {
//		this.roles = roles;
//	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

	// public Rol getRol() {
	// return rol;
	// }
	//
	// public void setRol(Rol rol) {
	// this.rol = rol;
	// }

}
