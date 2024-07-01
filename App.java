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

        SceneCreator mainSceneCreator = new MainSceneCreator(600, 350);
        mainScene = mainSceneCreator.createScene();

        SceneCreator athleteSceneCreator = new AthleteManagementSceneCreator(1220, 580);
        athleteScene = athleteSceneCreator.createScene();

        SceneCreator subscriptionSceneCreator = new SubscriptionManagementSceneCreator(1195, 695);
        subscriptionScene = subscriptionSceneCreator.createScene();

        SceneCreator reservationSceneCreator = new ReservationManagementSceneCreator(770, 350);
        reservationScene = reservationSceneCreator.createScene();

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Διαχείριση Αθλητικών Ακαδημιών");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}