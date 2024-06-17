package e23178_e23009;


public class Athlete extends User {                                  // η κλαση athlete κληρονομει την κλαση User
	
	private boolean isProfessional;  //ιδιοτητα επαγγελματια, δηλωση των πεδιων της κλασης Athlete ως private static για να χρησιμοποιηθουν στην κλαση Subscription & Enrollement
	private int experience;         // χρονια εμπειριας                         
	Athlete (int userCount, String name, String surname, char gender, String birthDate, String contactInfo, boolean isProfessional, int experience){
		super (userCount, name, surname, gender, birthDate, contactInfo);
		this.setIsProfessional(isProfessional);
		this.setExperience(experience);
	}
	
	public void setIsProfessional(boolean isProfessional) {                       //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της Athlete
		this.isProfessional= isProfessional;
	}
	public boolean getIsProfessional() {
		return this.isProfessional;
	}
	
	public void setExperience(int experience) {
		if (experience>=1 && experience<=5) {
			this.experience=experience;
		}
	}
	public int getExperience() {
		return this.experience;
	}
	
	
	
}
