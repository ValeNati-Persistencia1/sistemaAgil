package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends Persistible {

	private static final long serialVersionUID = 1L;
	private String apellido;
	 private String nombreUsuario;
	@ManyToMany
	private List<Project> project = new ArrayList<Project>();
	@OneToMany
	private List<UserStory> usersStories = new ArrayList<>();

		
	public Usuario(String nombre, String apellido) {
		this.nombreUsuario = nombre;
		this.apellido = apellido;
	}

	public Usuario() {

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombre) {
		this.nombreUsuario = nombre;
	}

	public List<Project> getProyectos() {
		return project;
	}

	public void addProyecto(Project proyecto) {
		this.project.add(proyecto);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellidoNombre() {
		return apellido + nombreUsuario;
	}

	public void borrarProyecto(Project proyecto) {
		this.project.remove(proyecto);
	}

	public List<UserStory> getUsersStories() {
		return usersStories;
	}

	public void setUsersStories(List<UserStory> usersStories) {
		this.usersStories = usersStories;
	}

	// public void setProyecto(Project proy) {
	// this.proyecto=proy;
	//
	// }

}
