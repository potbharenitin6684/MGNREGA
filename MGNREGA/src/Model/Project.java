package Model;

public class Project {
	
	private int Pid;
	private int PGpid;
	private String PName;
	private int PCost;
	private int Pduration;
	
	public Project(int pid, int pGpid, String pName, int pCost, int pduration) {
		super();
		Pid = pid;
		PGpid = pGpid;
		PName = pName;
		PCost = pCost;
		Pduration = pduration;
	}

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public int getPGpid() {
		return PGpid;
	}

	public void setPGpid(int pGpid) {
		PGpid = pGpid;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public int getPCost() {
		return PCost;
	}

	public void setPCost(int pCost) {
		PCost = pCost;
	}

	public int getPduration() {
		return Pduration;
	}

	public void setPduration(int pduration) {
		Pduration = pduration;
	}

	@Override
	public String toString() {
		return "Project [Pid=" + Pid + ", PGpid=" + PGpid + ", PName=" + PName + ", PCost=" + PCost + ", Pduration="
				+ Pduration + "]";
	}
}
