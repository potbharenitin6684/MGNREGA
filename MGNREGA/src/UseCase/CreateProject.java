package UseCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.ProjectException;
import Model.Project;

public class CreateProject {

	public static void CreateProject() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
				System.out.println("Enter the Project Name : ");
				String name = sc.nextLine();
				
				System.out.println("Enter the Project Cost : ");
				int cost = sc.nextInt();
				
				System.out.println("Enter the Project Duration :");
				int duration = sc.nextInt();
				
				Project p = new Project();
				p.setPName(name);
				p.setPCost(cost);
				p.setPduration(duration);
				
				BDOInterface dao = new BDOImpl();
				
				String res;
				
				try {
					res = dao.createProject(p);
					System.out.println(res);
	
				} catch (ProjectException e) {
					res = e.getMessage();
					System.out.println( res );
				}
				
			} catch (InputMismatchException i) {
				System.out.println("Exception : Invalid Input Data Type");
			}	
	}
}
