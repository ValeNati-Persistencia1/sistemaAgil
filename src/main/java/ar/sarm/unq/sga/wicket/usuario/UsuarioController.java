package ar.sarm.unq.sga.wicket.usuario;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.project.ProjectStore;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombreUsuario;
	private String apellido;
	@Autowired
	private UsuarioStore usuarioStore;

	@Autowired
	private ProjectStore projectStore;

	private Usuario usuario;

	private Project proyecto;

	public UsuarioController(Project proy, Usuario user) {
		projectStore.attach(proy);
		usuarioStore.attach(user);
		this.proyecto = proy;
		this.usuario = user;
	}

	public UsuarioController() {

	}

	public UsuarioController(String nombre, String apellido) {
		this.nombreUsuario = nombre;
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombre) {
		this.nombreUsuario = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	 public void agregarUsuario() {
	 Usuario dev = new Usuario();
	 dev.setNombreUsuario(nombreUsuario);
	 dev.setApellido(apellido);
	 dev.setProyecto(proyecto);
	 usuarioStore.insert(dev);
	
	 }
//	public void agregarUsuario() {
//		projectStore.attach(proyecto);
//		usuarioStore.attach(usuario);
//		usuario=new Usuario();
//		usuario.setNombreUsuario(nombreUsuario);
//		usuario.setApellido(apellido);
//		usuarioStore.insert(usuario);
//		usuario.setProyecto(proyecto);
//		proyecto.setUsuario(usuario);
//	}

	public void attach(Usuario developer) {
		usuarioStore.attach(developer);

	}

	public List<Usuario> getUsuarios() {
		return usuarioStore.getVerUsuario(proyecto);
	}

	public void borrarUsuario(Usuario dev) {
		usuarioStore.update(dev);

	}

	public List<Usuario> getListadoDeUsuarios() {
		return usuarioStore.getListadoDeUsaurios();
	}

	public void agregarProyectoAlUsuario(Project modelObject, Usuario user) {
		projectStore.attach(modelObject);
		usuarioStore.attach(user);
		user.addProyecto(modelObject);
		modelObject.setUsuario(user);

	}

	public List<Project> listaDeProyectosDelUsuario() {
		usuarioStore.attach(usuario);
		return usuario.getProyectos();
	}

	public void setUsuario(Usuario usuario2) {
		usuario = usuario2;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void borrarUsuario(Project proy) {
		proy.getUsuarios().forEach(p -> p.addProyecto(null));

	}

}
