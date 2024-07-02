package gr.unipi.core;

public class Facility {

	//Facility fields
	private String facilityName;
	private int maxCapacity;

	//constructor
	public Facility(String facilityName, int maxCapacity){
		this.setFacilityName(this.facilityName);
		this.setMaxCapacity(maxCapacity);
	}

	//setters & getters
	public void setFacilityName(String facilityName) {
		this.facilityName=facilityName;
	}
	public String getFacilityName() {
		return this.facilityName;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		if (maxCapacity > 0) { //the maximum capacity of the facility must be a positive number
		this.maxCapacity=maxCapacity;
		}
	}

	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
}
