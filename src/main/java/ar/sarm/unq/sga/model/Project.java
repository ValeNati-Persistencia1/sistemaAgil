package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;

	@OneToOne(cascade = CascadeType.ALL)
	private Backlog backlog;

	@ManyToMany(mappedBy = "project")
	private List<Usuario> usuarios=new ArrayList<>();

	@OneToMany(mappedBy = "project")
	private List<SprintBacklog> sprintBacklogs;

	@OneToMany(mappedBy = "project")
	private List<Rol> roles;

	public Project() {
	}

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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuario(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}

	public void borrarUsuarioDelProyecto(Usuario user) {
		usuarios.remove(user);

	}

	public List<SprintBacklog> getSprintBacklogs() {
		return sprintBacklogs;
	}

	public void setSprintBacklogs(SprintBacklog sprintBacklog) {
		sprintBacklogs.add(sprintBacklog);
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	public void addRol(Rol rol){
		this.roles.add(rol);
	}

}
