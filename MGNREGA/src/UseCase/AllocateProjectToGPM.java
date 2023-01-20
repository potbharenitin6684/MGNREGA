package UseCase;

import java.util.Scanner;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.BDOException;
import Exception.GramPanchayatException;
import Exception.ProjectException;

public class AllocateProjectToGPM {
	
	public static void allocateProjectToGPM() {
		
		Scanner sc = new Scanner(System.in);
		//System.out.println("===================================================================");
		
		System.out.println("Enter Project ID to assign : ");
		int pid = sc.nextInt();
		
		System.out.println("Enter Gram Panchayat Member ID to assign : ");
		int gpid = sc.nextInt();
		
		BDOInterface dao = new BDOImpl();
		
		String res;
		
		try {
			res = dao.allocateProjectToGPM(gpid, pid);
			System.out.println(res);
			
		} catch (ProjectException e) {
			
			res = e.getMessage();
			System.out.println( res);
			
		} catch (GramPanchayatException e) {
			
			res = e.getMessage();
			System.out.println(res);
			
		} catch (BDOException e) {
			
			res = e.getMessage();
			System.out.println(res);
		}
	}
}
