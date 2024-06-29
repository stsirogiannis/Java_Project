package gr.unipi.core;



public class Enrollment implements Pricelist {
	private int userCount;
	private Athlete athlete;
	private String enrollmentDate;
	private double enrollCost;
	private double discount;

	public Enrollment(int userCount, Athlete athlete, String enrollmentDate, double enrollCost, double discount) {
		this.userCount = userCount;
		this.athlete = athlete;
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

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
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