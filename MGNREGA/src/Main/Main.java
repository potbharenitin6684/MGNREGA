package Main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
	public static void appOpening() throws InputMismatchException  {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println();
			
			System.out.println("===================================================================");
			
			System.out.println("--------------Hello ! Welcome to MGNREGA Application --------------");
			
			System.out.println("===================================================================");
			
			System.out.println(" Choose Login Option from MGNREGA Application");
			System.out.println();
			
			System.out.println(" 1.log In as BDO.");
			System.out.println(" 2.log In as Gram Panchayat Member.");
			System.out.println(" 3.EXIT.");
			
			System.out.println("===================================================================");
			String choice = sc.nextLine();
		
			if(choice.equals("1")) {
				
				//System.out.println("bdo");
				BDOMain bmain = new BDOMain();
				Boolean resultb = bmain.bdoLogin();
				
				int countBdoLogin =1;
				
				while(!resultb) {
					countBdoLogin++;
					System.out.println((4-countBdoLogin) +" Attempts remaining");
					resultb = bmain.bdoLogin();
					
					if(countBdoLogin ==3 && resultb ==false) {
						System.out.println("Maximum Limit : Try Again Later");
						break;
					}
				}
				
				if(resultb) {
					
					while(true) {
						
						bmain.bdoHomeWndow();
						
						String choiceBdo = sc.nextLine();
						
						if(choiceBdo.equals("1")) {
							bmain.createProject();
						
						}else if(choiceBdo.equals("2")) {
							bmain.viewListOfProject();
						
						}else if (choiceBdo.equals("3")) {
							bmain.createGPM();
						
						}else if(choiceBdo.equals("4")){
							bmain.viewListOfGPM();
						
						}else if(choiceBdo.equals("5")){
							bmain.allocateProjectToGPM();
						
						}else if(choiceBdo.equals("6")){
							bmain.listOfEmployee();
						
						}else if(choiceBdo.equals("7")){
							System.out.println("LOGOUT SUCCESSFUL !");				
							break;
						
						}else {
							System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 7");
						}							
					}
					appOpening();
						
				}else {
					appOpening();
				}
				
			}else if(choice.equals("2")) {
				
				//System.out.println("gpm");
				
				GpmMain gpmMain = new GpmMain();
				Boolean resultg = gpmMain.GpmLogin();
				
				int countGpmLogin=1;
				
				while(!resultg) {
					
					countGpmLogin++;
					System.out.println((4-countGpmLogin) +" Attempts remaining");
					resultg = gpmMain.GpmLogin();
					
					if(countGpmLogin ==3 && resultg ==false) {
						
						System.out.println("Maximum Limit Crossed : Try Again Later");
						break;
					}
				}
				
				if(resultg) {
					
					while(true) {
						
						gpmMain.gpmWindow();
						
						String choiceGpm = sc.nextLine();
						
						if(choiceGpm.equals("1")) {
							gpmMain.createEmployee();
						
						}else if(choiceGpm.equals("2")) {
							gpmMain.displayEmployee();
						
						}else if(choiceGpm.equals("3")) {
							gpmMain.assignEmployee();
						
						}else if(choiceGpm.equals("4")) {
							gpmMain.dayWageTotal();
						
						}else if(choiceGpm.equals("5")) {
							
							System.out.println("LOGOUT SUCCESSFUL !");
							break;
						
						}else {
							System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 5");
						
						}		
					}
					appOpening();
					
				}else {
					appOpening();
				}
				
				
			}else if(choice.equals("3")) {
				
				System.out.println("APPLICATION CLOSED : EXITED");
				System.exit(0);
				
			}else {
				
				System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 3");
				appOpening();
			}
		
			}catch (InputMismatchException e){
				System.out.println(e.getMessage());
			
			}catch (NoSuchElementException e) {
				System.out.println(e.getMessage() );
			}
	}
	
	public static void main(String[] args) {
		appOpening();		
	}
}	
