package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SprintBacklog extends Persistible {

	private static final long serialVersionUID = 1L;
	@OneToMany
	private List<UserStory> listaUserStory = new ArrayList<>();

	@ManyToOne
	private Project project;

	private Boolean estado = false;

	private String nombreSprintBacklog;

	public SprintBacklog() {

	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Project getProyecto() {
		return project;
	}

	public void setProyecto(Project proyecto) {
		this.project = proyecto;
	}

	public List<UserStory> getListaUserStory() {
		return listaUserStory;
	}

	public void setListaUserStory(UserStory userStory) {
		this.listaUserStory.add(userStory);
	}

	public String getNombreSprintBacklog() {
		return nombreSprintBacklog;
	}

	public void setNombreSprintBacklog(String nombre) {
		this.nombreSprintBacklog = nombre;
	}

}
