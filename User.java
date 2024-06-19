package e23178_e23009;



public class User {

	private int userCount;
	private String name;
	private String surname;
	private char gender;
	private String birthDate;
	private String contactInfo;
	
	User (int userCount, String name, String surname, char gender, String birthDate, String contactInfo){   //ορισμος constructor με παραμετρους τα πεδια της κλασης User
		this.setUserCount(userCount);
		this.setName(name);
		this.setSurname(surname);
		this.setGender(gender);
		this.setBirthDate(birthDate);
		this.setContactInfo(contactInfo);
		
	} 
		
	public void setUserCount(int userCount) { //ορισμος μεθοδων getters και setters για τη θεση και την ανακτηση των τιμων της User
		this.userCount=userCount;
	}
	public int getUserCount() {
		return this.userCount;
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
	
	
	
	
}
