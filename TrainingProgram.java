package e23178_e23009;


public class TrainingProgram {
	 															//δηλωση των πεδιων της κλασης ΤrainingProgram ως private
	private User userCount; //κωδικος χρηστη
	private Sport sport;   //σπορ που σχετιζεται
	private Facility facility;  //εγκατασταση που σχετιζεται
	private Coach coach;      //προπονητης που θα το αναλαβει
	private int minExperience;     //ελαχιστη εμπειρια συμμετεχοντων
	private boolean weeklyReservation;   //απαιτειται εβδομαδιαια κρατηση
	private User gender;             //φυλο
	private float minDuration;      //διαρκεια σε λεπτα
	private int day;    //μερα
	
																				//ορισμος constructor με παραμετρους τα πεδια της κλασης User
	TrainingProgram(User userCount, Sport sport, Facility facility, Coach coach, int minExperience, boolean weeklyResernvation, User gender, float minDuration, int day){
		this.setUserCount(userCount);
		this.setSport(sport);
		this.setFacility(facility);
		this.setCoach(coach);
		this.setMinExperience(minExperience);
		this.setWeeklyReservation(weeklyResernvation);
		this.setGender(gender);
		this.setMinDuration(minDuration);
		this.setDay(day);
	
	}
	
	
	           										//ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
	public void setUserCount(User userCount) { 
		this.userCount=userCount;
	}
	public User getUserCount() {
		return this.userCount;
	}
	
	public void setSport (Sport sport){
		this.sport=sport;
	}
	public Sport getSport() {
		return this.sport;
	}
	
	public void setFacility (Facility facility){
		this.facility=facility;
	}
	public Facility getFacility() {
		return this.facility;
	}
	
	public void setCoach (Coach coach){
		this.coach=coach;
	}
	public Coach getCoach() {
		return this.coach;
	}
	
	public void setMinExperience (int minExperience){
		this.minExperience=minExperience;
	}
	public int getMinExperience() {
		return this.minExperience;
	}
	
	public void setWeeklyReservation (boolean weeklyReservation){
		this.weeklyReservation=weeklyReservation;
	}
	public boolean getWeeklyReservation() {
		return this.weeklyReservation;
	}
	
	public void setGender (User gender){
		this.gender=gender;
	}
	public User getGender() {
		return this.gender;
	}
	
	public void setMinDuration (float minDuration){
		if (minDuration>0) {                          //η διαρκεια πρπει να ειναι θετικος αρθμος
			this.minDuration=minDuration;
		}
		
	}
	public float getMinDuration() {
		return this.minDuration;
	}
	
	public void setDay (int day){                   //επιτεπομενος ευρος τιμων 1-7
		if (day>=1 && day<=7) {
			this.day=day;
		}
	}
	public int getDay() {
		return this.day;
	}
	
}	