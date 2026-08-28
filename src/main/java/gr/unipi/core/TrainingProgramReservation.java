package gr.unipi.core;

public class TrainingProgramReservation {

	//TrainingProgramReservation fields
	private String TPRCode;
	private Athlete athlete;
	private TrainingProgram trainingProgram;
	private String date;
	
	//constructor
	public TrainingProgramReservation(String TPRCode, Athlete athlete, TrainingProgram trainingProgram, String date){
		this.setTPRCode(TPRCode);
		this.setAthlete(athlete);
		this.setTrainingProgram(trainingProgram);
		this.setDate(date);
	}

	//setters & getters
	public void setTPRCode(String TPRCode) {
		this.TPRCode=TPRCode;
	}
	public String getTPRCode() {
		return this.TPRCode;
	}
	
	public void setAthlete(Athlete athlete) {
		this.athlete=athlete;
	}
	public Athlete getAthlete() {
		return this.athlete;
	}
	
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram=trainingProgram;
	}
	public TrainingProgram getTrainingProgram() {
		return this.trainingProgram;
	}
	
	public void setDate(String date) {
		this.date=date;
	}

	public String getDate() {
		return this.date;
	}

	public int getUserCount() {
		return athlete.getUserCount();
	}
	public int getTPCount() {
		return this.trainingProgram.getTPCount(); // FIX: was Subscription.getTrainingProgram().getTPCount();
	}
}