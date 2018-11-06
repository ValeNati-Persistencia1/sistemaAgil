package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;

public class UserStoryPage extends WebPage{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private UserStoryController userStoryController;
	@SuppressWarnings("unused")
	private UserStory userStory;
	
	public UserStoryPage(){
		this.agregarForm();
		this.volverAHomePage();;
	}
	
	public UserStoryPage(UserStory us){
		userStoryController.attach(us);
		this.userStory=us;
		agregarForm();
	}
		
	private void agregarForm(){
		Form<UserStoryController> crearUserStoryForm = new Form<UserStoryController>("crearUserStoryForm"){
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onSubmit() {
				UserStoryPage.this.userStoryController.agregarUserStoryALaLista();
				this.setResponsePage(new HomePage());
			
			}	
		};
		
		crearUserStoryForm
       .add(new TextField<>("nombre", new PropertyModel<>(this.userStoryController, "nombre")));

        crearUserStoryForm
		.add(new TextArea<>("descripcion", new PropertyModel<>(this.userStoryController, "descripcion")));
        
        crearUserStoryForm.add(new Link<String>("verListaUserStory"){
         	private static final long serialVersionUID = 1L;
        	@Override
    			public void onClick() {
    				this.setResponsePage(new ListUserStoryPage());
    				
    			}		
    			
    		});
        crearUserStoryForm.add(new Link<String>("verListaBacklog"){
         	private static final long serialVersionUID = 1L;
        	@Override
    			public void onClick() {
//    				this.setResponsePage(new ListUsersStoriesEnBacklog()); <<<--linkea ahi
    				this.setResponsePage(new HomePage());
    			}		
    			
    		});
  
		crearUserStoryForm.add(new Link<String>("cancelar"){
     	private static final long serialVersionUID = 1L;
    	@Override
			public void onClick() {
				this.setResponsePage(new ListProjectPage());
				
			}
			
			
		});
		
		this.add(crearUserStoryForm);
		
	}	
	  public void volverAHomePage() {
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				 this.setResponsePage(new HomePage());

			}

		});
	}
}
