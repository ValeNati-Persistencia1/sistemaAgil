package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;

import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.Project;

public class ProjectController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	@SpringBean(name= "project")
	private Home<Project> projectStore;
	
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
//arreglado con leo
	public void agregarProjecto(){
		Project projecto=new Project(getNombre());
		projectStore.insert(projecto);
	}
	
}
