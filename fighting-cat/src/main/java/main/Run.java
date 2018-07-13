package main;

import controller.MainSceneController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @Author
 * Karol Meksuła
 * 13-07-2018
 * */

public class Run extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainSceneController controller = new MainSceneController(primaryStage);
        controller.initialize();
    }

}
