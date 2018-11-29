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
	private List<UserStory> listaUserStory = new ArrayList<>();

	private int posicion;

	@ManyToOne
	private Project project;

	private Boolean estado = false;

	private String nombreSprintBacklog;

	public SprintBacklog() {

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

	public Project getProyecto() {
		return project;
	}

	public void setProyecto(Project proyecto) {
		this.project = proyecto;
	}

	public List<UserStory> getListaUserStory() {
		return listaUserStory;
	}

	public void setListaUserStory(List<UserStory> listaUserStory) {
		this.listaUserStory = listaUserStory;
	}

	public String getNombreSprintBacklog() {
		return nombreSprintBacklog;
	}

	public void setNombreSprintBacklog(String nombre) {
		this.nombreSprintBacklog = nombre;
	}

}
