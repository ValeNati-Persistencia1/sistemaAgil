package ar.sarm.unq.sga.wicket.project;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import ar.sarm.unq.sga.model.Project;



public class ProjectPage extends WebPage{
	private ProjectController controller=new ProjectController();
	
	public ProjectPage(){
		
	}
	
	
	private void agregarForm() {
		Form<ProjectController> crearAlumnoForm = new Form<ProjectController>("crearProjectForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
				ProjectPage.this.controller.agregarProjecto();
			
			}	
			
		};
					
		crearAlumnoForm.add(new TextField<>("nombre", new PropertyModel<>(this.controller, "nombre")));

}
}
