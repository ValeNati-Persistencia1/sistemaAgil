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
<<<<<<< HEAD
=======
import ar.sarm.unq.sga.wicket.backlog.BacklogController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;
<<<<<<< HEAD
import ar.sarm.unq.sga.wicket.userstory.UserStoryPageV;
=======
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd
>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324

public class ProjectPage extends WebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;

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
<<<<<<< HEAD
				this.setResponsePage(new ListProjectPage());
=======
<<<<<<< HEAD
				this.setResponsePage(new UserStoryPage());
=======
				this.setResponsePage(new ListProjectPage());
>>>>>>> d99656b8b1b15837ddbbe47da59d961673fa22fd

>>>>>>> 8a7d54169c7d1e0e3ea9a616f849a1c0fb25c324
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
