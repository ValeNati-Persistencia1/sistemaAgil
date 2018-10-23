package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.Project;

@Controller
public class ProjectController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	@Autowired
	private ProjectStore projectStore;
	
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
		Project proyecto=new Project(getNombre());
		projectStore.insert(proyecto);
	}
	
	public List<Project>getProyectos(){
		
		return null ;//projectStore.proyectos();
	}
}
