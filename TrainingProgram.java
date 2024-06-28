package gr.unipi.core;

import javafx.scene.control.ComboBox;

public class TrainingProgram {
	 															//δηλωση των πεδιων της κλασης ΤrainingProgram ως private
	private int TPCount; 
	private Sport sport;   //σπορ που σχετιζεται
	private Facility facility;  //εγκατασταση που σχετιζεται
	private Coach coach;      //προπονητης που θα το αναλαβει
	private int minExperience;     //ελαχιστη εμπειρια συμμετεχοντων
	private boolean weeklyReservation;   //απαιτειται εβδομαδιαια κρατηση
	private char gender;             //φυλο
	private int minDuration;      //διαρκεια σε λεπτα
	private ComboBox<String> dayComboBox;    //μερα
	
																				//ορισμος constructor με παραμετρους τα πεδια της κλασης User
	public TrainingProgram(int TPCount, Sport sport, Facility facility, Coach coach, int minExperience, boolean weeklyReservation, char gender, int minDuration, ComboBox<String> dayComboBox){
		this.setTPCount( TPCount);
		this.setSport(sport);
		this.setFacility(facility);
		this.setCoach(coach);
		this.setMinExperience(minExperience);
		this.setWeeklyReservation(weeklyReservation);
		this.setGender(gender);
		this.setMinDuration(minDuration);
		this.setDayComboBox(dayComboBox);
	
	}
	
	
	           										//ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της
	public void setTPCount(int TPCount) { 
		this.TPCount=TPCount;
	}
	public int getTPCount() {
		return this.TPCount;
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
	
	public void setGender (char gender){
		this.gender=gender;
	}
	public char getGender() {
		return this.gender;
	}
	
	public void setMinDuration (int minDuration){
		if (minDuration>0) {                          //η διαρκεια πρπει να ειναι θετικος αρθμος
			this.minDuration=minDuration;
		}
		
	}
	public int getMinDuration() {
		return this.minDuration;
	}
	
	public void setDayComboBox (ComboBox<String> dayComboBox){                   
			this.dayComboBox=dayComboBox;
	}
	public ComboBox<String> getDayComboBox() {
		return this.dayComboBox;
	}
	
	
	
	
	
	 public String toString() {
	        return "{" +  "TPCode="+TPCount + "\n"
	                + "sport=" + sport + "\n"
	                + "facility=" + facility + "\n"
	                +"coach=" + coach + "\n"
	                + "minExperience=" + minExperience + "\n"
	                + "weeklyReservation=" + weeklyReservation + "\n"
	                + "gender=" + gender + "\n"
	                + "minDuration=" + minDuration +"\n"
	                + "day=" + dayComboBox +
	                '}';
	    }
	
}	