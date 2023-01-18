package Model;

import java.sql.Date;

public class Employee {
	
	private int eId;
	private int eGPid;
	private int ePid;
	private String eName;
	private String eAddress;
	private Date eDate;
	private int eWage;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int eId, int eGPid, int ePid, String eName, String eAddress, Date eDate, int eWage) {
		super();
		this.eId = eId;
		this.eGPid = eGPid;
		this.ePid = ePid;
		this.eName = eName;
		this.eAddress = eAddress;
		this.eDate = eDate;
		this.eWage = eWage;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int geteGPid() {
		return eGPid;
	}

	public void seteGPid(int eGPid) {
		this.eGPid = eGPid;
	}

	public int getePid() {
		return ePid;
	}

	public void setePid(int ePid) {
		this.ePid = ePid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteAddress() {
		return eAddress;
	}

	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public int geteWage() {
		return eWage;
	}

	public void seteWage(int eWage) {
		this.eWage = eWage;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eGPid=" + eGPid + ", ePid=" + ePid + ", eName=" + eName + ", eAddress="
				+ eAddress + ", eDate=" + eDate + ", eWage=" + eWage + "]";
	}
}
