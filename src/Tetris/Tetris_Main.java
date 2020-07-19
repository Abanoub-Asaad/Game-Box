package Tetris;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Tetris_Main {

    private static Image tetris_back_img = new Image("Resources/Tetris/back.png", 1400, 800, false, false);
    protected static ImageView tetris_back_iv = new ImageView(tetris_back_img);

    private Stage Tetris_stage = new Stage();
    public static final int MOVE = 50;
    public static final int SIZE = 50;
    public static int XMAX = SIZE * 18;
    public static int YMAX = SIZE * 15;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    protected static Pane tetris_pane = new Pane();
    private static Form shape_object;
    protected static Scene Tetris_scene = new Scene(tetris_pane, 1400, 800);
    public static int score = 0;
    private static int top = 0;
    private static boolean game = true;
    private Controller controller_obj = new Controller();
    private Form nextObj = controller_obj.makeRect();
    protected static int linesNo = 0;

    protected static Rectangle[] Next = new Rectangle[4];

    //=========================================================
    /*
    ** For Singleton Pattern 
    */
    private static Tetris_Main tetrisInstance;

    public static Tetris_Main getInstanceFromTetris() {
        if (tetrisInstance == null) {
            tetrisInstance = new Tetris_Main();
        }

        return tetrisInstance;
    }

    private Tetris_Main() {

    }
    //======================================================
    
    public void start_Tetris(Stage games_stage) {

        
        
        tetris_pane.getChildren().add(tetris_back_iv);
        Controller.intialize_2D_array();
        Controller.design_score_and_lines(tetris_pane);

        Form a = nextObj;
        tetris_pane.getChildren().addAll(a.a, a.b, a.c, a.d);
        moveOnKeyPress(a);
        shape_object = a;

        nextObj = controller_obj.makeRect();

        Tetris_stage = games_stage;
        Tetris_stage.setScene(Tetris_scene);
        Tetris_stage.setTitle("GameBox - TETRIS");
//        Tetris_stage.setMaximized(true);
//        Tetris_stage.setResizable(false);
//        Tetris_stage.show();

        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {

                Platform.runLater(new Runnable() {

                    public void run() {
                        if (shape_object.a.getY() == 0 || shape_object.b.getY() == 0 || shape_object.c.getY() == 0
                                || shape_object.d.getY() == 0) {
                            top++;
                        } else {
                            top = 0;
                        }

                        if (top == 2) {
                            // GAME OVER
                            Controller.setGameOver();
                            game = false;
                            fall.cancel();
                        }

                        if (game) {

                            controller_obj.RemoveNextShape(Next, tetris_pane);
                            controller_obj.setShapeInSquare(nextObj.name);
                            MoveDown(shape_object);
                            Controller.setScore(score);
                            Controller.set_numOfLines(linesNo);
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);
    }

    private void moveOnKeyPress(Form form) {
        Tetris_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        Controller.MoveRight(form);
                        break;
                    case DOWN:
                        MoveDown(form);
                        score++;
                        break;
                    case LEFT:
                        Controller.MoveLeft(form);
                        break;
                    case UP:
                        controller_obj.start_MoveTurn(form);
                        break;
                }
            }
        });
    }

    private void MoveDown(Form form) {

        if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
                || form.d.getY() == YMAX - SIZE || controller_obj.moveA(form) || controller_obj.moveB(form)
                || controller_obj.moveC(form) || controller_obj.moveD(form)) {
            MESH[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
            MESH[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
            MESH[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
            MESH[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
            Clear.RemoveRows(tetris_pane);

            Form a = nextObj;
            nextObj = controller_obj.makeRect();
            System.out.println(nextObj.name);

            shape_object = a;

            tetris_pane.getChildren().addAll(a.a, a.b, a.c, a.d);
            moveOnKeyPress(a);
        }

        if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
                && form.d.getY() + MOVE < YMAX) {
            int movea = MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
            int moveb = MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
            int movec = MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
            int moved = MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setY(form.a.getY() + MOVE);
                form.b.setY(form.b.getY() + MOVE);
                form.c.setY(form.c.getY() + MOVE);
                form.d.setY(form.d.getY() + MOVE);
            }
        }
    }

}
