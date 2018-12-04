package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

public class SprintBacklogPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserStoryController userStoryController;
	// cambie el nombre por userStoryController;
	@SpringBean
	private ProjectController projectController;
	@SpringBean
	private BacklogController backlogController;
	private Backlog backlog;
	private Project project;
	private UserStory user;

	private SprintBacklog sprintBacklog;

	public SprintBacklogPage(Project proyecto, SprintBacklog sprint) {
		project = proyecto;
		sprintBacklog = sprint;
		projectController.attach(proyecto);
		projectController.attach(sprint.getProyecto());
		projectController.setProject(proyecto);
		projectController.setSprintBacklog(sprintBacklog);
		this.agregarAUserStoryFormBacklogsCompletadas();
		salir();
		cerrar();
	}

	public SprintBacklogPage(Project proyecto, UserStory userStory) {
		project = proyecto;
		user = userStory;
		projectController.attach(proyecto);
		userStoryController.attach(userStory);
		userStoryController.setUserStory(userStory);
		projectController.setSprintBacklog(userStory.getSprintBacklog());
		projectController.setProject(proyecto);

		agregarAUserStoryFormBacklogsCompletadas();
		salir();
		cerrar();
	}

	public void agregarAUserStoryFormBacklogsCompletadas() {
		this.add(new ListView<UserStory>("sublistaSprintBacklogCompletados",
				new PropertyModel<>(this.projectController, "listaDeUserStoryEnSprintBacklog")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory> backlogCompletado = new CompoundPropertyModel<>(item.getModel());
				item.add(new Label("nombre", backlogCompletado.bind("nombreUserStory")));
				item.add(new Label("completa", backlogCompletado.bind("estaCompleta")));
				item.add(new Label("complejidad", backlogCompletado.bind("historyPoint")));

				item.add(new Link<String>("completarUserStory") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						SprintBacklogPage.this.userStoryController.completarUserStory(item.getModelObject());
					}

				});
			}
		});
	}

	private void salir() {
		this.add(new Link<String>("salir") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListProjectPage());

			}

		});

		this.add(new Label("total", projectController.getSumarComplejidad()));
		this.add(new Label("totalCompletas", projectController.getSumarComplejidadUSCompletas()));
	}
	private void cerrar() {
		this.add(new Link<String>("cerrar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				SprintBacklogPage.this.projectController.cerrarSprintBacklog();
				this.setResponsePage(new ListProjectPage());

			}

		});
	}
}