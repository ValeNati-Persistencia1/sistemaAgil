package ar.sarm.unq.sga.wicket.backlog;

import java.io.Serializable;

import ar.sarm.unq.sga.model.Project;

public class BacklogController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Project proyecto;

	public BacklogController() {
	}
	
	public BacklogController(Project _proyecto){
		this.proyecto=_proyecto;
	}

	public Project getProyecto() {
		return proyecto;
	}

	public void setProyecto(Project proyecto) {
		this.proyecto = proyecto;
	}
	
}