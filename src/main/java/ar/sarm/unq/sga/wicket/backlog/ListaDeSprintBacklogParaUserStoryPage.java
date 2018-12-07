package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.SprintBacklog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;
import ar.sarm.unq.sga.wicket.project.ProjectPage;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

public class ListaDeSprintBacklogParaUserStoryPage extends WebPage {

	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;
	@SpringBean
	private UserStoryController userStoryController;// esto lo agrego vale
	private Project proyecto;
	private UserStory userStory;

	public ListaDeSprintBacklogParaUserStoryPage(Project proyecto) {
		this.projectController.setProject(proyecto);
		proyecto.getSprintBacklogs();
		this.agregarForm();
	}

	public ListaDeSprintBacklogParaUserStoryPage(Project proyec, UserStory user) {
		proyecto = proyec;
		userStory = user;
		projectController.attach(proyec);
		this.projectController.setProject(proyec);
		this.projectController.setBacklog(user.getBacklog());
		this.projectController.setProject(user.getProject());

		proyec.getSprintBacklogs();
		this.agregarForm();
	}

	private void agregarForm() {
		this.add(new Label("nombre", userStory.getNombreUserStory()));
		Form<ProjectController> crearSprintForm = new Form<ProjectController>("crearSprintForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				ListaDeSprintBacklogParaUserStoryPage.this.projectController
						.agregarUsertStorieEnSprintBacklog(userStory);
				this.setResponsePage(new SprintBacklogPage(proyecto, userStory));

			}

		};

		crearSprintForm
				.add(new DropDownChoice<>("proyecto", new PropertyModel<>(this.projectController, "sprintBacklog"),
						new PropertyModel<>(this.projectController, "sprintBacklogsCerrados"),
						new ChoiceRenderer<>("getNombreSprintBacklog")));

		crearSprintForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
			}

		});

		this.add(crearSprintForm);
	}
}
