package UseCase;

import java.util.Scanner;

import DAO.GPMImpl;
import DAO.GPMInterface;
import Exception.GramPanchayatException;
import Exception.IdentityException;

public class GPMLogin {
	
	public static boolean gpmLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Registered Phone Number to LogIn : ");
		String phone = sc.nextLine();
		
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		
		GPMInterface dao = new GPMImpl();
		
		String res;
		
		try {
			res= dao.gmpLogin(phone, password);
			return true;
			
		} catch (IdentityException e) {
			
			res = e.getMessage();
			return false;
			
		} catch (GramPanchayatException e) {
			res = e.getMessage();
			return false;
		}	
	}
}
