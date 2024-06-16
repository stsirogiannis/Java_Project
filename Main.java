package e23178_e23009;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static int userCount = 0;
	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<>();
		
		System.out.println("Please enter your personal info: ");
		
		Scanner sc= new Scanner(System.in);
		
		int userCount=1;
		System.out.println("Name: ");
		String name= sc.next();
		System.out.println("Surname");
		String surname=sc.next();
		System.out.println("Gender: (enter F for female and M for male");
		char gender;
		do {
			gender = sc.next().charAt(0);
		    if (gender == 'F' || gender == 'M') {
		        break; // Exit the loop if a valid value is entered
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
        
        
        boolean professional;
        String response;
        System.out.println("Are you a proffeasional athlete? (enter yes if you are, otherwise enter no");
        do {
        	response=sc.next();
        	if(response!="yes" && response!="no") {
        		System.out.println("invalid response, try again");
        		professional=true;
        	}
        	else {
        		professional=false;
        		break;
        	}
        }while(response!="no"&& response!="yes");
        
        
        
        

        ArrayList<Enrollement> enrollement= new ArrayList();
        
		
		
		
		
		userCount++;

	}

}
