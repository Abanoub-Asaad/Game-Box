
package Arkanoid;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Powerups {

    private ImageView expand_imageView = Icons.getExpand_IV();
    private ImageView shrink_imageView = Icons.getShrink_IV();
    private ImageView slow_imageView = Icons.getSlow_IV();
    private ImageView fast_imageView = Icons.getFast_IV();
    private ImageView empty_imageView = Icons.getEmpty_IV();
    private ImageView heart_imageView = Icons.getHeart_IV();
    private ImageView extra50_imageView = Icons.getExtra50_IV();
    private ImageView extra100_imageView = Icons.getExtra100_IV();
    public boolean extra50once = false, extra100once = false;

    public void checkexpand(paddle paddle) {
        Timeline expand_tl = new Timeline();
        if (Icons.getExpand_IV().getBoundsInParent().intersects(paddle.getPaddle_iv().getBoundsInParent())) {
            expand_imageView.setImage(null);
            AR_Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
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

    public void checkshrink(paddle paddle) {

        Timeline shrink_tl = new Timeline();
        if (Icons.getShrink_IV().getBoundsInParent().intersects(paddle.getPaddle_iv().getBoundsInParent())) {
            shrink_imageView.setImage(null);
            AR_Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
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

    public void checkFast(paddle paddle_obj, ball ball_obj) {

        Timeline Fast_tl = new Timeline();
        if (Icons.getFast_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            fast_imageView.setImage(null);
            AR_Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
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

    public void checkExtra100(paddle paddle_obj, Score score_obj) {
        if (Icons.getExtra100_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            AR_Sound.playsound_capsule();
            extra100_imageView.setImage(null);
            if (!extra100once) {
                System.out.println("check extra 100 ");
                score_obj.SetScore(3);
                extra100once = true;
            }
        }
    }

    public void checkExtra50(paddle paddle_obj, Score score_obj) {
        if (Icons.getExtra50_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            AR_Sound.playsound_capsule();
            extra50_imageView.setImage(null);

            if (!extra50once) {
                System.out.println("check extra 50 ");
                score_obj.SetScore(2);
                extra50once = true;
            }
        }

    }

    public void checkSlow(paddle paddle_obj, ball ball_obj) {

        Timeline Slow_tl = new Timeline();
        if (Icons.getSlow_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            slow_imageView.setImage(null);
            AR_Sound.playsound_capsule();

            KeyFrame key = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
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

    public void checkempty(paddle paddle_obj) {
        if (Icons.getEmpty_IV().getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            empty_imageView.setImage(null);
            AR_Sound.playsound_capsule();
        }

    }
}
