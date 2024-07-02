package gr.unipi.core;


public class TrainingProgramReservation {

	
			//δηλωση των πεδιων της κλασης ως private
	private String TPRCode;  //κωδικος trainingProgramReservation
	public Athlete athlete;        
	private TrainingProgram trainingProgram;       
	private String date;     
	
	//ορισμος constructor με παραμετρους τα πεδια της κλασης 
	public TrainingProgramReservation (String TPRCode, Athlete athlete, TrainingProgram trainingProgram, String date){
		this.setTPRCode(TPRCode);
		this.setAthlete(athlete);
		this.setTrainingProgram(trainingProgram);
		this.setDate(date);
	}
	
	//ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
	public void setTPRCode(String TPRCode) {
		this.TPRCode=TPRCode;
	}
	public String getTPRCode() {
		return this.TPRCode;
	}
	
	
	public void setAthlete(Athlete athlete) {
		this.athlete=athlete;
	}
	public Athlete getAthlete() {
		return this.athlete;
	}
	
	
	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram=trainingProgram;
	}
	public TrainingProgram getTrainingProgram() {
		return this.trainingProgram;
	}
	
	
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return this.date;
	}


	 // New getters for userCount and TPCount
    public int getUserCount() {
        return athlete.getUserCount();
    }

    public int getTPCount() {
        return Subscription.getTrainingProgram().getTPCount();
    }



}