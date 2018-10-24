diff --git a/src/main/java/ar/sarm/unq/sga/hibernate/HibernateConf.java b/src/main/java/ar/sarm/unq/sga/hibernate/HibernateConf.java
index 0b4b3bb..1f816c6 100644
--- a/src/main/java/ar/sarm/unq/sga/hibernate/HibernateConf.java
+++ b/src/main/java/ar/sarm/unq/sga/hibernate/HibernateConf.java
@@ -9,6 +9,7 @@ import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.ComponentScan;
 import org.springframework.context.annotation.Configuration;
+import org.springframework.context.annotation.EnableAspectJAutoProxy;
 import org.springframework.jdbc.datasource.DriverManagerDataSource;
 import org.springframework.orm.hibernate5.HibernateTransactionManager;
 import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@@ -16,8 +17,9 @@ import org.springframework.transaction.PlatformTransactionManager;
 import org.springframework.transaction.annotation.EnableTransactionManagement;
 
 @Configuration
-@ComponentScan(basePackages = "ar.unq.sarm.sga.wicket")
+@ComponentScan(basePackages = {"ar.unq.sarm.sga.wicket","ar.sarm.unq.sga.wicket","ar.sarm.unq.sga.hibernate"})
 @EnableTransactionManagement
+@EnableAspectJAutoProxy
 public class HibernateConf {
 	public static String modo = "update";
 
@@ -56,6 +58,7 @@ public class HibernateConf {
 		hibernateProperties.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
 		hibernateProperties.setProperty("show_sql", "true");
 		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", HibernateConf.modo);
+//		hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
 		return hibernateProperties;
 	}
 }
diff --git a/src/main/java/ar/sarm/unq/sga/home/Home.java b/src/main/java/ar/sarm/unq/sga/home/Home.java
index 0c5b988..589823d 100644
--- a/src/main/java/ar/sarm/unq/sga/home/Home.java
+++ b/src/main/java/ar/sarm/unq/sga/home/Home.java
@@ -5,7 +5,6 @@ package ar.sarm.unq.sga.home;
 import org.hibernate.Session;
 
 import ar.sarm.unq.sga.model.Persistible;
-
 	public interface Home<T extends Persistible>extends Serializable {
 
 		public T findByName(String name);
diff --git a/src/main/java/ar/sarm/unq/sga/wicket/HomePage.java b/src/main/java/ar/sarm/unq/sga/wicket/HomePage.java
index ef29efe..617ed82 100644
--- a/src/main/java/ar/sarm/unq/sga/wicket/HomePage.java
+++ b/src/main/java/ar/sarm/unq/sga/wicket/HomePage.java
@@ -4,25 +4,30 @@ import org.apache.wicket.markup.html.WebPage;
 import org.apache.wicket.markup.html.link.Link;
 import org.apache.wicket.spring.injection.annot.SpringBean;
 
-import ar.sarm.unq.sga.home.Home;
-import ar.sarm.unq.sga.model.Developer;
-import ar.sarm.unq.sga.model.Project;
-import ar.sarm.unq.sga.model.UserStory;
 import ar.sarm.unq.sga.wicket.backlog.BacklogPage;
+import ar.sarm.unq.sga.wicket.backlog.BacklogStore;
 import ar.sarm.unq.sga.wicket.developer.DeveloperPage;
+import ar.sarm.unq.sga.wicket.developer.DeveloperStore;
 import ar.sarm.unq.sga.wicket.project.ProjectPage;
+import ar.sarm.unq.sga.wicket.project.ProjectStore;
 import ar.sarm.unq.sga.wicket.userstory.UserStoryPage;
+import ar.sarm.unq.sga.wicket.userstory.UserStoryStore;
 
 public class HomePage extends WebPage {
 	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HomePage.class);
 	private static final long serialVersionUID = 1L;
 	
 	@SpringBean
-	private Home <Project> project; 
+	private ProjectStore projectStore; 
 	@SpringBean 
-	private Home<Developer>dev;
+	private DeveloperStore developerStore;
 	@SpringBean 
-	private Home<UserStory>user;
+	private UserStoryStore userStoryStore;
+	@SpringBean
+	private BacklogStore backlogStore;
+	
+	
+	
 	
 	public HomePage() {
 		log.debug("construyendo el formulario");
diff --git a/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperController.java b/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperController.java
index 110cf51..b9ea19c 100644
--- a/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperController.java
+++ b/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperController.java
@@ -1,7 +1,6 @@
 package ar.sarm.unq.sga.wicket.developer;
 
 import java.io.Serializable;
-import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 
@@ -15,8 +14,7 @@ public class DeveloperController<T extends Persistible> implements Serializable
 
     private String nombre;
     @Autowired
-    private DeveloperStore developerStore;
-    
+    private Home<Developer>developerStore;
     public DeveloperController(){
     	
     }
diff --git a/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperStore.java b/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperStore.java
index 5196ff7..289d278 100644
--- a/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperStore.java
+++ b/src/main/java/ar/sarm/unq/sga/wicket/developer/DeveloperStore.java
@@ -12,6 +12,22 @@ public class DeveloperStore extends HomeGeneralSession<Developer>{
 
 	private static final long serialVersionUID = 1L;
 	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
+	
 
 	public List<Developer> developers() {
 		return getSession().createQuery("FROM Developer", Developer.class).list();
diff --git a/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectController.java b/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectController.java
index 6c6fcce..85eb68b 100644
--- a/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectController.java
+++ b/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectController.java
@@ -3,45 +3,53 @@ package ar.sarm.unq.sga.wicket.project;
 import java.io.Serializable;
 import java.util.List;
 
+import javax.transaction.Transactional;
+
 import org.springframework.beans.factory.annotation.Autowired;
+import org.springframework.context.annotation.EnableAspectJAutoProxy;
 import org.springframework.stereotype.Controller;
 
 import ar.sarm.unq.sga.home.Home;
 import ar.sarm.unq.sga.model.Project;
 
 @Controller
-public class ProjectController implements Serializable{
-	
+@Transactional
+public class ProjectController implements Serializable {
+
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1L;
-	
+
 	private String nombre;
-	
+
 	@Autowired
 	private ProjectStore projectStore;
-	
-	public ProjectController(){
-		
+
+	public ProjectController() {
+
 	}
-	public ProjectController(String name){
-		this.nombre=name;
+
+	public ProjectController(String name) {
+		this.nombre = name;
 	}
+
 	public String getNombre() {
 		return nombre;
 	}
+
 	public void setNombre(String nombre) {
 		this.nombre = nombre;
 	}
-//arreglado con leo
-	public void agregarProjecto(){
-		Project proyecto=new Project(getNombre());
-		projectStore.insert(proyecto);
+
+	// arreglado con leo
+	public void agregarProyecto() {
+		Project proyecto = new Project(getNombre());
+		projectStore.agregarProyecto(proyecto);
 	}
-	
-	public List<Project>getProyectos(){
+
+	public List<Project> getProyectos() {
 		
-		return null ;//projectStore.proyectos();
+		return projectStore.proyectos;
 	}
 }
diff --git a/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectPage.java b/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectPage.java
index 9b5c025..6feba2a 100644
--- a/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectPage.java
+++ b/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectPage.java
@@ -29,7 +29,7 @@ public class ProjectPage extends WebPage{
 
 			@Override
 			protected void onSubmit() {
-				ProjectPage.this.projectController.agregarProjecto();
+				ProjectPage.this.projectController.agregarProyecto();
 				this.setResponsePage(new HomePage());
 			
 			}	
@@ -47,7 +47,7 @@ public class ProjectPage extends WebPage{
 
 			@Override
 			public void onClick() {
-			this.setResponsePage(new HomePage());
+//			this.setResponsePage(new HomePage());
 			//deberia volver a la lista de  proyectos para poder agregar el backlog	
 			}
 			
diff --git a/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectStore.java b/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectStore.java
index 35bd491..95b8ce7 100644
--- a/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectStore.java
+++ b/src/main/java/ar/sarm/unq/sga/wicket/project/ProjectStore.java
@@ -1,33 +0,0 @@
-package ar.sarm.unq.sga.wicket.project;
-import java.util.List;
-
-import org.springframework.stereotype.Component;
-
-import ar.sarm.unq.sga.home.HomeGeneralSession;
-import ar.sarm.unq.sga.model.Project;
-
-@Component
-public class ProjectStore extends HomeGeneralSession<Project>{
-
-	/**
-	 * 
-	 */
-	private static final long serialVersionUID = 1L;
-	
-	// public void agregarProject(Project project) {
-	// this.getSession().save(project);
-	// }
-	//
-	// public void updateProject(Project project) {
-	// this.getSession().update(project);
-	// }
-	//
-	// public void deleteProject(Project project) {
-	// this.getSession().delete(project);
-	// }
-
-	public List<Project> proyectos() {
-		return getSession().createQuery("FROM Project", Project.class).list();
-	}
-	
-}
\ No newline at end of file
diff --git a/src/main/webapp/WEB-INF/web.xml b/src/main/webapp/WEB-INF/web.xml
index ae2ba12..10d2065 100644
--- a/src/main/webapp/WEB-INF/web.xml
+++ b/src/main/webapp/WEB-INF/web.xml
@@ -10,7 +10,7 @@
 	 </context-param>
  	<context-param>
 		     <param-name>contextConfigLocation</param-name>
-		     <param-value>ar.sarm.unq.sga.wicket;ar.sarm.unq.sga.hibernate</param-value>
+		     <param-value>ar.sarm.unq.sga.hibernate.HibernateConf</param-value>
 	 </context-param>
 	
 	<filter>
diff --git a/src/test/java/ar/sarm/unq/sga/GenerateData.java b/src/test/java/ar/sarm/unq/sga/GenerateData.java
index 26749cb..c1700ff 100644
--- a/src/test/java/ar/sarm/unq/sga/GenerateData.java
+++ b/src/test/java/ar/sarm/unq/sga/GenerateData.java
@@ -1,42 +1,32 @@
 package ar.sarm.unq.sga;
 
-import org.hibernate.Session;
 import org.hibernate.SessionFactory;
 import org.hibernate.Transaction;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
-import org.springframework.transaction.annotation.Transactional;
 
-import ar.sarm.unq.sga.home.Home;
-import ar.sarm.unq.sga.model.Developer;
 import ar.sarm.unq.sga.model.Project;
-import ar.sarm.unq.sga.wicket.developer.DeveloperStore;
+import ar.sarm.unq.sga.wicket.project.ProjectStore;
+
 @Component
-@Transactional
 public class GenerateData {
-	
 
 	@Autowired
-	private Home<Project> projectStore;
-	
-	@Autowired Home<Developer>developerStore;
+	private ProjectStore projectStore;
+	@Autowired
+	private SessionFactory sessionFactory;
+
+	// @Autowired Home<Developer>developerStore;
 
 	protected void generate() {
 		Project proyecto = new Project("proyectito2");
+
+		Transaction ts = sessionFactory.getCurrentSession().beginTransaction();
 		projectStore.insert(proyecto);
-		
-		Developer dev=new Developer("Jose");
-		developerStore.insert(dev);
-		
-		
-		
-		
-		
-		
-		
+		// acá van los .insert
+		ts.commit();
+		// Developer dev=new Developer("Jose");
+		// developerStore.insert(dev);
+
 	}
 }
-	
-	
-	
-	
diff --git a/src/test/java/ar/sarm/unq/sga/GenerateDataMain.java b/src/test/java/ar/sarm/unq/sga/GenerateDataMain.java
index 0af22db..affee3e 100644
--- a/src/test/java/ar/sarm/unq/sga/GenerateDataMain.java
+++ b/src/test/java/ar/sarm/unq/sga/GenerateDataMain.java
@@ -9,7 +9,7 @@ public class GenerateDataMain {
 	public static void main(String[] args) {
 		HibernateConf.modo = "create";
 		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
-		ctx.scan("ar.sarm.unq.sga" , "ar.sarm.unq.sga.wicket", "ar.sarm.unq.sga.hibernate", "ar.sarm.unq.sga.home","ar.sarm.unq.sga.model");
+		ctx.scan("ar.sarm.unq.sga", "ar.sarm.unq.sga.wicket", "ar.sarm.unq.sga.hibernate", "ar.sarm.unq.sga.home","ar.sarm.unq.sga.model");
 		ctx.refresh();
 		
 		GenerateData gd = (GenerateData) ctx.getBean("generateData");
