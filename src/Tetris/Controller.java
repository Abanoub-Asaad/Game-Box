package Tetris;

import static Tetris.Tetris_Main.Tetris_scene;
import java.util.Arrays;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controller {

    ShapeFactory shapeFactory_obj = new ShapeFactory();

    Shape shape1_obj = shapeFactory_obj.getShape("Line_shape");
    Shape shape2_obj = shapeFactory_obj.getShape("Square_shape");
    Shape shape3_obj = shapeFactory_obj.getShape("L_shape");
    Shape shape4_obj = shapeFactory_obj.getShape("MirroredL_shape");
    Shape shape5_obj = shapeFactory_obj.getShape("S_shape");
    Shape shape6_obj = shapeFactory_obj.getShape("T_shape");
    Shape shape7_obj = shapeFactory_obj.getShape("Z_shape");

    // Getting the numbers and the MESH from Tetris_Main
    public static final int MOVE = Tetris_Main.MOVE;
    public static final int SIZE = Tetris_Main.SIZE;
    public static int XMAX = Tetris_Main.XMAX;
    public static int YMAX = Tetris_Main.YMAX;
    public static int[][] MESH = Tetris_Main.MESH;

    private static Text scoretext = new Text("Score: ");
    private static Text numOfLines = new Text("Lines: ");

    public static void MoveRight(Form form) {
        if (form.a.getX() + MOVE <= XMAX - SIZE && form.b.getX() + MOVE <= XMAX - SIZE
                && form.c.getX() + MOVE <= XMAX - SIZE && form.d.getX() + MOVE <= XMAX - SIZE) {
            int movea = MESH[((int) form.a.getX() / SIZE) + 1][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX() / SIZE) + 1][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX() / SIZE) + 1][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX() / SIZE) + 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() + MOVE);
                form.b.setX(form.b.getX() + MOVE);
                form.c.setX(form.c.getX() + MOVE);
                form.d.setX(form.d.getX() + MOVE);
            }
        }
    }

    public static void MoveLeft(Form form) {
        if (form.a.getX() - MOVE >= 0 && form.b.getX() - MOVE >= 0 && form.c.getX() - MOVE >= 0
                && form.d.getX() - MOVE >= 0) {
            int movea = MESH[((int) form.a.getX() / SIZE) - 1][((int) form.a.getY() / SIZE)];
            int moveb = MESH[((int) form.b.getX() / SIZE) - 1][((int) form.b.getY() / SIZE)];
            int movec = MESH[((int) form.c.getX() / SIZE) - 1][((int) form.c.getY() / SIZE)];
            int moved = MESH[((int) form.d.getX() / SIZE) - 1][((int) form.d.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.a.setX(form.a.getX() - MOVE);
                form.b.setX(form.b.getX() - MOVE);
                form.c.setX(form.c.getX() - MOVE);
                form.d.setX(form.d.getX() - MOVE);
            }
        }
    }

    public Form makeRect() {
        int block = (int) (Math.random() * 100);
        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1), b = new Rectangle(SIZE - 1, SIZE - 1), c = new Rectangle(SIZE - 1, SIZE - 1),
                d = new Rectangle(SIZE - 1, SIZE - 1);
        if (block < 15) {
            shape4_obj.setShape(a, b, c, d);
            name = "l";
        } else if (block < 30) {
            shape3_obj.setShape(a, b, c, d);
            name = "j";
        } else if (block < 45) {

            shape2_obj.setShape(a, b, c, d);
            name = "o";
        } else if (block < 60) {

            shape5_obj.setShape(a, b, c, d);
            name = "s";
        } else if (block < 75) {
            shape6_obj.setShape(a, b, c, d);
            name = "t";
        } else if (block < 90) {
            shape7_obj.setShape(a, b, c, d);
            name = "z";
        } else {
            shape1_obj.setShape(a, b, c, d);
            name = "i";
        }
        return new Form(a, b, c, d, name);
    }

    protected void setNextShapeInSquare() {

    }

    protected boolean moveA(Form form) {
        return (MESH[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
    }

    protected boolean moveB(Form form) {
        return (MESH[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
    }

    protected boolean moveC(Form form) {
        return (MESH[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
    }

    protected boolean moveD(Form form) {
        return (MESH[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
    }

    /**
     * Initialize the 2D array that called "Mesh" with zeroes
     */
    protected static void intialize_2D_array() {
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
    }

    /**
     * design line as a separator design score_text and number of lines
     *
     * @param group
     */
    protected static void design_score_and_lines(Pane group) {
        Tetris_scene.getStylesheets().add(Controller.class.getResource("cs.css").toExternalForm());
        Line sperator_line = new Line(XMAX, 0, XMAX, YMAX);
        Reflection reflection = new Reflection();
        reflection.setFraction(1);

        scoretext.setId("st");
        scoretext.setEffect(reflection);
        scoretext.setStroke(Color.IVORY);
        scoretext.setY(400);
        scoretext.setX(XMAX + 50);

        //numOfLines.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
        numOfLines.setId("st");
        numOfLines.setEffect(reflection);
        numOfLines.setY(570);
        numOfLines.setX(XMAX + 50);
        numOfLines.setStroke(Color.IVORY);
        group.getChildren().addAll(scoretext, sperator_line, numOfLines);
    }

    protected static void setScore(int score) {
        scoretext.setText("Score: " + Integer.toString(score));
    }

    protected static void set_numOfLines(int linesNo) {
        numOfLines.setText("Lines:  " + Integer.toString(linesNo));
    }

    protected void start_MoveTurn(Form form) {
        int f = form.form;
        Rectangle a = form.a;
        Rectangle b = form.b;
        Rectangle c = form.c;
        Rectangle d = form.d;
        switch (form.getName()) {
            case "j":
                shape3_obj.MoveTurn(form, f, a, b, c, d);
                break;
            case "l":
                shape4_obj.MoveTurn(form, f, a, b, c, d);
                break;
            case "o":
                break;
            case "s":
                shape5_obj.MoveTurn(form, f, a, b, c, d);
                break;
            case "t":
                shape6_obj.MoveTurn(form, f, a, b, c, d);
                break;
            case "z":
                shape7_obj.MoveTurn(form, f, a, b, c, d);
                break;
            case "i":
                shape1_obj.MoveTurn(form, f, a, b, c, d);
                break;
        }
    }

    protected static void setGameOver() {
        Image gameOver = new Image("Resources/Tetris/Game Over.png", 500, 150, false, false);
        ImageView gameOverIv = new ImageView(gameOver);
        gameOverIv.setX(435);
        gameOverIv.setY(200);
        Tetris_Main.tetris_pane.getChildren().add(gameOverIv);

    }

    protected void setShapeInSquare(String name) {
        if (name == "i") {
            shape1_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        } else if (name == "o") {
            shape2_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        } else if (name == "j") {
            shape3_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        } else if (name == "l") {
            shape4_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        } else if (name == "s") {
            shape5_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        } else if (name == "t") {
            shape6_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        } else if (name == "z") {
            shape7_obj.Basic(Tetris_Main.Next, Tetris_Main.tetris_pane);
        }

    }

    protected void RemoveNextShape(Rectangle[] rectangles, Pane group) {
        for (int i = 0; i < 4; i++) {
            group.getChildren().remove(rectangles[i]);
        }
    }
}
