package ar.sarm.unq.sga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class UserStory extends Persistible {

	private static final long serialVersionUID = 1L;

	@Column(name = "valorCliente", nullable = true, length = 10)
	private String valorCliente;

	@Column(name = "historyPoint", nullable = true, length = 10)
	private int historyPoint;

	@OrderBy("estacompleta = true")
	public boolean estaCompleta = false;

	@ManyToOne
	private Usuario usuario;

	private String nombreUserStory;

	@Column(name = "descripcion", nullable = true, length = 1000)
	private String descripcion;

	@ManyToOne
	private Backlog backlog;

	@ManyToOne
	private Project project;

	@ManyToOne
	private SprintBacklog sprintBacklog;
	private boolean estaEnBacklogSprint = false;

	private Rol rol;
    

	public UserStory() {

	}

	public UserStory(String nombre) {
		this.nombreUserStory = nombre;
	}

	public UserStory(String _valorCliente, int _historiePoint, boolean _estaCompleta, Usuario _usuario) {
		this.valorCliente = _valorCliente;
		this.historyPoint = _historiePoint;
		this.estaCompleta = _estaCompleta;
		this.usuario = _usuario;
	}

	public String getValorCliente() {
		return valorCliente;
	}

	public void setValorCliente(String valorCliente) {
		this.valorCliente = valorCliente;
	}

	public String isEstaCompleta() {
		if (estaCompleta == true) {
			return "Completa";
		} else {

			return "Incompleta";
		}
	}

	
	public void setEstaCompleta(boolean estaCompleta) {
		this.estaCompleta = estaCompleta;
	}

	public boolean estaCompleta() {
		return estaCompleta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}

	public String getNombreUserStory() {
		return nombreUserStory;
	}

	public void setNombreUserStory(String nombre) {
		this.nombreUserStory = nombre;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;

	}

	public int getHistoryPoint() {
		return historyPoint;
	}

	public void setHistoryPoint(int historyPoint) {
		this.historyPoint = historyPoint;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public SprintBacklog getSprintBacklog() {
		return sprintBacklog;
	}

	public void setSprintBacklog(SprintBacklog sprintBacklog) {
		this.sprintBacklog = sprintBacklog;
	}

	public boolean isEstaEnBacklogSprint() {
		return estaEnBacklogSprint;
	}

	public void setEstaEnBacklogSprint(boolean estaEnBacklogSprint) {
		this.estaEnBacklogSprint = estaEnBacklogSprint;
	}

	public boolean getEstaEnBacklogSprint() {
		return estaEnBacklogSprint;
	}
	
	public Rol getRol(){
		return this.rol;
	}

	public void setRol(Rol rol) {
	   this.rol=rol;
		
	}

	
	
	

	
}
