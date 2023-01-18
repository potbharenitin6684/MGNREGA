package Model;

import java.sql.Date;

public class EmployeeWage {
	
	private int eid;
	private String name;
	private int projectID;
	private String ProjectName;
	private Date date_joined;
	private int no_Of_Days;
	private int wage;
	private int total_Amount;
	
	public EmployeeWage(int eid, String name, int projectID, String projectName, Date date_joined, int no_Of_Days,
			int wage, int total_Amount) {
		super();
		this.eid = eid;
		this.name = name;
		this.projectID = projectID;
		ProjectName = projectName;
		this.date_joined = date_joined;
		this.no_Of_Days = no_Of_Days;
		this.wage = wage;
		this.total_Amount = total_Amount;
	}

	@Override
	public String toString() {
		return "EmployeeWage [eid=" + eid + ", name=" + name + ", projectID=" + projectID + ", ProjectName="
				+ ProjectName + ", date_joined=" + date_joined + ", no_Of_Days=" + no_Of_Days + ", wage=" + wage
				+ ", total_Amount=" + total_Amount + "]";
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public Date getDate_joined() {
		return date_joined;
	}

	public void setDate_joined(Date date_joined) {
		this.date_joined = date_joined;
	}

	public int getNo_Of_Days() {
		return no_Of_Days;
	}

	public void setNo_Of_Days(int no_Of_Days) {
		this.no_Of_Days = no_Of_Days;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public int getTotal_Amount() {
		return total_Amount;
	}

	public void setTotal_Amount(int total_Amount) {
		this.total_Amount = total_Amount;
	}
}
