package Tetris;

import java.util.HashMap;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class Shapes {

    //---------------------------------------------
    float x = 400f;
    float y = 5f;
    final float width=50f , height=50f;
    private HashMap<String , Boolean> buttonPressed = new HashMap<String , Boolean>();
    static int  NumOfTurn ;
    static int NumOfThisShape , NumOfNextShape;
    private final float X_ofNextShape=1120 , Y_ofNextShape = 150;
    //------------------------------------------------

    // choose first shape that will fall at the first of the game
    protected void Set_FirstShape_In_TheGame(Rectangle[] rectangles, Group group) {
        //----------------------------------
        NumOfThisShape = (int) ((Math.random() * ((7 - 1) + 1)) + 1);
        SetShapes(rectangles, x, y, group, NumOfThisShape);
    }

    // generate random number to set next shape randomly
    private int GenerateNumOfNextShape() {
        NumOfNextShape = (int) ((Math.random() * ((7 - 1) + 1)) + 1);
        System.out.println("Num   " + NumOfNextShape);
        return NumOfNextShape;
    }

    protected void SetNextShapeInSquare(Rectangle[] rectangles, Group group) {
        SetShapes(rectangles, X_ofNextShape, Y_ofNextShape, group, GenerateNumOfNextShape());
    }

    protected void RemoveNextShape(Rectangle[] rectangles, Group group) {
        for (int i = 0; i < 4; i++) {
            group.getChildren().remove(rectangles[i]);
        }
    }

    protected void SetShapes(Rectangle[] rectangles, float X, float Y, Group group, int number) {
        Shape1 normalObj = new Shape1();
        Shape2 squareObj = new Shape2();
        Shape3 LObj = new Shape3();
        Shape4 __1Obj = new Shape4();
        Shape5 sBrickObj = new Shape5();
        Shape6 tBrickObj = new Shape6();
        Shape7 zBrickObj = new Shape7();

        switch (number) {

            case 1:
                normalObj.Basic(rectangles, X, Y, group);
                break;

            case 2:
                squareObj.Basic(rectangles, X, Y, group);
                break;

            case 3:
                LObj.Basic(rectangles, X, Y, group);
                break;

            case 4:
                __1Obj.Basic(rectangles, X, Y, group);
                break;

            case 5:
                sBrickObj.Basic(rectangles, X, Y, group);
                break;

            case 6:
                tBrickObj.Basic(rectangles, X, Y, group);
                break;

            case 7:
                zBrickObj.Basic(rectangles, X, Y, group);
                break;
        }
    }

}
