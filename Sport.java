package e23178_e23009;


public class Sport {
																//δηλωση των πεδιων της κλασης Sport ως private
	private String sportName;   //ονομα σπορ                                          
	private boolean professionalAccess;//επιτρεπομενη προσβαση μονο σε επαγγελματιες
	
	Sport(String sportName, boolean professionalAccesss){             //ορισμος constructor με παραμετρους τα πεδια της κλασης Sport
		this.setSportName(sportName);
		this.setProfessionalAccess(professionalAccess);
	}
	
	public void setSportName(String sportName) {                    //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της Sport
		this.sportName=sportName;
	}
	public String getSportName() {
		return this.sportName;
	}
	
	public void setProfessionalAccess(boolean professionalAccess) {
		this.professionalAccess=professionalAccess;
	}
	public boolean getProfessionalAccess() {
		return this.professionalAccess;
	}
	
}
