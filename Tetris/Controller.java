package Tetris;

import static Tetris.Tetris_Main.MESH;
import java.util.Arrays;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Controller {

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

            Shapes shapesObj = new Shapes();
            Shapes.NumOfThisShape = Shapes.NumOfNextShape;
            shapesObj.SetShapes(rectangles, shapesObj.x, shapesObj.y, Tetris_Main.root_tetris, Shapes.NumOfNextShape);
            shapesObj.RemoveNextShape(Tetris_Main.Next, Tetris_Main.root_tetris);
            shapesObj.SetNextShapeInSquare(Tetris_Main.Next, Tetris_Main.root_tetris);
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
        Shape1 shape1 = new Shape1();
        Shape3 shape3 = new Shape3();
        Shape4 shape4 = new Shape4();
        Shape5 shape5 = new Shape5();
        Shape6 shape6 = new Shape6();
        Shape7 shape7 = new Shape7();
        Shapes shapeObj = new Shapes();

        /*
         First seet which turn the will go to case 1 the is in basic and should go to 90 
         and case 2 shape in 90 and should go to 180 ...etc we determine this from numOfTurn in each shape
         then determine  which shape is access now to go to its turning shape 
         */
        switch (Shapes.NumOfTurn) {
            case 1: // shape in basic and should go to 90
                switch (Shapes.NumOfThisShape) {
                    case 1:
                        shape1.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 2: // shape in 90 and should go to 180
                switch (Shapes.NumOfThisShape) {
                    case 1:
                        shape1.turn180(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3.turn180(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4.turn180(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5.turn180(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6.turn180(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7.turn180(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 3: // shape in 180 and should go to 270
                switch (Shapes.NumOfThisShape) {
                    case 1:
                        shape1.turn270(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3.turn270(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4.turn270(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5.turn270(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6.turn270(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7.turn270(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 4: // shape in 270 and should go to 360(basic)
                switch (Shapes.NumOfThisShape) {
                    case 1:
                        shape1.turn360(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3.turn360(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4.turn360(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5.turn360(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6.turn360(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7.turn360(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                }
                break;
            case 5: //shape in 360(basic) and should go to 90  and Again....
                switch (Shapes.NumOfThisShape) {
                    case 1:
                        shape1.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 3:
                        shape3.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 4:
                        shape4.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 5:
                        shape5.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 6:
                        shape6.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
                        break;
                    case 7:
                        shape7.turn90(rectangles, shapeObj.x, shapeObj.y, Tetris_Main.root_tetris);
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
