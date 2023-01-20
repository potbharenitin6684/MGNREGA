package UseCase;

import java.util.List;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.GramPanchayatException;
import Model.GramPanchayat;

public class DisplayAllGramPayanchayatMember {

	public static void displayAllGPM() {
		
		BDOInterface dao = new BDOImpl();
		
		try {
			
			List<GramPanchayat> gpmList = dao.displayAllGramPayanchayatMember();
			
			System.out.println("===================================================================");
			
			System.out.println(" Table of all Gram Panchayat Member Present ");
			
			System.out.println("===================================================================");
			
			System.out.printf("%7s %12s %16s %12.5s %19s", "GPID", "NAME", "ADDRESS", "PHONE", "PASSWORD");
			System.out.println();
			
			System.out.println("===================================================================");
			System.out.println();
			
			for(GramPanchayat g : gpmList) {

				System.out.format("  %2s  %15s   %14s   %15s   %14s",g.getGPid(),g.getGPName(),g.getGPAddress(),g.getGPPhone(),g.getGPPassword());
				System.out.println();
			}
			
			System.out.println("===================================================================");
		
		} catch (GramPanchayatException e) {
			System.out.println(e.getMessage());
		}
	}
}
