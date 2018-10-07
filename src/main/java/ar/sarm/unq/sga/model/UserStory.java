package ar.sarm.unq.sga.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserStory extends Persistible{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private int valorCliente;
//	
//	private int historiePoint;
//	
//	private boolean estaCompleta;
//	
//	private Developer Developer;
	
	private String nombre;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn
	private Backlog backlog;
	
	public UserStory(String nombre){
		this.nombre=nombre;
	}
	
//	public UserStory(int _valorCliente, int _historiePoint, boolean _estaCompleta, Developer _developer){
//		this.valorCliente= _valorCliente;
//		this.historiePoint= _historiePoint;
//		this.estaCompleta=_estaCompleta;
//		this.Developer= _developer;
//	}
//
//	public int getValorCliente() {
//		return valorCliente;
//	}
//
//	public void setValorCliente(int valorCliente) {
//		this.valorCliente = valorCliente;
//	}
//
//	public int getHistoriePoint() {
//		return historiePoint;
//	}
//
//	public void setHistoriePoint(int historiePoint) {
//		this.historiePoint = historiePoint;
//	}
//
//	public boolean isEstaCompleta() {
//		return estaCompleta;
//	}
//
//	public void setEstaCompleta(boolean estaCompleta) {
//		this.estaCompleta = estaCompleta;
//	}
//
//	public Developer getDeveloper() {
//		return Developer;
//	}
//
//	public void setDeveloper(Developer developer) {
//		Developer = developer;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	
	

}
