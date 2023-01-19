package Main;

import UseCase.BDO_Login;

public class BDOMain {

	public static Boolean bdoLogin() {
		
		BDO_Login login = new BDO_Login();
		Boolean res = login.bdoLogin();
		return res;
	}
	public static void bdoHomeWndow() {
		
		System.out.println("Welcome to BDO Home Window : ");
		System.out.println("1. Create a Project.");
		System.out.println("2. View List of all Projects. ");
		System.out.println("3. Create a Gram Panchayat Member. ");
		System.out.println("4. View List of all Gram Panchayat Members . ");
		System.out.println("5. Allocate Project to Gram Panchayat Member. ");
		System.out.println("6. See the List of Employee working on a project. ");
		System.out.println("7. LOGOUT AND RETURN TO HOMEPAGE. ");	
	}
}
