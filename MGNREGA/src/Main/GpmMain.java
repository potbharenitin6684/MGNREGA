package Main;

import UseCase.AssignEmployeeToProject;
import UseCase.CreateEmployee;
import UseCase.DisplayAllEmployee;
import UseCase.EmployeedaysAndWage;
import UseCase.GPMLogin;

public class GpmMain {
	
		public static boolean GpmLogin() {
			GPMLogin login = new GPMLogin();
			boolean result =login.gpmLogin();
			return result;	
		}
		
		public static void gpmWindow() {
			System.out.println();
			System.out.println("===================================================================");
			System.out.println("-------Welcome to Gram Panchayat Member MGNREGA Application------- ");
			System.out.println("===================================================================");
			System.out.println();
			System.out.println(" 1.Create a Employee.");
			System.out.println(" 2.View Detail List of all Employee.");
			System.out.println(" 3.Assingn Employee to a Project.");
			System.out.println(" 4.View deatil of all Employees Working along with wages, day worked and Total Receivable Amount Till Current Day.");
			System.out.println(" 5.LOGOUT AND RETURN TO HOMEPAGE");
			System.out.println();
			System.out.println("===================================================================");
		}
		
		public static void createEmployee() {
			CreateEmployee createEmp = new CreateEmployee();
			createEmp.CreateEmployee();
		}
		
		public static void displayEmployee() {
			DisplayAllEmployee displayEmp = new DisplayAllEmployee();
			displayEmp.displayEmployee();	
		}
		
		public static void assignEmployee() {
			AssignEmployeeToProject assignEmployee = new AssignEmployeeToProject();
			assignEmployee.assignEmployeeToProject();
		}
		
		public static void dayWageTotal() {
			EmployeedaysAndWage dayWage = new EmployeedaysAndWage();
			dayWage.employeedaysAndWage();
		}	
}
