package gr.unipi.core;


public class TrainingProgramReservation {

	
			//δηλωση των πεδιων της κλασης ως private
	private String TPRCode;  //κωδικος trainingProgramReservation
	public Athlete athlete;        
	private TrainingProgram trainingProgram;       
	private String dateString;     
	
	//ορισμος constructor με παραμετρους τα πεδια της κλασης 
	public TrainingProgramReservation (String TPRCode, Athlete athlete, TrainingProgram trainingProgram, String dateString){
		this.setTPRCode(TPRCode);
		this.setAthlete(athlete);
		this.setTrainingProgram(trainingProgram);
		this.setDateString(dateString);
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
	
	
	public void setDateString(String dateString) {
		this.dateString=dateString;
	}
	public String getDateString() {
		return this.dateString;
	}






}