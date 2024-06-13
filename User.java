package e23009_e23178;

public class User {
	                                              //δηλωση των πεδιων της κλασης User ως private
	private long password;              //κωδικος                                         
	private String name;               //ονομα
	private String surname;           //επωνυμο
	private char gender;             //φυλο
	private String birthDate;       //  ημ/νια γεννησης
	private String contactInfo;    //στοιχεια επικοινωνιας
	
	User (long code, String name, String surname, char gender, String birthDate, String contactInfo){         //ορισμος constructor με παραμετρους τα πεδια της κλασης User
		this.setPassword(password);
		this.setName(name);
		this.setSurname(surname);
		this.setGender(gender);
		this.setBirthDate(birthDate);
		this.setContactInfo(contactInfo);
	} 
		
	public void setPassword(long password) {                 //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της User
		this.password=password;
	}
	public long getPassword() {
		return this.password;
	}
		
		
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
		
	public void setSurname(String surname) {
		this.surname=surname;
	}
	public String getSurname() {
		return this.surname;
	}
		
	public void setGender(char gender) {
		this.gender=gender;
	}
	public char getGender() {
		return this.gender;
	}
		
	public void setBirthDate(String birthDate) {
		this.birthDate=birthDate;
	}
	public String getBirthDate() {
		return this.birthDate;
	}
		
	public void setContactInfo(String contactInfo) {
		this.contactInfo=contactInfo;
	}
	public String getContactInfo() {
		return this.contactInfo;
	}
	
	
	public String toString(){                                            //Μέθοδος toString που επιστρέφει τα στοιχεία επικοινωνίας ως String
		String contactInfo = new String("Contact Info: " +"\n"
										+ "Name: " +name+ "\n"
										+ "Surname" +surname+ "\n");
		return contactInfo;
	}
	
}
