package ar.sarm.unq.sga.wicket.backlog;

import java.io.Serializable;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;

public class BacklogController implements Serializable {

	private static final long serialVersionUID = 1L;
	// private Project proyecto;

	private String nombre;

	public BacklogController() {
	}

	public BacklogController(String backlog) {
		this.nombre = backlog;
	}

	// public BacklogController(Project _proyecto){
	// this.proyecto=_proyecto;
	// }
	//
	// public Project getProyecto() {
	// return proyecto;
	// }
	//
	// public void setProyecto(Project proyecto) {
	// this.proyecto = proyecto;
	// }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarBacklog() {
		Backlog backlog = new Backlog(getNombre());
		BacklogStore.elunico().agregarBacklog(backlog);
	}
}