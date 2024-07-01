package gr.unipi.gui;

import gr.unipi.core.Athlete;
import gr.unipi.core.Subscription;
import gr.unipi.core.TrainingProgram;
import gr.unipi.core.TrainingProgramReservation;
import gr.unipi.core.User;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	
	private int TPCount=0;
    private String TPRCode; //unique user code
    static ArrayList<TrainingProgramReservation> reservationList;
    static ArrayList<Athlete> athleteList = AthleteManagementSceneCreator.athleteList;
    static ArrayList<Subscription> subscriptionList = SubscriptionManagementSceneCreator.subscriptionList;
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
        TPCountLbl = new Label("Κωδικός Προγράμματος Προπόνησης:");
        userCountLbl = new Label("Κωδικός Αθλητή:");
        reservationDateLbl = new Label("Ημερομηνία Κράτησης:");
        // Fields
        TPCountField = new TextField();
        TPCountField.setEditable(false);
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
        DatePicker reservationDateField = new DatePicker();
        inputFieldsPane.add(reservationDateField, 1, 2);

        // Customize rootGridPane (add buttonFlowPane, inputFieldsPane, back button and TableView to the root GridPane)
        rootGridPane.setVgap(15);
        rootGridPane.setHgap(12);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(reservationTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 1, 1);

        // Customize athleteTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        reservationTableView.setPrefSize(300, 250);

        TableColumn<TrainingProgramReservation, String> TPRCodeColumn = new TableColumn<>("Κωδικός Κράτησης");
        TPRCodeColumn.setCellValueFactory(new PropertyValueFactory<>("TPRCode"));
        reservationTableView.getColumns().add(TPRCodeColumn);
        TPRCodeColumn.setPrefWidth(130);

       /* TableColumn<TrainingProgramReservation, Integer> userCountColumn = new TableColumn<>("Κωδικός Αθλητή");
        userCountColumn.setCellValueFactory(new PropertyValueFactory<>("athlete.getUserCount()"));
        reservationTableView.getColumns().add(userCountColumn);
        userCountColumn.setPrefWidth(130);
        
        TableColumn<TrainingProgramReservation, Integer> TPCountColumn = new TableColumn<>("Κωδικός Προγράμματος Προπόνησης");
        TPCountColumn.setCellValueFactory(new PropertyValueFactory<>("Subscription.getTrainingProgram().getTPCount()"));
        reservationTableView.getColumns().add(TPCountColumn);
        TPCountColumn.setPrefWidth(130);*/

    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
    	
    	TrainingProgram selectedTrainingProgram=null;
        Athlete selectedAthlete = null;
        if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);
        }

        // Get values from fields, create new Athlete (based on these values) add it to athleteList, sync the athleteList with the TableView, clear the fields
        if (event.getSource() == newReservationBtn) {

            try {
                // Validate that the number is one of the valid numbers from athleteList
                int userCount = Integer.parseInt(userCountField.getText());
                DatePicker reservationDateField = new DatePicker();
                LocalDate date = reservationDateField.getValue();
                String dateString = date.toString();

                boolean isValid = false;
                boolean hasTP = false;
                // Validate that the number is one of the valid numbers from athleteList
                for (Athlete athlete : athleteList) {
                    if (athlete.getUserCount() == userCount) {
                        isValid = true;
                        selectedAthlete = athlete;
                        break;
                    }
                }
                
         /*      // for(TrainingProgram trainingProgram: )
                for (Subscription subscription : subscriptionList) {
                	TrainingProgram trainingProgram = Subscription.getTrainingProgram();
                    if (Subscription.getTrainingProgram().getTPCount() > 0){
                    	TPCount = Subscription.getTrainingProgram().getTPCount();
                    	selectedTrainingProgram= trainingProgram;
                        hasTP = true;
                        break;
                    }
                }*/

                for (Subscription subscription : subscriptionList) {
                    TrainingProgram trainingProgram = Subscription.getTrainingProgram();
                    if (trainingProgram.getTPCount() > 0) {
                        selectedTrainingProgram = trainingProgram;
                        hasTP = true;
                        break;
                    }
                }
                if (!isValid) {
                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("Μη Έγκυρη Τιμή");
                    alertType.setContentText("Εισάγετε έναν έγκυρο κωδικό αθλητή.");
                    alertType.show();

                } else if (!hasTP){
                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("ERROR");
                    alertType.setContentText("Δεν υπάρχει συνδρομή στο Training Program από τον αθλητή");
                    alertType.show();

                }
                else{
                    TPRCode = Subscription.getTrainingProgram().getTPCount() + "_" + userCount + "_" + "<"+ dateString+ ">";
                    createTrainingProgramReservation(TPRCode, selectedAthlete, selectedTrainingProgram, dateString);
                }
              
            } catch (NumberFormatException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη εισαγωγή");
                alertType.setContentText("Παρακαλώ εισάγετε έναν αριθμό. \nException message: " + e.getMessage());
                alertType.show();

            }

        }
     

        if (event.getSource() == cancelReservationBtn) {


        }
       
        // Get Selected reservation from TableView, get the values from the selection and set them to the fields
        if (event.getSource() == reservationTableView) {
            TrainingProgramReservation selectedReservation = reservationTableView.getSelectionModel().getSelectedItem();
            if (selectedReservation != null) {
               // userCountField.setText(String.valueOf(selectedReservation.athlete.getUserCount()));
                TPRCode = String.valueOf(selectedReservation.getTPRCode());
               // TPCountField.setText(String.valueOf(selectedReservation.getTrainingProgram().getTPCount()));

            }
                
           
        }
     
            tableSync();
           // clearTextFields();
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


    

    public void createTrainingProgramReservation(String TPRCode, Athlete selectedAthlete, TrainingProgram selectedTrainingProgram, String dateString) {
        TrainingProgramReservation trainingProgramReservation = new TrainingProgramReservation(TPRCode, selectedAthlete, selectedTrainingProgram, dateString);
        reservationList.add(trainingProgramReservation);
    }








}