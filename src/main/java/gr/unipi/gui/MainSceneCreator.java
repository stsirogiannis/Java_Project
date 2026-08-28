package gr.unipi.gui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {

    // Flow Pane (root node)
    FlowPane rootFlowPane;

    // Main scene buttons
    Button AthleteBtn, SubscriptionBtn, ReservationBtn;

    public MainSceneCreator(double width, double height) {
        super(width, height);

        rootFlowPane = new FlowPane();
        AthleteBtn = new Button("Διαχείριση Αθλητών");
        SubscriptionBtn = new Button("Διαχείριση Συνδρομών");
        ReservationBtn = new Button("Διαχείριση Κρατήσεων");

        // attach handle event to Btn
        AthleteBtn.setOnMouseClicked(this);
        SubscriptionBtn.setOnMouseClicked(this);
        ReservationBtn.setOnMouseClicked(this);

        // set up Flow pane
        rootFlowPane.setHgap(10);
        rootFlowPane.setAlignment(Pos.CENTER);

        // add athlete, reservation, subscription buttons to rootFlowPane
        rootFlowPane.getChildren().add(AthleteBtn);
        rootFlowPane.getChildren().add(SubscriptionBtn);
        rootFlowPane.getChildren().add(ReservationBtn);
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource() == AthleteBtn) {
            App.primaryStage.setScene(App.athleteScene);
            App.primaryStage.setTitle("Διαχείριση Αθλητών");
        }  else if (event.getSource() == SubscriptionBtn) {
            App.primaryStage.setScene(App.subscriptionScene);
            App.primaryStage.setTitle("Διαχείριση Συνδρομών");
        } else if(event.getSource() == ReservationBtn) {
            App.primaryStage.setScene(App.reservationScene);
            App.primaryStage.setTitle("Διαχείριση Κρατήσεων");
        }
    }

    @Override
    Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }

}