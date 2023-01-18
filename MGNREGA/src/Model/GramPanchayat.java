package Model;

public class GramPanchayat {
	
	private int GPid;
	private String GPName;
	private String GPAddress;
	private String GPPhone;
	private String GPPassword;
	
	public GramPanchayat(int gPid, String gPName, String gPAddress, String gPPhone, String gPPassword) {
		super();
		GPid = gPid;
		GPName = gPName;
		GPAddress = gPAddress;
		GPPhone = gPPhone;
		GPPassword = gPPassword;
	}

	public int getGPid() {
		return GPid;
	}

	public void setGPid(int gPid) {
		GPid = gPid;
	}

	public String getGPName() {
		return GPName;
	}

	public void setGPName(String gPName) {
		GPName = gPName;
	}

	public String getGPAddress() {
		return GPAddress;
	}

	public void setGPAddress(String gPAddress) {
		GPAddress = gPAddress;
	}

	public String getGPPhone() {
		return GPPhone;
	}

	public void setGPPhone(String gPPhone) {
		GPPhone = gPPhone;
	}

	public String getGPPassword() {
		return GPPassword;
	}

	public void setGPPassword(String gPPassword) {
		GPPassword = gPPassword;
	}

	@Override
	public String toString() {
		return "GramPanchayat [GPid=" + GPid + ", GPName=" + GPName + ", GPAddress=" + GPAddress + ", GPPhone="
				+ GPPhone + ", GPPassword=" + GPPassword + "]";
	}
}
