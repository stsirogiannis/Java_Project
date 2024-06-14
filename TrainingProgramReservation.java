

public class TrainingProgramReservation {

	
	 																				//δηλωση των πεδιων της κλασης ως private
	private TrainingProgram password;    //κωδικος του trainingProgram του user
	private Athlete athlete;        //αθλητης
	private TrainingProgram trainingProgram;       
	private String date;     //ημε/νια κρατησης
	
	                                                                            //ορισμος constructor με παραμετρους τα πεδια της κλασης 
	TrainingProgramReservation (TrainingProgram password, Athlete athlete, TrainingProgram trainingProgram, String date){
		this.setPassword(password);
		this.setAthlete(athlete);
		this.setTrainingProgram(trainingProgram);
		this.setDate(date);
	}
	
	                                                     //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
	public void setPassword(TrainingProgram password) {
		this.password=password;
	}
	public TrainingProgram getPassword() {
		return this.password;
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
	
	
	
	
}
