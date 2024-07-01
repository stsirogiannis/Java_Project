package gr.unipi.gui;

import gr.unipi.core.Athlete;
import gr.unipi.core.Subscription;
import gr.unipi.core.TrainingProgram;
import gr.unipi.core.TrainingProgramReservation;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReservationManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    private String TPRCode; //unique user code
    static ArrayList<TrainingProgramReservation> reservationList;
    ArrayList<Athlete> athleteList = AthleteManagementSceneCreator.athleteList;
    ArrayList<Subscription> subscriptionList = SubscriptionManagementSceneCreator.subscriptionList;
    // Flow Pane
    FlowPane buttonFlowPane;
    // Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Second Scene buttons
    Button newReservationBtn, cancelReservationBtn, backBtn;
    // Second scene labels
    Label reservationCodeLbl, reservationDateLbl, userCountLbl;
    // Second scene TextFields
    TextField TPRCodeField, reservationDateField, userCountField;
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
        reservationCodeLbl = new Label("Κωδικός κράτησης:");
        userCountLbl = new Label("Κωδικός Αθλητή:");
        reservationDateLbl = new Label("Ημερομηνία Κράτησης:");
        // Fields
        TPRCodeField = new TextField();
        TPRCodeField.setEditable(false);
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
        inputFieldsPane.add(reservationCodeLbl, 0, 0);
        inputFieldsPane.add(TPRCodeField, 1, 0);
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



    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {

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
                for (Subscription subscription : subscriptionList) {
                    if (Subscription.getTrainingProgram().getTPCount() > 0);{
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
                    //createTrainingProgramReservation(TPRCode, selectedAthlete, trainingProgram, date);
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

        // Get Selected Athlete from TableView, get the values from the selection and set them to the fields
       /* if (event.getSource() == reservationTableView) {
            TrainingProgramReservation selectedReservation = athleteTableView.getSelectionModel().getSelectedItem();
            if (selectedAthlete != null) {
                userCountField.setText(String.valueOf(selectedAthlete.getUserCount()));
                nameField.setText(selectedAthlete.getName());
                surnameField.setText(selectedAthlete.getSurname());

                //check if the gender is male or female
                char gender = selectedAthlete.getGender();
                if (gender == 'Ά') {
                    maleRadioBtn.setSelected(true);
                } else if (gender == 'Γ') {
                    femaleRadioBtn.setSelected(true);
                }

                contactInfoField.setText(selectedAthlete.getContactInfo());
                birthDateField.setText(selectedAthlete.getBirthDate());

                //check if the athlete is professional or not
                if (selectedAthlete.getIsProfessional()) {
                    professionalYesRadioBtn.setSelected(true);
                } else {
                    professionalNoRadioBtn.setSelected(true);
                }

                experienceField.setText(String.valueOf(selectedAthlete.getExperience()));
            }
        }
    }
    */




    }

    public void createTrainingProgramReservation(String TPRCode, Athlete athlete, TrainingProgram trainingProgram, String date) {
        TrainingProgramReservation trainingProgramReservation = new TrainingProgramReservation(TPRCode, athlete, trainingProgram, date);
    }









}
