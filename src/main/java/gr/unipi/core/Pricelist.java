package gr.unipi.core;

public interface Pricelist {

	//Pricelist interface fields
	int amateurEnrollmentPrice = 50;
	int professionalEnrollmentPrice = 20;
	double discountRate12 = 0.1;
	double discountRate34 = 0.2;
	double discountRate5 = 0.3;
	double discountRateProf = 0.2;

	double calculateTotalPrice();
	
}