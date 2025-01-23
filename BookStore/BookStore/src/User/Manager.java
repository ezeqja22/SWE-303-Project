package User;

public class Manager {

	private String ManagerId, ManagerPassword;

	public Manager(String ManagerId, String ManagerPassword) {
		super();
		this.ManagerId = ManagerId;
		this.ManagerPassword = ManagerPassword;
	}

	public String getManagerId() {
		return ManagerId;
	}

	public void setManagerId(String ManagerId) {
		this.ManagerId = ManagerId;
	}
	
	public String getManagerPassword() {
		return ManagerPassword;
	}

	public void setManagerPassword(String ManagerPassword) {
		this.ManagerPassword = ManagerPassword;
	}
	
}
