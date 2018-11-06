package ar.sarm.unq.sga.wicket.project;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jetty.security.UserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
<<<<<<< HEAD
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;
import ar.sarm.unq.sga.wicket.usuario.UsuarioController;
import ar.sarm.unq.sga.wicket.usuario.UsuarioStore;
=======
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.backlog.BacklogController;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd

@Controller
@Transactional
public class ProjectController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
    @Autowired 
    private UserStoryStore userStoryStore;  //agregado
	@Autowired
	private ProjectStore projectStore;
	
	@Autowired
	private BacklogStore backlogStore;
	
	@Autowired
	private UsuarioStore usuarioStore;
	
	private Backlog backlog;

	private Project proyecto;

	private String message;

	public ProjectController() {

	}

	public ProjectController(String name) {
		this.nombre = name;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// public Project getProyectoNombre() {
	// return this.findByName();
	// }

	// arreglado con leo
	public void agregarProyecto() {
		Project proyecto = new Project(getNombre());
		Backlog back= new Backlog("Backlog");
		projectStore.agregarProject(proyecto);
		backlogStore.agregarBacklogStore(back);
		proyecto.setBacklog(back);
	}

	public List<Project> getProyectos() {
		return projectStore.getProyectos();
	}

	public Project findByName() {
		try {
			this.setMessage(null);
			proyecto = projectStore.findByName(getNombre());
		} catch (Exception e) {
			setMessage("no existe el objeto");// TODO: handle exception
			proyecto = null;
		}
		return proyecto;
	}

	public void attach(Project proy) {
		projectStore.attach(proy);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Backlog getBacklog(Project proy) {
		projectStore.attach(proy);
		return proy.getBacklog();
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	public String nombreBacklog(){
		return this.proyecto.getBacklog().getNombre();
	}

	public void borrarProyecto(Project proy) {
		projectStore.deleteProject(proy);
		
	}

<<<<<<< HEAD
	public List<Usuario> mostrarUsuarios(Project proyecto) {
		projectStore.attach(proyecto);
		return usuarioStore.verUsuarios(proyecto);
=======
	public void addUserStory(UserStory us) { //agregado
     userStoryStore.insert(us);
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
	}
}
