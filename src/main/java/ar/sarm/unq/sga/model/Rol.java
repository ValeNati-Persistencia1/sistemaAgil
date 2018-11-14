package ar.sarm.unq.sga.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
@Entity
public class Rol extends Persistible {

	static final long serialVersionUID = 1L;

	@ManyToOne
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
