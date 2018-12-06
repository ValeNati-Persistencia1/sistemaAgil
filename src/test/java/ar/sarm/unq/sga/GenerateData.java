package ar.sarm.unq.sga;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
import ar.sarm.unq.sga.wicket.backlog.SprintBacklogPage;
import ar.sarm.unq.sga.wicket.backlog.SprintBacklogStore;
import ar.sarm.unq.sga.wicket.project.ProjectStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;
import ar.sarm.unq.sga.wicket.usuario.UsuarioStore;

@Component
@Transactional
public class GenerateData {

	@Autowired
	private ProjectStore projectStore;

	@Autowired
	private UsuarioStore usuarioStore;

	@Autowired
	private UserStoryStore userStoryStore;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BacklogStore backlogStore;

	@Autowired
	private SprintBacklogStore sprintBacklogStore;

	protected void generate() {
		List<Usuario> usuarios = new ArrayList();
		Backlog back = new Backlog("el back");

		Project proyecto = new Project("proyectito2");
		Project proy = new Project("proyecto3");

		Usuario usuario = new Usuario("lara", "larroque");
		Usuario usuario2 = new Usuario("Brisa", "rivarola");
		Usuario usuario3 = new Usuario("francisco", "barreto");

		UserStory us = new UserStory("userstory");
		usuario3.addProyecto(proyecto);
		usuario2.addProyecto(proyecto);
		proyecto.setUsuario(usuario2);
		proyecto.setUsuario(usuario3);
		proyecto.setBacklog(back);
		usuario.setProyecto(proyecto);
		SprintBacklog sp = new SprintBacklog();
		us.setHistoryPoint(4);
		sp.setSumatoriaComplejidad(sp.getSumatoriaComplejidad());
		
		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();

		projectStore.insert(proyecto);
		projectStore.insert(proy);
		backlogStore.insert(back);
		usuarioStore.insert(usuario);
		usuarioStore.insert(usuario2);
		usuarioStore.insert(usuario3);
		userStoryStore.insert(us);

		ts.commit();
	}
}
