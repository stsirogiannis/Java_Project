

public class Enrollement implements Pricelist {
	                                                                           
	                                                              //δηλωση των πεδιων της κλασης ως private
	private User password;  //κωδικος user
	private Athlete athlete;
	private TrainingProgramReservation date;
	private double enrolCost;  //κοστος εγγραφης
	private int discountRate;   //ποσοστο εκπτωσης που αντιστοιχει στην εγγραφη
	
	                                                                   //ορισμος constructor με παραμετρους τα πεδια της κλασης
	Enrollement (User password, Athlete athlete, TrainingProgramReservation date, double enrolCost, int discountRate){
		this.setPassword(password);
		this.setAthlete(athlete);
		this.setDate(date);
		this.setEnrolCost(enrolCost);
		this.setDiscountRate(discountRate);
	}

	public User getPassword() {  //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
		return password;
	}

	public void setPassword(User password) {
		this.password = password;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public TrainingProgramReservation getDate() {
		return date;
	}

	public void setDate(TrainingProgramReservation date) {
		this.date = date;
	}

	public double getEnrolCost() {
		return enrolCost;
	}

	public void setEnrolCost(double enrolCost) {
		this.enrolCost = enrolCost;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
	
	public double calculateInitialEnrolCost() {     //υπολογισμος του αρχικου κοστους εγγραφης χωρις την εκπτωση με τη χρηση μεθοδου που εξαρταται απο την ιδιοτητα ή μη επαγγελματια
		if (Athlete.getIsProfessional() == false) {
			enrolCost = 50;
		} else {
			enrolCost = 20;
		}
		setEnrolCost(enrolCost);
		return enrolCost;
	}
	
	public int calculateDiscountRate() {                               //υπολογισμος της ποσοστιαιας εκπτωσης με τη χρηση μεθοδου που εξαρταται απο την τα χρονια εμπειριας 
		
		if (Athlete.getIsProfessional() == false) {
			if (Athlete.getExperience()>=1 && Athlete.getExperience()<=2) {
				discountRate=10;
			}
			else if (Athlete.getExperience()<=4) {
				discountRate=20;
			}
			else if(Athlete.getExperience()<=5) {
				discountRate=30;
			}	
		else 
			if (Athlete.getExperience()>=1 && Athlete.getExperience()<=2) {
				discountRate=30;
			}
			else if (Athlete.getExperience()<=4) {
				discountRate=40;
			}
			else if(Athlete.getExperience()<=5) {
				discountRate=50;
			}	
		}	
		
		setDiscountRate(discountRate);
		return discountRate;
	}

	@Override                                                        //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του κοστους με την εκπτωση
	public double calculateTotalPrice() {
		return enrolCost- (discountRate/100)*enrolCost;
	}	
		
	
	 
	
	
	
}
