package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Exception.EmployeeException;
import Exception.GramPanchayatException;
import Exception.IdentityException;
import Exception.ProjectException;
import Model.Employee;
import Model.EmployeeWage;
import Utility.DBUtil;

public class GPMImpl implements GPMInterface {

	
//===================================== login Section Start ============================================================================//


	public static int storedGpmID;

	@Override
	public String gmpLogin(String phone, String password) throws IdentityException, GramPanchayatException {
		// TODO Auto-generated method stub
		
			String str = "GPM Login Failed !!!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from grampanchayat");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String phoneNumber = rs.getString("gphone");
				
				String pass = rs.getString("gpassword");
				
				if(phoneNumber.equals(phone) && pass.equals(password)) {
				
					str = "GPM login Sucessful !!!";
					
					storedGpmID = rs.getInt("GPID");
					
					return str;
				}
			}
			str = "Wrong Identity";
			throw new IdentityException(str);
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}		
	}

//===================================== login Section End ============================================================================//



	
	
//=====================================Create Employee Section start ===================================================================//

	
	@Override
	public String createEmployee(Employee e) throws EmployeeException {
		// TODO Auto-generated method stub
		
		String str ="Employee is Not Created !!!";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into employee(egpid,ename,eaddress,edate_joined,ewage) values(?,?,?,curdate(),?)");
			
			ps.setInt(1, e.geteGPid());
			ps.setString(2, e.geteName());
			ps.setString(3, e.geteAddress());
			ps.setInt(4, e.geteWage());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				
				str = "Employee is Created Now !!!";
				
			}else {
				throw new EmployeeException(str);
			}
			
		} catch (SQLException s) {
			throw new EmployeeException(s.getMessage());
		}
		
		return str;
	}

//=====================================Create Employee Section End ======================================================================//
	
	@Override
	public List<Employee> displayAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignEmployeeToProject(int pid, int eid)
			throws EmployeeException, ProjectException, GramPanchayatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeWage> employeedaysAndWage() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
