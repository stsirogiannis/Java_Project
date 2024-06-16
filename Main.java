package e23178_e23009;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static int userCount = 1;
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		
		
		
		
		
		ArrayList<User> userList = new ArrayList<User>();
		System.out.println("Please enter your personal info: ");
		
		
		System.out.println("Name: ");
		String name= sc.next();
		System.out.println("Surname");
		String surname=sc.next();
		System.out.println("Gender: (enter F for female and M for male");
		char gender;
		do {
			gender = sc.next().charAt(0);
		    if (gender == 'F' || gender == 'M') {
		        break; 
		    } else {
		        System.out.println("Invalid value, try again");
		    }
	    
		}while (gender!='F'&& gender!='M');
		System.out.println("Date of birth: ");
		String birthDate= sc.next();
		System.out.println("Contact info: ");
		String contactInfo= sc.next();
		
		User user = new User(userCount, name, surname, gender, birthDate, contactInfo);
        userList.add(user);
        
       
        
        
        
        
        
        
        
        
        
        ArrayList <Athlete> athleteList= new ArrayList<Athlete>();
        boolean isProfessional;
        String response;
        System.out.println("Are you a proffeasional athlete? (enter yes if you are, otherwise enter no");
        do {
        	response=sc.next();
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
	        	experience=sc.nextInt();
	        		if (experience>=1 && experience<=5) {
	        			break;
	        		}
	        		else {
	        			System.out.println("Invalid value, try again");
	        		}
        	}catch (Exception e){
	        	System.out.println("Please enter a number");
	        	sc.next();   // Clear the invalid input from the --scanner buffer--
        	}
        }while(true);
        Athlete athlete= new Athlete (userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
        athleteList.add(athlete);
        
       

        
        
        
        
        ArrayList<Enrollement> enrollement= new ArrayList<Enrollement>();
        ArrayList<Payment> payment= new ArrayList<Payment>();
        
        
		
		
		
		
		userCount++;

	}

}
