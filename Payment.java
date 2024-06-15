package e23178_e23009;


public class Payment implements Pricelist {

	private User userCount; //κωδικος χρηστη, δηλωση των πεδιων της κλασης ως private
	private TrainingProgramReservation date;
	private String paymentMethod;  //τροπος πληρωμης
	private Subscription subscription;
	private Enrollement enrollement;
	private double totalCost;  //συνολικο κοστος
	
    
	                                                               //ορισμος constructor με παραμετρους τα πεδια της κλασης
	Payment(User  userCount, TrainingProgramReservation date, String paymentMethod, Subscription subscription, Enrollement enrollement, double total_cost){
		this.setUserCount(userCount);
		this.setDate(date);
		this.setPaymentMethod(paymentMethod);
		this.setSubscription(subscription);
		this.setEnrollement(enrollement);
		this.setTotalCost(totalCost);
	}

	public User getuUserCount() {                      //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
		return userCount;
	}

	public void setUserCount(User userCount) {
		this.userCount = userCount;
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
		