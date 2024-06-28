package gr.unipi.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import gr.unipi.core.Coach;
import gr.unipi.core.Facility;
import gr.unipi.core.Sport;
import gr.unipi.core.Subscription;
import gr.unipi.core.TrainingProgram;
import gr.unipi.core.User;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import gr.unipi.core.Athlete;

public class SubscriptionManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent>  {
	
	private int subCount=0;
	private int TPCount=0;      //counter of training program
	private String subCode;
	private double monthlyCost;
	ArrayList <Subscription> subscriptionList;
    ArrayList<Athlete> athleteList;
	private Sport sport;
    private Facility facility;
    private Coach coach;
	private TrainingProgram trainingProgram;
   
	
	 //	Flow Panel
	 FlowPane buttonFlowPane;                 
    //	Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //	Second Scene buttons
    Button newSubBtn, updateSubBtn, deleteSubBtn, backBtn;
    //	Second scene labels
    Label userCountLbl, trainingProgramLbl, TPCodeLbl, sportNameLbl, professionalAccessLbl, facilityNameLbl, maxCapacityLbl, sportIDLbl, degreesLbl, minExperienceLbl, weeklyReservationLbl, genderLbl, minDurationLbl, dayLbl;
    //	Second scene TextFields
    TextField userCountField, sportNameField, facilityNameField, maxCapacityField, degreesField, minExperienceField, minDurationField ;
    //	TableView
    TableView<Subscription> subscriptionTableView;
    // ComboBox for the days of the week
    ComboBox<String> dayComboBox;
    // Radio Buttons
    RadioButton maleRadioBtn, femaleRadioBtn, mixedRadioBtn,  professionalAccessYesRadioBtn, professionalAccessNoRadioBtn, weeklyReservationYesRadioBtn, weeklyReservationNoRadioBtn;
    ToggleGroup genderToggleGroup, professionalAccessOnlyToggleGroup, weeklyReservationToggleGroup;
	
    private Labeled subCodeField;
	private Labeled trainingProgramField;
	private Labeled monthlyCostField;
	private Labeled athleteField;           
 
    
   
   
	
	

	public SubscriptionManagementSceneCreator(double width, double height) {
	 	super(width, height);
	    //Initialize fields
	 	subscriptionList= new ArrayList<>();
	 	 athleteList = AthleteManagementSceneCreator.getAthleteList();
        //GridPane: root
        rootGridPane = new GridPane();
        //buttonFlowPane
        buttonFlowPane = new FlowPane();
        //Labels
        userCountLbl = new Label("Κωδικός Αθλητή");
        trainingProgramLbl= new Label ("Πρόγραμμα Προπόνησης: ");
        TPCodeLbl= new Label ("Κωδικός Προγράμματος Προπόνησης: ");
        sportNameLbl = new Label("Όνομα Αθλήματος: ");
        professionalAccessLbl = new Label("Πρόσβαση Μόνο Σε Επαγγελματίες: ");
        facilityNameLbl = new Label("Όνομα Εγκατάστασης: ");
        maxCapacityLbl = new Label("Μέγιστη Χωριτικότητα της Εγκατάσταης: ");
        sportIDLbl = new Label("Ταυτότητα Αθλήματος: ");
        degreesLbl = new Label("Πτυχία Προπονητή: ");
        minExperienceLbl = new Label("Ελάχιστη Εμπειρία Συμμετοχής: ");
        weeklyReservationLbl = new Label("Εβδομαδιαία Κράτηση: ");
        genderLbl = new Label("Φύλο Συμμετεχόντων: ");
        minDurationLbl = new Label("Διάρκεια σε Λεπτά: ");
        dayLbl = new Label("Ημέρα: ");
        
        
        
        //Fields
        userCountField= new TextField();
        sportNameField = new TextField();
        facilityNameField = new TextField();
        maxCapacityField= new TextField();
        degreesField= new TextField();
        minExperienceField= new TextField();
        minDurationField= new TextField();
        
        
        
        // Radio Buttons for Gender
        genderToggleGroup = new ToggleGroup();
        maleRadioBtn = new RadioButton("Άντρας");
        maleRadioBtn.setToggleGroup(genderToggleGroup);
        femaleRadioBtn = new RadioButton("Γυναίκα");
        femaleRadioBtn.setToggleGroup(genderToggleGroup);
        mixedRadioBtn= new RadioButton("Μεικτό");
        mixedRadioBtn.setToggleGroup(genderToggleGroup);
        // Radio Buttons for Professional access Status
        professionalAccessOnlyToggleGroup = new ToggleGroup();
        professionalAccessYesRadioBtn = new RadioButton("Ναι");
        professionalAccessYesRadioBtn.setToggleGroup(professionalAccessOnlyToggleGroup);
        professionalAccessNoRadioBtn = new RadioButton("Όχι");
        professionalAccessNoRadioBtn.setToggleGroup(professionalAccessOnlyToggleGroup);
        //Radio buttons for weekly reservation
        weeklyReservationToggleGroup = new ToggleGroup();
        weeklyReservationYesRadioBtn = new RadioButton("Ναι");
        weeklyReservationYesRadioBtn.setToggleGroup(weeklyReservationToggleGroup);
        weeklyReservationNoRadioBtn = new RadioButton("Όχι");
        weeklyReservationNoRadioBtn.setToggleGroup(weeklyReservationToggleGroup);
       
        
        //comboBox
        dayComboBox = new ComboBox<>(FXCollections.observableArrayList(
                "Δευτέρα", "Tρίτη", "Τετάρτη", "Πέμπτη", "Παρασκευή", "Σάββατο", "Κυριακή"
        ));
        
        //Buttons
        newSubBtn = new Button("Πληρωμή");
        updateSubBtn = new Button("Ενημέρωση");
        deleteSubBtn = new Button("Διαγραφή");
        backBtn = new Button("Πίσω");
        // GridPane: Input Fields
        inputFieldsPane = new GridPane();
        //TableView
        subscriptionTableView = new TableView<>();
        
        
        
        //  Attach events
        backBtn.setOnMouseClicked(this);
        newSubBtn.setOnMouseClicked(this);
        updateSubBtn.setOnMouseClicked(this);
        deleteSubBtn.setOnMouseClicked(this);
        subscriptionTableView.setOnMouseClicked(this);
        
        
        //  Customize buttonFlowPane (add buttons to FlowPane)
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newSubBtn);
        buttonFlowPane.getChildren().add(updateSubBtn);
        buttonFlowPane.getChildren().add(deleteSubBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		
        
        
        
        
        
        // Customize inputFieldsPane (add Labels and TextFields to GridPane)
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(userCountLbl, 0, 0);
        inputFieldsPane.add(userCountField, 1, 0);
        inputFieldsPane.add(trainingProgramLbl, 0, 1);
        inputFieldsPane.add(TPCodeLbl, 0, 2);
        inputFieldsPane.add(sportNameLbl, 0, 3);
        inputFieldsPane.add(sportNameField, 1, 3);
        inputFieldsPane.add(professionalAccessLbl, 0, 4);
        inputFieldsPane.add(professionalAccessYesRadioBtn, 1, 4);
        inputFieldsPane.add(professionalAccessNoRadioBtn, 2, 4);
        inputFieldsPane.add(facilityNameLbl, 0, 5);
        inputFieldsPane.add(facilityNameField, 1, 5);
        inputFieldsPane.add(maxCapacityLbl, 0, 6);
        inputFieldsPane.add(maxCapacityField, 1, 6);
        inputFieldsPane.add(sportIDLbl, 0, 7);
        inputFieldsPane.add(degreesLbl, 0, 8);
        inputFieldsPane.add(degreesField, 1, 8);
        inputFieldsPane.add(minExperienceLbl, 0, 9);
        inputFieldsPane.add(minExperienceField, 1, 9);
        inputFieldsPane.add(weeklyReservationLbl, 0, 10);
        inputFieldsPane.add(weeklyReservationYesRadioBtn, 1, 10);
        inputFieldsPane.add(weeklyReservationNoRadioBtn, 2, 10);
        inputFieldsPane.add(genderLbl, 0, 11);
        inputFieldsPane.add(maleRadioBtn, 1, 11);
        inputFieldsPane.add(femaleRadioBtn, 2, 11);
        inputFieldsPane.add(mixedRadioBtn, 3, 11);
        inputFieldsPane.add(minDurationLbl, 0, 12);
        inputFieldsPane.add(minDurationField, 1, 12);
        inputFieldsPane.add(dayLbl, 0, 13);
        inputFieldsPane.add(dayComboBox, 1, 13);  
        
        
        
        
        // Customize rootGridPane (add buttonFlowPane, inputFieldsPane, back button and TableView to the root GridPane)
        rootGridPane.setVgap(20);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(subscriptionTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 1);
        
		   
        
        // Customize subscriptionTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        TableColumn<Subscription, String> subCodeColumn = new TableColumn<>("Κωδικός Συνδρομής");
        subCodeColumn.setCellValueFactory(new PropertyValueFactory<>("subCode"));
        subscriptionTableView.getColumns().add(subCodeColumn);

        TableColumn<Subscription, Integer> athleteColumn = new TableColumn<>("Αθλητής");
        athleteColumn.setCellValueFactory(new PropertyValueFactory<>("athlete"));
        subscriptionTableView.getColumns().add(athleteColumn);
        
        TableColumn<Subscription, Integer> trainingProgramColumn = new TableColumn<>("Προγράμμα Προπόνησης");
        //TPCodeColumn.setCellValueFactory(new PropertyValueFactory<>("trainingProgram"));
        trainingProgramColumn.setCellValueFactory(new PropertyValueFactory<>("createTrainingProgram(TPCount, sport, facility, coach, minExperience, weeklyReservation, gender, minDuration, dayComboBox);"));
        subscriptionTableView.getColumns().add(trainingProgramColumn);        
        
        
       /* TableColumn<Subscription, String> trainingProgramColumn = new TableColumn<>("Προγράμμα Προπόνησης");
        trainingProgramColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Subscription, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Subscription, String> param) {
                return new SimpleStringProperty(param.getValue().getTrainingProgram().toString());
            }
        });   
        subscriptionTableView.getColumns().add(trainingProgramColumn);*/
        
        
        TableColumn<Subscription, Double> monthlyCostColumn = new TableColumn<>("Μηνιαίο Ποσό");
        monthlyCostColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyCost"));
        subscriptionTableView.getColumns().add(monthlyCostColumn);
        
        
	}


	@Override
	public void handle(MouseEvent event) {
		
		if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);
        }
		
		
		
		
		
		ArrayList<Athlete> athleteList = AthleteManagementSceneCreator.athleteList;
		Athlete selectedAthlete = null;
	    // Get values from fields, create new Subscription (based on these values), clear the fields
        if (event.getSource() == newSubBtn) {
        	subCount++;
	        TPCount++;
	        int minExperience = 0;
        	try {
	        	   int userCount = Integer.parseInt(userCountField.getText());                             
	        	   // Validate that the number is one of the valid numbers from athleteList
	               boolean isValid = false;
	               for (Athlete athlete : athleteList) {
	                   if (athlete.getUserCount() == userCount) { // Assuming getUserCount() returns the count for the athlete
	                        isValid = true;
	                        selectedAthlete = athlete;
	                        break;
	                    }
	               }    
		           if (!isValid) { 
		                Alert alertType = new Alert(Alert.AlertType.ERROR);
		                alertType.setTitle("Μη Έγκυρη Τιμή");
	                    alertType.setContentText(" Εισάγετε έναν έγκυρο κωδικό αθλητή.");
		                alertType.show();  
		                subCount--;
		    	        TPCount--;
		           }     
		           else {
		        	    subCode = userCount + "_" + TPCount + "_" + "<"+ subCount+ ">";
		           }
	        } catch (NumberFormatException e) {
	               Alert alertType = new Alert(Alert.AlertType.ERROR);
	               alertType.setTitle("Μη έγκυρη εισαγωγή");
	               alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
	               alertType.show();
	               subCount--;
	               TPCount--;
	       }
	        
	        
		   String sportName = sportNameField.getText();
		    
		   boolean professionalAccess = ((RadioButton) professionalAccessOnlyToggleGroup.getSelectedToggle()).getText().equals("Ναι");
		   createSport(sportName, professionalAccess);
		   
		   String facilityName= facilityNameField.getText();
		   
		   try {
		        int maxCapacity= Integer.parseInt(maxCapacityField.getText());
		        createFacility(facilityName, maxCapacity);
		    }catch(NumberFormatException e) {
		    		Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		            subCount--;
		            TPCount--;
		     } 
		   
		     try {
		    	    int degrees= Integer.parseInt(degreesField.getText());
		    	    createCoach(degrees);
		     }catch(NumberFormatException e) {
		    	 	Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		            subCount--;
		            TPCount--;
		     }
		     
		     try {
	                
	              minExperience = Integer.parseInt(minExperienceField.getText());
	              if (minExperience < 1 || minExperience > 5) {
	                    subCount--;  
	                    TPCount--; 
	                    throw new IllegalArgumentException("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5.");
	              }
	         } catch (NumberFormatException e) {
	                // Your catch block that uses subCount and TPCount
	               Alert alertType = new Alert(Alert.AlertType.ERROR);
	               alertType.setTitle("Μη έγκυρη εισαγωγή");
	               alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
	               alertType.show();
	               subCount--;
	               TPCount--;
	         } catch (IllegalArgumentException e) {
	                // Handle IllegalArgumentException
	                Alert alertType = new Alert(Alert.AlertType.ERROR);
	                alertType.setTitle("Μη έγκυρη εισαγωγή");
	                alertType.setContentText(e.getMessage());
	                alertType.show();
	                // Note: subCount and TPCount are already decremented before throwing this exception
	         }
		     
		     boolean weeklyReservation = ((RadioButton) weeklyReservationToggleGroup.getSelectedToggle()).getText().equals("Ναι");
		     char gender = ((RadioButton) genderToggleGroup.getSelectedToggle()).getText().charAt(0);

		    try {
		        	int minDuration= Integer.parseInt(minDurationField.getText());
		        	createTrainingProgram(TPCount, sport, facility, coach, minExperience, weeklyReservation, gender, minDuration, dayComboBox);
		        	createSubscription(subCode, selectedAthlete  , trainingProgram, monthlyCost);
		        	
		    }catch(NumberFormatException e) {
		        	Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		            subCount--;
		            TPCount--;
		    }
		        
	        tableSync();
  //          clearTextFields();
	        
        }
        
        
        
        
        
        if (event.getSource() == updateSubBtn) {
	      
	         try {
	        	int userCount = Integer.parseInt(userCountField.getText());                             
	        	  // Validate that the number is one of the valid numbers from athleteList
	               boolean isValid = false;
	               for (Athlete athlete :AthleteManagementSceneCreator.athleteList) {
	                   if (athlete.getUserCount() == userCount) { // Assuming getUserCount() returns the count for the athlete
	                        isValid = true;
	                        selectedAthlete = athlete;
	                        break;
	                    }
	                }
	                if (!isValid) {
	                    Alert alertType = new Alert(Alert.AlertType.ERROR);
	                    alertType.setTitle("Μη Έγκυρη Τιμή");
	                    alertType.setContentText(" Εισάγετε έναν έγκυρο κωδικό αθλητή.");
	                    alertType.show();
	               }   
	                else {
	                	 subCode = userCount + "_" + TPCount + "_" + "<"+ subCount+ ">";
	                }
	         } catch (NumberFormatException e) {
	               Alert alertType = new Alert(Alert.AlertType.ERROR);
	               alertType.setTitle("Μη έγκυρη εισαγωγή");
	               alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
	               alertType.show();
	         }
	        
	         
		     String sportName = sportNameField.getText();
		   
		     boolean professionalAccess = ((RadioButton) professionalAccessOnlyToggleGroup.getSelectedToggle()).getText().equals("Ναι");
		     createSport(sportName, professionalAccess);
		     
		     
		     String facilityName= facilityNameField.getText();
		   
		     try {
		        int maxCapacity= Integer.parseInt(maxCapacityField.getText());
		        createFacility(facilityName, maxCapacity);
		     }catch(NumberFormatException e) {
		    		Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		      } 
		   
		      try {
		    	    int degrees= Integer.parseInt(degreesField.getText());
		    	    createCoach(degrees);
		      }catch(NumberFormatException e) {
		    	 	Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		      }
		    
		      try {
		        	int minExperience= Integer.parseInt(minExperienceField.getText());
		        	if (minExperience < 1 || minExperience > 5) {
		                 throw new IllegalArgumentException("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5.");
		            }
		      }catch(NumberFormatException e) {
		        	Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		      }
		      
		      boolean weeklyReservation = ((RadioButton) weeklyReservationToggleGroup.getSelectedToggle()).getText().equals("Ναι");
		     
		      char gender = ((RadioButton) genderToggleGroup.getSelectedToggle()).getText().charAt(0);
		      
		      try {
		        	int minDuration= Integer.parseInt(minDurationField.getText());
		        	createSubscription(subCode, selectedAthlete  , trainingProgram, monthlyCost);
		      }catch(NumberFormatException e) { 
		        	Alert alertType = new Alert(Alert.AlertType.ERROR);
		            alertType.setTitle("Μη έγκυρη εισαγωγή");
		            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
		            alertType.show();
		      }
        	
//		      tableSync();
//	          clearTextFields();
        }
        
		      
	    // Delete Subscription by subscription code
		 if (event.getSource() == deleteSubBtn) {
		      deleteSub(subCode);
		 //     tableSync();
	   //       clearTextFields();
		  }
		 
		 
	
        
		 
		    // Get Selected subscription from TableView, get the values from the selection and set them to the fields
		 if (event.getSource() == subscriptionTableView) {
		        Subscription selectedSubscription = subscriptionTableView.getSelectionModel().getSelectedItem();
		        if (selectedSubscription != null) {
		            subCodeField.setText(String.valueOf(selectedSubscription.getSubCode()));
		            athleteField.setText(selectedSubscription.getAthlete().toString()); // Assuming Athlete has a meaningful toString() implementation
		            trainingProgramField.setText(selectedSubscription.getTrainingProgram().toString()); // Assuming TrainingProgram has a meaningful toString() implementation
		            monthlyCostField.setText(String.valueOf(selectedSubscription.getMonthlyCost()));
		        }
		 }
		 
		 
       
	}

	

	private void createSubscription(String subCode, Athlete selectedAthlete, TrainingProgram trainingProgram,double monthlyCost) {
		Subscription subsc= new Subscription(subCode, selectedAthlete, trainingProgram, monthlyCost);
		subscriptionList.add(subsc);
		
	}

	
	

    // sync athleteList objects with objects in TableView
	public void tableSync() {
        List<Subscription> items = subscriptionTableView.getItems();
        items.clear();
        items.addAll(subscriptionList);
    }

	
	// find a Subscription by subCode and delete it from subscriptionList
	private void deleteSub(String subCode) {
		 for (int i = 0; i < subscriptionList.size(); i++) {
	            if (subscriptionList.get(i).getSubCode().equals(subCode)) {
	                subscriptionList.remove(i);
	                break;
	            }
	        }
		
	}                    


	private void createFacility(String facilityName, int maxCapacity) {
		facility= new Facility(facilityName, maxCapacity);
		
	}

	private void createSport(String sportName, boolean professionalAccess) {
		 sport = new Sport(sportName, professionalAccess);
	}
	
	public void createCoach(int degrees) {
        int userCount = Integer.parseInt(userCountField.getText());

        // Find the athlete in the athleteList by userCount
        Optional<Athlete> athleteOptional = athleteList.stream()
                .filter(athlete -> athlete.getUserCount() == userCount)
                .findFirst();

        if (athleteOptional.isPresent()) {
            Athlete athlete = athleteOptional.get();

            // Use the athlete's details to create the Coach
            String name = athlete.getName();
            String surname = athlete.getSurname();
            char gender = athlete.getGender();
            String birthDate = athlete.getBirthDate();
            String contactInfo = athlete.getContactInfo();
            coach = new Coach(userCount, name, surname, gender, birthDate, contactInfo, sport, degrees);
            // Additional logic to handle the created Coach object if necessary
        } else {
            // Handle the case where no athlete with the given userCount is found
            Alert alertType = new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Μη Έγκυρη Τιμή");
            alertType.setContentText("Δεν βρέθηκε αθλητής με τον παρεχόμενο αριθμό χρήστη.");
            alertType.show();
        }
    }
	
	private void createTrainingProgram(int TPCount,Sport sport,Facility facility,Coach coach, int minExperience, boolean weeklyReservation, char gender, int minDuration, ComboBox<String> dayComboBox) {
		trainingProgram= new TrainingProgram(TPCount, sport, facility, coach, minExperience, weeklyReservation, gender, minDuration, dayComboBox);
	}
    
	


	
	
	@Override
	Scene createScene() {
		 return new Scene(rootGridPane, width, height);
	}
	
	

	
}	
	
	






























	/*System.out.println("Sport Name: ");
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
   
   
   
	
	
	subCode++;*/
	
	
	

