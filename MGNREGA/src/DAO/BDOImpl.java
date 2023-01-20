package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.BDOException;
import Exception.EmployeeException;
import Exception.GramPanchayatException;
import Exception.IdentityException;
import Exception.ProjectException;
import Model.Employee;
import Model.GramPanchayat;
import Model.Project;
import Utility.DBUtil;

public class BDOImpl implements BDOInterface {

//===================================== login Section start =========================================================================//
	
	
	@Override
	public String bdologin(String username, String password) throws IdentityException {
		// TODO Auto-generated method stub

		String str = "Invalid Identity Details !!!";
		
		if (username.equals(BDOInterface.username) && password.equals(BDOInterface.password)) {
			 str = "Welcome to BDO Account ... BDO Login Successful !!!";
		}else {
			throw new IdentityException(str);
		}
		return str;	
	}
//===================================== login Section End ============================================================================//



	
	
	
	
	
//=====================================Create Project Section start===================================================================//
	@Override
	public String createProject(Project p) throws ProjectException {
		// TODO Auto-generated method stub
		
		String str ="Project Not Created.";
		
		try (Connection con =DBUtil.provideConnection() ){
			
			PreparedStatement ps = con.prepareStatement("insert into project (pname,pcost,pduration) values(?,?,?)");
			
			ps.setString(1, p.getPName());
			ps.setInt(2, p.getPCost());
			ps.setInt(3, p.getPduration());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				str = "Project Created.";
			}else {
				throw new ProjectException(str);
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		return str;
	}
//=====================================Create Project Section End===================================================================//
	


	
	
	
	
	
//=====================================View Project Section Start===================================================================//
		
	@Override
	public List<Project> displayAllProject() throws ProjectException {
		// TODO Auto-generated method stub
		
		List<Project> projectList = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from project");
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int pid = rs.getInt("pid");
				int pgpid = rs.getInt("pgpid");
				String name = rs.getString("pname");
				int cost = rs.getInt("pcost");
				int duration = rs.getInt("pduration");
				
				Project p = new Project(pid, pgpid, name, cost, duration);
				projectList.add(p);
			}
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(projectList.size() ==0) {
			throw new ProjectException("Exception : No Project Found.");
		}
		
		return projectList;
	}
//=====================================View Project Section End===================================================================//	

	
	
	
	
	
	
	

//===================================== Create Gram Panchayat Member Section start===================================================================//	
	
	@Override
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException {
		// TODO Auto-generated method stub
		
		String result ="Gram Panchayat Member information not Inserted !";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into grampanchayat (gpname,gpaddress,gpphone,gppassword) values(?,?,?,?)");
			
			ps.setString(1, g.getGPName());
			ps.setString(2, g.getGPAddress());
			ps.setString(3, g.getGPPhone());
			ps.setString(4, g.getGPPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Gram Panchayat Member information is Inserted successfully !!!.";
			}else {
				throw new GramPanchayatException(result);
			}
			
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
		
		return result;
	}

//===================================== Create Gram Panchayat Member Section End===================================================================//	



	
	
	
	
//===================================== View List Of Gram Panchayat Member Section Start===================================================================//	
	
	@Override
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException {	
		// TODO Auto-generated method stub
			
		List<GramPanchayat> GPMList = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayat");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int gpid = rs.getInt("GPID");
				String name = rs.getString("GPName");
				String address = rs.getString("GPAddress");
				String phone = rs.getString("GPPhone");
				String password = rs.getString("GPPassword");
					
				GramPanchayat gp = new GramPanchayat(gpid, name, address, phone, password);
				GPMList.add(gp);
			}
		} catch (SQLException e) {
			throw new GramPanchayatException(e.getMessage());
		}
		
		if(GPMList.size() ==0) {
			throw new GramPanchayatException("Exception : No Gram Panchayat Member Found.");
		}
		
		return GPMList;
	}

//===================================== View List Of Gram Panchayat Member Section End===================================================================//	
	

	
	
	
	
	
	
//===================================== Allocate Project To GPM Section Start ===================================================================//		
	
	@Override
	public String allocateProjectToGPM(int gpmid, int pid)
			throws ProjectException, GramPanchayatException, BDOException {
		// TODO Auto-generated method stub
		
		String res = "Project is Not Allocated ";
		
		try (Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from grampanchayat where GPID = ?");
			ps.setInt(1, gpmid);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = con.prepareStatement("select * from project where pid = ?");
				ps2.setInt(1,pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = con.prepareStatement("update project set pgpid = ? where pid = ?");
					ps3.setInt(1, gpmid);
					ps3.setInt(2, pid);
					
					int x = ps3.executeUpdate();
					
					if(x > 0) {
						res = " Project with PID ID : " + pid +" Allocated to GPM with GPM ID : " +gpmid ;
						return res;
					}
	
				}else {
					throw new ProjectException("Project is not exist with PID : " + pid);	
				}
				
			}else {
				throw new GramPanchayatException("Gram Panchyat Member is not exist with GPID :" + gpmid);
			}
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		return res;
	}
//===================================== Allocate Project To GPM Section End ===================================================================//

	

	
	
	
	
	
//=====================================Employee On A Project Section start ===================================================================//
	
	@Override
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BDOException {
		// TODO Auto-generated method stub
		
		List<Employee> empList = new ArrayList<>();
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from project where pid =?");
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = con.prepareStatement("select * from employee e inner join project p on e.epid = p.pid where p.pid = ?");
				ps2.setInt(1, pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {

					int eid = rs2.getInt("eId");
					int egpid = rs2.getInt("eGPid");
					int epid = rs2.getInt("ePid");
					String name = rs2.getString("eName");
					String address = rs2.getString("eAddress");
					Date date = rs2.getDate("eDate_joined");
					int wage = rs2.getInt("eWage");
				
					Employee e = new Employee(eid, egpid, epid, name, address, date, wage);
					empList.add(e);
				}
				
			}else {
				throw new ProjectException("No Project found with PID ID : " + pid);
			}
		
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employee Found in the given PID : ." + pid);
		}
		return empList;
	}
}

//===================================== Employee On A Project Section End ===================================================================//

















