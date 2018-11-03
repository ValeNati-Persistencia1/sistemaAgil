package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.springframework.beans.factory.annotation.Autowired;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;

public class AddBacklogPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@Autowired
	private BacklogController backlogController;
	
	@Autowired
	private ProjectController projectController;
	private Project proyecto;

	public AddBacklogPage(Project proy) {
		projectController.attach(proy);
		this.proyecto = proy;
		agregarForm();

	}

	public AddBacklogPage() {
		agregarForm();
	}

	private void agregarForm() {
		Form<BacklogController> crearNuevoProyectoBacklogForm = new Form<BacklogController>("crearBacklogForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				AddBacklogPage.this.backlogController.agregarBacklog();
				 this.setResponsePage(new ListProjectPage());

			}
		};

		crearNuevoProyectoBacklogForm
				.add(new TextField<>("nombre", new PropertyModel<>(this.backlogController, "nombre")));

		crearNuevoProyectoBacklogForm
				.add(new TextArea<>("descripcion", new PropertyModel<>(this.backlogController, "descripcion")));

		crearNuevoProyectoBacklogForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				// this.setResponsePage(new BacklogPage());

			}

		});

		this.add(crearNuevoProyectoBacklogForm);

	}
}
