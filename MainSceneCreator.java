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
    Button AthleteBtn, ReservationBtn, SubscriptionBtn;

    public MainSceneCreator(double width, double height) {
        super(width, height);
        rootFlowPane = new FlowPane();
        AthleteBtn = new Button("Διαχείριση Αθλητών");
        ReservationBtn = new Button("Διαχείριση Συνδρομών");
        SubscriptionBtn = new Button("Διαχείριση Κρατήσεων");

        // attach handle event to AthleteBtn
        AthleteBtn.setOnMouseClicked(this);

        // set up Flow pane
        rootFlowPane.setHgap(10);
        rootFlowPane.setAlignment(Pos.CENTER);
        // add athlete, reservation, subscription buttons to rootFlowPane
        rootFlowPane.getChildren().add(AthleteBtn);
        rootFlowPane.getChildren().add(ReservationBtn);
        rootFlowPane.getChildren().add(SubscriptionBtn);

    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getSource() == AthleteBtn) {
            App.primaryStage.setScene(App.athleteScene);
            App.primaryStage.setTitle("Athlete Management Window");
        }
        else if(event.getSource() == SubscriptionBtn) {
        	 App.primaryStage.setScene(App.subscriptionScene);
             App.primaryStage.setTitle("Subscription Management Window");
        }
        else if(event.getSource() == ReservationBtn){
        	App.primaryStage.setScene(App.reservationScene);
            App.primaryStage.setTitle("Reservation Management Window");
        }
    
    }
    
 
    

    @Override
    Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }
}

