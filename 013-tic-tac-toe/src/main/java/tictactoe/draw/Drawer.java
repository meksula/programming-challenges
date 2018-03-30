package tictactoe.draw;

import javafx.scene.control.Button;
import tictactoe.gameAction.GameAction;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

public class Drawer {
    private double height;
    private double width;

    public Drawer(double height, double width) {
        assignHeightAndWidth(height, width);
    }

    private void assignHeightAndWidth(double height, double width) {
        System.out.println(height);
        this.height = height / 3;
        this.width = width / 3;
    }

    public Button[] drawFields() {
        Button[] fields = new Button[9];

        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setPrefWidth(width);
            button.setPrefHeight(height);
            if (i <= 2) {
                button.setLayoutY(0);
                button.setLayoutX(width * i);
            }
            if (i >= 3 && i <= 6) {
                button.setLayoutY(height);
                button.setLayoutX(width * i - (width * 3));
            }
            if (i >= 6 && i <= 9) {
                button.setLayoutY(height * 2);
                button.setLayoutX(width * i - (width * 6));
            }
            setAction(button);
            fields[i] = button;
        }
        return fields;
    }

    private void setAction(Button button) {
        GameAction gameAction = GameAction.getInstance();
        button.setOnMouseClicked(event -> {
            button.setText(String.valueOf(gameAction.PLAYER_X));
            button.setDisable(true);
            gameAction.changeQueue();
        });
    }
}
