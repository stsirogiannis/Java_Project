package gr.unipi.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    // Stage
    static Stage primaryStage;
    // Scenes
    static Scene mainScene, athleteScene, reservationScene, subscriptionScene;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();

        SceneCreator athleteSceneCreator = new AthleteManagementSceneCreator(650, 300);
        athleteScene = athleteSceneCreator.createScene();

        SceneCreator reservationSceneCreator = new ReservationManagementSceneCreator(650, 300);
        reservationScene = reservationSceneCreator.createScene();

        SceneCreator subscriptionSceneCreator = new SubscriptionManagementSceneCreator(650, 300);
        subscriptionScene = subscriptionSceneCreator.createScene();


        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Διαχείριση Αθλητών Ακαδημιών");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
