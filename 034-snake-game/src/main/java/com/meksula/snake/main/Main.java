package com.meksula.snake.main;

import com.meksula.snake.controller.MainBoardController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @Author
 * Karol Meksuła
 * 29-06-2018
 * */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainBoardController mainBoardController = new MainBoardController(primaryStage);

        primaryStage.setOnCloseRequest(event -> mainBoardController.stopGame());
        primaryStage.setWidth(600);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
