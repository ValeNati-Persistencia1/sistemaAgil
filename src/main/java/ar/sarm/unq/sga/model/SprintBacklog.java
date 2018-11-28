package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SprintBacklog extends Persistible {

	private static final long serialVersionUID = 1L;
	@OneToMany
	private List<Backlog> backlogs = new ArrayList<>();

	private int posicion;

	@ManyToOne
	private Project project;

	private Boolean estado = false;

	public List<Backlog> getBacklog() {
		return backlogs;
	}

	public void setBacklog(List<Backlog> backlog) {
		this.backlogs = backlog;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public void setSprintBacklog(Backlog back) {
		this.backlogs.add(back);
	}

	public Project getProyecto() {
		return project;
	}

	public void setProyecto(Project proyecto) {
		this.project = proyecto;
	}

}
