package gr.unipi.gui;


import gr.unipi.core.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class ReservationManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    private int TPCount;
    private String TPRCode; //unique user code
    static ArrayList<TrainingProgramReservation> reservationList;
    static ArrayList<Athlete> athleteList = AthleteManagementSceneCreator.athleteList;
    static ArrayList<Subscription> subscriptionList = SubscriptionManagementSceneCreator.subscriptionList;
    ArrayList<Enrollment> enrollmentList =  AthleteManagementSceneCreator.enrollmentList;
    static ArrayList<TrainingProgram> trainingProgramList= SubscriptionManagementSceneCreator.trainingProgramList;
    // Flow Pane
    FlowPane buttonFlowPane;
    // Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Second Scene buttons
    Button newReservationBtn, cancelReservationBtn, backBtn;
    // Second scene labels
    Label TPCountLbl, reservationDateLbl, userCountLbl;
    // Second scene TextFields
    TextField TPCountField, reservationDateField, userCountField;
    // Radio Buttons
    //RadioButton
    //ToggleGroup
    // TableView
    TableView<TrainingProgramReservation> reservationTableView;

    public ReservationManagementSceneCreator(double width, double height) {
        super(width, height);
        // Initialize fields
        reservationList = new ArrayList<>();
        // GridPane: root
        rootGridPane = new GridPane();
        // buttonFlowPane
        buttonFlowPane = new FlowPane();
        // Labels
        TPCountLbl = new Label("Κωδικός Προγρ. Προπ.:");
        userCountLbl = new Label("Κωδικός Αθλητή:");
        reservationDateLbl = new Label("Ημερομηνία Κράτησης:" 
        		                        + "\n"+ "(yyyyMMdd)");
        // Fields
        TPCountField = new TextField();
        // TPCountField.setEditable(false);
        userCountField = new TextField();
        reservationDateField = new TextField();
        // Buttons
        newReservationBtn = new Button("Νέα Κράτηση");
        backBtn = new Button("Επιστροφή");
        cancelReservationBtn = new Button("Ακύρωση Κράτησης");
        // GridPane: Input Fields
        inputFieldsPane = new GridPane();
        // TableView
        reservationTableView = new TableView<>();
        // Attach events
        backBtn.setOnMouseClicked(this);
        newReservationBtn.setOnMouseClicked(this);
        cancelReservationBtn.setOnMouseClicked(this);
        // Customize buttonFlowPane (add buttons to FlowPane)
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newReservationBtn);
        buttonFlowPane.getChildren().add(backBtn);
        buttonFlowPane.getChildren().add(cancelReservationBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
        // Customize inputFieldsPane (add Labels and TextFields to GridPane)
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(TPCountLbl, 0, 0);
        inputFieldsPane.add(TPCountField, 1, 0);
        inputFieldsPane.add(userCountLbl, 0, 1);
        inputFieldsPane.add(userCountField, 1, 1);
        inputFieldsPane.add(reservationDateLbl, 0, 2);
        inputFieldsPane.add(reservationDateField, 1, 2);

        // Customize rootGridPane (add buttonFlowPane, inputFieldsPane, back button and TableView to the root GridPane)
        rootGridPane.setVgap(15);
        rootGridPane.setHgap(12);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(reservationTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 1, 1);

        // Customize athleteTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        reservationTableView.setPrefSize(550, 250);


        TableColumn<TrainingProgramReservation, String> TPRCodeColumn = new TableColumn<>("Κωδικός Κράτησης");
        TPRCodeColumn.setCellValueFactory(new PropertyValueFactory<>("TPRCode"));
        reservationTableView.getColumns().add(TPRCodeColumn);
        TPRCodeColumn.setPrefWidth(130);

        TableColumn<TrainingProgramReservation, Integer> userCountColumn = new TableColumn<>("Κωδικός Αθλητή");
        userCountColumn.setCellValueFactory(new PropertyValueFactory<>("userCount"));
        reservationTableView.getColumns().add(userCountColumn);
        userCountColumn.setPrefWidth(130);

        TableColumn<TrainingProgramReservation, Integer> TPCountColumn = new TableColumn<>("Κωδικός Προγρ/τος Προπόν.");
        TPCountColumn.setCellValueFactory(new PropertyValueFactory<>("TPCount"));
        reservationTableView.getColumns().add(TPCountColumn);
        TPCountColumn.setPrefWidth(130);

        TableColumn<TrainingProgramReservation, String> dateStringColumn = new TableColumn<>("Ημερομηνία Κράτ.");
        dateStringColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        reservationTableView.getColumns().add(dateStringColumn);
        dateStringColumn.setPrefWidth(130);


    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {

    	int userCount=0;
    	boolean isValid = false;
        Athlete selectedAthlete = null;
        Subscription selectedSubscription = null;
        TrainingProgram selectedTrainingProgram= null;
        if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);
        }

        // Get values from fields, create new Athlete (based on these values) add it to athleteList, sync the athleteList with the TableView, clear the fields
        if (event.getSource() == newReservationBtn) {

        	try {
	        	   userCount = Integer.parseInt(userCountField.getText());                             
	        	   // Validate that the number is one of the valid numbers from athleteList
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
		    
		           }    
        	} catch (NumberFormatException e) {
	               Alert alertType = new Alert(Alert.AlertType.ERROR);
	               alertType.setTitle("Μη έγκυρη εισαγωγή");
	               alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
	               alertType.show();
	         
        		}
        
        	if (isValid==true) {
        			boolean isValidSubscription = false;
	        		for (Subscription subscription : subscriptionList) {
	        			if (subscription.getUserCount() == selectedAthlete.getUserCount()) {
	        				isValidSubscription = true;
	        				selectedSubscription = subscription;
	        				break;
	                    
	        			}
	        		}
	
	        		if (!isValidSubscription) {
	        			Alert alertType = new Alert(Alert.AlertType.ERROR);
	        			alertType.setTitle("Σφάλμα");
	        			alertType.setContentText("Δεν βρέθηκε συνδρομή για τον επιλεγμένο αθλητή.");
	        			alertType.show();
	        		}	
        	}
        		
        			
        	try {
            	int TPCount=Integer.parseInt(TPCountField.getText());
            	 // Validate that the number is one of the valid numbers from trainingProgramList
	               isValid = false;
	               for(TrainingProgram trainingProgram: trainingProgramList) {
	            	   if (trainingProgram.getTPCount()==TPCount) {
	            		   isValid=true;
	            		   selectedTrainingProgram= trainingProgram;
	            		   break;
	            	   }
	               }
		           if (!isValid) { 
		                Alert alertType = new Alert(Alert.AlertType.ERROR);
		                alertType.setTitle("Μη Έγκυρη Τιμή");
	                    alertType.setContentText(" Εισάγετε έναν έγκυρο κωδικό προγράμματος προπόνησης.");
		                alertType.show();  
		           }     
        	} catch (NumberFormatException e) {
	               Alert alertType = new Alert(Alert.AlertType.ERROR);
	               alertType.setTitle("Μη έγκυρη εισαγωγή");
	               alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
	               alertType.show();
        	}

        	try {
                String date = reservationDateField.getText();
                if (!isValidDateFormat(date)) {
                    throw new IllegalArgumentException("Εισάγετε την ημερομηνία στη σωστή μορφή");
                }else {
                	TPRCode= TPCount+ "_" +userCount+ "_" + date;
                	createTrainingProgramReservation( TPRCode, selectedAthlete, selectedTrainingProgram, date);
	                // Proceed with valid date
	                System.out.println("Date is valid: " + date);
                }
            } catch (IllegalArgumentException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Μη έγκυρη ημερομηνία");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }    
    
	    if (event.getSource() == cancelReservationBtn) {
	        deleteTrainingProgramReservation(TPRCode);
	        tableSync();
            clearTextFields();
	     }
	        
	     // Get Selected reservation from TableView, get the values from the selection and set them to the fields
	     if (event.getSource() == reservationTableView) {
	          TrainingProgramReservation selectedReservation = reservationTableView.getSelectionModel().getSelectedItem();
		     if (selectedReservation != null) {
		          userCountField.setText(String.valueOf(selectedReservation.selectedAthlete.getUserCount()));
		          TPRCode = String.valueOf(selectedReservation.getTPRCode());
		          TPCountField.setText(String.valueOf(selectedReservation.getSelectedTrainingProgram().getTPCount()));
		          reservationDateField.setText(String.valueOf(selectedReservation.getDate()));
		      }
	     }
	     tableSync();
	     clearTextFields();
	    
	    
    }
    
    
    public static boolean isValidDateFormat(String dateStr) {
        // Check if the string has exactly 8 characters
        if (dateStr.length() != 8) {
            return false;
        }

        // Check if all characters are digits
        for (char c : dateStr.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Basic checks on the date components (year, month, day)
        try {
            int year = Integer.parseInt(dateStr.substring(0, 4));
            int month = Integer.parseInt(dateStr.substring(4, 6));
            int day = Integer.parseInt(dateStr.substring(6, 8));

            if (month < 1 || month > 12) {
                return false;
            }
            if (day < 1 || day > 31) {
                return false;
            }


        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    

    // sync reservationList objects with objects in TableView
    public void tableSync() {
        List<TrainingProgramReservation> items = reservationTableView.getItems();
        items.clear();
        for (Object res : reservationList) {
            if (res instanceof TrainingProgramReservation) {
                items.add((TrainingProgramReservation) res);
            }
        }
    }

    public void createTrainingProgramReservation(String TPRCode, Athlete selectedAthlete, TrainingProgram selectedTrainingProgram, String date) {
        TrainingProgramReservation trainingProgramReservation = new TrainingProgramReservation(TPRCode, selectedAthlete, selectedTrainingProgram, date);
        reservationList.add(trainingProgramReservation);
    }
    
    private void deleteTrainingProgramReservation(String TPRCode) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getTPRCode().equals(TPRCode)) {
                reservationList.remove(i);
                break;
            }
        }
    }
    
    public void clearTextFields() {
        userCountField.clear();
        reservationDateField.clear();
        TPCountField.clear();
       
    }

}    
    
    
    