package e23178_e23009;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int userCount = 1;
		
		Scanner stringScanner = new Scanner(System.in);         
		Scanner intScanner= new Scanner(System.in);
		
		
		
		
		
		ArrayList<User> userList = new ArrayList<User>();              //arrayList για την αποθηκευση των αντικειμενων του user
		System.out.println("Please enter your personal info: ");
		
		
		System.out.println("Name: ");                                  //o χρηστης εισαγει τα στοιχεια του
		String name= stringScanner.next();
		System.out.println("Surname");
		String surname=stringScanner.next();
		System.out.println("Gender: (enter F for female or M for male)");
		char gender;
		do {
			gender = stringScanner.next().charAt(0);                     
		    if (gender == 'F' || gender == 'M') {                             //του φυλο μπορει να ειναι μονο αντρας η γυναικα
		        break; 
		    } else {
		        System.out.println("Invalid value, try again");
		    }
	    
		}while (gender!='F'&& gender!='M');
		System.out.println("Date of birth: ");
		String birthDate= stringScanner.next();
		System.out.println("Contact info: ");
		String contactInfo= stringScanner.next();
		
		User user = new User(userCount, name, surname, gender, birthDate, contactInfo);        //δημιουργια αντικειμενου user
        userList.add(user);             //προσθηκη  του αντικειμενου user στην arrayList 
        
        
        
        
        
        
        
        
        
        
        
        ArrayList <Athlete> athleteList= new ArrayList<Athlete>();          //arrayList για την αποθηκευση των αντικειμενων του athlete
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
        }while(true);                                                        // συνεχεια του looping μεχρι την καταχωρηση μιας εγκυρης απαντησης
        
        
        System.out.println("Enter your experience level (1-5)");
        int experience;
        
        do {
        	try {                                                       //ελεγχος της πςριπτωσης εισαγωγης χαρακτηρων απο το χρηστη και εμφανιση αναλογου μηνυματος
	        	experience=intScanner.nextInt();
	        		if (experience>=1 && experience<=5) {
	        			break;
	        		}
	        		else {
	        			System.out.println("Invalid value, try again");
	        		}
        	}catch (Exception e){
	        	System.out.println("Please enter a number");
	        	intScanner.next();                                                    // καθαρισμος της ανεγκυρης τιμης απο το  --scanner buffer--
        	}
        }while(true);                                                                                      //δημοουργια αντικειμενου athlete 
        Athlete athlete= new Athlete (userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);       
        athleteList.add(athlete);                                                        //καταχωρηση του αντικειμενου athlete στην arrayList 
        
        
       
        
        
        
        
        int flag=0;
        ArrayList<Enrollment> enrollmentList= new ArrayList<Enrollment>();                 //δημιουργια arrayLists Enrollment & Payment
        ArrayList<Payment> paymentList= new ArrayList<Payment>();
        
        System.out.println("Please enter the Enrollement date: ");
        String date=stringScanner.next();
        
        double enrollCost;
        int discountRate = 0;                                                          // αρχικοποιηση discountRate με default τιμη
        int extraDiscountRate = 0;
        
        if (athlete.getIsProfessional() == false) {                                  //το αντικειμενο του athlete ειναι δηλωμενο ως "athlete"
			enrollCost = 50;                                                        //υπολογισμος κοστους εγγραφης  που εξαρταται απο την ιδιοτητα ή μη του επαγγελματια
			if (athlete.getExperience()>=1 && athlete.getExperience()<=2) {        //υπολογισμος της ποσοστιαιας εκπτωσης που εξαρταται απο την τα χρονια εμπειριας 
				discountRate=10;
			}
			else if (athlete.getExperience()<=4) {
				discountRate=20;
			}
			else if(athlete.getExperience()<=5) {
				discountRate=30;
			}	
        }else {
			enrollCost = 20;
			if (athlete.getExperience()>=1 && athlete.getExperience()<=2) {
				discountRate=10;
			}
			else if (athlete.getExperience()<=4) {
				discountRate=20;
			}
			else if(athlete.getExperience()<=5) {
				discountRate=30;
			}
			extraDiscountRate= 20;
		}
        
       
        Enrollment enrollment= new Enrollment(userCount, athlete, date, enrollCost, discountRate);      //δημιουργια αντικειμενου enrollment
        enrollmentList.add(enrollment);                                                   //προσθηκη του αντικειμενου enrollment στην arraylist
        
        double enrollTotalPrice = enrollment.calculateTotalPrice();                         //καταχωρηση του συνολικου ποσου της εγγραφης στην αντιστοιχη μεταβλητη μεσω της μεθοδου της διεπαφης Pricelist απο την Enrollment 
     
        enrollTotalPrice= enrollTotalPrice-(extraDiscountRate/100.0)* enrollTotalPrice; 
      
        
        System.out.println("Please enter your payment method");
        String paymentMethod= stringScanner.next();
        System.out.println("paymnetMethod is: "+paymentMethod);
       
        int payCode=1;
       
        Payment payment= new Payment (payCode, date, paymentMethod, null, enrollment, enrollTotalPrice);
       
        paymentList.add(payment);      
      
		System.out.println("Name: " +user.getName() + "\n"
        		          +"Surname: "+user.getSurname()+ "\n"
        		          +"User code: "+user.getUserCount()+"\n"
        		          +"Gender: " +user.getGender()+ "\n"
        		          +"Enrollment date: "+enrollment.getDate()+ "\n"
        		          +"Enrollment cost: "+payment.calculateTotalPrice());
						
		
		
		
		
		
		
		
		
		
		//SUBSCRIPTION
        flag=1;
        
        if (flag==1) {
        	
        	ArrayList <Subscription> subscriptionList= new ArrayList<Subscription>();
        	
        	int subCode=1;
        	
        	ArrayList<Sport> sportList= new ArrayList <Sport>();
        	System.out.println("Please enter the information below: ");
        	System.out.println("Sport Name: ");
        	String sportName= stringScanner.next();
        	System.out.println("Only professional access: (yes/no)");
        	boolean professionalAccess;
        	do {
            	response=stringScanner.next();
              	if(response.equals("yes") || response.equals("no")) {
              		if(response.equals("no")) {
              			professionalAccess=false;
              		}else {
              			professionalAccess=true;
              		}
              		break;
              	}
              	else {
              		System.out.println("invalid response, try again");
              	}
           }while(true);                                                        // συνεχεια του looping μεχρι την καταχωρηση μιας εγκυρης απαντησης
           Sport sport = new Sport(sportName, professionalAccess);
           sportList.add(sport);
           
           
           
           ArrayList<Facility> facilityList= new ArrayList <Facility>();
           System.out.println("Facility name: ");
           String facilityName= stringScanner.next();
           System.out.println("Max Capacity of participants: ");
           int maxCapacity=0;
           try {
        	   maxCapacity= intScanner.nextInt();
           }catch (Exception e) {
        	   System.out.println("Please enter a number: ");
           }
           Facility facility= new Facility(facilityName, maxCapacity);
           facilityList.add(facility);
           
           
           
           ArrayList <Coach> coachList = new ArrayList<Coach>();
           System.out.println("The number of Coach's degrees is: ");
           int degrees=0;
           try {
        	   degrees= intScanner.nextInt();
           }catch(Exception e) {
        	   System.out.println("Please enter a number");
           }
           Coach coach= new Coach(userCount, user.getName(), user.getSurname(), user.getGender(), user.getBirthDate(), user.getContactInfo(), sport, degrees);
           coachList.add(coach); 
           
           
           
        	
        	
        	subCode++;
        }
		
        
		
		
		userCount++;
		
	}

}
