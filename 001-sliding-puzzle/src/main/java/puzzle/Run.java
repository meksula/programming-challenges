package puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import puzzle.controller.Controller;

/*
 * @Author Karol Meksuła
 * 24-02-2018
 **/

public class Run extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sliding Puzzle");
        primaryStage.show();
    }

    public static void main(String[]args){
        launch(args);
    }
}
