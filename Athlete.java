package e23009_e23178;

public class Athlete extends User {                                  // η κλαση athlete κληρονομει την κλαση User
	
	private static boolean isProfessional;  //ιδιοτητα επαγγελματια                            //δηλωση των πεδιων της κλασης Athlete ως private static για να χρησιμοποιηθουν στην κλαση Subscription & Enrollement
	private static int experience;         // χρονια εμπειριας                         
	Athlete (long password, String name, String surname, char gender, String birthDate, String contactInfo, boolean isProfessional, int experience){
		super (password, name, surname, gender, birthDate, contactInfo);
		Athlete.setIsProfessional(isProfessional);
		Athlete.setExperience(experience);
	}
	
	public static void setIsProfessional(boolean isProfessional) {                       //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της Athlete
		Athlete.isProfessional= isProfessional;
	}
	public static  boolean getIsProfessional() {
		return Athlete.isProfessional;
	}
	
	public static void setExperience(int experience) {
		if (experience>=1 && experience<=5) {
			Athlete.experience=experience;
		}
	}
	public static int getExperience() {
		return Athlete.experience;
	}
	
	
	
}
