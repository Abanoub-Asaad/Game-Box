
package Tetris;


import javafx.scene.Group;
import javafx.scene.shape.Rectangle;



public class Generator extends Shape{
    
    protected static int NumOfThisShape , NumOfNextShape;
    private final float X_ofNextShape=1120 , Y_ofNextShape = 150;
    private float x = 400f;
    private float y = 5f;
    
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

    @Override
    void Basic(Rectangle[] rectangles, float x, float y, Group group) {}

    @Override
    void turn90(Rectangle[] rectangles, float x, float y, Group group) {}


    @Override
    void turn180(Rectangle[] rectangles, float x, float y, Group group) {}

    @Override
    void turn270(Rectangle[] rectangles, float x, float y, Group group) {}
 
    @Override
    void turn360(Rectangle[] rectangles, float x, float y, Group group) {}
  
    
}
