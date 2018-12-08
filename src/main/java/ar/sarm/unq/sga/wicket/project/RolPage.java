package ar.sarm.unq.sga.wicket.project;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.HomePage;

public class RolPage extends WebPage{

	@SpringBean 
	private ProjectController projectController;
	private Project proy;
	private Project project;
	public RolPage(){
		agregarForm();
	}
	
	public RolPage(Project proy) {
		project= proy;
		projectController.attach(project);
		projectController.setProject(project);
		agregarForm();
	}

	private void agregarForm() {
		Form<ProjectController> crearProjectForm = new Form<ProjectController>("crearProjectForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				RolPage.this.projectController.agregarRol();
				this.setResponsePage(new ListProjectPage());
			}

		};
		crearProjectForm.add(new TextField<>("nombre", new PropertyModel<>(this.projectController, "nombreRol")));

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
