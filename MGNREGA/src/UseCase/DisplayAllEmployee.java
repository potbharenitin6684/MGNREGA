package UseCase;

import java.util.List;

import DAO.GPMImpl;
import DAO.GPMInterface;
import Exception.EmployeeException;
import Model.Employee;

public class DisplayAllEmployee {
	
	public static void displayEmployee() {
		
		GPMInterface dao =new GPMImpl();
		
		try {
				List<Employee> emp = dao.displayAllEmployee();
				
				System.out.println("===================================================================");
				
				System.out.println("Table of all the Employee Present");
				
				System.out.println("===================================================================");
				
				System.out.printf("%7s %7.5s %8.5s %10s %15s %17s %16s","EID", "EGPMID","EPID", "NAME", "ADDRESS", "DATE JOINED", "WAGE/DAY");
				
				System.out.println();
				
				System.out.println("===================================================================");
				
				System.out.println();
				
				for(Employee e : emp) {
					
					System.out.format("  %2s   %6s   %8.5s   %13s   %14s   %16s    %10s",e.geteId(),e.getePid(),e.getePid(),e.geteName(),e.geteAddress(),e.geteDate(),e.geteWage());
					System.out.println();
				}
				
				System.out.println("===================================================================");
		
			} catch (EmployeeException e) {
				System.out.println(e.getMessage());
			}
		}
}
