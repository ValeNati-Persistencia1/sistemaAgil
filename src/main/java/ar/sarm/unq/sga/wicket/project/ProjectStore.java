package ar.sarm.unq.sga.wicket.project;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Project;

public class ProjectStore extends HomeGeneralSession<Project>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProjectStore elunico;
	
	public static ProjectStore elunico() {
		if(elunico==null){
			elunico=new ProjectStore();
		}
		return elunico;
	}
	
	public void agregarProject(Project project){
		this.getSession().save(project);
	}
	public void updateProject(Project project){
		this.getSession().update(project);
	}
	public void deleteProject(Project project){
		this.getSession().delete(project);
	}
	
	
	

}
