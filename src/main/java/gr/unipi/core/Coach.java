package gr.unipi.core;

public class Coach extends User {

	//Coach fields
	private Sport sport;
	private int degrees;

	//constructor
    public Coach(int userCount, String name, String surname, char gender, String birthDate, String contactInfo, Sport sport, int degrees){
		super (userCount, name, surname, gender, birthDate, contactInfo);
		this.setSport(sport);
		this.setDegrees(degrees);	
	}

	//setters & getters
	public void setSport(Sport sport) {
		this.sport=sport;
	}
	public Sport getSport() {
		return this.sport;
	}
	
	public void setDegrees(int degrees) {
		if (degrees>0) { //degrees of coach must be a positive number
			this.degrees= degrees;
		}
	}
	public int getDegrees() {
		return this.degrees;
	}
	
}