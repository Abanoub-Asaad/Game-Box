package Tetris;

import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Shapes {

    //---------------------------------------------
    private float x = 400f;
    private float y = 5f;
    private boolean IsTurn = false;
    
   
    //------------------------------------------------


    public int RandomNum() {
        int Num;
        Num = (int) ((Math.random() * ((7 - 1) + 1)) + 1);
        System.out.println("Num   " + Num);
        return Num;
    }

    public void chooseShape(Rectangle[] rectangles, Group group) {
        //----------------------------------
        DrawNormalShape normalObj = new DrawNormalShape();
        DrawSquareShape squareObj = new DrawSquareShape();
        Draw_L_Shape LObj = new Draw_L_Shape();
        Draw__1Shape __1Obj = new Draw__1Shape();
        SBrick sBrickObj = new SBrick();
        TBrick tBrickObj = new TBrick();
        ZBrick zBrickObj = new ZBrick();
        //-----------------------------------

        switch (RandomNum()) {

            case 1:
                normalObj.Basic(rectangles, x, y, group);
                break;

            case 2:
                squareObj.Basic(rectangles, x, y, group);
                break;

            case 3:
                LObj.Basic(rectangles, x, y, group);
                break;

            case 4:
                __1Obj.Basic(rectangles, x, y, group);
                break;

            case 5:
                sBrickObj.Basic(rectangles, x, y, group);
                break;

            case 6:
                tBrickObj.Basic(rectangles, x, y, group);
                break;

            case 7:
                zBrickObj.Basic(rectangles, x, y, group);
                break;
        }
    }
    
    

	

        
    

    public boolean checkTurn(Rectangle[] rectangles, Scene SceneTetris) {

        SceneTetris.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.UP) {
                    IsTurn = true;
                }
            }
        });
        return IsTurn;
    }

}
