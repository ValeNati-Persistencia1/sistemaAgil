package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;

import ar.sarm.unq.sga.model.Project;

public class ProjectController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	public ProjectController(){
		
	}
	public ProjectController(String name){
		this.nombre=name;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarProjecto(){
		Project projecto=new Project(getNombre());
		ProjectStore.elunico().agregarProject(projecto);
	}
	
}
