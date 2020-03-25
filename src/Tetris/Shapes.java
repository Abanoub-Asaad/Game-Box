package Tetris;

import javafx.scene.shape.Rectangle;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Shapes {

    //---------------------------------------------
    private float x = 409f;
    private float y = 5f;
    private boolean IsTurn = false;
    private int MoveValue = 51 ;
    //------------------------------------------------

    public void tranformation(Rectangle[] rectangles, float move0, float move1, float move2, float move3) {
        TranslateTransition transitionRec0 = new TranslateTransition();
        TranslateTransition transitionRec1 = new TranslateTransition();
        TranslateTransition transitionRec2 = new TranslateTransition();
        TranslateTransition transitionRec3 = new TranslateTransition();

        System.out.println("y 0:" + rectangles[0].getY());
        System.out.println("y 1:" + rectangles[1].getY());
        System.out.println("y 2:" + rectangles[2].getY());
        System.out.println("y 3:" + rectangles[3].getY());

        transitionRec0.setToY(rectangles[0].getY() + move0);
        transitionRec0.setCycleCount(1);
        transitionRec0.setNode(rectangles[0]);
        transitionRec0.setDuration(Duration.seconds(5));
        //transitionRec0
        transitionRec0.play();

        transitionRec1.setToY(rectangles[1].getY() + move1);
        transitionRec1.setCycleCount(1);
        transitionRec1.setNode(rectangles[1]);
        transitionRec1.setDuration(Duration.seconds(5));
        transitionRec1.play();

        transitionRec2.setToY(rectangles[2].getY() + move2);
        transitionRec2.setCycleCount(1);
        transitionRec2.setNode(rectangles[2]);
        transitionRec2.setDuration(Duration.seconds(5));
        transitionRec2.play();

        transitionRec3.setToY(rectangles[3].getY() + move3);
        transitionRec3.setCycleCount(1);
        transitionRec3.setNode(rectangles[3]);
        transitionRec3.setDuration(Duration.seconds(5));
        transitionRec3.play();

    }

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

    public void moveShapes(Rectangle[] rectangles, float xDirection) {
        
        
        int Move_a = (int)rectangles[0].getX() + (int)(xDirection * MoveValue);
        int Move_b = (int)rectangles[1].getX() + (int)(xDirection * MoveValue);
        int Move_c = (int)rectangles[2].getX() + (int)(xDirection * MoveValue);
        int Move_d = (int)rectangles[3].getX() + (int)(xDirection * MoveValue);
        
        if(Move_a<1000 && Move_b<1000 && Move_c<1000 && Move_d<1000 )
        {         
            if(Move_a>-1 && Move_b>-1 && Move_c>-1 && Move_d>-1){
            rectangles[0].setX(Move_a);
            rectangles[1].setX(Move_b);
            rectangles[2].setX(Move_c);
            rectangles[3].setX(Move_d);}
        }
    }

    public void checkPressLeftOrRight(Rectangle[] rectangles, Scene SceneTetris) {

        SceneTetris.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.LEFT) {
                    moveShapes(rectangles, -1);
                }
                if (e.getCode() == KeyCode.RIGHT) {
                    moveShapes(rectangles, 1);
                }

            }
        });

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
