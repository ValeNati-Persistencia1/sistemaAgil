package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Usuario extends Persistible {

	private static final long serialVersionUID = 1L;

	private String apellido;
	private String nombre;
	@Transient
	@ManyToMany
	private List<Project> proyectos = new ArrayList<>();

	@ManyToOne
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
		return proyectos;
	}

	public void setProyectos(List<Project> proyectos) {
		this.proyectos = proyectos;
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

	public Project getProyecto() {
		return proyecto;
	}

	public void setProyecto(Project proyecto) {
		this.proyecto = proyecto;
	}

}