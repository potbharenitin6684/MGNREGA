package UseCase;

import java.util.Scanner;

import DAO.GPMImpl;
import DAO.GPMInterface;
import Exception.EmployeeException;
import Exception.GramPanchayatException;
import Exception.ProjectException;

public class AssignEmployeeToProject {

	public static void assignEmployeeToProject() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project ID to assign : ");
		int pid = sc.nextInt();
		
		System.out.println("Enter Employee ID to assign : ");
		int eid = sc.nextInt();
		
		
		GPMInterface dao = new GPMImpl();
		String res;
		
		try {
			
			res = dao.assignEmployeeToProject(pid, eid);
			System.out.println(res);
		
		} catch (EmployeeException e) {
			
			res = e.getMessage();
			System.out.println( res );
		
		} catch (ProjectException e) {
			
			res = e.getMessage();
			System.out.println( res );
		
		} catch (GramPanchayatException e) {
			res = e.getMessage();
			System.out.println( res );
		}
	}
}
