package gr.unipi.core;

public class Coach extends User {
	
	private Sport sport; //Sport που κανει ο coach, δηλωση των πεδιων της κλασης Coach ως private
	private int degrees;//αριθμος πτυχιων 
	                                                             
	                                                               //ορισμος constructor με παραμετρους τα πεδια της κλασης
	public Coach (int userCount, String name, String surname, char gender, String birthDate, String contactInfo, Sport sport, int degrees){
		super (userCount, name, surname, gender, birthDate, contactInfo);
		this.setSport(sport);
		this.setDegrees(degrees);	
	}
	
	public void setSport(Sport sport) {                            //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της Coach
		this.sport=sport;
	}
	public Sport getSport() {
		return this.sport;
	}
	
	public void setDegrees(int degrees) {
		if (degrees>0) {
			this.degrees= degrees;
		}
	}
	public int getDegrees() {
		return this.degrees;
	}
	
	public String toString() {
		return new String (" {" +super.toString() + "\n"
							+"Sport: "+ sport +"\n"
							+"Degrees: "+degrees+ "\n"
							+"}");
	}


	
}
