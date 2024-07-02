package gr.unipi.core;

public class Athlete extends User {

	//Athlete fields
	private boolean isProfessional;
	private int experience;

	//constructor
	public Athlete(int userCount, String name, String surname, char gender, String birthDate, String contactInfo, boolean isProfessional, int experience) {
		super(userCount, name, surname, gender, birthDate, contactInfo);
		this.setIsProfessional(isProfessional);
		this.setExperience(experience);
	}

	//setters & getters
	public void setIsProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}
	public boolean getIsProfessional() {
		return this.isProfessional;
	}

	public void setExperience(int experience) {
		if (experience >= 1 && experience <= 5) { //experience must be between 1 and 5
			this.experience = experience;
		}
	}
	public int getExperience() {
		return this.experience;
	}

}
