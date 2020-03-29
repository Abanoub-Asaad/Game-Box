
package Tetris;

import static Tetris.Tetris_Main.MESH;
import java.util.Arrays;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;


public class Controller {

    public Controller() {
        
        for (int[] a : MESH) 
        {
                Arrays.fill(a, 0);
        }
    }
    
    
    
    private static int MOVE = Board.MoveValue ;
    private static int XMAX = Board.XMAX;
    private static int YMAX = Board.YMAX;
    private static int SIZE = Board.Size ; //size of the one rectangle
    private static int MESH[][] = Tetris_Main.MESH;
    
    protected static void MoveRight(Rectangle[] rectangles) 
        {
		if (rectangles[0].getX()+ MOVE <= XMAX - SIZE +10&& rectangles[1].getX() + MOVE <= XMAX - SIZE+10
				&& rectangles[2].getX() + MOVE <= XMAX - SIZE +10&& rectangles[3].getX() + MOVE <= XMAX - SIZE+10) 
                {
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
		if (rectangles[0].getX() - MOVE >= 0 && rectangles[1].getX() - MOVE >= 0 && rectangles[2].getX() - MOVE >= 0
				&& rectangles[3].getX() - MOVE >= 0) {
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
				|| rectangles[3].getY() >= YMAX - SIZE ||
                        moveA(rectangles[0]) || moveB(rectangles[1]) || moveC(rectangles[2]) || moveD(rectangles[3])) {
			MESH[(int) rectangles[0].getX() / SIZE][(int) rectangles[0].getY() / SIZE] = 1;
			MESH[(int) rectangles[1].getX() / SIZE][(int) rectangles[1].getY() / SIZE] = 1;
			MESH[(int) rectangles[2].getX() / SIZE][(int) rectangles[2].getY() / SIZE] = 1;
			MESH[(int) rectangles[3].getX() / SIZE][(int) rectangles[3].getY() / SIZE] = 1;
			
                 
			Shapes shapesObj = new Shapes() ;
                        shapesObj.chooseShape(rectangles,Tetris_Main.root_tetris);
			Tetris_Main.root_tetris.getChildren().addAll(rectangles[0],rectangles[1],rectangles[2],rectangles[3]);
			checkPressLeftOrRight(rectangles,Tetris_Main.tetris_scene);
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

	private static  boolean moveB(Rectangle rect) {
		return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
	}

	private static boolean moveC(Rectangle rect) {
		return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
	}

	private static boolean moveD(Rectangle rect) {
		return (MESH[(int) rect.getX() / SIZE][((int) rect.getY() / SIZE) + 1] == 1);
	}
    
        
        
        
        
        
        
        
    protected static void checkPressLeftOrRight(Rectangle[] rectangles, Scene SceneTetris) {

        SceneTetris.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.LEFT) {
                    MoveLeft(rectangles);
                }
                if (e.getCode() == KeyCode.RIGHT) {
                    MoveRight(rectangles);
                }

            }
        });

    }
}
