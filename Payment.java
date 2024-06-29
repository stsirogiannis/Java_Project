package gr.unipi.core;


public class Payment implements Pricelist {

	private int payCode;
	private String payDate;
	private String paymentMethod;
	private Subscription subscription;
	private Enrollment enrollment;
	private double totalCost;

	public Payment(int payCode, String payDate, String paymentMethod, Subscription subscription, Enrollment enrollment, double totalCost){
		this.setPayCode(payCode);
		this.setPayDate(payDate);
		this.setPaymentMethod(paymentMethod);
		this.setSubscription(subscription);
		this.setEnrollment(enrollment);
		this.setTotalCost(totalCost);
	}


	public int getPayCode() {
		return payCode;
	}

	public void setPayCode(int payCode) {
		this.payCode = payCode;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public double calculateTotalPrice() {

		return this.totalCost;
	}
}
