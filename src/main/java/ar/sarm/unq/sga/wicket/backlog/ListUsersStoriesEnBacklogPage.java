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
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

public class ListUsersStoriesEnBacklogPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private BacklogController backlogController;
	@SpringBean
	private UserStoryController userStoryController;
	private UserStory userStory;
	private Backlog backlog;

	@SpringBean
	private ProjectController projectController;

	private Project project;

	public ListUsersStoriesEnBacklogPage() {
		this.crearForm();
		this.salir();
	}

	public ListUsersStoriesEnBacklogPage(Backlog back, UserStory us) {
		this.backlogController.attach(back);
		this.userStory = us;
		back.setUserStory(us);
		this.backlog = back;
		this.crearForm();
		// this.salir();
	}

	public ListUsersStoriesEnBacklogPage(UserStory us) {
		this.userStory = us;
		userStoryController.attach(us);
		userStoryController.setUserStory(us);
		this.crearForm();
		this.salir();
	}

	public ListUsersStoriesEnBacklogPage(Project proyecto) {
		projectController.attach(proyecto);
		projectController.setProject(proyecto);
		backlogController.setProyecto(proyecto);
		userStoryController.setProject(proyecto);
		project = proyecto;
		this.crearForm();
		this.salir();
	}

	private void crearForm() {
		this.add(new ListView<UserStory>("losUsersStoriesEnBacklog",
				new PropertyModel<>(this.projectController, "listaDeUserStoryDelProyecto")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory> us = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", us.bind("nombre")));
				item.add(new Label("completa", us.bind("estaCompleta")));

				item.add(new Link<String>("borrarUserStory") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {

					}

				});
				item.add(new Link<String>("agregarUserStoryASprint") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						ListUsersStoriesEnBacklogPage.this.userStoryController
								.agregarUsertStorieEnSprintBacklog(item.getModelObject());
						this.setResponsePage(new SprintBacklogPage(project));
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
	}

}
