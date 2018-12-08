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
<<<<<<< HEAD
	// private String nombreUsuario;
	private String nombre;
	@ManyToMany
	private List<Project> project = new ArrayList<Project>();
	@OneToMany
	private List<UserStory> usersStories = new ArrayList<>();

=======
    private String nombre;
	@ManyToMany
	private List<Project> project = new ArrayList<Project>();
	@OneToMany
    private List<UserStory> usersStories=new ArrayList<>();
		
>>>>>>> f9e8b3715441d491814c2717f42c91aa7dcbd625
	public Usuario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario() {

	}

	public String getNombreUsuario() {
		return nombre;
	}

	public void setNombreUsuario(String nombre) {
		this.nombre = nombre;
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
		return apellido + nombre;
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
