package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario extends Persistible {

	private static final long serialVersionUID = 1L;
	private String apellido;
	private String nombre;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Project> project = new ArrayList<Project>();

	@OneToOne
	private Project proyecto;

	public Usuario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
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

	public void setProyecto(Project proyec) {
		proyecto = proyec;

	}

	public Project getProyecto() {
		return proyecto;
	}

}
