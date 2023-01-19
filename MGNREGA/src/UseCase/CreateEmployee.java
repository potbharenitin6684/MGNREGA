package UseCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import DAO.GPMImpl;
import DAO.GPMInterface;
import Exception.EmployeeException;
import Model.Employee;

public class CreateEmployee {
	
	public static void CreateEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
				System.out.println("Enter the Employee Name : ");
				String name = sc.nextLine();
				
				System.out.println("Enter the Employee Address : ");
				String address = sc.nextLine();
				
				System.out.println("Enter the Employee Wage per day : ");
				int wage = sc.nextInt();
				
				Employee emp = new Employee();
				
				emp.seteGPid(GPMImpl.storedGpmID);
				emp.seteAddress(address);
				emp.seteName(name);
				emp.seteWage(wage);
	
				GPMInterface dao = new GPMImpl();
				String res;
				
				try {
					res = dao.createEmployee(emp);
					System.out.println( res );
	
				} catch (EmployeeException e) {
					res = e.getMessage();
					System.out.println( res );
				}
				
			} catch (InputMismatchException i) {
				System.out.println("Exception : Invalid Input Data Type !");
			}
		}
}
