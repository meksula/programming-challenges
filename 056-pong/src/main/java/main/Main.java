package main;

import controller.BoardController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @Author
 * Karol Meksuła
 * 05-06-2018
 * */

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BoardController boardController = new BoardController(stage);
        boardController.initialize();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
