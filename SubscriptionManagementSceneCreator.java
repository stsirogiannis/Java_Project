package gr.unipi.gui;

import java.util.ArrayList;

import gr.unipi.core.Coach;
import gr.unipi.core.Facility;
import gr.unipi.core.Sport;
import gr.unipi.core.Subscription;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import gr.unipi.core.Athlete;

public class SubscriptionManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent>  {
	
	private int subCount=0;
	ArrayList <Subscription> subscriptionList;
	
	     
	 //	Flow Panel
	 FlowPane buttonFlowPane;                 
    //	Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //	Second Scene buttons
    Button newSubBtn, updateSubBtn, deleteSubBtn, backBtn, paymentSubBtn;
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
    ToggleGroup genderToggleGroup, professionalAccessToggleGroup, weeklyReservationToggleGroup;           
 
    
    
   

	public SubscriptionManagementSceneCreator(double width, double height) {
	 	super(width, height);
	    //Initialize fields
	 	subscriptionList= new ArrayList<>();
        //GridPane: root
        rootGridPane = new GridPane();
        //buttonFlowPane
        buttonFlowPane = new FlowPane();
        //Labels
        userCountLbl = new Label("Κωδικός Αθλητή");
        trainingProgramLbl= new Label ("Πρόγραμμα Προπόνησης: ");
        TPCodeLbl= new Label ("Κωδικός Προγράμματος Διαχείρισης: ");
        sportNameLbl = new Label("Όνομα Αθλήματος: ");
        professionalAccessLbl = new Label("Πρόσβαση Μόνο Σε Επαγγελματίες: ");
        facilityNameLbl = new Label("Όνομα Εγκατάστασης: ");
        maxCapacityLbl = new Label("Μέγιστη Χωριτικότητα της Εγκατάσταης: ");
        sportIDLbl = new Label("Ταυτότητα Αθλήματος: ");
        degreesLbl = new Label("Πτυχία Προπονητή: ");
        minExperienceLbl = new Label("Ελάχιστη Εμπειρία Συμμετοχής: ");
        weeklyReservationLbl = new Label("Εβδομαδιαία Κράτηση: ");
        genderLbl = new Label("Φύλο Συμμετεχόντων: ");
        minDurationLbl = new Label("Ελάχιστη Διάρκεια: ");
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
        professionalAccessToggleGroup = new ToggleGroup();
        professionalAccessYesRadioBtn = new RadioButton("Ναι");
        professionalAccessYesRadioBtn.setToggleGroup(professionalAccessToggleGroup);
        professionalAccessNoRadioBtn = new RadioButton("Όχι");
        professionalAccessNoRadioBtn.setToggleGroup(professionalAccessToggleGroup);
        //Radio buttons for weekly reservation
        weeklyReservationToggleGroup = new ToggleGroup();
        weeklyReservationYesRadioBtn = new RadioButton("Ναι");
        weeklyReservationYesRadioBtn.setToggleGroup(weeklyReservationToggleGroup);
        weeklyReservationNoRadioBtn = new RadioButton("Όχι");
        weeklyReservationNoRadioBtn.setToggleGroup(weeklyReservationToggleGroup);
       
        
        //comboBox
        dayComboBox = new ComboBox<>(FXCollections.observableArrayList(
                "Δευτέτρα", "Tρίτη", "Τετάρτη", "Πέμπτη", "Παρασκευή", "Σάββατο", "Κυριακή"
        ));
        
        //Buttons
        newSubBtn = new Button("Νέα Συνδρομή");
        updateSubBtn = new Button("Ενημέρωση");
        deleteSubBtn = new Button("Διαγραφή");
        backBtn = new Button("Πίσω");
        paymentSubBtn= new Button ("Πληρωμή");
        // GridPane: Input Fields
        inputFieldsPane = new GridPane();
        //TableView
        subscriptionTableView = new TableView<>();
        
        
        
        //  Attach events
        backBtn.setOnMouseClicked(this);
        newSubBtn.setOnMouseClicked(this);
        updateSubBtn.setOnMouseClicked(this);
        deleteSubBtn.setOnMouseClicked(this);
        paymentSubBtn.setOnMouseClicked(this);
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
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(subscriptionTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 1);
        rootGridPane.add(paymentSubBtn, 2, 1);
        
		   
        
        // Customize subscriptionTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        TableColumn<Subscription, String> subCodeColumn = new TableColumn<>("Κωδικός Συνδρομής");
        subCodeColumn.setCellValueFactory(new PropertyValueFactory<>("subCode"));
        subscriptionTableView.getColumns().add(subCodeColumn);

        TableColumn<Subscription, Integer> userCountColumn = new TableColumn<>("Κωδικός Αθλητή");
        userCountColumn.setCellValueFactory(new PropertyValueFactory<>("userCount"));
        subscriptionTableView.getColumns().add(userCountColumn);
        
        TableColumn<Subscription, Integer> TPCodeColumn = new TableColumn<>("Κωδικός Προγράμματος Προπόνησης");
        TPCodeColumn.setCellValueFactory(new PropertyValueFactory<>("TPCode"));
        subscriptionTableView.getColumns().add(TPCodeColumn);
        
        TableColumn<Subscription, Double> monthlyCostColumn = new TableColumn<>("Μηνιαίο Ποσό");
        TPCodeColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyCost"));
        subscriptionTableView.getColumns().add(monthlyCostColumn);
        
        
	}


	@Override
	public void handle(MouseEvent event) {
		
		if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);
        }
		
		 // Get values from fields, create new Athlete (based on these values) add it to athleteList, sync the athleteList with the TableView, clear the fields
        if (event.getSource() == newSubBtn) {
        	subCount++;
        	try {
        		int userCount = Integer.parseInt(userCountField.getText());                             
        		  // Validate that the number is one of the valid numbers from athleteList
                boolean isValid = false;
                for (Athlete athlete :AthleteManagementSceneCreator.athleteList) {
                    if (athlete.getUserCount() == userCount) { // Assuming getUserCount() returns the count for the athlete
                        isValid = true;
                        break;
                    }
                }

                if (!isValid) {
                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("Μη Έγκυρη Τιμή");
                    alertType.setContentText(" Εισάγετε έναν έγκυρο κωδικό αθλητή.");
                    alertType.show();
                } else {
                    // Proceed with creating a new subscription, adding to the list, syncing with TableView, etc.
                    // Clear the fields after processing
                    userCountField.clear();
                    // Add further logic as needed
                }

            } catch (NumberFormatException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη εισαγωγή");
                alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
                alertType.show();
            }
        }
        
        String sportName = sportNameField.getText();
        String facilityName= facilityNameField.getText();
        try {
        	int maxCapacity= Integer.parseInt(userCountField.getText());
        }catch(NumberFormatException e) {
        	Alert alertType = new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Μη έγκυρη εισαγωγή");
            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
            alertType.show();
        }
        try {
        	int degrees= Integer.parseInt(userCountField.getText());
        }catch(NumberFormatException e) {
        	Alert alertType = new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Μη έγκυρη εισαγωγή");
            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
            alertType.show();
        }
        try {
        	int minExperience= Integer.parseInt(userCountField.getText());
        	 if (minExperience < 1 || minExperience > 5) {
                 throw new IllegalArgumentException("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5.");
             }
        }catch(NumberFormatException e) {
        	Alert alertType = new Alert(Alert.AlertType.ERROR);
            alertType.setTitle("Μη έγκυρη εισαγωγή");
            alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
            alertType.show();
        }
        
        
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
	
	
	

