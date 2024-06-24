package gr.unipi.gui;

import gr.unipi.core.Athlete;
import gr.unipi.core.User;
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

public class AthleteManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    private int userCount=0;
    ArrayList<Athlete> athleteList;
    // Flow Pane
    FlowPane buttonFlowPane;
    // Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    // Second Scene buttons
    Button newAthleteBtn, updateAthleteBtn, deleteAthleteBtn, backBtn;
    // Second scene labels
    Label userCountLbl, nameLbl, surnameLbl, genderLbl, contactInfoLbl, birthDateLbl, isProfessionalLbl, experienceLbl;
    // Second scene TextFields
    TextField userCountField, nameField, surnameField, contactInfoField, birthDateField, experienceField;
    // Radio Buttons
    RadioButton maleRadioBtn, femaleRadioBtn, professionalYesRadioBtn, professionalNoRadioBtn;
    ToggleGroup genderToggleGroup, professionalToggleGroup;
    // TableView
    TableView<Athlete> athleteTableView;

    public AthleteManagementSceneCreator(double width, double height) {
        super(width, height);
        // Initialize fields
        athleteList = new ArrayList<>();
        // GridPane: root
        rootGridPane = new GridPane();
        // buttonFlowPane
        buttonFlowPane = new FlowPane();
        // Labels
        userCountLbl = new Label("User Count: ");
        nameLbl = new Label("Name: ");
        surnameLbl = new Label("Surname: ");
        genderLbl = new Label("Gender: ");
        contactInfoLbl = new Label("Contact: ");
        birthDateLbl = new Label("Birthday: ");
        isProfessionalLbl = new Label("Is Professional: ");
        experienceLbl = new Label("Experience: ");
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
        maleRadioBtn = new RadioButton("Male");
        maleRadioBtn.setToggleGroup(genderToggleGroup);
        femaleRadioBtn = new RadioButton("Female");
        femaleRadioBtn.setToggleGroup(genderToggleGroup);
        // Radio Buttons for Professional Status
        professionalToggleGroup = new ToggleGroup();
        professionalYesRadioBtn = new RadioButton("Yes");
        professionalYesRadioBtn.setToggleGroup(professionalToggleGroup);
        professionalNoRadioBtn = new RadioButton("No");
        professionalNoRadioBtn.setToggleGroup(professionalToggleGroup);
        // Buttons
        newAthleteBtn = new Button("New Athlete");
        updateAthleteBtn = new Button("Update");
        deleteAthleteBtn = new Button("Delete");
        backBtn = new Button("Go Back");
        // GridPane: Input Fields
        inputFieldsPane = new GridPane();
        // TableView
        athleteTableView = new TableView<>();

        // Attach events
        backBtn.setOnMouseClicked(this);
        newAthleteBtn.setOnMouseClicked(this);
        updateAthleteBtn.setOnMouseClicked(this);
        deleteAthleteBtn.setOnMouseClicked(this);
        athleteTableView.setOnMouseClicked(this);

        // Customize buttonFlowPane (add buttons to FlowPane)
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newAthleteBtn);
        buttonFlowPane.getChildren().add(updateAthleteBtn);
        buttonFlowPane.getChildren().add(deleteAthleteBtn);
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
        rootGridPane.setVgap(8);
        rootGridPane.setHgap(8);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(athleteTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 1);

        // Customize athleteTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        TableColumn<Athlete, Integer> userCountColumn = new TableColumn<>("UserCount");
        userCountColumn.setCellValueFactory(new PropertyValueFactory<>("userCount"));
        athleteTableView.getColumns().add(userCountColumn);

        TableColumn<Athlete, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        athleteTableView.getColumns().add(nameColumn);

        TableColumn<Athlete, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        athleteTableView.getColumns().add(surnameColumn);

        TableColumn<Athlete, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        athleteTableView.getColumns().add(genderColumn);

        TableColumn<Athlete, String> contactInfoColumn = new TableColumn<>("Contact");
        contactInfoColumn.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
        athleteTableView.getColumns().add(contactInfoColumn);

        TableColumn<Athlete, String> birthDateColumn = new TableColumn<>("Birthday");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        athleteTableView.getColumns().add(birthDateColumn);

        TableColumn<Athlete, Boolean> isProfessionalColumn = new TableColumn<>("Is Professional");
        isProfessionalColumn.setCellValueFactory(new PropertyValueFactory<>("isProfessional"));
        athleteTableView.getColumns().add(isProfessionalColumn);

        TableColumn<Athlete, Integer> experienceColumn = new TableColumn<>("Experience");
        experienceColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));
        athleteTableView.getColumns().add(experienceColumn);
    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("Διαχείριση Αθλητών Ακαδημιών");
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
            boolean isProfessional = ((RadioButton) professionalToggleGroup.getSelectedToggle()).getText().equals("Yes");


            try {
                int experience = Integer.parseInt(experienceField.getText());
                if (experience < 1 || experience > 5) {
                    userCount--;
                    throw new IllegalArgumentException("Experience must be between 1 and 5");
                }
                createAthlete(userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
            } catch (IllegalArgumentException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Invalid value");
                alertType.setContentText("The value must be between 1 and 5. \n Exception message: "+ e.getMessage());
                alertType.show();
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
                    throw new IllegalArgumentException("Experience must be between 1 and 5");
                }
                updateAthlete(userCount, name, surname, gender, birthDate, contactInfo, isProfessional, experience);
            } catch (IllegalArgumentException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Invalid value");
                alertType.setContentText("The value must be between 1 and 5. \n Exception message: "+ e.getMessage());
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

        // Get Selected Athlete from TableView, get the values from the selection and set them to the fields
        if (event.getSource() == athleteTableView) {
            Athlete selectedAthlete = athleteTableView.getSelectionModel().getSelectedItem();
            if (selectedAthlete != null) {
                userCountField.setText(String.valueOf(selectedAthlete.getUserCount()));
                nameField.setText(selectedAthlete.getName());
                surnameField.setText(selectedAthlete.getSurname());

                char gender = selectedAthlete.getGender();
                if (gender == 'M') {
                    maleRadioBtn.setSelected(true);
                } else if (gender == 'F') {
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
}


