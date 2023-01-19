package UseCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import DAO.BDOImpl;
import DAO.BDOInterface;
import Exception.GramPanchayatException;
import Model.GramPanchayat;

public class CreateGramPanchayatMember {
	
	public static boolean flag = false;
	
		public static void createGramPanchayatMember()  {
		
			Scanner sc = new Scanner(System.in);		
		
			try {
					System.out.println("Enter the Gram Panchayat Member Name : ");
					String name = sc.nextLine();
					
					System.out.println("Enter the Gram Panchayat Member Address : ");
					String address = sc.nextLine();
					
					System.out.println("Enter the Gram Panchayat Member Phone Number : ");
					long phNumber = sc.nextLong();
					sc.nextLine();
					String phone = Long.toString(phNumber);
					
					System.out.println("Enter the Gram Panchayat Member Password : ");
					
					System.out.println("(Password must contain 8 characters and should have atleast 1 UpperCase, 1 SmallCase, 1 Number and 1 SpecialCharacter)");
					
					boolean flag = false;
					
					String password = null;
					
					while(!flag) {
						
						password = sc.nextLine();
						flag = password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
					
						if(flag) {
							break;
						}
						System.out.println("Invalid Password Pattern");
						System.out.println("(Password must contain 8 characters and should have atleast 1 UpperCase, 1 SmallCase, 1 Number and 1 SpecialCharacter)");
					}
					
					GramPanchayat g = new GramPanchayat();
					g.setGPName(name);
					g.setGPAddress(address);
					g.setGPPhone(phone);
					g.setGPPassword(password);
					
					BDOInterface dao = new BDOImpl();
					String result;
					
					try {
						result = dao.createGramPanchayatMember(g);
						System.out.println(result);
					} catch (GramPanchayatException e) {
						result = e.getMessage();
						System.out.println( result );
					}	
					
				} catch (InputMismatchException e) {
					System.out.println(" Exception : Invalid Input Data Type ");
				}
		}
}