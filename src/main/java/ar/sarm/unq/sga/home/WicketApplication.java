package ar.sarm.unq.sga.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import ar.sarm.unq.sga.hibernate.SessionFactoryContainer;
import ar.sarm.unq.sga.wicket.HomePage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see ar.edu.unq.sarmiento.epers.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		System.out.println(" LEVANTANDO LA APP  ***********************");
		SessionFactoryContainer.buildSessionFactory(false);
		this.getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		this.getRequestCycleSettings().setResponseRequestEncoding("UTF-8"); 

	}
}
