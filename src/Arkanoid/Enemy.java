package Arkanoid;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Enemy {

    Timeline timeline;
    private boolean clickOnlyOnce = false, goRight = false, goLeft = false, Play_Animation = false;
    boolean BallDoesnotMove = false;

    private Text finish_txt = new Text();

    Scene Enemy_scene;
    Pane Enemy_pane;
    Timeline Enemy_timeLine = new Timeline();
    int Enemy_scene_width = 1370;
    int Enemy_scene_height = 750;
    Image enemy_img1 = new Image("Resources/Arkanoid/enemy/1.png", 200, 150, false, false);
    Image enemy_img2 = new Image("Resources/Arkanoid/enemy/2.png", 200, 150, false, false);
    Image enemy_img3 = new Image("Resources/Arkanoid/enemy/3.png", 200, 150, false, false);
    Image enemy_img4 = new Image("Resources/Arkanoid/enemy/4.png", 200, 150, false, false);
    Image enemy_img5 = new Image("Resources/Arkanoid/enemy/5.png", 200, 150, false, false);
    Image enemy_img6 = new Image("Resources/Arkanoid/enemy/6.png", 200, 150, false, false);
    int enemy_mov = 5, y_increase = 5;
    Image fire = new Image("Resources/Arkanoid/ball_2.png");
    ImageView fire_iv1 = new ImageView(fire);
    ImageView fire_iv2 = new ImageView(fire);
    ImageView fire_iv3 = new ImageView(fire);
    Paddle paddle_obj = new Paddle();
    Ball ball_obj = new Ball();
    ImageView enemy_iv = new ImageView(enemy_img1);
    Text pressToStart = new Text();
    double x = 0.0;
    double count = 20.0;
    final ProgressBar bar = new ProgressBar(1);

    Enemy() {

    }

    Enemy(Stage stage_main) {
        //================ (Intialilization)

        Enemy_pane = new Pane();
        Enemy_scene = new Scene(Enemy_pane, Enemy_scene_width, Enemy_scene_height);

        //================ ( Background ) ==========
        Image EnemyBack_img = new Image("Resources/Arkanoid/kj.jpg", 1400, 780, false, true);
        ImageView EnemyBack_iv = new ImageView(EnemyBack_img);
        Enemy_pane.getChildren().add(EnemyBack_iv);
        //==========================================
        //                  (Paddle)                
        paddle_obj.setX((Enemy_scene.getWidth() / 2) - paddle_obj.getWidth());
        paddle_obj.setY((Enemy_scene.getHeight() - paddle_obj.getWidth()) + 20);
        Enemy_pane.getChildren().add(paddle_obj.getPaddle_iv());
        paddle_obj.Animation_Paddle(true);
        //============================================
        //                    (ball)
        ball_obj.setX(paddle_obj.getX() + ((paddle_obj.getWidth() / 2) - ball_obj.getWidth() / 2));
        ball_obj.setY(paddle_obj.getY() - ball_obj.getHeight() - 1);
        ball_obj.setStepX(1);
        ball_obj.setStepY(-1);
        Enemy_pane.getChildren().add(ball_obj.getBall_iv());
        //======================================
        //      ( enemy)
        enemy_iv.setX((Enemy_scene.getWidth() / 2) - enemy_img1.getWidth());
        enemy_iv.setY(50);
        Enemy_pane.getChildren().addAll(enemy_iv);
        //==========================
        //     (bar)
        bar.setLayoutX((Enemy_scene.getWidth() / 2) - paddle_obj.getWidth());
        bar.setLayoutY(20);
        bar.setStyle("-fx-accent: red;");
        bar.setPrefWidth(150);
        bar.setPrefHeight(20);
        Enemy_pane.getChildren().addAll(bar);

        //==================
//        BaseClsas.check_Escape(Enemy_scene, Menu.stage_menu, Menu.sceneButtons);
        stage_main.setTitle("Arkanoid  -  Enemy");
        stage_main.setScene(Enemy_scene);
        PressEnterToStart();
        StartMovement(Enemy_scene);
    }

    public void drawEnemy() {

        fire_iv1.setY(160);
        fire_iv2.setY(160);
        fire_iv3.setY(160);
        fire_iv1.setX(enemy_iv.getX());
        fire_iv2.setX(enemy_iv.getX() + 50);
        fire_iv3.setX(enemy_iv.getX() + 100);
        timeline = new Timeline(
                new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        enemy_iv.setX(enemy_iv.getX() + enemy_mov);

                        fire_iv1.setX(enemy_iv.getX() - x);
                        fire_iv2.setX(enemy_iv.getX());
                        fire_iv3.setX(enemy_iv.getX() + x);
                        fire_iv1.setY(fire_iv1.getY() + y_increase);
                        fire_iv2.setY(fire_iv1.getY() + y_increase);
                        fire_iv3.setY(fire_iv1.getY() + y_increase);
                        x += 2.57;
                        check_fire(fire_iv1);
                        check_fire(fire_iv2);
                        check_fire(fire_iv3);

                        if (enemy_iv.getX() == Enemy_scene_width - 200 || enemy_iv.getX() == 50) {
                            enemy_mov *= -1;
                        }
                        if (fire_iv1.getY() == Enemy_scene_height) {
                            x = 0;
                            fire_iv1.setY(160);
                            fire_iv2.setY(160);
                            fire_iv3.setY(160);
                            fire_iv1.setX(enemy_iv.getX());
                            fire_iv2.setX(enemy_iv.getX() + 50);
                            fire_iv3.setX(enemy_iv.getX() + 100);
                        }

                    }
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Enemy_pane.getChildren().addAll(fire_iv1, fire_iv2, fire_iv3);

        KeyFrame enemy_f1 = new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {
                enemy_iv.setImage(enemy_img1);

            }
        });

        KeyFrame enemy_f2 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {

                enemy_iv.setImage(enemy_img2);

            }
        });

        KeyFrame enemy_f3 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {

                enemy_iv.setImage(enemy_img3);
            }
        });

        KeyFrame enemy_f4 = new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {

                enemy_iv.setImage(enemy_img4);
            }
        });

        KeyFrame enemy_f5 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {

                enemy_iv.setImage(enemy_img5);
            }
        });
        KeyFrame enemy_f6 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent t) {

                enemy_iv.setImage(enemy_img6);
            }
        });
        Enemy_timeLine.getKeyFrames().addAll(enemy_f1, enemy_f2, enemy_f3, enemy_f4, enemy_f5, enemy_f6);
        Enemy_timeLine.setCycleCount(Timeline.INDEFINITE);
        Enemy_timeLine.setAutoReverse(true);

        Enemy_timeLine.play();
    }

    private void check_fire(ImageView fire) {
        if (fire.getBoundsInParent().intersects(paddle_obj.getPaddle_iv().getBoundsInParent())) {
            finish(false);
        }
    }

    private void check_enemy(double enemy_x) {

        //Here We determine If the ball is under or above or on left or on rigth of the block
        boolean ball_down_Enemy = ball_obj.getX() <= enemy_x + enemy_img1.getWidth()
                && ball_obj.getX() >= enemy_x - ball_obj.getWidth()
                && ball_obj.getY() <= 50 + enemy_img1.getHeight() + 3
                && ball_obj.getY() >= 50 + enemy_img1.getHeight() - 3;
        boolean ball_left_Enemy = ball_obj.getY() <= 50 + enemy_img1.getHeight()
                && ball_obj.getY() >= 50 - ball_obj.getHeight()
                && ball_obj.getX() <= enemy_x - ball_obj.getWidth() + 3
                && ball_obj.getX() >= enemy_x - ball_obj.getWidth() - 3;
        boolean EnemyRight = ball_obj.getY() <= 50 + enemy_img1.getHeight()
                && ball_obj.getY() >= 50 - ball_obj.getHeight()
                && ball_obj.getX() <= enemy_x + enemy_img1.getWidth() + 3
                && ball_obj.getX() >= enemy_x + enemy_img1.getWidth() - 3;
        if (ball_down_Enemy) {
            ball_obj.setStepY(1);
            Sound.playsound();
            count--;
            bar.setProgress(count / 20);
            if (enemy_finish()) {
                finish(true);
            }

        }
        if (ball_left_Enemy) {
            Sound.playsound();

            ball_obj.setStepX(-1);
            count--;
            bar.setProgress(count / 20);

            if (enemy_finish()) {
                finish(true);
            }

        }
        if (EnemyRight) {

            Sound.playsound();
            count--;
            bar.setProgress(count / 20);
            if (enemy_finish()) {
                finish(true);
            }
            ball_obj.setStepX(1);

        }
    }

    public boolean enemy_finish() {
        if (count == 0.0) {
            return true;
        } else {
            return false;
        }
    }

    private void dragUsingKeyboard() {
        Enemy_scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
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
        Enemy_scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
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

    public static void checkPaddle(Ball ball_obj, Paddle paddle_obj, boolean goLeft, boolean goRight) {

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

    public void GameMovement(boolean play_Animation) {
        drawEnemy();
        AnimationTimer at;
        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (goLeft && paddle_obj.getX() > 0 && !BallDoesnotMove) {
                    paddle_obj.setX(paddle_obj.getX() - paddle_obj.getSpeed());
                }
                if (goRight && paddle_obj.getX() < Enemy_scene.getWidth() - paddle_obj.getWidth() * 2 && !BallDoesnotMove) {
                    paddle_obj.setX(paddle_obj.getX() + paddle_obj.getSpeed());
                }
                checkPaddle(ball_obj, paddle_obj, goLeft, goRight);
                checkBorders();
                dragUsingKeyboard();
                check_enemy(enemy_iv.getX());
                paddle_obj.Animation_Paddle(true);
                paddle_obj.dragPaddleUsingMouse(paddle_obj);

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

    public void StartMovement(Scene scene_1) {

        scene_1.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER && clickOnlyOnce == false) {
                    GameMovement(true);
                    clickOnlyOnce = true;
                    Enemy_pane.getChildren().remove(pressToStart);
                }

            }
        });

    }

    public void checkBorders() {

        boolean atRightBorder = ball_obj.getX() >= (Enemy_scene.getWidth() - ball_obj.getWidth());
        boolean atLeftBorder = ball_obj.getX() <= 0;
        boolean atTopBorder = ball_obj.getY() <= (ball_obj.getWidth()) / 2;
        boolean atBottomBorder = ball_obj.getY() >= (Enemy_scene.getHeight() - ball_obj.getWidth());

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

                Sound.mediaPlayer_ball_out.play();
                Sound.mediaPlayer_background.pause();

                goRight = false;
                goLeft = false;

            }
        }

    }

    public void PressEnterToStart() {
        pressToStart.setX(Enemy_scene.getWidth() / 2 - 250);
        pressToStart.setY(Enemy_scene.getHeight() / 2 + 150);
        pressToStart.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 50));
        pressToStart.setFill(Color.DEEPSKYBLUE);// setting colour of the text to blue   
        pressToStart.setText("Press \" Enter \" to Start");
        Enemy_pane.getChildren().add(pressToStart);
    }

    //============================= (Finish)
    private void finish(boolean win) {

        finish_txt.setX(Enemy_scene.getWidth() / 2 - 280);
        finish_txt.setY(Enemy_scene.getHeight() / 2);
        finish_txt.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 80));
        finish_txt.setFill(Color.CORAL);// setting colour of the text to blue   
        if (win) {
            finish_txt.setText("YOU WIN");
            Sound.mediaPlayer_win.play();
        } else {
            finish_txt.setText("GAME OVER");
            Sound.mediaPlayer_ball_out.play();
        }
        goLeft = false;
        goRight = false;
        timeline.stop();
        BallDoesnotMove = true;
        Enemy_pane.getChildren().add(finish_txt);

    }
}
