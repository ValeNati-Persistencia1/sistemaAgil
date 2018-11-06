package ar.sarm.unq.sga.model;

import java.io.IOException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UserStory extends Persistible{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int valorCliente;
	
	private int historiePoint;
	
	private boolean estaCompleta;
	
<<<<<<< HEAD
	private Usuario usuario;
=======
	private Usuario Developer;
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
	
	private String nombre;
	@Column(name="descripcion", nullable=true, length=1000)
	private String descripcion;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	private Backlog backlog;
	
	public UserStory(){
		
	}
	public UserStory(String nombre){
		this.nombre=nombre;
	}
	
<<<<<<< HEAD
	public UserStory(int _valorCliente, int _historiePoint, boolean _estaCompleta, Usuario _usuario){
=======
	public UserStory(int _valorCliente, int _historiePoint, boolean _estaCompleta, Usuario _developer){
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
		this.valorCliente= _valorCliente;
		this.historiePoint= _historiePoint;
		this.estaCompleta=_estaCompleta;
		this.usuario= _usuario;
	}

	public int getValorCliente() {
		return valorCliente;
	}

	public void setValorCliente(int valorCliente) {
		this.valorCliente = valorCliente;
	}

	public int getHistoriePoint() {
		return historiePoint;
	}

	public void setHistoriePoint(int historiePoint) {
		this.historiePoint = historiePoint;
	}

	public boolean isEstaCompleta() {
		return estaCompleta;
	}

	public void setEstaCompleta(boolean estaCompleta) {
		this.estaCompleta = estaCompleta;
	}

<<<<<<< HEAD
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		usuario = usuario;
=======
	public Usuario getDeveloper() {
		return Developer;
	}

	public void setDeveloper(Usuario developer) {
		Developer = developer;
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
	}

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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion){
	    this.descripcion = descripcion;

	}

}
