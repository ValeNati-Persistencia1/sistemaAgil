package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;
import ar.sarm.unq.sga.wicket.project.ProjectPage;
import ar.sarm.unq.sga.wicket.usuario.UsuarioController;

public class CrearSprintBacklogPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private ProjectController projectController;

	private Project proyecto;

	public CrearSprintBacklogPage(Project proyec) {
		projectController.setProject(proyec);
		agregarForm();
	}

	public CrearSprintBacklogPage() {
		agregarForm();
	}

	private void agregarForm() {
		Form<ProjectController> crearProjectForm = new Form<ProjectController>("crearProjectForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				CrearSprintBacklogPage.this.projectController.crearSprintBacklog();
				this.setResponsePage(new ListProjectPage());
			}

		};
		crearProjectForm
				.add(new TextField<>("nombre", new PropertyModel<>(this.projectController, "nombreSprintBacklog")));

		crearProjectForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
			}

		});

		this.add(crearProjectForm);
	}
}
