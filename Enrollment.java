package e23178_e23009;



public class Enrollment implements Pricelist {
	                                                                           
	                                                              //δηλωση των πεδιων της κλασης ως private
	private int userCount;  //κωδικος user
	private Athlete athlete;
	private String date;
	private double enrollCost;  //κοστος εγγραφης
	private int discountRate;   //ποσοστο εκπτωσης που αντιστοιχει στην εγγραφη
	
	                                                                   //ορισμος constructor με παραμετρους τα πεδια της κλασης
	Enrollment (int userCount, Athlete athlete, String date, double enrollCost, int discountRate){
		this.setUserCount(userCount);
		this.setAthlete(athlete);
		this.setDate(date);
		this.setEnrollCost(enrollCost);
		this.setDiscountRate(discountRate);
	}

			//ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
	public void setUserCount(int userCount) { 
		this.userCount=userCount;
	}
	public int getUserCount() {
		return this.userCount;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getEnrollCost() {
		return enrollCost;
	}

	public void setEnrollCost(double enrollCost) {
		this.enrollCost = enrollCost;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	

	@Override                                                        //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του κοστους με την εκπτωση
	public double calculateTotalPrice() {
		return enrollCost-(discountRate/100.0)*enrollCost;
	}	
}	
	