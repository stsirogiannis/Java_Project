package gr.unipi.core;

import javafx.scene.control.ComboBox;

public class Payment implements Pricelist {

	private int payCode; //κωδικος χρηστη, δηλωση των πεδιων της κλασης ως private
	private String payDate;
	private ComboBox<String> paymentMethod;  //τροπος πληρωμης
	private Subscription subscription;
	private Enrollment enrollment;
	private double totalCost;  //συνολικο κοστος
	
    
	                                                               //ορισμος constructor με παραμετρους τα πεδια της κλασης
	Payment(int  payCode, String payDate, ComboBox <String> paymentMethod, Subscription subscription, Enrollment enrollment, double totalCost){
		this.setPayCode(payCode);
		this.setPayDate(payDate);
		this.setPaymentMethod(paymentMethod);
		this.setSubscription(subscription);
		this.setEnrollment(enrollment);
		this.setTotalCost(totalCost);
	}

	public int getPayCode() {                      //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
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

	public ComboBox <String> getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(ComboBox <String> paymentMethod) {
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
	


	@Override
	public double calculateTotalPrice() {                //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του υνολικου κοστους
		
		return this.totalCost;
	}	
}	
		