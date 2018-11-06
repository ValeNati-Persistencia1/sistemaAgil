package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.HomePage;

public class ListUserStoryPage extends WebPage {

	private static final long serialVersionUID = 5691036303664036670L;

	@SpringBean
	private UserStoryController userStoryController;
	
	@SuppressWarnings("unused")
	private UserStory userStory;
	
	public ListUserStoryPage(){
		this.addForm();
		this.botonAgregarUserStory();
		this.salir();
		this.volverAtras();
	}
	public ListUserStoryPage(UserStory us){
		userStoryController.attach(us);
		this.userStory=us;
		this.addForm();
		this.botonAgregarUserStory();
		this.salir();
        this.volverAtras();
	}

	private void addForm() {
     this.add(new ListView<UserStory>("losUsersStories", new PropertyModel<>(this.userStoryController, "usersStories")) {

		private static final long serialVersionUID = 1L;

		@Override
		protected void populateItem(ListItem<UserStory> item) {
			CompoundPropertyModel<UserStory>us=new CompoundPropertyModel<>(item.getModelObject());
			item.add(new Label("nombre", us.bind("nombre")));
			item.add(new TextArea<>("descripcion",us.bind("descripcion")));
		
         item.add(new Link<String>("borrarUserStory") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				ListUserStoryPage.this.userStoryController.borrarUserStory(item.getModelObject());
				this.setResponsePage(new ListUserStoryPage());
				
			}

		});

	}

});

}
	public void botonAgregarUserStory() {
		this.add(new Link<String>("agregarUserStory") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				 this.setResponsePage(new UserStoryPage());

			}

		});
	}
    
	public void salir() {
		this.add(new Link<String>("salir") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				 this.setResponsePage(new HomePage());

			}

		});
	}
	public void volverAtras() {
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				 this.setResponsePage(new UserStoryPage());

			}

		});
	}
	
}
