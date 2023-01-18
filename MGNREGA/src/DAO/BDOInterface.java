package DAO;

import java.util.List;

import Exception.BDOException;
import Exception.EmployeeException;
import Exception.GramPanchayatException;
import Exception.IdentityException;
import Exception.ProjectException;
import Model.Employee;
import Model.GramPanchayat;
import Model.Project;

public interface BDOInterface {
	
	public final String username = "bdo";
	public final String password = "bdo123";
	
	public String bdologin(String username, String password) throws IdentityException;
	
	public String createProject(Project p) throws ProjectException;
	
	public List<Project> displayAllProject() throws ProjectException;
	
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException;
	
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException;
	
	public String allocateProjectToGPM(int gpmid, int pid) throws ProjectException, GramPanchayatException, BDOException;
	
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BDOException;
	
}
