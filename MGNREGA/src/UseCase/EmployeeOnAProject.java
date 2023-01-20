package UseCase;

import java.util.List;
import java.util.Scanner;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.BDOException;
import Exception.EmployeeException;
import Exception.ProjectException;
import Model.Employee;

public class EmployeeOnAProject {
	
	public static void employeeOnAProject() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Project ID to see the list of all employeein that project : ");
		int pid = sc.nextInt();
		
		BDOInterface dao = new BDOImpl();
		
		try {
			List<Employee> emp =  dao.employeeOnAProject(pid);
			
			System.out.println("===================================================================");
			System.out.println("Table of all the Employee Present in the Project ID : ");
			
			System.out.println("===================================================================");
			
			System.out.printf("%17s %10.5s %19s","EID","NAME","WAGE/DAY" );
			System.out.println();
			
			System.out.println("===================================================================");
			System.out.println();
			
			for(Employee e : emp) {
				
				System.out.format("%9.2s %13s %10s",e.geteId(),e.geteName(),e.geteWage());
				System.out.println();
			}
			
			System.out.println("===================================================================");
			
		} catch (ProjectException e) {
			
			System.out.println(e.getMessage());
		
		} catch (EmployeeException e) {
		
			System.out.println(e.getMessage());
		
		} catch (BDOException e) {
		
			System.out.println(e.getMessage());
		}	
	}
}
