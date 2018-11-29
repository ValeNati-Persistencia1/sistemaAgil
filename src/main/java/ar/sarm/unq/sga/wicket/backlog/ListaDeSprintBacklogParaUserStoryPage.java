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
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;
import ar.sarm.unq.sga.wicket.project.ProjectPage;

public class ListaDeSprintBacklogParaUserStoryPage extends WebPage{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private ProjectController projectController;
	
	public ListaDeSprintBacklogParaUserStoryPage(Project proyecto){
		this.projectController.setProject(proyecto);
		this.agregarForm();
	}
	

	private void agregarForm() {
		Form<ProjectController> crearSprintForm = new Form<ProjectController>("crearSprintForm") {
			private static final long serialVersionUID = -1309536194793150773L;

			@Override
			protected void onSubmit() {
			//	ListaDeSprintBacklogParaUserStoryPage.this.projectController.agregarASprintBacklog();
				this.setResponsePage(new SprintBacklogPage() );
			}

		};
		crearSprintForm.add(new Label("nombreUserStory",new PropertyModel<>(this.projectController,"nombreUserStory")));
		crearSprintForm.add(new DropDownChoice<>("sprintBacklog",
				new PropertyModel<>(this.projectController, "sprintBacklog"),
				new PropertyModel<>(this.projectController, "sprintsBacklogs"), 
				new ChoiceRenderer<>("nombre")
));
		

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



