package Tetris;

import java.util.Arrays;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Controller extends Generator {

    private static ShapeFactory shapeFactory_obj = new ShapeFactory();
    
    private static Shape shape1_obj = shapeFactory_obj.getShape("Line_shape");
    private static Shape shape2_obj = shapeFactory_obj.getShape("Square_shape");
    private static Shape shape3_obj = shapeFactory_obj.getShape("L_shape");
    private static Shape shape4_obj = shapeFactory_obj.getShape("MirroredL_shape");
    private static Shape shape5_obj = shapeFactory_obj.getShape("S_shape");
    private static Shape shape6_obj = shapeFactory_obj.getShape("T_shape");
    private static Shape shape7_obj = shapeFactory_obj.getShape("Z_shape");

    private static float x = 400f;
    private static float y = 5f;

    public Controller() {

        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
    }

    private static int MOVE = Board.MoveValue;
    private static int XMAX = Board.XMAX;
    private static int YMAX = Board.YMAX;
    protected static int SIZE = Board.Size; //size of the one rectangle
    private static int MESH[][] = Tetris_Main.MESH;

    protected static void MoveRight(Rectangle[] rectangles) {
        if (rectangles[0].getX() + MOVE <= XMAX - SIZE + 10 && rectangles[1].getX() + MOVE <= XMAX - SIZE + 10
                && rectangles[2].getX() + MOVE <= XMAX - SIZE + 10 && rectangles[3].getX() + MOVE <= XMAX - SIZE + 10) {
            int movea = MESH[((int) rectangles[0].getX() / SIZE) + 1][((int) rectangles[0].getY() / SIZE)];
            int moveb = MESH[((int) rectangles[1].getX() / SIZE) + 1][((int) rectangles[1].getY() / SIZE)];
            int movec = MESH[((int) rectangles[2].getX() / SIZE) + 1][((int) rectangles[2].getY() / SIZE)];
            int moved = MESH[((int) rectangles[3].getX() / SIZE) + 1][((int) rectangles[3].getY() / SIZE)];

            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                rectangles[0].setX(rectangles[0].getX() + MOVE);
                rectangles[1].setX(rectangles[1].getX() + MOVE);
                rectangles[2].setX(rectangles[2].getX() + MOVE);
                rectangles[3].setX(rectangles[3].getX() + MOVE);
            }
        }
    }

    protected static void MoveLeft(Rectangle[] rectangles) {
        if (rectangles[0].getX() - MOVE >= 1 && rectangles[1].getX() - MOVE >= 1 && rectangles[2].getX() - MOVE >= 1
                && rectangles[3].getX() - MOVE >= 1) {
            int movea = MESH[((int) rectangles[0].getX() / SIZE) - 1][((int) rectangles[0].getY() / SIZE)];
            int moveb = MESH[((int) rectangles[1].getX() / SIZE) - 1][((int) rectangles[1].getY() / SIZE)];
            int movec = MESH[((int) rectangles[2].getX() / SIZE) - 1][((int) rectangles[2].getY() / SIZE)];
            int moved = MESH[((int) rectangles[3].getX() / SIZE) - 1][((int) rectangles[3].getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                rectangles[0].setX(rectangles[0].getX() - MOVE);
                rectangles[1].setX(rectangles[1].getX() - MOVE);
                rectangles[2].setX(rectangles[2].getX() - MOVE);
                rectangles[3].setX(rectangles[3].getX() - MOVE);
            }
        }
    }

    protected static void MoveDown(Rectangle[] rectangles) {
        if (rectangles[0].getY() >= YMAX - SIZE || rectangles[1].getY() >= YMAX - SIZE || rectangles[2].getY() >= YMAX - SIZE
                || rectangles[3].getY() >= YMAX - SIZE
                || moveA(rectangles[0]) || moveB(rectangles[1]) || moveC(rectangles[2]) || moveD(rectangles[3])) {
            MESH[(int) rectangles[0].getX() / SIZE][(int) rectangles[0].getY() / SIZE] = 1;
            MESH[(int) rectangles[1].getX() / SIZE][(int) rectangles[1].getY() / SIZE] = 1;
            MESH[(int) rectangles[2].getX() / SIZE][(int) rectangles[2].getY() / SIZE] = 1;
            MESH[(int) rectangles[3].getX() / SIZE][(int) rectangles[3].getY() / SIZE] = 1;
            clear.remove(Tetris_Main.root_tetris);

            Generator generator_Obj = new Generator();
            NumOfThisShape = NumOfNextShape;
            generator_Obj.SetShapes(rectangles, x, y, Tetris_Main.root_tetris, generator_Obj.NumOfNextShape);
            generator_Obj.RemoveNextShape(Tetris_Main.Next, Tetris_Main.root_tetris);
            generator_Obj.SetNextShapeInSquare(Tetris_Main.Next, Tetris_Main.root_tetris);
            Tetris_Main.root_tetris.getChildren().addAll(rectangles[0], rectangles[1], rectangles[2], rectangles[3]);
            Press_LEFT_RIGHT_UP_DOWN(rectangles, Tetris_Main.tetris_scene);
        }

        if (rectangles[0].getY() + MOVE < YMAX && rectangles[1].getY() + MOVE < YMAX && rectangles[2].getY() + MOVE < YMAX
                && rectangles[3].getY() + MOVE < YMAX) {
            int movea = MESH[(int) rectangles[0].getX() / SIZE][((int) rectangles[0].getY() / SIZE) + 1];
            int moveb = MESH[(int) rectangles[1].getX() / SIZE][((int) rectangles[1].getY() / SIZE) + 1];
            int movec = MESH[(int) rectangles[2].getX() / SIZE][((int) rectangles[2].getY() / SIZE) + 1];
            int moved = MESH[(int) rectangles[3].getX() / SIZE][((int) rectangles[3].getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                rectangles[0].setY(rectangles[0].getY() + MOVE);
                rectangles[1].setY(rectangles[1].getY() + MOVE);
                rectangles[2].setY(rectangles[2].getY() + MOVE);
                rectangles[3].setY(rectangles[3].getY() + MOVE);
            }
        }

    }

    private static boolean moveA(Rectangle rect) {
        return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveB(Rectangle rect) {
        return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveC(Rectangle rect) {
        return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveD(Rectangle rect) {
        return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
    }

    protected static void Press_LEFT_RIGHT_UP_DOWN(Rectangle[] rectangles, Scene SceneTetris) {

        SceneTetris.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                switch (e.getCode().toString()) {
                    case "LEFT":
                        MoveLeft(rectangles);
                        break;
                    case "RIGHT":
                        MoveRight(rectangles);
                        break;
                    case "DOWN":
                        MoveDown(rectangles);
                        break;
                    case "UP":
                        TurnShape(rectangles);
                        break;
                }
            }
        });
    }

    private static void TurnShape(Rectangle[] rectangles) {

        switch (Shape.NumOfTurn) {
            case 1: // shape in basic and should go to 90
                switch (Generator.NumOfThisShape) {
                    case 1:
                        shape1_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 2: // shape in 90 and should go to 180
                switch (Generator.NumOfThisShape) {
                    case 1:
                        shape1_obj.turn180(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3_obj.turn180(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4_obj.turn180(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5_obj.turn180(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6_obj.turn180(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7_obj.turn180(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 3: // shape in 180 and should go to 270
                switch (Generator.NumOfThisShape) {
                    case 1:
                        shape1_obj.turn270(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3_obj.turn270(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4_obj.turn270(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5_obj.turn270(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6_obj.turn270(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7_obj.turn270(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 4: // shape in 270 and should go to 360(basic)
                switch (Generator.NumOfThisShape) {
                    case 1:
                        shape1_obj.turn360(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3_obj.turn360(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4_obj.turn360(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5_obj.turn360(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6_obj.turn360(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7_obj.turn360(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 5: //shape in 360(basic) and should go to 90  and Again....
                switch (Generator.NumOfThisShape) {
                    case 1:
                        shape1_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7_obj.turn90(rectangles, x, y, Tetris_Main.root_tetris);
                        break;
                }
                break;
        }

    }
    /* first check that rectangles is at the top .. Then check if the shape is moving or it will stay at this place
     if yes set gameOver image and return true then  stop game from main
     */

    private boolean Is_Shape_At_TheTop(Rectangle[] rectangles) {
        if (rectangles[0].getY() >= 5 && rectangles[0].getY() <= 20 || rectangles[1].getY() >= 5 && rectangles[1].getY() <= 20
                || rectangles[2].getY() >= 5 && rectangles[2].getY() <= 20 || rectangles[3].getY() >= 5 && rectangles[3].getY() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean CheckGameOver(Rectangle[] rectangles) {
        if (Is_Shape_At_TheTop(rectangles)) {
            if (Controller.moveA(rectangles[0]) || Controller.moveB(rectangles[1]) || Controller.moveC(rectangles[2]) || Controller.moveD(rectangles[3])) {
                {
                    System.out.println(" Yess ");
                    Controller.setGameOver();
                    return true;
                }
            }
        }
        return false;
    }

    private static void setGameOver() {
        Image gameOver = new Image("Resources/Tetris/Game Over.png", 500, 150, false, false);
        ImageView gameOverIv = new ImageView(gameOver);
        gameOverIv.setX(435);
        gameOverIv.setY(365);
        Tetris_Main.root_tetris.getChildren().add(gameOverIv);

    }

}
