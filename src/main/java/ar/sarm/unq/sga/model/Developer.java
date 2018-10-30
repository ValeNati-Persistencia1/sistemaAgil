package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Developer extends Persistible{
	
	private static final long serialVersionUID = 1L;
	

	private String nombre;
	
	@ManyToMany
	private List<Project>proyectos=new ArrayList<>();
	
	public Developer(String nombre){
		this.nombre=nombre;
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

	public void setProjects(List<Project> proyectos) {
		this.proyectos = proyectos;
	}



}
