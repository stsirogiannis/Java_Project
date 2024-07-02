package gr.unipi.core;



public class Enrollment implements Pricelist {
	private int userCount;
	private Athlete selectedAthlete;
	private String enrollmentDate;
	private double enrollCost;
	private double discount;

	public Enrollment(int userCount, Athlete selectedAthlete, String enrollmentDate, double enrollCost, double discount) {
		this.userCount = userCount;
		this.selectedAthlete = selectedAthlete;
		this.enrollmentDate = enrollmentDate;
		this.enrollCost = enrollCost;
		this.discount = discount;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public Athlete getSelectedAthlete() {
		return selectedAthlete;
	}

	public void setSelectedAthlete(Athlete selectedAthlete) {
		this.selectedAthlete = selectedAthlete;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public double getEnrollCost() {
		return enrollCost;
	}

	public void setEnrollCost(double enrollCost) {
		this.enrollCost = enrollCost;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public double calculateTotalPrice() {
		return this.enrollCost;
	}





}