package ar.sarm.unq.sga.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import ar.sarm.unq.sga.wicket.backlog.BacklogPage;
import ar.sarm.unq.sga.wicket.project.ProjectPage;
import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage() {
		
		this.add(new Link<String>("proyecto") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ProjectPage());
			}

		});
		this.add(new Link<String>("backlog") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new BacklogPage());
			}

		});
		this.add(new Link<String>("userstory"){
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
               this.setResponsePage(new UserStoryPage());				
			}
			
		});
		this.add(new Link<String>("developer"){
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
               this.setResponsePage(new HomePage());				
			}
			
		});

	}
}
