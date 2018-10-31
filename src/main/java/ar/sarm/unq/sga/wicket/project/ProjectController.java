package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Project;

@Controller
@Transactional
public class ProjectController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;

	@Autowired
	private ProjectStore projectStore;

	private Project proyecto;

	private String message;

	public ProjectController() {

	}

	public ProjectController(String name) {
		this.nombre = name;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public Project getProyectoNombre() {
//		return this.findByName();
//	}

	// arreglado con leo
	public void agregarProyecto() {
		Project proyecto = new Project(getNombre());
		projectStore.agregarProject(proyecto);
	}

	public List<Project> getProyectos() {
		return projectStore.getProyectos();
	}

	public Project findByName() {
		try{
			this.setMessage(null);
			proyecto=projectStore.findByName(getNombre());
	}
		catch (Exception e) {
			setMessage("no existe el objeto");// TODO: handle exception
			proyecto=null;
		}
		return proyecto;
	}
	public void attach(Project proy) {
		projectStore.attach(proy);
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
