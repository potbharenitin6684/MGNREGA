package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				
				String phoneNumber = rs.getString("GPPhone");
				
				String pass = rs.getString("GPPassword");
				
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


	

//=====================================View Employee List Section start ======================================================================//

	
	@Override
	public List<Employee> displayAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<Employee> empList = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				int egpid = rs.getInt("egpid");
				int epid = rs.getInt("epid");
				String name = rs.getString("ename");
				String address = rs.getString("eaddress");
				Date date = rs.getDate("edate_joined");
				int wage = rs.getInt("ewage");
				
				Employee e = new Employee(eid, egpid, epid, name, address, date, wage);
				empList.add(e);
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employeet Found.");
		}
		
		return empList;
	}

//=====================================View Employee List Section End ======================================================================//

	

	
//=====================================Assign Employee To Project Section Start ======================================================================//	
	
	@Override
	public String assignEmployeeToProject(int pid, int eid)
			throws EmployeeException, ProjectException, GramPanchayatException {
		// TODO Auto-generated method stub
		
		String res = "Employee not assinged to project";
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ? and egpid =?");
			ps.setInt(1, eid);
			ps.setInt(2, storedGpmID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ? and pgpid =?");
				ps2.setInt(1, pid);
				ps2.setInt(2, storedGpmID);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()){
					
					PreparedStatement ps3 = conn.prepareStatement("update employee set epid = ? where eid =?");
					ps3.setInt(1, pid);
					ps3.setInt(2, eid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						
						res = "Project with PID ID : " + pid + " assigned to employee with EID ID : " + eid;
						return res;
					}
					
				}else {
					
					throw new ProjectException("Either Project don't exist or NOT assinged to Logined Gram Panchayat Member Account by BDO");
				}
				
			}else {
				
				throw new EmployeeException("Either employee don't exist or assigned by different Gram Panchayat Member ");
			}
		
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
	
		return res;
	}

//=====================================Assign Employee To Project Section End======================================================================//	


	
	
	
//=====================================Employee Days And Wage Section End======================================================================//	

	
	@Override
	public List<EmployeeWage> employeedaysAndWage() throws EmployeeException {
		// TODO Auto-generated method stub
		
		List<EmployeeWage> WageList = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" select e.eid,e.ename,p.pid,p.pname,e.edate_joined,datediff(curdate(),edate_joined) days,e.ewage,datediff(curdate(),edate_joined)*e.ewage total from employee e inner join project p on e.epid = p.pid group by e.eid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Date date = rs.getDate("edate_joined");
				int days = rs.getInt("days");
				int wage = rs.getInt("ewage");
				int total = rs.getInt("total");
				
				EmployeeWage empWageTotal = new EmployeeWage(eid, ename, pid, pname, date, days, wage, total);
				WageList.add(empWageTotal);	
			}
	
		} catch (SQLException e) {
		
			throw new EmployeeException(e.getMessage());
		}
		
		if(WageList.size() ==0) {
			throw new EmployeeException("Exception : No employee Found in DataBase");
		}
			
		return WageList;
	}
}

//=====================================Employee Days And Wage Section End======================================================================//	

















