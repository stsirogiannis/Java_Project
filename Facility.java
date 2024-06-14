

public class Facility {
	
	private String facilityName; //ονομα εκαταστασης                            //δηλωση των πεδιων της κλασης Facility ως private
	private int maxCapacity;    //μεγιστη χωριτικοτητα ατομων 
	
	Facility (String faciltyName, int maxCapacity){                  //ορισμος constructor με παραμετρους τα πεδια της κλασης Facility
		this.setFacilityName(facilityName);
		this.setMaxCapacity(maxCapacity);
	}
	
	public void setFacilityName(String facilityName) {                //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της Facility
		this.facilityName=facilityName;
	}
	public String getFacilityName() {
		return this.facilityName;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		if (maxCapacity > 0) {
		this.maxCapacity=maxCapacity;
		}
	}
	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
	
	
}
