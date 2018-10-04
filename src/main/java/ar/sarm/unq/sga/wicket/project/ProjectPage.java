package ar.sarm.unq.sga.wicket.project;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import ar.sarm.unq.sga.wicket.HomePage;



public class ProjectPage extends WebPage{
	private ProjectController controller=new ProjectController();
	
	public ProjectPage(){
		agregarForm();
	}
	
	
	private void agregarForm() {
		Form<ProjectController> crearProjectForm = new Form<ProjectController>("crearProjectForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				ProjectPage.this.controller.agregarProjecto();
				this.setResponsePage(new HomePage());
			
			}	
			
		};
					
		crearProjectForm.add(new TextField<>("nombre", new PropertyModel<>(this.controller, "nombre")));

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
