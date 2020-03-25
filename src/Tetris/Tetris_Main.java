
package Tetris;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Tetris_Main
{ 
    public Stage Tetris_Stage ;
    private Group root_tetris = new Group() ;
    public static Scene tetris_scene ;
    private Image tetris_back_img ;
    private ImageView tetris_back_iv ;
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
        tetris_back_img = new Image("Resources/Tetris/tt.png" ,1400,800,false,false) ;
        tetris_back_iv  = new ImageView(tetris_back_img);
        root_tetris.getChildren().addAll (tetris_back_iv );
        
        tetris_scene = new Scene(root_tetris, 1370 , 750); 
         //----------------------------------
        board.draw_back_ground();
       root_tetris.getChildren().add(board.grid);
        //---------------------------------------
        Rectangle[] rectangles = new Rectangle[4];
        Shapes shapesObj = new Shapes() ;
        shapesObj.chooseShape(rectangles,root_tetris);
        shapesObj.checkPressLeftOrRight( rectangles , tetris_scene);
        board.Abnb(tetris_scene);
        //-----------------------------------------------
        
        Tetris_Stage = Games_Stage;
        Tetris_Stage.setScene(tetris_scene);
       
    }
    
}
