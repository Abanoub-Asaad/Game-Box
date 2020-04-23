package Arkanoid;

import GameLoop.BaseClass;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
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
import javafx.stage.WindowEvent;

/**
 *
 * @author egypt
 */
public class Movement {

    private static Paddle paddle_obj = new Paddle();
    private static Ball ball_obj = new Ball();
    private PlayerNameFile player_obj = new PlayerNameFile();
    private Icons icon;
    private Arkanoid_Map map;
    private Score score;
    private Powerups powerup = new Powerups();
    public int lives = 5;
    private static boolean goLeft = false;
    private static boolean goRight = false;
    private static boolean BallDoesnotMove = false;
    private static boolean clickOnlyOnce = false, Play_Animation = false;
    static Text pressToStart = new Text();
    private Stage arkanoid_stage;

    public Movement(Stage Arkanoid_stage) throws IOException {
        map = new Arkanoid_Map();
        this.arkanoid_stage = Arkanoid_stage;
        start();
    }

    private void start() throws IOException {
        ArkanoidMain.root.getChildren().clear();

        dragUsingKeyboard(ArkanoidMain.Arkanoid_scene);

        map.startlevel();
        icon = new Icons();
        score = new Score();
        goLeft = false;
        goRight = false;
        BallDoesnotMove = false;
        clickOnlyOnce = false;
        Play_Animation = false;

        PressEnterToStart();
        paddle_obj.setX((ArkanoidMain.Arkanoid_scene.getWidth() / 2) - paddle_obj.getWidth());
        paddle_obj.setY((ArkanoidMain.Arkanoid_scene.getHeight() - paddle_obj.getWidth()));
        ball_obj.setX(paddle_obj.getX() + (paddle_obj.getWidth() / 2) - (ball_obj.getWidth() / 2) + 50);
        ball_obj.setY(paddle_obj.getY() - ball_obj.getHeight() - 1);
        BaseClass.ShowPlayerNameOnScreen(player_obj.getPlayerName());
        BaseClass.check_Escape(ArkanoidMain.Arkanoid_scene, arkanoid_stage, Menu.sceneButtons);
        icon.DrawHeart();
        ArkanoidMain.root.getChildren().addAll(ball_obj.getBall_iv(), paddle_obj.getPaddle_iv());

        StartMovement(ArkanoidMain.Arkanoid_scene);
    }

    private void StartMovement(Scene scene_1) {

        scene_1.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER && clickOnlyOnce == false) {
                    GameMovement(true);
                    clickOnlyOnce = true;
                    ArkanoidMain.root.getChildren().remove(pressToStart);
                }

            }
        });

    }

    private void GameMovement(boolean play_Animation) {
        AnimationTimer at;
        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (goLeft && paddle_obj.getX() > 0 && !BallDoesnotMove) {
                    paddle_obj.setX(paddle_obj.getX() - paddle_obj.getSpeed());
                }
                if (goRight && paddle_obj.getX() < ArkanoidMain.Arkanoid_scene.getWidth() - paddle_obj.getWidth() * 2
                        && !BallDoesnotMove) {
                    paddle_obj.setX(paddle_obj.getX() + paddle_obj.getSpeed());
                }
                powerup.checkexpand(paddle_obj);
                powerup.checkshrink(paddle_obj);
                powerup.checkempty(paddle_obj);
                powerup.checkFast(paddle_obj, ball_obj);
                powerup.checkSlow(paddle_obj, ball_obj);
                powerup.checkExtra100(paddle_obj, score);
                powerup.checkExtra50(paddle_obj, score);
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

    private void checkBlocks() {
        for (ImageView b : map.bricks_arraylist) {
            boolean ball_down_block = ball_obj.getX() <= b.getX() + 150 && ball_obj.getX() >= b.getX() - ball_obj.getWidth() && ball_obj.getY() <= b.getY() + 50 + 3 && ball_obj.getY() >= b.getY() + 50 - 3;
            boolean ball_above_block = ball_obj.getX() <= b.getX() + 150 && ball_obj.getX() >= b.getX() - ball_obj.getWidth() && ball_obj.getY() <= b.getY() - ball_obj.getHeight() + 3 && ball_obj.getY() >= b.getY() - ball_obj.getHeight() - 3;
            boolean ball_left_block = ball_obj.getY() <= b.getY() + 50 && ball_obj.getY() >= b.getY() - ball_obj.getHeight() && ball_obj.getX() <= b.getX() - ball_obj.getWidth() + 3 && ball_obj.getX() >= b.getX() - ball_obj.getWidth() - 3;
            boolean blockRight = ball_obj.getY() <= b.getY() + 50 && ball_obj.getY() >= b.getY() - ball_obj.getHeight() && ball_obj.getX() <= b.getX() + 150 + 3 && ball_obj.getX() >= b.getX() + 150 - 3;

            //==========================
            if (ball_down_block) {
                if (!b.isDisabled()) {
                    if (!checkdouble(b)) {
                        icon.check_number(b);
                        b.setImage(null);
                        b.setDisable(true);
                        ArkanoidMain.root.getChildren().remove(b);
                        if (checkWin()) {
                            if (!BallDoesnotMove) {
                                finish(true);
                                BallDoesnotMove = true;
                            }
                        }
                    }
                    Sound.playsound(); //Sounds
                    ball_obj.setStepY(1);
                    score.SetScore(1);
                }

            } else if (ball_above_block) {

                if (!b.isDisable()) {
                    if (!checkdouble(b)) {
                        icon.check_number(b);
                        b.setImage(null);
                        b.setDisable(true);
                        ArkanoidMain.root.getChildren().remove(b);
                        if (checkWin()) {
                            if (!BallDoesnotMove) {
                                finish(true);
                                BallDoesnotMove = true;
                            }
                        }
                    }
                    Sound.playsound(); //Sounds
                    ball_obj.setStepY(-1);
                    score.SetScore(1);

                }

            } else if (ball_left_block) {
                if (!b.isDisable()) {
                    if (!checkdouble(b)) {
                        icon.check_number(b);
                        b.setImage(null);
                        b.setDisable(true);
                        ArkanoidMain.root.getChildren().remove(b);
                        if (checkWin()) {
                            if (!BallDoesnotMove) {
                                finish(true);
                                BallDoesnotMove = true;
                            }
                        }
                    }
                    Sound.playsound(); //Sounds
                    ball_obj.setStepX(-1);
                    score.SetScore(1);

                }

            } else if (blockRight) {

                if (!b.isDisable()) {
                    if (!checkdouble(b)) {
                        icon.check_number(b);
                        b.setImage(null);
                        b.setDisable(true);
                        ArkanoidMain.root.getChildren().remove(b);
                        if (checkWin()) {
                            if (!BallDoesnotMove) {
                                finish(true);
                                BallDoesnotMove = true;
                            }
                        }
                    }
                    Sound.playsound(); //Sounds
                    ball_obj.setStepX(1);
                    score.SetScore(1);

                }

            }

        }

    }

    private boolean checkdouble(ImageView brick) {
        switch (brick.getId()) {
            case "21":
                brick.setImage(map.getBroken_double_brick1());
                brick.setId("1");
                return true;
            case "22":
                brick.setImage(map.getBroken_double_brick2());
                brick.setId("1");
                return true;
            case "23":
                brick.setImage(map.getBroken_double_brick3());
                brick.setId("1");
                return true;
            case "24":
                brick.setImage(map.getBroken_double_brick4());
                brick.setId("1");
                return true;
        }
        return false;
    }

    private boolean checkWin() {
        for (ImageView b : map.bricks_arraylist) {
            if (!b.isDisable()) {
                return false;
            }
        }
        Sound.mediaPlayer_background.pause();
        Sound.mediaPlayer_win.play();
        return true;

    }

    private void checkBorders() {

        boolean atRightBorder = ball_obj.getX() >= (ArkanoidMain.Arkanoid_scene.getWidth() - ball_obj.getWidth());
        boolean atLeftBorder = ball_obj.getX() <= 0;
        boolean atTopBorder = ball_obj.getY() <= (ball_obj.getWidth()) / 2;
        boolean atBottomBorder = ball_obj.getY() >= (ArkanoidMain.Arkanoid_scene.getHeight() - ball_obj.getWidth());

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
                Sound.mediaPlayer_ball_out.play();
                Sound.mediaPlayer_background.pause();

            }
        }

    }

    private void finish(boolean win) {

        Stage finishStage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene_finish = new Scene(root, 400, 100);

        HBox Label = new HBox(15);
        Label.setAlignment(Pos.BOTTOM_CENTER);
        HBox bBox = new HBox(20);

        String labels;
        Button nextlevel = new Button("next level");

        if (win) {
            labels = "You Win";
            bBox.getChildren().addAll(nextlevel);

        } else {
            labels = "Game Over";
            try {
                score.WriteScoreInFile();
            } catch (IOException ex) {
                Logger.getLogger(Movement.class.getName()).log(Level.SEVERE, null, ex);
            }
            Sound.mediaPlayer_ball_out.play();
        }

        nextlevel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    start();
                    finishStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(Movement.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );
        Button close = new Button("Close");
        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    score.WriteScoreInFile();
                } catch (IOException ex) {
                    Logger.getLogger(Movement.class.getName()).log(Level.SEVERE, null, ex);
                }
                Platform.exit();

            }
        }
        );

        Label label = new Label(labels);
        final double MAX_FONT_SIZE = 30.0; // define max font size you need
        label.setFont(new Font(MAX_FONT_SIZE)); // set to Label
        Label.getChildren().add(label);
        root.setCenter(Label);

        String restartText;
        if (win) {
            restartText = "Next Level";
        }

        arkanoid_stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
            }
        });

        bBox.getChildren().addAll(close);
        root.setBottom(bBox);
        finishStage.setScene(scene_finish);
        finishStage.show();

    }

    private void dragUsingKeyboard(Scene scene1) {
        ArkanoidMain.Arkanoid_scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
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
        ArkanoidMain.Arkanoid_scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
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

    private void checkPaddle() {

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

    private void PressEnterToStart() {
        pressToStart.setX(ArkanoidMain.Arkanoid_scene.getWidth() / 2 - 250);
        pressToStart.setY(ArkanoidMain.Arkanoid_scene.getHeight() / 2 + 150);
        pressToStart.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 50));
        pressToStart.setFill(Color.DEEPSKYBLUE);// setting colour of the text to blue   
        pressToStart.setText("Press \" Enter \" to Start");
        ArkanoidMain.root.getChildren().add(pressToStart);
    }
}
