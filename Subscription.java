

public class Subscription implements Pricelist{                  //κλαση που υλοποιει τη διεπαφη Pricelist

	                                                                     //δηλωση των πεδιων της κλασης ως private		
		private e23009_e23178.User password;  //κωδικος χρηστη
		private Athlete athlete;   
		private e23009_e23178.TrainingProgram trainingProgram;
		private double monthlyCost;    //μηνιαιο κοστος ως double

		                                                                 //ορισμος constructor με παραμετρους τα πεδια της κλασης 
		Subscription(e23009_e23178.User password, Athlete athlete, e23009_e23178.TrainingProgram trainingProgram, double monthlyCost){
			this.setPassword(password);
			this.setAthlete(athlete);
			this.setTrainingProgram(trainingProgram);
			this.setMonthlyCost (monthlyCost);
		}
		
		public void setPassword(e23009_e23178.User password) {                                   //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
			this.password=password;
		}
		public e23009_e23178.User getPassword() {
			return this.password;
		}
		
		public void setAthlete(Athlete athlete) {
			this.athlete=athlete;
		}
		public Athlete getAthlete() {
			return this.athlete;
		}
		
		public void setTrainingProgram(e23009_e23178.TrainingProgram trainingProgram) {
			this.trainingProgram=trainingProgram;
		}
		public e23009_e23178.TrainingProgram getTrainingProgram() {
			return this.trainingProgram;
		}
		
		public void setMonthlyCost(double monthlyCost) {
			this.monthlyCost=monthlyCost;
		}
		public double getMonthlyCost() {
			return this.monthlyCost;
		}
		
		public double calculateMonthlyCost() {                     //υπολογισμος του μηνιαιου κοστους με τη χρηση μεθοδου που εξαρταται απο την τα χρονια εμπειριας και απο την ιδιοτητα ή μη επαγγελματια
			if (Athlete.getIsProfessional()==false) {
				if (Athlete.getExperience()>=1 && Athlete.getExperience()<=2) {
					monthlyCost = 50 - 0.10 * 50; 
				}
				else if(Athlete.getExperience()<=4) {
					monthlyCost= 50- 0.20*50;
				}
				else if(Athlete.getExperience()<=5) {
					monthlyCost= 50- 0.30*50;
				}
			}
			else {
				if (Athlete.getExperience()>=1 && Athlete.getExperience()<=2) {
					monthlyCost= 20- 0.10 *20;
				}
				else if(Athlete.getExperience()<=4) {
					monthlyCost= 20- 0.20 *20;
				}
				else if(Athlete.getExperience()<=5) {
					monthlyCost=20 -0.30 *20;
				}
				monthlyCost= monthlyCost-0.20 *monthlyCost;                      //υπαρχει εξτρα εκπτωση για τους επαγγελματιες
			}
			
			setMonthlyCost(monthlyCost);           //xρησιμοποιηση setter για την αποθηκευση της τιμης του μηνιαου κοστους στη μεταβλητη
			return monthlyCost;

		}
		
		@Override
		public double calculateTotalPrice() {          //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του χρονικου κοστους
			return monthlyCost*12;
		}
				
	
}
