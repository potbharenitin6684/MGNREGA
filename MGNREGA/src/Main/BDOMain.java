package Main;

import UseCase.AllocateProjectToGPM;
import UseCase.BDO_Login;
import UseCase.CreateGramPanchayatMember;
import UseCase.CreateProject;
import UseCase.DisplayAllGramPayanchayatMember;
import UseCase.DisplayAllProject;
import UseCase.EmployeeOnAProject;

public class BDOMain {
	
			public static Boolean bdoLogin() {
				BDO_Login login = new BDO_Login();
				Boolean result = login.bdoLogin();
				return result;	
			}
			
			public static void bdoHomeWndow() {
				System.out.println();
				System.out.println("===================================================================");
				System.out.println("--------- Welcome to BDO MGNREGA Application ---------");
				System.out.println("===================================================================");
				System.out.println();
				System.out.println(" 1.Create a Project.");
				System.out.println(" 2.View List of all Projects.");
				System.out.println(" 3.Create a Gram Panchayat Member.");
				System.out.println(" 4.View List of all Gram Panchayat Members .");
				System.out.println(" 5.Allocate Project to Gram Panchayat Member.");
				System.out.println(" 6.See the List of Employee working on a project");
				System.out.println(" 7.LOGOUT AND RETURN TO HOMEPAGE");	
				System.out.println();
				System.out.println("===================================================================");
			}
			
			public static void createProject() {
				CreateProject createProject = new CreateProject();
				createProject.CreateProject();
			}
			
			public static void viewListOfProject() {
				DisplayAllProject projects = new DisplayAllProject();
				projects.displayProject();
			}
			
			public static void createGPM() {
				CreateGramPanchayatMember createGPM = new CreateGramPanchayatMember();
				createGPM.createGramPanchayatMember();
			}
			
			public static void viewListOfGPM() {
				DisplayAllGramPayanchayatMember gpmList = new DisplayAllGramPayanchayatMember();
				gpmList.displayAllGPM();
			}
			
			public static void allocateProjectToGPM() {
				AllocateProjectToGPM allocate = new AllocateProjectToGPM();
				allocate.allocateProjectToGPM();
			}
			
			public static void listOfEmployee() {
				EmployeeOnAProject emp = new EmployeeOnAProject();
				emp.employeeOnAProject();
			}
}
