package DAO;

import java.sql.Connection;
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
		
		String result ="Gram Panchayat Member Data Not Inserted.";
		
		try (Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("insert into grampanchayat (gname,gaddress,gphone,gpassword) values(?,?,?,?)");
			
			ps.setString(1, g.getGPName());
			ps.setString(2, g.getGPAddress());
			ps.setString(3, g.getGPPhone());
			ps.setString(4, g.getGPPassword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Gram Panchayat data Inserted.";
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
		return null;
		
	}

//===================================== View List Of Gram Panchayat Member Section End===================================================================//	
	
	
	
	@Override
	public String allocateProjectToGPM(int gpmid, int pid)
			throws ProjectException, GramPanchayatException, BDOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> employeeOnAProject(int pid) throws ProjectException, EmployeeException, BDOException {
		// TODO Auto-generated method stub
		return null;
	}

}
