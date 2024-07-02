package gr.unipi.core;


public class Subscription implements Pricelist{                  

		private String subCode;  
		private Athlete athlete;   
		private static TrainingProgram selectedTrainingProgram;
		private double monthlyCost;
        public Subscription(String subCode, Athlete athlete, TrainingProgram selectedTrainingProgram, double monthlyCost){
			this.setSubCode(subCode);
			this.setAthlete(athlete);
			this.setSelectedTrainingProgram(selectedTrainingProgram);
			this.setMonthlyCost (monthlyCost);
		}
		
		public void setSubCode(String subCode) {
			this.subCode=subCode;
		}
		public String getSubCode() {
			return this.subCode;
		}
		
		public void setAthlete(Athlete athlete) {
			this.athlete=athlete;
		}
		public Athlete getAthlete() {
			return this.athlete;
		}
		
		public void setSelectedTrainingProgram(TrainingProgram selectedTrainingProgram) {
			this.selectedTrainingProgram=selectedTrainingProgram;
		}
		
		public static TrainingProgram getSelectedTrainingProgram() {
			return selectedTrainingProgram;
		}
		
		public void setMonthlyCost(double monthlyCost) {
			this.monthlyCost=monthlyCost;
		}
		public double getMonthlyCost() {
			return this.monthlyCost;
		}


		@Override
		public double calculateTotalPrice() {          //χρηση μεθοδου override για την υλοποιηση της διεπαφης που χρησιμοποιει τη μεθοδο calculateTotalPrice για τον υπολογισμο του χρονικου κοστους
			return monthlyCost;
		}

		public int getUserCount() {
			return athlete.getUserCount();
		}

}	

		