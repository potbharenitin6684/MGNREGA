package DAO;

import java.util.List;

import Exception.EmployeeException;
import Exception.GramPanchayatException;
import Exception.IdentityException;
import Exception.ProjectException;
import Model.Employee;
import Model.EmployeeWage;

public interface GPMInterface {

	public String gmpLogin(String phone, String password) throws IdentityException , GramPanchayatException;
	
	public String createEmployee(Employee e) throws EmployeeException;
	
	public List<Employee> displayAllEmployee() throws EmployeeException;
	
	public String assignEmployeeToProject(int pid, int eid) throws EmployeeException, ProjectException, GramPanchayatException;
	
	public List<EmployeeWage> employeedaysAndWage() throws EmployeeException;
	
}
