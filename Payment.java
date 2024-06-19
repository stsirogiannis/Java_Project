package e23178_e23009;


public class Payment implements Pricelist {

	private int payCode; //κωδικος χρηστη, δηλωση των πεδιων της κλασης ως private
	private String date;
	private String paymentMethod;  //τροπος πληρωμης
	private Subscription subscription;
	private Enrollment enrollment;
	private double totalCost;  //συνολικο κοστος
	
    
	                                                               //ορισμος constructor με παραμετρους τα πεδια της κλασης
	Payment(int  payCode, String date, String paymentMethod, Subscription subscription, Enrollment enrollment, double totalCost){
		this.setPayCode(payCode);
		this.setDate(date);
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	


	@Override
	public double calculateTotalPrice() {                //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του υνολικου κοστους
		
		return this.totalCost;
	}	
}	
		