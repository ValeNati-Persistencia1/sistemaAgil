package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;

public class ListUsersStoriesEnBacklog extends WebPage{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private BacklogController backlogController;
	
	private UserStory userStory;
	
  public ListUsersStoriesEnBacklog(){
     this.crearForm();
     this.salir();
     this.volverAHomePage();
  }
  public ListUsersStoriesEnBacklog(Backlog backlog){
	     this.backlogController.attach(backlog);
	     this.crearForm();
	     this.salir();
	     this.volverAHomePage();
	  }


   private void crearForm() {
      
}

   private void salir() {
	  this.add(new Link<String>("salir") {

		private static final long serialVersionUID = 1L;

		@Override
		public void onClick() {
			this.setResponsePage(new ListProjectPage());
			
		}
	});
   }
	  private void volverAHomePage(){
		  
		  this.add(new Link<String>("volverAHomePage"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
			  this.setResponsePage(new HomePage());
				
			}
		  });	  
		  
	  }
  	

}