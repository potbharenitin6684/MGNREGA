package UseCase;

import java.util.Scanner;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.IdentityException;

public class BDO_Login {

	public static boolean bdoLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter BDO Username : ");
		String username = sc.next();
		
		System.out.println("Enter BDO Password : ");
		String password = sc.next();
		
		BDOInterface dao = new BDOImpl();
		
		String res;
		
		try {
			res = dao.bdologin(username, password);
			return true;
			
		} catch (IdentityException e) {
			
			res = e.getMessage();
			return false;
		}		
	}
}
