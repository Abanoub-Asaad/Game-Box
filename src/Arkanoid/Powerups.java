/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 *
 * @author egypt
 */
public class Powerups {

    public void checkexpand(Paddle paddle) {
        Timeline expand_tl = new Timeline();
        if (Icons.getExpand_IV().getBoundsInParent().intersects(paddle.getPaddle_iv().getBoundsInParent())) {
//            Icons.setExpand_IV(null);
            Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent t) {
                    paddle.getPaddle_iv().setFitWidth(230);
                }
            });
            expand_tl.getKeyFrames().add(key);
            expand_tl.setCycleCount(20);
            expand_tl.setAutoReverse(true);
            expand_tl.play();
        }
        expand_tl.setOnFinished(event -> {
            paddle.getPaddle_iv().setFitWidth(200);
        });
    }

    public void checkshrink(Paddle paddle) {

        Timeline shrink_tl = new Timeline();
        if (Icons.getShrink_IV().getBoundsInParent().intersects(paddle.getPaddle_iv().getBoundsInParent())) {
//            Icons.setExpand_IV(null);
            Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent t) {
                    paddle.getPaddle_iv().setFitWidth(150);
                }
            });
            shrink_tl.getKeyFrames().add(key);
            shrink_tl.setCycleCount(20);
            shrink_tl.setAutoReverse(true);
            shrink_tl.play();
        }
        shrink_tl.setOnFinished(event -> {
            paddle.getPaddle_iv().setFitWidth(200);
        });
    }

    public void checkFast(Paddle paddle_obj, Ball ball_obj) {

        Timeline Fast_tl = new Timeline();
        if (Icons.getFast_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
//            Icons.setFast_IV(null);
            Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent t) {
                    ball_obj.setSpeed(7);
                }
            });
            Fast_tl.getKeyFrames().add(key);
            Fast_tl.setCycleCount(20);
            Fast_tl.setAutoReverse(true);
            Fast_tl.play();
        }
        Fast_tl.setOnFinished(event -> {
            ball_obj.setSpeed(5);
        });
    }

    public void checkExtra100(Paddle paddle_obj, Score score_obj) {
        if (Icons.getExtra100_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            Sound.playsound_capsule();
//            Icons.setExtra100_IV(null);
            score_obj.SetScore(3);

        }
    }

    public void checkExtra50(Paddle paddle_obj, Score score_obj) {
        if (Icons.getExtra50_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            Sound.playsound_capsule();
//            Icons.setExtra50_IV(null);
            score_obj.SetScore(2);

        }

    }

    public void checkSlow(Paddle paddle_obj, Ball ball_obj) {

        Timeline Slow_tl = new Timeline();
        if (Icons.getSlow_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
//            Icons.setSlow_IV(null);   
            Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent t) {
                    ball_obj.setSpeed(4);
                }
            });
            Slow_tl.getKeyFrames().add(key);
            Slow_tl.setCycleCount(20);
            Slow_tl.setAutoReverse(true);
            Slow_tl.play();
        }
        Slow_tl.setOnFinished(event -> {
            ball_obj.setSpeed(5);
        });
    }

    public void checkempty(Paddle paddle_obj) {
        if (Icons.getEmpty_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
//            Icons.setEmpty_IV(null);
            Sound.playsound_capsule();
        }

    }
}
