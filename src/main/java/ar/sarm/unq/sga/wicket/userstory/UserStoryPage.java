package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.wicket.HomePage;

public class UserStoryPage extends WebPage{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private UserStoryController userStoryController;
	
	public UserStoryPage(){
		agregarForm();
	}
	
	private void agregarForm(){
		Form<UserStoryController> crearUserStoryForm = new Form<UserStoryController>("crearUserStoryForm"){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
				UserStoryPage.this.userStoryController.agregarUserStory();
				this.setResponsePage(new HomePage());
			
			}	
		};
		
		crearUserStoryForm.add(new TextField<>("nombre", new PropertyModel<>(userStoryController, "nombre")));

		crearUserStoryForm.add(new Link<String>("cancelar"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
				
			}
			
			
		});
		this.add(crearUserStoryForm);
		
	}	
}
