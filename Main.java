package e23178_e23009;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		int userCount = 1;
		
		Scanner stringScanner = new Scanner(System.in);
		Scanner intScanner= new Scanner(System.in);
		
		
		
		
		
		ArrayList<User> userList = new ArrayList<User>();
		System.out.println("Please enter your personal info: ");
		
		
		System.out.println("Name: ");
		String name= stringScanner.next();
		System.out.println("Surname");
		String surname=stringScanner.next();
		System.out.println("Gender: (enter F for female and M for male");
		char gender;
		do {
			gender = stringScanner.next().charAt(0);
		    if (gender == 'F' || gender == 'M') {
		        break; 
		    } else {
		        System.out.println("Invalid value, try again");
		    }
	    
		}while (gender!='F'&& gender!='M');
		System.out.println("Date of birth: ");
		String birthDate= stringScanner.next();
		System.out.println("Contact info: ");
		String contactInfo= stringScanner.next();
		
		User user = new User(userCount, name, surname, gender, birthDate, contactInfo);
        userList.add(user);
        
        
        
        
        
        
        
        
        
        
        
        ArrayList <Athlete> athleteList= new ArrayList<Athlete>();
        boolean isProfessional;
        String response;
        System.out.println("Are you a professional athlete? (enter yes if you are, otherwise enter no");
        do {
        	response=stringScanner.next();
        	if(response.equals("yes") || response.equals("no")) {
        		if(response.equals("no")) {
        			isProfessional=false;
        		}else {
        			isProfessional=true;
        		}
        		break;
        	}
        	else {
        		System.out.println("invalid response, try again");
        	}
        }while(true); // Continue looping until a valid response is received
        
        
        System.out.println("Enter your experience level (1-5)");
        int experience;
        
        do {
        	try {
	        	experience=intScanner.nextInt();
	        		if (experience>=1 && experience<=5) {
	        			break;
	        		}
	        		else {
	        			System.out.println("Invalid value, try again");
	        		}
        	}catch (Exception e){
	        	System.out.println("Please enter a number");
	        	intScanner.next();   // Clear the invalid input from the --scanner buffer--
        	}
        }while(true);
        Athlete athlete= new Athlete (userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
        athleteList.add(athlete);
        
        
       
        
        
        
        
        
        ArrayList<Enrollment> enrollmentList= new ArrayList<Enrollment>();
        ArrayList<Payment> paymentList= new ArrayList<Payment>();
        
        System.out.println("Please enter the Enrollement date: ");
        String date=stringScanner.next();
        
        double enrolCost;
        int discountRate = 0;
        
        if (athlete.getIsProfessional() == false) {     //το αντικειμενο του athlete ειναι δηλωμενο ως "athlete"
			enrolCost = 50;
			if (athlete.getExperience()>=1 && athlete.getExperience()<=2) {
				discountRate=10;
			}
			else if (athlete.getExperience()<=4) {
				discountRate=20;
			}
			else if(athlete.getExperience()<=5) {
				discountRate=30;
			}	
        }else {
			enrolCost = 20;
			if (athlete.getExperience()>=1 && athlete.getExperience()<=2) {
				discountRate=30;
			}
			else if (athlete.getExperience()<=4) {
				discountRate=40;
			}
			else if(athlete.getExperience()<=5) {
				discountRate=50;
			}
		}
        
       
        Enrollment enrollment= new Enrollment(userCount, athlete, date, enrolCost, discountRate);
        enrollmentList.add(enrollment);
        
        
        
		
		
		
		
		userCount++;

	}

}
