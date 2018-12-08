package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SprintBacklog extends Persistible {

	private static final long serialVersionUID = 1L;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sprintBacklog", cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "sprintBacklog", cascade = CascadeType.ALL)
	public List<UserStory> listaUserStory = new ArrayList<>();

	@ManyToOne
	private Project project;

	private Boolean estadoAbierto = true;

	private String nombreSprintBacklog;

	private int sumatoriaComplejidad;

	public SprintBacklog() {

	}

	public Boolean getEstadoAbierto() {
		return estadoAbierto;
	}

	public void setEstadoAbierto(Boolean estado) {
		this.estadoAbierto = estado;
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

	public void addListaUserStory(UserStory userStory) {
		this.listaUserStory.add(userStory);
	}

	public String getNombreSprintBacklog() {
		return nombreSprintBacklog;
	}

	public void setNombreSprintBacklog(String nombre) {
		this.nombreSprintBacklog = nombre;
	}

	public int getSumatoriaComplejidad() {
		return getListaUserStory().stream().mapToInt(us -> us.getHistoryPoint()).sum();

	}

	public void setSumatoriaComplejidad(int sumatoriaComplejidad) {
		this.sumatoriaComplejidad = sumatoriaComplejidad;
	}

	public int getSumatoriaComplejidadUsCompletas() {
		return getListaUserStory().stream().filter(us -> us.isEstaEnBacklogSprint() == true)
				.mapToInt(us -> us.getHistoryPoint()).sum();
	}

	public List<UserStory> getListaUserStoryIncompletas() {
		return listaUserStory.stream().filter(us -> us.getEstaCompleta() == false).collect(Collectors.toList());
	}

	public List<UserStory> getListaUserStoryCompletas() {
		return listaUserStory.stream().filter(us -> us.getEstaCompleta() == true).collect(Collectors.toList());
	}

}
