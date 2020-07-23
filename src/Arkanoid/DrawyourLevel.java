package Arkanoid;

import GameLoop.BaseClass;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class DrawyourLevel {

    private final Set<KeyCode> pressedKeys = new HashSet<>();  //To Make Combinations of events 
    private ArrayList<ImageView> Bricks_array = new ArrayList<>();

    paddle paddle = new paddle();
    ball ball = new ball();
    Scene scene_drawLevel;
    Pane pane_drawLevel;
    Button undo_btn = new Button();
    Button delete_btn = new Button();
    private Text pressToStart = new Text();
    private Text finish_txt = new Text();
    Image b1_, b2_, b3_, b4_, b5_, b6_, b7_, b8_, b9_, b10_, _b1, _b2, _b3, _b4, _b5, _b6;
    Image cursor_img = new Image("Resources/Arkanoid/yellowCursor2.png", 200, 150, false, false);
    Image cursor_img_hand = new Image("Resources/Arkanoid/hoverCursor2.png", 200, 150, false, false);
    ImageView b_iv1, b_iv2, b_iv3, b_iv4, b_iv5, b_iv6, b_iv7, b_iv8, b_iv9, b_iv10, _b_iv1, _b_iv2, _b_iv3, _b_iv4, _b_iv5, _b_iv6;
    ImageView b_draw_iv;

    private boolean clickOnlyOnce = false;
    private boolean goLeft = false;
    private boolean goRight = false;
    private boolean BallDoesnotMove = false;
    private boolean baBallDoesnotMove = false;
    int width_Drawlevel_scene = 1370;
    int height_Drawlevel_scene = 750;
    private int x_mouse_pos, y_mouse_pos;

    DrawyourLevel(Stage stage) {
        pane_drawLevel = new Pane();
        scene_drawLevel = new Scene(pane_drawLevel, width_Drawlevel_scene, height_Drawlevel_scene);

        DrawRightSide();
        IntializeSet();
        IntializeDrawLevel();
        Action();
        StartMovement();

        BaseClass.check_Escape(scene_drawLevel, stage, AR_Menu.sceneButtons);
        scene_drawLevel.setCursor(new ImageCursor(cursor_img));
        stage.setTitle("Arkanoid - Your Level");
        stage.setScene(scene_drawLevel);

    }

    private void DrawRightSide() {
        //================ ( Background ) ==========
        Image drawLevelBackr_img = new Image("Resources/Arkanoid/ca.png", 420, 750, false, true);
        ImageView drawLevelBackr_iv = new ImageView(drawLevelBackr_img);
        drawLevelBackr_iv.setX(950);
        drawLevelBackr_iv.setY(0);
        pane_drawLevel.getChildren().add(drawLevelBackr_iv);

        Image drawLevelBackl_img = new Image("Resources/Arkanoid/right_back.jpg", 950, 750, false, true);
        ImageView drawLevelBackl_iv = new ImageView(drawLevelBackl_img);
        drawLevelBackl_iv.setX(0);
        drawLevelBackl_iv.setY(0);
        pane_drawLevel.getChildren().add(drawLevelBackl_iv);
        //==========================================  
        //              ( Button Undo )

        Image undo_img = new Image("Resources/Arkanoid/backbtn.jpg", 60, 40, false, false);
        ImageView undo_iv = new ImageView(undo_img);
        undo_btn = new Button("", undo_iv);
        undo_btn.setLayoutX(1050);
        undo_btn.setLayoutY(660);
        undo_btn.setCursor(new ImageCursor(cursor_img_hand));
        undo_btn.setOnAction(e -> {
            if (Bricks_array.size() != 0) {
                pane_drawLevel.getChildren().remove(Bricks_array.get(Bricks_array.size() - 1));
                Bricks_array.remove(Bricks_array.get(Bricks_array.size() - 1));
            }
        });
        pane_drawLevel.getChildren().add(undo_btn);
        //             (Button Delete All)
        Image delete_img = new Image("Resources/Arkanoid/delete_o.jpg", 60, 40, false, false);
        ImageView delete_iv = new ImageView(delete_img);
        delete_btn = new Button(null, delete_iv);
        delete_btn.setLayoutX(1200);
        delete_btn.setLayoutY(660);
        delete_btn.setCursor(new ImageCursor(cursor_img_hand));
        delete_btn.setOnAction(e -> {
            for (int i = 0; i < Bricks_array.size(); i++) {
                pane_drawLevel.getChildren().remove(Bricks_array.get(i));
            }
            Bricks_array.clear();
        });
        pane_drawLevel.getChildren().add(delete_btn);
        //==========================================
        int x_b = 1000;
        int y_b = 300;
        ArrayList<ImageView> list_ivs = new ArrayList<>();
        b1_ = new Image("Resources/Arkanoid/bricks/normal brick1.png", 60, 20, false, false);
        b2_ = new Image("Resources/Arkanoid/bricks/normal brick2.png", 60, 20, false, false);
        b3_ = new Image("Resources/Arkanoid/bricks/normal brick3.png", 60, 20, false, false);
        b4_ = new Image("Resources/Arkanoid/bricks/normal brick4.png", 60, 20, false, false);
        b5_ = new Image("Resources/Arkanoid/bricks/normal brick5.png", 60, 20, false, false);
        b6_ = new Image("Resources/Arkanoid/bricks/normal brick6.png", 60, 20, false, false);
        b7_ = new Image("Resources/Arkanoid/bricks/normal brick7.png", 60, 20, false, false);
        b8_ = new Image("Resources/Arkanoid/bricks/normal brick8.png", 60, 20, false, false);
        b9_ = new Image("Resources/Arkanoid/bricks/normal brick9.png", 60, 20, false, false);
        b10_ = new Image("Resources/Arkanoid/bricks/normal brick10.png", 60, 20, false, false);
        _b1 = new Image("Resources/Arkanoid/bricks/small brick1.png", 40, 40, false, false);
        _b2 = new Image("Resources/Arkanoid/bricks/small brick2.png", 40, 40, false, false);
        _b3 = new Image("Resources/Arkanoid/bricks/small brick8.png", 40, 40, false, false);
        _b4 = new Image("Resources/Arkanoid/bricks/small brick13.png", 40, 40, false, false);
        _b5 = new Image("Resources/Arkanoid/bricks/small brick5.png", 40, 40, false, false);
        _b6 = new Image("Resources/Arkanoid/bricks/small brick14.png", 40, 40, false, false);

        b_iv1 = new ImageView(b1_);
        list_ivs.add(b_iv1);
        b_iv2 = new ImageView(b2_);
        list_ivs.add(b_iv2);
        b_iv3 = new ImageView(b3_);
        list_ivs.add(b_iv3);
        b_iv4 = new ImageView(b4_);
        list_ivs.add(b_iv4);
        b_iv5 = new ImageView(b5_);
        list_ivs.add(b_iv5);
        b_iv6 = new ImageView(b6_);
        list_ivs.add(b_iv6);
        b_iv7 = new ImageView(b7_);
        list_ivs.add(b_iv7);
        b_iv8 = new ImageView(b8_);
        list_ivs.add(b_iv8);
        b_iv9 = new ImageView(b9_);
        list_ivs.add(b_iv9);
        b_iv10 = new ImageView(b10_);
        list_ivs.add(b_iv10);
        _b_iv1 = new ImageView(_b1);
        list_ivs.add(_b_iv1);
        _b_iv2 = new ImageView(_b2);
        list_ivs.add(_b_iv2);
        _b_iv3 = new ImageView(_b3);
        list_ivs.add(_b_iv3);
        _b_iv4 = new ImageView(_b4);
        list_ivs.add(_b_iv4);
        _b_iv5 = new ImageView(_b5);
        list_ivs.add(_b_iv5);
        _b_iv6 = new ImageView(_b6);
        list_ivs.add(_b_iv6);

    }

    private void Action() {

        scene_drawLevel.setOnMousePressed(e -> {
            AR_Sound.mediaPlayer_clickMouse.stop();
            AR_Sound.mediaPlayer_clickMouse.play();
            int a = x_mouse_pos = (int) e.getX();
            int b = y_mouse_pos = (int) e.getY();

            if (a >= 0 && a <= 850 && b >= 0 && b <= 500) {
                if (pressedKeys.contains(KeyCode.DIGIT1)) {
                    Bricks_array.add(new ImageView(b1_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT2)) {
                    Bricks_array.add(new ImageView(b2_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT3)) {
                    Bricks_array.add(new ImageView(b3_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT4)) {
                    Bricks_array.add(new ImageView(b4_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT5)) {
                    Bricks_array.add(new ImageView(b5_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT6)) {
                    Bricks_array.add(new ImageView(b6_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT7)) {
                    Bricks_array.add(new ImageView(b7_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT8)) {
                    Bricks_array.add(new ImageView(b8_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT9)) {
                    Bricks_array.add(new ImageView(b9_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.DIGIT0)) {
                    Bricks_array.add(new ImageView(b10_));
                    adjust_size_and_pos_brick(a, b, true);
                } else if (pressedKeys.contains(KeyCode.A)) {
                    Bricks_array.add(new ImageView(_b1));
                    adjust_size_and_pos_brick(a, b, false);
                } else if (pressedKeys.contains(KeyCode.B)) {
                    Bricks_array.add(new ImageView(_b2));
                    adjust_size_and_pos_brick(a, b, false);
                } else if (pressedKeys.contains(KeyCode.C)) {
                    Bricks_array.add(new ImageView(_b3));
                    adjust_size_and_pos_brick(a, b, false);
                } else if (pressedKeys.contains(KeyCode.D)) {
                    Bricks_array.add(new ImageView(_b4));
                    adjust_size_and_pos_brick(a, b, false);
                } else if (pressedKeys.contains(KeyCode.E)) {
                    Bricks_array.add(new ImageView(_b5));
                    adjust_size_and_pos_brick(a, b, false);
                } else if (pressedKeys.contains(KeyCode.F)) {
                    Bricks_array.add(new ImageView(_b6));
                    adjust_size_and_pos_brick(a, b, false);
                }
            }

        });
    }

    private void IntializeSet() {
        scene_drawLevel.setOnKeyPressed(e -> pressedKeys.add(e.getCode()));
        scene_drawLevel.setOnKeyReleased(e -> pressedKeys.remove(e.getCode()));
    }

    public void adjust_size_and_pos_brick(int a, int b, boolean check) {
        if (check) {
            Bricks_array.get(Bricks_array.size() - 1).setFitWidth(100);
            Bricks_array.get(Bricks_array.size() - 1).setFitHeight(35);
        } else {
            Bricks_array.get(Bricks_array.size() - 1).setFitWidth(60);
            Bricks_array.get(Bricks_array.size() - 1).setFitHeight(60);
        }
        Bricks_array.get(Bricks_array.size() - 1).setX(a);
        Bricks_array.get(Bricks_array.size() - 1).setY(b);
        pane_drawLevel.getChildren().add(Bricks_array.get(Bricks_array.size() - 1));
    }

    private void IntializeDrawLevel() {
        //================================================
        //              ( Paddle ) 
        paddle.setX((scene_drawLevel.getWidth() / 2) - paddle.getWidth() - 160);
        paddle.setY((scene_drawLevel.getHeight() - paddle.getWidth()) + 20);
        pane_drawLevel.getChildren().add(paddle.getPaddle_iv());
        paddle.Animation_Paddle(true);
        //==========================================================
        //              ( Ball )
        ball.setBall_iv(new ImageView(new Image("Resources/Arkanoid/acid ball.png", 30, 30, false, false)));
        ball.setX(paddle.getX() + (paddle.getWidth() / 2) - (paddle.getWidth() / 2) + 50);
        ball.setY(paddle.getY() - ball.getHeight() - 1);
        pane_drawLevel.getChildren().add(ball.getBall_iv());

    }

    private void StartMovement() {
        System.out.println("Yes");
        scene_drawLevel.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER && clickOnlyOnce == false) {
                    AR_Sound.mediaPlayer_background.play();
                    GameMovement(true);
                    clickOnlyOnce = true;
                    pane_drawLevel.getChildren().remove(pressToStart);
                }

            }
        });
        scene_drawLevel.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER) {
                    GameMovement(false);
                }

            }

        });

    }

    public void GameMovement(boolean play_Animation) {

        AnimationTimer at;
        at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (goLeft && paddle.getX() > 0 && !BallDoesnotMove) {
                    paddle.setX(paddle.getX() - paddle.getSpeed());
                }
                if (goRight && paddle.getX() < 950 - paddle.getWidth() * 2 && !BallDoesnotMove) {
                    paddle.setX(paddle.getX() + paddle.getSpeed());
                }

                checkBorders();
                BaseClass.checkPaddle(ball, paddle, goLeft, goRight);
                checkBlocks();
                BaseClass.checkPause(scene_drawLevel, ball, paddle, null, pane_drawLevel);

                dragUsingKeyboard();

                paddle.Animation_Paddle(true);

                if (!BallDoesnotMove) {
                    ball.setX(ball.getX() + ball.getStepX() * ball.getSpeed());
                    ball.setY(ball.getY() + ball.getStepY() * ball.getSpeed());
                }

            }
        };
        if (play_Animation == true) {
            at.start();
        } else {
            at.stop();
        }
    }

    //==================================== Drag Using Keyboard
    private void dragUsingKeyboard() {
        scene_drawLevel.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
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
        scene_drawLevel.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
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

    //===================================== Check Borders
    public void checkBorders() {

        boolean atRightBorder = ball.getX() >= (950 - ball.getWidth());
        boolean atLeftBorder = ball.getX() <= 0;
        boolean atTopBorder = ball.getY() <= (ball.getWidth()) / 2;
        boolean atBottomBorder = ball.getY() >= (scene_drawLevel.getHeight() - ball.getWidth());

        //Here we change the Direction of the Ball 
        if (atRightBorder) {
            ball.setStepX(-1);
        }

        if (atLeftBorder) {
            ball.setStepX(1);
        }

        if (atTopBorder) {
            ball.setStepY(1); //ball_obj.getStepY()*-1
        }
        if (atBottomBorder) {
            ball.setStepX(0);
            ball.setStepY(0);
            if (!BallDoesnotMove) {
                finish(false);
                BallDoesnotMove = true;

                AR_Sound.mediaPlayer_ball_out.play();
                AR_Sound.mediaPlayer_background.pause();

                goRight = false;
                goLeft = false;

            }
        }

    }

    private void finish(boolean win) {

        finish_txt.setX(scene_drawLevel.getWidth() / 2 - 280);
        finish_txt.setY(scene_drawLevel.getHeight() / 2);
        finish_txt.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 80));
        finish_txt.setFill(Color.CORAL);// setting colour of the text to blue   
        if (win) {
            finish_txt.setText("YOU WIN");
            AR_Sound.mediaPlayer_win.play();
        } else {
            finish_txt.setText("GAME OVER");
            AR_Sound.mediaPlayer_ball_out.play();
        }
        pane_drawLevel.getChildren().add(finish_txt);
    }

    public void checkBlocks() {
        for (ImageView b : Bricks_array) {

            //Here We determine If the ball is under or above or on left or on rigth of the block
            boolean ball_down_block = ball.getX() <= b.getX() + b.getFitWidth() && ball.getX() >= b.getX() - ball.getWidth() && ball.getY() <= b.getY() + b.getFitHeight() + 3 && ball.getY() >= b.getY() + b.getFitHeight() - 3;
            boolean ball_above_block = ball.getX() <= b.getX() + b.getFitWidth() && ball.getX() >= b.getX() - ball.getWidth() && ball.getY() <= b.getY() - ball.getHeight() + 3 && ball.getY() >= b.getY() - ball.getHeight() - 3;
            boolean ball_left_block = ball.getY() <= b.getY() + b.getFitHeight() && ball.getY() >= b.getY() - ball.getHeight() && ball.getX() <= b.getX() - ball.getWidth() + 3 && ball.getX() >= b.getX() - ball.getWidth() - 3;
            boolean blockRight = ball.getY() <= b.getY() + b.getFitHeight() && ball.getY() >= b.getY() - ball.getHeight() && ball.getX() <= b.getX() + b.getFitWidth() + 3 && ball.getX() >= b.getX() + b.getFitWidth() - 3;

            //==========================
            if (ball_down_block) {
                AR_Sound.playsound(); //Sounds
                pane_drawLevel.getChildren().remove(b);
                Bricks_array.remove(b);
                ball.setStepY(1);

                if (checkWin()) {
                    if (!BallDoesnotMove) {
                        finish(true);
                        BallDoesnotMove = true;
                    }
                }

            } else if (ball_above_block) {
                AR_Sound.playsound();
                pane_drawLevel.getChildren().remove(b);
                Bricks_array.remove(b);
                ball.setStepY(-1);

                if (checkWin()) {
                    if (!BallDoesnotMove) {
                        finish(true);
                        BallDoesnotMove = true;
                    }
                }
            } else if (ball_left_block) {
                AR_Sound.playsound();

                pane_drawLevel.getChildren().remove(b);
                Bricks_array.remove(b);
                ball.setStepX(-1);
                if (checkWin()) {
                    if (!BallDoesnotMove) {
                        finish(true);
                        BallDoesnotMove = true;
                    }
                }

            } else if (blockRight) {

                AR_Sound.playsound();

                pane_drawLevel.getChildren().remove(b);
                Bricks_array.remove(b);
                ball.setStepX(1);
                if (checkWin()) {
                    if (!BallDoesnotMove) {
                        finish(true);
                        BallDoesnotMove = true;
                    }
                }

            }

        }

    }

    public boolean checkWin() {
        if (Bricks_array.size() == 0) {
            AR_Sound.mediaPlayer_background.pause();
            AR_Sound.mediaPlayer_win.play();
            return true;
        }
        return false;
    }
}
