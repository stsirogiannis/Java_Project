package e23009_e23178;

public class Payment implements Pricelist{

	private User password; //κωδικος χρηστη                          //δηλωση των πεδιων της κλασης ως private
	private TrainingProgramReservation date;
	private String paymentMethod;  //τροπος πληρωμης
	private Subscription subscription;
	private Enrollement enrollement;
	private double totalCost;  //συνολικο κοστος
	
    
	                                                               //ορισμος constructor με παραμετρους τα πεδια της κλασης
	Payment(User password, TrainingProgramReservation date, String paymentMethod, Subscription subscription, Enrollement enrollement, double total_cost){
		this.setPassword(password);
		this.setDate(date);
		this.setPaymentMethod(paymentMethod);
		this.setSubscription(subscription);
		this.setEnrollement(enrollement);
		this.setTotalCost(totalCost);
	}

	public User getPassword() {                      //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
		return password;
	}

	public void setPassword(User password) {
		this.password = password;
	}

	public TrainingProgramReservation getDate() {
		return date;
	}

	public void setDate(TrainingProgramReservation date) {
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

	public Enrollement getEnrollement() {
		return enrollement;
	}

	public void setEnrollement(Enrollement enrollement) {
		this.enrollement = enrollement;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	


	@Override
	public double calculateTotalPrice() {                //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του υνολικου κοστους
		
		return totalCost;
		
	}
	

}
