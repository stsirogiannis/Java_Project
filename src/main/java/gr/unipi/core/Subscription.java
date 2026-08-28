package gr.unipi.core;

public class Subscription implements Pricelist{

	//fields
	private String subCode;
	private Athlete athlete;
	private TrainingProgram trainingProgram; // FIX: removed static
	private double monthlyCost;

	//constructor
	public Subscription(String subCode, Athlete athlete, TrainingProgram trainingProgram, double monthlyCost){
		this.setSubCode(subCode);
		this.setAthlete(athlete);
		this.setTrainingProgram(trainingProgram);
		this.setMonthlyCost (monthlyCost);
	}

	//setters & getters
	public void setSubCode(String subCode) {
		this.subCode=subCode;
	}
	public String getSubCode() {
		return this.subCode;
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
	public TrainingProgram getTrainingProgram() { // FIX: removed static
		return trainingProgram;
	}

	public void setMonthlyCost(double monthlyCost) {
		this.monthlyCost=monthlyCost;
	}
	public double getMonthlyCost() {
		return this.monthlyCost;
	}


	@Override
	public double calculateTotalPrice() {
		return monthlyCost;
	}

	public int getUserCount() {
		return athlete.getUserCount();
	}

}