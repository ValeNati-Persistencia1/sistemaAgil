package ar.sarm.unq.sga;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.sarm.unq.sga.hibernate.HibernateConf;

public class GenerateDataMain {

	public static void main(String[] args) {
		HibernateConf.modo= "create";
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("ar.sarm.unq.sga" , "ar.sarm.unq.sga.wicket", "ar.sarm.unq.sga.hibernate", "ar.sarm.unq.sga.home","ar.sarm.unq.sga.model");
		ctx.refresh();
		
		GenerateData gd = (GenerateData) ctx.getBean("generateData");
		gd.generate();
		
		ctx.close();
	}

}
