package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	
	
	@Override
	public List<Project> displayAllProject() throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createGramPanchayatMember(GramPanchayat g) throws GramPanchayatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GramPanchayat> displayAllGramPayanchayatMember() throws GramPanchayatException {
		// TODO Auto-generated method stub
		return null;
	}

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
