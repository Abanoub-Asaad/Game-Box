package GameLoop;

import Arkanoid.AR_Sound;
import Arkanoid.ArkanoidMain;
import Arkanoid.ball;
import Arkanoid.paddle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BaseClass {

    public static void checkPaddle(ball ball_obj, paddle paddle_obj, boolean goLeft, boolean goRight) {

        boolean atLeftBorder = ball_obj.getX() >= (paddle_obj.getX() - ball_obj.getWidth());
        boolean atRightBorder = ball_obj.getX() <= (paddle_obj.getX() + paddle_obj.getWidth() + ball_obj.getWidth() - 10);
        boolean atBottomBorder = ball_obj.getY() >= (paddle_obj.getY() - ball_obj.getHeight());

        if (atRightBorder && atLeftBorder && atBottomBorder) {
            ball_obj.setStepY(-1);
            if (goLeft) {
                ball_obj.setStepX(-1);
            }
            if (goRight) {
                ball_obj.setStepX(1);
            }
        }

        boolean atLeftBorderleft = ball_obj.getX() >= paddle_obj.getX() - ball_obj.getWidth() && ball_obj.getX() <= (paddle_obj.getX() - ball_obj.getWidth() + 10);
        boolean atBottomBorderleft = ball_obj.getY() >= (paddle_obj.getY() - ball_obj.getHeight() + 3);
        if (atLeftBorderleft && atBottomBorderleft) {
            ball_obj.setStepY(-1);
            ball_obj.setStepX(-1);
        }

        boolean atRightBorderRight = ball_obj.getX() <= paddle_obj.getX() + paddle_obj.getWidth() + ball_obj.getWidth() + 5 && ball_obj.getX() >= paddle_obj.getX() + paddle_obj.getWidth() + ball_obj.getWidth() - 10;
        boolean atBottomBorderRight = ball_obj.getY() >= (paddle_obj.getY() - ball_obj.getHeight() + 3);
        if (atRightBorderRight && atBottomBorderRight) {
            ball_obj.setStepY(-1);
            ball_obj.setStepX(1);
        }
    }

    public static void checkPause(Scene scene_1, ball ball_obj, paddle paddle_obj, Group group, Pane pane) {
        Text pause = new Text();
        scene_1.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.P) {
                    ball_obj.setSpeed(0);
                    paddle_obj.setSpeed(0);

                    pause.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 50));
                    pause.setFill(Color.LIME);// setting colour of the text to blue   
                    pause.setText("Paused");
                    if (group == null) {
                        pane.getChildren().add(pause);
                        pause.setX(scene_1.getWidth() / 2 - 260);
                        pause.setY(scene_1.getHeight() / 2);
                    } else {
                        group.getChildren().add(pause);
                        pause.setX(scene_1.getWidth() / 2 - 60);
                        pause.setY(scene_1.getHeight() / 2);
                    }

                    AR_Sound.mediaPlayer_background.pause();
                } else if (e.getCode() == KeyCode.ENTER) {
                    ball_obj.setSpeed(5);
                    paddle_obj.setSpeed(10);
                    if (group == null) {
                        pane.getChildren().remove(pause);
                    } else {
                        group.getChildren().remove(pause);
                    }

                    AR_Sound.mediaPlayer_background.play();
                } else if (e.getCode() == KeyCode.S) {
                    AR_Sound.mediaPlayer_background.pause();
                }

            }
        });
    }

    public static void check_Escape(Scene Currentscene, Stage stage, Scene Toscene) {
        Currentscene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ESCAPE) {
                    AR_Sound.mediaPlayer_background.stop();
                    stage.setTitle("Arkanoid - Menu");
                    stage.setScene(Toscene);
                }

            }
        });
    } 

    public static void ShowPlayerNameOnScreen(String s_name) {
        Text player_txt = new Text();

        player_txt.setX(560);
        player_txt.setY(40);
        player_txt.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 25));
        player_txt.setFill(Color.RED);// setting colour of the text to blue   
        player_txt.setText("\" " + s_name + " \"");

        ArkanoidMain.root.getChildren().add(player_txt);
    }

}
