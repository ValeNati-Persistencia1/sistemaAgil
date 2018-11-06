package ar.sarm.unq.sga.wicket.project;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.backlog.BacklogController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;

public class ProjectPage extends WebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;
	@SpringBean
	private BacklogController backlogController;

	private Project proy;
	private Backlog back;

	@SuppressWarnings("serial")
	public ProjectPage() {
		agregarForm();
	}

	private void agregarForm() {
		Form<ProjectController> crearProjectForm = new Form<ProjectController>("crearProjectForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				ProjectPage.this.projectController.agregarProyecto();
				this.setResponsePage(new ListProjectPage());

			}

		};
		crearProjectForm.add(new TextField<>("nombre", new PropertyModel<>(this.projectController, "nombre")));
		crearProjectForm.add(new Link<String>("cancelar") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
			}

		});
		this.add(crearProjectForm);
	}
}
