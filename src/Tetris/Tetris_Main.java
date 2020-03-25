
package Tetris;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Tetris_Main
{ 
    public Stage Tetris_Stage ;
    private Group root_tetris = new Group() ;
    public static Scene tetris_scene ;
    
    //=========================================================
    /*
    ** For Singleton Pattern 
    */
    private static Tetris_Main tetrisInstance ; 
    public static Tetris_Main getInstanceFromTetris()
    {
        if (tetrisInstance == null)
        {
            tetrisInstance = new Tetris_Main(); 
        }
        
        return tetrisInstance;
    }
    private Tetris_Main()
    {
    
    }
    //======================================================
   
    
    /*
    ** Method for Sor Opening Tetris Game
    */
    public void Tetris_Main (Stage Games_Stage)
    {
        
        
        tetris_scene = new Scene(root_tetris, 1370, 750);
        board.draw_back_ground();
        root_tetris.getChildren().addAll(board.tetris_back_iv, board.grid);
        
        //---------------------------------------
        Rectangle[] rectangles = new Rectangle[4];
        Shapes shapesObj = new Shapes() ;
        shapesObj.chooseShape(rectangles,root_tetris);
        shapesObj.checkPressLeftOrRight( rectangles , tetris_scene);
        board.Abnb(tetris_scene);
        
        //---------------------------------------------------
        //---------------------------------------------------
        
        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        
                        
                        rectangles[0].setY(rectangles[0].getY() + 5);
                        rectangles[1].setY(rectangles[1].getY() + 5);
                        rectangles[2].setY(rectangles[2].getY() + 5);
                        rectangles[3].setY(rectangles[3].getY() + 5);
                        
                        if(rectangles[0].getY() + 50>700 &&rectangles[1].getY() + 50>700&&
                                rectangles[2].getY() + 50>700&&rectangles[3].getY() + 50>700 ){
                            Shapes shapesObj = new Shapes() ;
                            shapesObj.chooseShape(rectangles,root_tetris);
                        }
                    }
                });
            }
        };
        fall.schedule(task, 0, 20);
        
        //---------------------------------------------------
        //-----------------------------------------------
        
        Tetris_Stage = Games_Stage;
        Tetris_Stage.setScene(tetris_scene);
       
    }
    
}
