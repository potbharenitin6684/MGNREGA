package UseCase;

import java.util.List;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.ProjectException;
import Model.Project;

public class DisplayAllProject {
	
	public static void displayProject() {
		
		BDOInterface dao = new BDOImpl();
		
		try {
				List<Project> projects = dao.displayAllProject();
				
				System.out.println("===================================================================");
				System.out.println(" Table of all the Projects Present ");
				System.out.println("===================================================================");			
				System.out.printf("%7s %7.5s %16s %15s %17s","PID", "GPMID", "NAME", "COST", "DURATION");
				System.out.println();
				System.out.println("===================================================================");
				
				System.out.println();
				for(Project p: projects) {
					
					System.out.format("   %2s  %6s  %22s%12s     %11s",p.getPid(),p.getPGpid(), p.getPName(),p.getPCost(),p.getPduration() + " Days");
					System.out.println();
			}
			
				System.out.println("===================================================================");
	
		} catch (ProjectException e) {
			System.out.println( e.getMessage());
		}
	}
}
