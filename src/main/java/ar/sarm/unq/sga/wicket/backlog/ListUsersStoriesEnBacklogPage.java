package ar.sarm.unq.sga.wicket.backlog;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.junit.runner.Computer;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.userstory.VerDetalleUserStoryPage;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;

public class ListUsersStoriesEnBacklogPage extends WebPage{

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private BacklogController backlogController;
	@SpringBean
	private UserStoryController userStoryController;
	private UserStory userStory;
	private Backlog backlog;
  public ListUsersStoriesEnBacklogPage(){
     this.crearForm();
     this.salir();
     this.volverAHomePage();
  }
  public ListUsersStoriesEnBacklogPage(Backlog back,UserStory us){
         this.backlogController.attach(back);  
         this.userStory=us;
         back.setUserStory(us);
         this.backlog=back;
	     this.crearForm();
	     this.salir();
	     this.volverAHomePage();
	  }


   private void crearForm() {
	   this.add(new ListView<UserStory>("losUsersStoriesEnBacklog", new PropertyModel<>(this.backlogController, "usersstories")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<UserStory> item) {
				CompoundPropertyModel<UserStory>us=new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", us.bind("nombre")));
			
	         item.add(new Link<String>("borrarUserStory") {
				private static final long serialVersionUID = 1L;

				@Override
				public void onClick() {
					ListUsersStoriesEnBacklogPage.this.backlogController.borrarUserStoryDeListaEnBacklog(item.getModelObject());
					this.setResponsePage(new ListUsersStoriesEnBacklogPage());
					
				}

			});
	         item.add(new Link<String>("agregarUserStoryASprint") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						
						this.setResponsePage(new SprintBacklogPage());
						
					}

				});
		         
	         

		}

	});
         
      
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
		  
		  this.add(new Link<String>("volver"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
			  this.setResponsePage(new HomePage());
				
			}
		  });	  
		  
	  }
  	

}