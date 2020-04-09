package Arkanoid;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author egypt
 */
public class movement {

    public static paddle paddle_obj = new paddle();
    public static ball ball_obj = new ball();
    public static boolean goLeft = false;
    public static boolean goRight = false;
    public static boolean BallDoesnotMove = false;
    private static boolean clickOnlyOnce = false, Play_Animation = false;
    static Text pressToStart = new Text();

    public static void start() throws IOException {
        goLeft = false;
        goRight = false;
        BallDoesnotMove = false;
        clickOnlyOnce = false;
        Play_Animation = false;
        Arkanoid_main.root.getChildren().clear();
        map.startlevel();
        dragUsingKeyboard(Arkanoid_main.Arkanoid_scene);
        PressEnterToStart();
        paddle_obj.setX((Arkanoid_main.Arkanoid_scene.getWidth() / 2) - paddle_obj.getWidth());
        paddle_obj.setY((Arkanoid_main.Arkanoid_scene.getHeight() - paddle_obj.getWidth()));

        ball_obj.setX(paddle_obj.getX() + (paddle_obj.getWidth() / 2) - (ball_obj.getWidth() / 2) + 50);
        ball_obj.setY(paddle_obj.getY() - ball_obj.getHeight() - 1);

        Arkanoid_main.root.getChildren().addAll(ball_obj.ball_iv, paddle_obj.paddle_iv);
        StartMovement(Arkanoid_main.Arkanoid_scene);
    }

    public static void StartMovement(Scene scene_1) {

        scene_1.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER && clickOnlyOnce == false) {
                    GameMovement(true);
                    clickOnlyOnce = true;
                    Arkanoid_main.root.getChildren().remove(pressToStart);
                }

            }
        });

    }

    public static void GameMovement(boolean play_Animation) {

        AnimationTimer at;
        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (goLeft && paddle_obj.getX() > 0 && !BallDoesnotMove) {
                    paddle_obj.setX(paddle_obj.getX() - paddle_obj.speed);
                }
                if (goRight && paddle_obj.getX() < Arkanoid_main.Arkanoid_scene.getWidth() - paddle_obj.getWidth() * 2
                        && !BallDoesnotMove) {
                    paddle_obj.setX(paddle_obj.getX() + paddle_obj.speed);
                }

                checkBorders();
                checkBlocks();
                checkPaddle();
                paddle_obj.Animation_Paddle(true);

                if (!BallDoesnotMove) {
                    ball_obj.setX(ball_obj.getX() + ball_obj.getStepX() * ball_obj.getSpeed());
                    ball_obj.setY(ball_obj.getY() + ball_obj.getStepY() * ball_obj.getSpeed());
                }

            }
        };
        if (play_Animation == true) {
            at.start();
        } else {
            at.stop();
        }
    }

    public static void checkBlocks() {
        for (ImageView b : map.bricks_arraylist) {
            boolean ball_down_block = ball_obj.getX() <= b.getX() + 150 && ball_obj.getX() >= b.getX() - ball_obj.getWidth() && ball_obj.getY() <= b.getY() + 50 + 3 && ball_obj.getY() >= b.getY() + 50 - 3;
            boolean ball_above_block = ball_obj.getX() <= b.getX() + 150 && ball_obj.getX() >= b.getX() - ball_obj.getWidth() && ball_obj.getY() <= b.getY() - ball_obj.getHeight() + 3 && ball_obj.getY() >= b.getY() - ball_obj.getHeight() - 3;
            boolean ball_left_block = ball_obj.getY() <= b.getY() + 50 && ball_obj.getY() >= b.getY() - ball_obj.getHeight() && ball_obj.getX() <= b.getX() - ball_obj.getWidth() + 3 && ball_obj.getX() >= b.getX() - ball_obj.getWidth() - 3;
            boolean blockRight = ball_obj.getY() <= b.getY() + 50 && ball_obj.getY() >= b.getY() - ball_obj.getHeight() && ball_obj.getX() <= b.getX() + 150 + 3 && ball_obj.getX() >= b.getX() + 150 - 3;

            //==========================
            if (ball_down_block) {

                if (!b.isDisabled()) {
                    System.out.print("block number " + map.bricks_arraylist.indexOf(b) + "\n");
                    b.setImage(null);
                    b.setDisable(true);
                    Arkanoid_main.root.getChildren().remove(b);
                    ball_obj.setStepY(1);

                    if (checkWin()) {
                        if (!BallDoesnotMove) {
                            finish(true);
                            BallDoesnotMove = true;
                        }
                    }
                }

            } else if (ball_above_block) {

                if (!b.isDisable()) {
                    b.setImage(null);
                    b.setDisable(true);
                    Arkanoid_main.root.getChildren().remove(b);
                    ball_obj.setStepY(-1);

                    if (checkWin()) {
                        if (!BallDoesnotMove) {
                            finish(true);
                            BallDoesnotMove = true;

                        }
                    }
                }

            } else if (ball_left_block) {
                if (!b.isDisable()) {
                    b.setImage(null);
                    b.setDisable(true);
                    Arkanoid_main.root.getChildren().remove(b);
                    ball_obj.setStepX(-1);
                    if (checkWin()) {
                        if (!BallDoesnotMove) {
                            finish(true);
                            BallDoesnotMove = true;
                        }
                    }
                }

            } else if (blockRight) {

                if (!b.isDisable()) {
                    b.setImage(null);
                    b.setDisable(true);
                    Arkanoid_main.root.getChildren().remove(b);
                    ball_obj.setStepX(1);
                    if (checkWin()) {
                        if (!BallDoesnotMove) {
                            finish(true);
                            BallDoesnotMove = true;
                        }
                    }
                }

            }

        }

    }

    public static boolean checkWin() {
        for (ImageView b : map.bricks_arraylist) {
            if (!b.isDisable()) {
                return false;
            }
        }
        return true;

    }

    public static void checkBorders() {

        boolean atRightBorder = ball_obj.getX() >= (Arkanoid_main.Arkanoid_scene.getWidth() - ball_obj.getWidth());
        boolean atLeftBorder = ball_obj.getX() <= 0;
        boolean atTopBorder = ball_obj.getY() <= (ball_obj.getWidth()) / 2;
        boolean atBottomBorder = ball_obj.getY() >= (Arkanoid_main.Arkanoid_scene.getHeight() - ball_obj.getWidth());

        //Here we change the Direction of the Ball 
        if (atRightBorder) {
            ball_obj.setStepX(-1);
        }

        if (atLeftBorder) {
            ball_obj.setStepX(1);
        }

        if (atTopBorder) {
            ball_obj.setStepY(1); //ball_obj.getStepY()*-1
        }
        if (atBottomBorder) {
            ball_obj.setStepX(0);
            ball_obj.setStepY(0);
            if (!BallDoesnotMove) {
                finish(false);
                BallDoesnotMove = true;
                goRight = false;
                goLeft = false;

            }
        }

    }

    private static void finish(boolean win) {
        Stage finishStage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene_finish = new Scene(root, 400, 100);
        HBox Label = new HBox(15);
        Label.setAlignment(Pos.BOTTOM_CENTER);
        HBox bBox = new HBox(20);
        String labels;
        Button nextlevel = new Button("next level");
        nextlevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    start();
                    finishStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(movement.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

        if (win) {
            labels = "You Win";
            bBox.getChildren().addAll(nextlevel);

        } else {
            labels = "Game Over";
        }

        Label label = new Label(labels);
        final double MAX_FONT_SIZE = 30.0; // define max font size you need
        label.setFont(new Font(MAX_FONT_SIZE)); // set to Label
        Label.getChildren().add(label);
        root.setCenter(Label);

        String restartText;
        if (win) {
            restartText = "Next Level";
        }

        Button close = new Button("Close");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Platform.exit();

            }
        }
        );

        bBox.getChildren().addAll(close);
        root.setBottom(bBox);
        finishStage.setScene(scene_finish);
        finishStage.show();
    }

    ;
    
   
        private static void dragUsingKeyboard(Scene scene1) {
        Arkanoid_main.Arkanoid_scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.LEFT) {
                    goLeft = true;
                }
                if (e.getCode() == KeyCode.RIGHT) {
                    goRight = true;
                }
            }
        });
        Arkanoid_main.Arkanoid_scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.LEFT) {
                    goLeft = false;
                }
                if (e.getCode() == KeyCode.RIGHT) {
                    goRight = false;
                }
            }

        });

    }

    public static void checkPaddle() {

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

    public static void PressEnterToStart()
    {
        pressToStart.setX(Arkanoid_main.Arkanoid_scene.getWidth() / 2 - 250);
        pressToStart.setY(Arkanoid_main.Arkanoid_scene.getHeight() / 2 + 150);
        pressToStart.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 50));
        pressToStart.setFill(Color.DEEPSKYBLUE);// setting colour of the text to blue   
        pressToStart.setText("Press \" Enter \" to Start");
        Arkanoid_main.root.getChildren().add(pressToStart);
    }
}
