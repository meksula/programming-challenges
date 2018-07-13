package model.conc;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import model.Actions;

import javafx.scene.image.ImageView;

/**
 * @Author
 * Karol Meksuła
 * 13-07-2018
 * */

public class BasicActions implements Actions {

    @Override
    public void addCharacterActions(Scene scene, ImageView imageView) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                imageView.setLayoutX(imageView.getLayoutX() + 7);
                imageView.setScaleX(1);
            }
            if (event.getCode() == KeyCode.LEFT) {
                imageView.setLayoutX(imageView.getLayoutX() - 7);
                imageView.setScaleX(-1);
            }
            if (event.getCode() == KeyCode.SPACE) {
                jump(imageView);
            }

        });

    }

    private void jump(ImageView imageView) {
        imageView.setImage(new Image("/cat_ani/cat_jump.gif"));
        GameTimer gameTimer = new GameTimer();
        gameTimer.jump(imageView, 60);

        imageView.setImage(new Image("/cat_ani/cat_idle.gif"));
    }

}
