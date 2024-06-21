 package gr.unipi.gui;
import gr.unipi.core.Athlete;

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


    ArrayList<Athlete> athleteList;
    //	Flow Pane
    FlowPane buttonFlowPane;
    //	Grid Panes
    GridPane rootGridPane, inputFieldsPane;
    //	Second Scene buttons
    Button newAthleteBtn, updateAthleteBtn, deleteAthleteBtn, backBtn;
    //	Second scene labels
    Label userCountLbl, nameLbl, surnameLbl, ageLbl, genderLbl, contactLbl, birthdayLbl, professionalLbl, experienceLbl;
    //	Second scene TextFields
    TextField userCountField, nameField, surnameField, genderField, contactField, birthdayField, professionalField, experienceField;
    //	TableView
    TableView<Athlete> athleteTableView;


    public AthleteManagementSceneCreator(double width, double height) {
        super(width, height);
        //  Initialize fields
        athleteList = new ArrayList<>();
        //GridPane: root
        rootGridPane = new GridPane();
        //buttonFlowPane
        buttonFlowPane = new FlowPane();
        //Labels
        nameLbl = new Label("Name: ");
        surnameLbl = new Label("Surname: ");
        genderLbl = new Label("Gender: ");
        contactLbl = new Label("Contact: ");
        birthdayLbl = new Label("Birthday: ");
        // Fields
        nameField = new TextField();
        surnameField = new TextField();
        genderField = new TextField();
        contactField = new TextField();
        birthdayField = new TextField();
        //Buttons
        newAthleteBtn = new Button("New Athlete");
        updateAthleteBtn = new Button("Update");
        deleteAthleteBtn = new Button("Delete");
        backBtn = new Button("Go Back");
        // GridPane: Input Fields
        inputFieldsPane = new GridPane();
        //TableView
        athleteTableView = new TableView<>();


        //  Attach events
        backBtn.setOnMouseClicked(this);
        newAthleteBtn.setOnMouseClicked(this);
        updateAthleteBtn.setOnMouseClicked(this);
        deleteAthleteBtn.setOnMouseClicked(this);
        athleteTableView.setOnMouseClicked(this);

        //  Customize buttonFlowPane (add buttons to FlowPane)
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().add(newAthleteBtn);
        buttonFlowPane.getChildren().add(updateAthleteBtn);
        buttonFlowPane.getChildren().add(deleteAthleteBtn);
        buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);

        // Customize inputFieldsPane (add Labels and TextFields to GridPane)
        inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
        inputFieldsPane.setVgap(10);
        inputFieldsPane.setHgap(10);
        inputFieldsPane.add(nameLbl, 0, 0);
        inputFieldsPane.add(nameField, 1, 0);
        inputFieldsPane.add(ageLbl, 0, 1);
        inputFieldsPane.add(ageField, 1, 1);
        inputFieldsPane.add(breedLbl, 0, 2);
        inputFieldsPane.add(breedField, 1, 2);
        inputFieldsPane.add(genderLbl, 0, 3);
        inputFieldsPane.add(genderField, 1, 3);

        // Customize rootGridPane (add buttonFlowPane, inputFieldsPane, back button and TableView to the root GridPane)
        rootGridPane.setVgap(10);
        rootGridPane.setHgap(10);
        rootGridPane.add(inputFieldsPane, 1, 0);
        rootGridPane.add(athleteTableView, 0, 0);
        rootGridPane.add(buttonFlowPane, 0, 1);
        rootGridPane.add(backBtn, 1, 1);

        // Customize dogTableView: Create Column, create Cell and set it to Column. Add Column to TableView
        TableColumn<Athlete, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        athleteTableView.getColumns().add(nameColumn);

        TableColumn<Athlete, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        athleteTableView.getColumns().add(ageColumn);

        TableColumn<Athlete, String> breedColumn = new TableColumn<>("Breed");
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));
        athleteTableView.getColumns().add(breedColumn);

        TableColumn<Athlete, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        athleteTableView.getColumns().add(genderColumn);


    }

    @Override
    Scene createScene() {
        return new Scene(rootGridPane, width, height);
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == backBtn) {
            App.primaryStage.setTitle("ZooMainFX Window");
            App.primaryStage.setScene(App.mainScene);
        }

        // Get values from fields, create new Dog (based on these values) add it to athleteList, sync the athleteList with the TableView, clear the fields
        if (event.getSource() == newAthleteBtn) {
            String name = nameField.getText();
            String breed = breedField.getText();
            char gender = (genderField.getText()).charAt(0);
//      	  int age = Integer.parseInt(ageField.getText());
//      	  createDog(name, age, breed, gender);

            //EXCEPTION HANDLING ---> RUNTIME ERROR HANDLING

            try {
                int age = Integer.parseInt(ageField.getText());
                createDog(name, age, breed, gender);
            } catch (NumberFormatException e) {
                Alert alertType = new Alert(Alert.AlertType.ERROR);
                alertType.setTitle("Invalid value");
                alertType.setContentText("The value provided for age is not a number. \n Exception message: "+ e.getMessage());
                alertType.show();
            }

            tableSync();
            clearTextFields();
        }

        // Get values from fields, update Dog, sync table and athleteList, clearFields
        if (event.getSource() == updateDogBtn) {
            String name = nameField.getText();
            String age = ageField.getText();
            String breed = breedField.getText();
            String gender = genderField.getText();

            updateDog(name, Integer.parseInt(age), breed, gender.charAt(0));

            tableSync();
            clearTextFields();
        }
        // Delete Dog by name
        if (event.getSource() == deleteDogBtn) {
            deleteDog(nameField.getText());

            tableSync();
            clearTextFields();
        }

        // Get Selected Dog from TableView, get the values from the selection and set them to the fields
        if (event.getSource() == athleteTableView) {
            Athlete selectedDog = athleteTableView.getSelectionModel().getSelectedItem();
            if (selectedDog != null) {
                nameField.setText(selectedDog.getName());
                breedField.setText(selectedDog.getBreed());
                ageField.setText(Integer.toString(selectedDog.getAge()));
                genderField.setText(Character.toString(selectedDog.getGender()));
            }
        }

    }

    // create a new Dog object and add it to zoolist
    public void createDog(String name, int age, String breed, char gender) {
        Mammal d = new Dog(name, age, breed, gender);
        athleteList.add(d);
    }


    // sync athleteList objects with objects in TableView
    public void tableSync() {
        List<Dog> items = dogTableView.getItems();
        items.clear();
        for (Mammal d : athleteList) {
            if (d instanceof Dog) {
                items.add((Dog) d);
            }
        }
    }
    // Update Dog by searching the athleteList by Dog name and then update the rest of the fields (tip: better use unique ID for this job...)
    public void updateDog(String name, int age, String breed, char gender) {
        for (Mammal d : athleteList) {
            if ((d.getName()).equals(name)) {
                d.setAge(age);
                d.setGender(gender);
                ((Dog) d).setBreed(breed);
            }
        }
    }

    // find a Dog by name and delete it from athleteList
    public void deleteDog(String name) {
        for (int i = 0; i < athleteList.size(); i++) {
            if (athleteList.get(i).getName().equals(name)) {
                athleteList.remove(i);
                break;
            }
        }
    }

    //set to empty strings to clear the textFields
    public void clearTextFields() {
        nameField.setText("");
        ageField.setText("");
        breedField.setText("");
        genderField.setText("");
    }


}
