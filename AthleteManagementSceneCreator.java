package gr.unipi.gui;

import gr.unipi.core.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AthleteManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    private int userCount=0;
    public static ArrayList<Athlete> athleteList;
    static ArrayList<Payment> paymentList;
    static ArrayList<Enrollment> enrollmentList;
    // Flow Pane
    FlowPane buttonFlowPane;
    // Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Second Scene buttons
    Button newAthleteBtn, updateAthleteBtn, deleteAthleteBtn, enrollmentPayBtn, backBtn;
    // Second scene labels
    Label userCountLbl, nameLbl, surnameLbl, genderLbl, contactInfoLbl, birthDateLbl, isProfessionalLbl, experienceLbl;
    // Second scene TextFields
    TextField userCountField, nameField, surnameField, contactInfoField, birthDateField, experienceField;
    // Radio Buttons
    RadioButton maleRadioBtn, femaleRadioBtn, professionalYesRadioBtn, professionalNoRadioBtn;
    ToggleGroup genderToggleGroup, professionalToggleGroup;
    // TableView
    TableView<Athlete> athleteTableView;
    TableView<Enrollment> enrollmentTableView;

    public AthleteManagementSceneCreator(double width, double height) {
        super(width, height);
        // Initialize fields
        athleteList = new ArrayList<>();
        paymentList = new ArrayList<>();
        enrollmentList = new ArrayList<>();
        // GridPane: root
        rootGridPane = new GridPane();
        // buttonFlowPane
        buttonFlowPane = new FlowPane();
        // Labels
        userCountLbl = new Label("Κωδικός Αθλητή: ");
        nameLbl = new Label("Όνομα: ");
        surnameLbl = new Label("Επώνυμο: ");
        genderLbl = new Label("Φύλο: ");
        contactInfoLbl = new Label("Στ. Επικοινωνίας (email/τηλ.): ");
        birthDateLbl = new Label("Ημ. Γέννησης: ");
        isProfessionalLbl = new Label("Είναι Επαγγελματίας: ");
        experienceLbl = new Label("Εμπειρία: ");
        // Fields
        userCountField = new TextField();
        userCountField.setEditable(false);
        nameField = new TextField();
        surnameField = new TextField();
        contactInfoField = new TextField();
        birthDateField = new TextField();
        experienceField = new TextField();
        // Radio Buttons for Gender
        genderToggleGroup = new ToggleGroup();
        maleRadioBtn = new RadioButton("Άνδρας");
        maleRadioBtn.setToggleGroup(genderToggleGroup);
        femaleRadioBtn = new RadioButton("Γυναίκα");
        femaleRadioBtn.setToggleGroup(genderToggleGroup);
        // Radio Buttons for Professional Status
        professionalToggleGroup = new ToggleGroup();
        professionalYesRadioBtn = new RadioButton("Ναι");
        professionalYesRadioBtn.setToggleGroup(professionalToggleGroup);
        professionalNoRadioBtn = new RadioButton("Όχι");
        professionalNoRadioBtn.setToggleGroup(professionalToggleGroup);
        // Buttons
        newAthleteBtn = new Button("Εγγραφή");
        updateAthleteBtn = new Button("Ενημέρωση");
        deleteAthleteBtn = new Button("Διαγραφή");
        enrollmentPayBtn = new Button("Πληρωμή Εγγραφής");
        backBtn = new Button("Επιστροφή");
        // GridPane: Input Fields
        inputFieldsPane = new GridPane();
        // TableView
        athleteTableView = new TableView<>();
        enrollmentTableView = new TableView<>();

        // Attach events
        backBtn.setOnMouseClicked(this);
        newAthleteBtn.setOnMouseClicked(this);
        updateAthleteBtn.setOnMouseClicked(this);
        deleteAthleteBtn.setOnMouseClicked(this);
        enrollmentPayBtn.setOnMouseClicked(this);
        athleteTableView.setOnMouseClicked(this);
        enrollmentTableView.setOnMouseClicked(this);

        // Customize buttonFlowPane (add buttons to FlowPane)
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newAthleteBtn);
        buttonFlowPane.getChildren().add(updateAthleteBtn);
        buttonFlowPane.getChildren().add(deleteAthleteBtn);
        buttonFlowPane.getChildren().add(enrollmentPayBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        // Customize inputFieldsPane (add Labels and TextFields to GridPane)
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(userCountLbl, 0, 0);
        inputFieldsPane.add(userCountField, 1, 0);
        inputFieldsPane.add(nameLbl, 0, 1);
        inputFieldsPane.add(nameField, 1, 1);
        inputFieldsPane.add(surnameLbl, 0, 2);
        inputFieldsPane.add(surnameField, 1, 2);
        inputFieldsPane.add(genderLbl, 0, 3);
        inputFieldsPane.add(maleRadioBtn, 1, 3);
        inputFieldsPane.add(femaleRadioBtn, 2, 3);
        inputFieldsPane.add(contactInfoLbl, 0, 4);
        inputFieldsPane.add(contactInfoField, 1, 4);
        inputFieldsPane.add(birthDateLbl, 0, 5);
        inputFieldsPane.add(birthDateField, 1, 5);
        inputFieldsPane.add(isProfessionalLbl, 0, 6);
        inputFieldsPane.add(professionalYesRadioBtn, 1, 6);
        inputFieldsPane.add(professionalNoRadioBtn, 2, 6);
        inputFieldsPane.add(experienceLbl, 0, 7);
        inputFieldsPane.add(experienceField, 1, 7);

        // Customize rootGridPane (add buttonFlowPane, inputFieldsPane, back button and TableView to the root GridPane)
        rootGridPane.setVgap(15);
        rootGridPane.setHgap(12);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(athleteTableView, 0, 0);
        rootGridPane.add(enrollmentTableView, 0, 1);
        rootGridPane.add(buttonFlowPane, 0, 2);
        rootGridPane.add(backBtn, 1, 1);

        // Customize athleteTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        athleteTableView.setPrefSize(770, 250);
        enrollmentTableView.setPrefSize(770, 250);

        TableColumn<Athlete, Integer> userCountColumn = new TableColumn<>("Κωδικός Αθλητή");
        userCountColumn.setCellValueFactory(new PropertyValueFactory<>("userCount"));
        athleteTableView.getColumns().add(userCountColumn);
        userCountColumn.setPrefWidth(110);

        TableColumn<Athlete, String> nameColumn = new TableColumn<>("Όνομα");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        athleteTableView.getColumns().add(nameColumn);
        nameColumn.setPrefWidth(70);

        TableColumn<Athlete, String> surnameColumn = new TableColumn<>("Επώνυμο");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        athleteTableView.getColumns().add(surnameColumn);
        surnameColumn.setPrefWidth(80);

        TableColumn<Athlete, String> genderColumn = new TableColumn<>("Φύλο");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        athleteTableView.getColumns().add(genderColumn);
        genderColumn.setPrefWidth(65);

        TableColumn<Athlete, String> contactInfoColumn = new TableColumn<>("Στ. Επικοινωνίας");
        contactInfoColumn.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
        athleteTableView.getColumns().add(contactInfoColumn);
        contactInfoColumn.setPrefWidth(110);

        TableColumn<Athlete, String> birthDateColumn = new TableColumn<>("Ημ. Γέννησης");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        athleteTableView.getColumns().add(birthDateColumn);
        birthDateColumn.setPrefWidth(100);

        TableColumn<Athlete, Boolean> isProfessionalColumn = new TableColumn<>("Είναι Επαγγελματίας");
        isProfessionalColumn.setCellValueFactory(new PropertyValueFactory<>("isProfessional"));
        athleteTableView.getColumns().add(isProfessionalColumn);
        isProfessionalColumn.setPrefWidth(130);

        TableColumn<Athlete, Integer> experienceColumn = new TableColumn<>("Εμπειρία");
        experienceColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));
        athleteTableView.getColumns().add(experienceColumn);
        experienceColumn.setPrefWidth(90);

        TableColumn<Enrollment, Integer> enrollmentUserCountColumn = new TableColumn<>("Κωδικός Αθλητή");
        enrollmentUserCountColumn.setCellValueFactory(new PropertyValueFactory<>("userCount"));
        enrollmentTableView.getColumns().add(enrollmentUserCountColumn);
        enrollmentUserCountColumn.setPrefWidth(200);

        TableColumn<Enrollment, String> enrollmentDateColumn = new TableColumn<>("Hμ. Εγγραφής");
        enrollmentDateColumn.setCellValueFactory(new PropertyValueFactory<>("enrollmentDate"));
        enrollmentTableView.getColumns().add(enrollmentDateColumn);
        enrollmentDateColumn.setPrefWidth(200);

        TableColumn<Enrollment, Double> enrollmentPriceColumn = new TableColumn<>("Τιμή Εγγραφής");
        enrollmentPriceColumn.setCellValueFactory(new PropertyValueFactory<>("enrollCost"));
        enrollmentTableView.getColumns().add(enrollmentPriceColumn);
        enrollmentPriceColumn.setPrefWidth(200);



    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
            App.primaryStage.setScene(App.mainScene);
        }

        // Get values from fields, create new Athlete (based on these values) add it to athleteList, sync the athleteList with the TableView, clear the fields
        if (event.getSource() == newAthleteBtn) {
            userCount++;
            String name = nameField.getText();
            String surname = surnameField.getText();
            char gender = ((RadioButton) genderToggleGroup.getSelectedToggle()).getText().charAt(0);
            String contactInfo = contactInfoField.getText();
            String birthDate = birthDateField.getText();
            boolean isProfessional = ((RadioButton) professionalToggleGroup.getSelectedToggle()).getText().equals("Ναι");

            try {
                int experience = Integer.parseInt(experienceField.getText());
                if (experience < 1 || experience > 5) {
                    throw new IllegalArgumentException("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5.");
                }
                createAthlete(userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
            } catch (IllegalArgumentException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη εισαγωγή");
                alertType.setContentText("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5");
                alertType.show();
                userCount--;
            }


            tableSync();
            clearTextFields();

        }

        if (event.getSource() == updateAthleteBtn) {

            String name = nameField.getText();
            String surname = surnameField.getText();
            char gender = ((RadioButton) genderToggleGroup.getSelectedToggle()).getText().charAt(0);
            String contactInfo = contactInfoField.getText();
            String birthDate = birthDateField.getText();
            boolean isProfessional = ((RadioButton) professionalToggleGroup.getSelectedToggle()).getText().equals("Yes");
            try {
                int experience = Integer.parseInt(experienceField.getText());
                if (experience < 1 || experience > 5) {
                    throw new IllegalArgumentException("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5.");
                }
                updateAthlete(userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
            } catch (IllegalArgumentException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Μη έγκυρη εισαγωγή");
                alertType.setContentText("Η εμπειρία πρέπει να είναι μεταξύ 1 και 5."+ e.getMessage());
                alertType.show();
            }


            tableSync();
            clearTextFields();

        }

        // Delete Athlete by name
        if (event.getSource() == deleteAthleteBtn) {
            deleteAthlete(nameField.getText());

            tableSync();
            clearTextFields();
        }

        if (event.getSource() == enrollmentPayBtn) {
            Athlete selectedAthlete = athleteTableView.getSelectionModel().getSelectedItem();
            if (selectedAthlete == null) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Σφάλμα");
                alertType.setContentText("Επιλέξτε κάποιον αθλητή πρώτα.");
                alertType.show();
                return;
            }
            showEnrollmentPayWindow(selectedAthlete);
        }

        // Get Selected Athlete from TableView, get the values from the selection and set them to the fields
        if (event.getSource() == athleteTableView) {
            Athlete selectedAthlete = athleteTableView.getSelectionModel().getSelectedItem();
            if (selectedAthlete != null) {
                userCountField.setText(String.valueOf(selectedAthlete.getUserCount()));
                nameField.setText(selectedAthlete.getName());
                surnameField.setText(selectedAthlete.getSurname());

                char gender = selectedAthlete.getGender();
                if (gender == 'Ά') {
                    maleRadioBtn.setSelected(true);
                } else if (gender == 'Γ') {
                    femaleRadioBtn.setSelected(true);
                }

                contactInfoField.setText(selectedAthlete.getContactInfo());
                birthDateField.setText(selectedAthlete.getBirthDate());

                if (selectedAthlete.getIsProfessional()) {
                    professionalYesRadioBtn.setSelected(true);
                } else {
                    professionalNoRadioBtn.setSelected(true);
                }

                experienceField.setText(String.valueOf(selectedAthlete.getExperience()));
            }
        }
    }

    // create a new Athlete object and add it to athleteList
    public void createAthlete(int userCount, String name, String surname, char gender, String birthDate, String contactInfo, boolean isProfessional, int experience) {
        Athlete ath = new Athlete(userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
        athleteList.add(ath);
    }

    // sync athleteList objects with objects in TableView
    public void tableSync() {
        List<Athlete> items = athleteTableView.getItems();
        items.clear();
        for (User ath : athleteList) {
            if (ath instanceof Athlete) {
                items.add((Athlete) ath);
            }
        }
    }



    // Update Athlete by searching the athleteList by its userCount and then update the rest of the fields
    public void updateAthlete(int userCount, String name, String surname, char gender, String birthDate, String contactInfo, boolean isProfessional, int experience) {
        for (Athlete ath : athleteList) {
            if (ath.getUserCount() == userCount) {
                ath.setName(name);
                ath.setSurname(surname);
                ath.setGender(gender);
                ath.setContactInfo(contactInfo);
                ath.setBirthDate(birthDate);
                ath.setIsProfessional(isProfessional);
                ath.setExperience(experience);
                break;
            }
        }
    }

    // find an Athlete by name and delete it from athleteList
    public void deleteAthlete(String name) {
        for (int i = 0; i < athleteList.size(); i++) {
            if (athleteList.get(i).getName().equals(name)) {
                athleteList.remove(i);
                break;
            }
        }
    }

    //set to empty strings to clear the textFields
    public void clearTextFields() {
        userCountField.clear();
        nameField.clear();
        surnameField.clear();
        genderToggleGroup.selectToggle(null);
        contactInfoField.clear();
        birthDateField.clear();
        professionalToggleGroup.selectToggle(null);
        experienceField.clear();
    }
    int payCode=0;
    private void showEnrollmentPayWindow(Athlete selectedAthlete) {
        Stage payStage = new Stage();
        payStage.initModality(Modality.APPLICATION_MODAL);
        payStage.setTitle("Πληρωμή Εγγραφής");

        Label dateLabel = new Label("Ημερομηνία Εγγραφής:");
        TextField dateTextField = new TextField();
        Label methodLabel = new Label("Μέθοδος Πληρωμής:");
        ChoiceBox<String> paymentMethodChoice = new ChoiceBox<>();
        paymentMethodChoice.getItems().addAll("Μετρητά", "Τραπεζική Κάρτα");
        Button payButton = new Button("Πληρωμή");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(dateLabel, dateTextField, methodLabel, paymentMethodChoice, payButton);
        layout.setAlignment(Pos.CENTER);

        payButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String dateString = dateTextField.getText();
                String method = paymentMethodChoice.getValue();
                if (dateString == null || method == null) {
                    Alert alertType = new Alert(Alert.AlertType.ERROR);
                    alertType.setTitle("Μη έγκυρη είσοδος");
                    alertType.setContentText("Παρακαλώ συμπληρώστε όλα τα πεδία.");
                    alertType.show();
                    return;
                }
                // Calculate total enrollment cost
                double enrollmentPrice = selectedAthlete.getIsProfessional() ? 20.0 : 50.0;
                createEnrollment(selectedAthlete.getUserCount(), selectedAthlete, dateString, 0, 0);
                Enrollment enrollment = new Enrollment(selectedAthlete.getUserCount(), selectedAthlete, dateString, enrollmentPrice, 0);
                enrollmentList.add(enrollment);
                enrollmentTableView.getItems().add(enrollment);
                createPayment(++payCode, dateString, method, null, enrollment, 0);



                // Display payment code
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Κωδικός Πληρωμής");
                alert.setHeaderText(null);
                alert.setContentText("Ο κωδικός πληρωμής σας είναι: " + payCode);
                alert.showAndWait();

                // Close payment stage
                payStage.close();
            }
        });

        Scene scene = new Scene(layout, 300, 200);
        payStage.setScene(scene);
        payStage.showAndWait();

        tableSync();
        clearTextFields();
    }

    public void createPayment(int payCode, String date, String paymentMethod, Subscription subscription, Enrollment enrollment, double totalCost) {
        Payment payment = new Payment(payCode, date, paymentMethod, subscription, enrollment, totalCost);
        paymentList.add(payment);
    }

    public void createEnrollment(int userCount, Athlete athlete, String enrollmentDate, double enrollCost, double discount){
        Enrollment enrollment = new Enrollment(userCount, athlete, enrollmentDate, enrollCost, discount);
        enrollmentList.add(enrollment);
    }

    public static ArrayList<Athlete> getAthleteList() {
        return athleteList;
    }

}