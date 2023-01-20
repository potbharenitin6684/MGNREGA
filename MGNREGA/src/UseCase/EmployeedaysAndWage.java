package UseCase;

import java.util.List;

import DAO.GPMImpl;
import DAO.GPMInterface;
import Exception.EmployeeException;
import Model.EmployeeWage;

public class EmployeedaysAndWage {
	
	public static void employeedaysAndWage() {
		
		GPMInterface dao = new GPMImpl();
		
		try {
				List<EmployeeWage> empWage =  dao.employeedaysAndWage();
				System.out.println("===================================================================");
			
				System.out.println("Table of all the Employee, Wage, days, Total Amount");
				
				System.out.println("===================================================================");
				
				System.out.printf("%7s %10s %11s %17s %22s %17s %13s %21s","EID", "ENAME", "PID", "PNAME", "DATE_JOINED", "TOTAL DAYS", "WAGE/DAY", "TOTAL_AMOUNT");
				System.out.println();
				
				System.out.println("===================================================================");
				System.out.println();
				
				for(EmployeeWage e : empWage) {
					
					System.out.format("%2s %12s %9s %22s %17s %14s %14s %18s",e.getEid(),e.getName(), e.getProjectID(),e.getProjectName(),e.getDate_joined(),e.getNo_Of_Days(),e.getWage(),e.getTotal_Amount());
					System.out.println();
				}
			
				System.out.println("===================================================================");
			
		} catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
