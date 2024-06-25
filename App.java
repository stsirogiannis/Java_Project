package gr.unipi.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */

public class App extends Application {

    // Stage
    static Stage primaryStage;
    // Scenes
    static Scene mainScene, athleteScene, subscriptionScene, reservationScene;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        SceneCreator mainSceneCreator = new MainSceneCreator(800, 450);
        mainScene = mainSceneCreator.createScene();

        SceneCreator athleteSceneCreator = new AthleteManagementSceneCreator(1100, 350);
        athleteScene = athleteSceneCreator.createScene();

        SceneCreator subscriptionSceneCreator = new SubscriptionManagementSceneCreator(1100, 200);
        subscriptionScene = subscriptionSceneCreator.createScene();

        SceneCreator reservationSceneCreator = new ReservationManagementSceneCreator(650, 300);
        reservationScene = reservationSceneCreator.createScene();

        
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}