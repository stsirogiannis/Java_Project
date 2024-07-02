package gr.unipi.core;

public class Sport {

	//Sport fields
	private String sportName;
	private boolean professionalAccess;

	//constructor

	public Sport(String sportName, boolean professionalAccess) {
		this.professionalAccess = professionalAccess;
		this.sportName = sportName;
	}

	//setters & getters
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public boolean isProfessionalAccess() {
		return professionalAccess;
	}
	public void setProfessionalAccess(boolean professionalAccess) {
		this.professionalAccess = professionalAccess;
	}
}
