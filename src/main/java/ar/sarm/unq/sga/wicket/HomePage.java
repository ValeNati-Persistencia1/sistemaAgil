package ar.sarm.unq.sga.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectPage;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;
import ar.sarm.unq.sga.wicket.usuario.ListUsuariosPage;
import ar.sarm.unq.sga.wicket.usuario.UsuarioPage;

public class HomePage extends WebPage {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HomePage.class);
	private static final long serialVersionUID = 1L;	
		public HomePage() {
		log.debug("construyendo la lista de proyectos");
		
		this.add(new Link<String>("losProyectos") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				log.debug("antes de derivar a la ListProjectPage");
				this.setResponsePage(new ListProjectPage());
			}

		});

		
		log.debug("construyendo el formulario");
		this.add(new Link<String>("proyecto") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				log.debug("antes de derivar al project Page");
				this.setResponsePage(new ProjectPage());
			}

		});
//		this.add(new Link<String>("backlog") {
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void onClick() {
//				this.setResponsePage(new BacklogPage());
//			}
//
//		});
		this.add(new Link<String>("userstory"){
			private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
               log.debug("antes de derivar el userStory Page");
               this.setResponsePage(new UserStoryPage());				
			}
			
		});
		this.add(new Link<String>("usuario"){
			private static final long serialVersionUID = 1L;
            @Override
			public void onClick() {
               log.debug("antes de derivar el develper page");
               this.setResponsePage(new UsuarioPage());				
			}
			
		});
		this.add(new Link<String>("usuarios"){
			private static final long serialVersionUID = 1L;
            @Override
			public void onClick() {
               log.debug("antes de derivar el develper page");
               this.setResponsePage(new ListUsuariosPage());				
			}
			
		});
		
		
		

	}
}
