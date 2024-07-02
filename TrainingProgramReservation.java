package gr.unipi.core;


public class TrainingProgramReservation {

	
			//δηλωση των πεδιων της κλασης ως private
	private String TPRCode;  //κωδικος trainingProgramReservation
	public Athlete selectedAthlete;        
	private TrainingProgram selectedTrainingProgram;       
	private String date;     
	
	//ορισμος constructor με παραμετρους τα πεδια της κλασης 
	public TrainingProgramReservation (String TPRCode, Athlete selectedAthlete, TrainingProgram selectedTrainingProgram, String date){
		this.setTPRCode(TPRCode);
		this.setSelectedAthlete(selectedAthlete);
		this.setSelectedTrainingProgram(selectedTrainingProgram);
		this.setDate(date);
	}
	
	//ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
	public void setTPRCode(String TPRCode) {
		this.TPRCode=TPRCode;
	}
	public String getTPRCode() {
		return this.TPRCode;
	}
	
	
	public void setSelectedAthlete(Athlete selectedAthlete) {
		this.selectedAthlete=selectedAthlete;
	}
	public Athlete getSelectedAthlete() {
		return this.selectedAthlete;
	}
	
	
	public void setSelectedTrainingProgram(TrainingProgram selectedTrainingProgram) {
		this.selectedTrainingProgram=selectedTrainingProgram;
	}
	public TrainingProgram getSelectedTrainingProgram() {
		return this.selectedTrainingProgram;
	}
	
	
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return this.date;
	}


	 // New getters for userCount and TPCount
    public int getUserCount() {
        return selectedAthlete.getUserCount();
    }

    public int getTPCount() {
        return Subscription.getSelectedTrainingProgram().getTPCount();
    }



}