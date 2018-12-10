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
import ar.sarm.unq.sga.wicket.userstory.VerDetalleUserStoryPage;

public class ListaDeSprintBacklogDeUnProyecto extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserStoryController userStoryController;

	@SpringBean
	private ProjectController projectController;

	private Backlog backlog;

	private Project proyecto;

	private UserStory userStory;

	public ListaDeSprintBacklogDeUnProyecto() {
		this.listaDeSprintBacklogDeUnProyecto();
		salir();
	}

	public ListaDeSprintBacklogDeUnProyecto(Project proy, UserStory user) {
		proyecto = proy;
		userStory = user;
		userStoryController.attach(user);
		projectController.attach(proy);
		userStoryController.setUserStory(user);
		projectController.setSprintBacklog(user.getSprintBacklog());

		this.listaDeSprintBacklogDeUnProyecto();
		salir();
	}

	public ListaDeSprintBacklogDeUnProyecto(Project proy) {
		proyecto = proy;
		projectController.attach(proy);
		projectController.setProject(proy);
		userStoryController.setProject(proy);
		this.listaDeSprintBacklogDeUnProyecto();
		salir();
	}

	public <T> void listaDeSprintBacklogDeUnProyecto() {
		this.add(new ListView<SprintBacklog>("sublistaSprintBacklogCompletados",
				new PropertyModel<>(this.projectController, "getSprintBacklogsAbiertos")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<SprintBacklog> item) {
				CompoundPropertyModel<SprintBacklog> sprintBacklog = new CompoundPropertyModel<>(item.getModel());
				item.add(new Label("nombre", sprintBacklog.bind("getNombreSprintBacklog")));

				item.add(new Link<String>("listaDeUSSB") {

					@Override
					public void onClick() {
						this.setResponsePage(new SprintBacklogPage(proyecto, item.getModelObject()));

					}

				});
				 item.add(new Link<String>("verDetalleUserStory") {
					 private static final long serialVersionUID = 1L;
					
					 @Override
					 public void onClick() {
					 this.setResponsePage(new VerDetalleUserStoryPage());
					
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
