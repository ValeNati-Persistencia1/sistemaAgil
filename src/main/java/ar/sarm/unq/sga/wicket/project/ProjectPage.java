package ar.sarm.unq.sga.wicket.project;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.springframework.beans.factory.annotation.Autowired;

import ar.sarm.unq.sga.wicket.HomePage;


public class ProjectPage extends WebPage{
	@Autowired
	private ProjectController projectController;
	
	public ProjectPage(){
		agregarForm();
	}
	
	
	private void agregarForm() {
		Form<ProjectController> crearProjectForm = new Form<ProjectController>("crearProjectForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				ProjectPage.this.projectController.agregarProjecto();
				this.setResponsePage(new HomePage());
			
			}	
			
		};
					
		crearProjectForm.add(new TextField<>("nombre", new PropertyModel<>(/* */ , "nombre")));

		crearProjectForm.add(new Link<String>("cancelar"){

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
