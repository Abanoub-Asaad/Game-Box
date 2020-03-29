
package Tetris;

import java.util.Arrays;
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
    protected static Group root_tetris = new Group() ;
    protected static Scene tetris_scene ;
    public static int[][] MESH = new int[Board.XMAX / Board.Size][Board.YMAX / Board.Size];
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
   
    
    /*
    ** Method for Sor Opening Tetris Game
    */
    public void Tetris_Main (Stage Games_Stage)
    {

        tetris_scene = new Scene(root_tetris, 1370, 750);
        //Board.draw_back_ground();
        root_tetris.getChildren().addAll(Board.tetris_back_iv,Board.drawLine());//, board.grid);
        
        //---------------------------------------
        Rectangle[] rectangles = new Rectangle[4];
        Shapes shapesObj = new Shapes() ;
        shapesObj.chooseShape(rectangles,root_tetris);
        Controller.checkPressLeftOrRight( rectangles , tetris_scene);
        Controller controller_obj = new Controller();
        Tetris_Stage = Games_Stage;
        Tetris_Stage.setScene(tetris_scene);
        //---------------------------------------------------
    
        Timer fall = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        
                       Controller.MoveDown(rectangles);
                    }
                });
            }
        };
        fall.schedule(task, 0, 300);
        
       
    }
    
}
