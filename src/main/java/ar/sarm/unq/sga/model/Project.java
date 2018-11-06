package ar.sarm.unq.sga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;

	@OneToOne(cascade = CascadeType.REMOVE)
	private Backlog backlog;
<<<<<<< HEAD
	// @ManyToMany
	@OneToMany
	private List<Usuario> usuarios = new ArrayList<>();
=======
<<<<<<< HEAD
//	@ManyToMany
	@OneToMany
	private List<Usuario> usuarios = new ArrayList<>();
=======
	@Transient
	@ManyToMany
	private List<Usuario> developers = new ArrayList<>();
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324
	// @Enumerated(EnumType.STRING)
	// private TipoRol tipoRol;
	// @OneToMany
	// private List<Rol> roles = new ArrayList<>();
	@OneToOne
	private Usuario usuario;

	public Project() {
	}

	public Project(String nombre) {
		this.nombre = nombre;
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

	// public List<Rol> getRoles() {
	// return roles;
	// }
	//
	// public void setRoles(List<Rol> roles) {
	// this.roles = roles;
	// }
<<<<<<< HEAD

=======
	


<<<<<<< HEAD
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
<<<<<<< HEAD
=======
=======
	public List<Usuario> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Usuario> developers) {
		this.developers = developers;
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324
	}

	// public Rol getRol() {
	// return rol;
	// }
	//
	// public void setRol(Rol rol) {
	// this.rol = rol;
	// }

}
