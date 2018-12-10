package ar.sarm.unq.sga.wicket.project;

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
import ar.sarm.unq.sga.wicket.backlog.BacklogController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

public class SprintBacklogConTodasLasUsersStoriesPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private UserStoryController userStoryController;
	@SpringBean
	private ProjectController projectController;

	@SpringBean
	private BacklogController backlogController;

	private Backlog backlog;

	private Project project;

	private UserStory user;

	private SprintBacklog sprintBacklog;

	public SprintBacklogConTodasLasUsersStoriesPage(Project proyecto, SprintBacklog sprint) {
		project = proyecto;
		sprintBacklog = sprint;
		projectController.attach(proyecto);
		projectController.attach(sprint.getProyecto());
		projectController.setProject(proyecto);
		projectController.setSprintBacklog(sprintBacklog);
		agregarAUserStoryFormBacklogsCompletadas();
		salir();
	}

	public SprintBacklogConTodasLasUsersStoriesPage(UserStory userStory) {
		user = userStory;
		projectController.attach(project);
		userStoryController.attach(userStory);
		userStoryController.setUserStory(userStory);
		projectController.setSprintBacklog(userStory.getSprintBacklog());
		projectController.setProject(project);
		this.agregarAUserStoryFormBacklogsCompletadas();
		salir();
	}

	public void agregarAUserStoryFormBacklogsCompletadas() {
		this.add(new ListView<UserStory>("usersStoriesEnSprint",
				new PropertyModel<>(this.projectController, "sprintBacklog.getListaUserStory")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory> historia = new CompoundPropertyModel<>(item.getModel());
				item.add(new Label("nombre", historia.bind("nombreUserStory")));
				item.add(new Label("completa", historia.bind("isEstaCompleta")));
				item.add(new Label("complejidad", historia.bind("historyPoint")));

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

}
