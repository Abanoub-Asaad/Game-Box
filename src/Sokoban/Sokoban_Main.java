
package Sokoban;

import Tetris.Tetris_Main;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Sokoban_Main 
{
    public Stage Sokoban_Stage ;
    //================================================================
    /*
    ** For Singleton Pattern 
    */
    private static Sokoban_Main sokobanInstance ; 
    public static Sokoban_Main getInstanceFromSokoban()
    {
        if (sokobanInstance == null)
        {
            sokobanInstance = new Sokoban_Main(); 
        }
        
        return sokobanInstance; 
    }
    //===============================================================
    
    
     public void Sokoban_Main (Stage primaryStage) throws IOException 
    {
        map map_op = map.fromfile("map.txt");
        map_op.split_image_sheet();
        StackPane root = new StackPane();

        root.getChildren().add(map_op.canvas);

        Scene sokoban_scene = new Scene(root,1370 , 750 );

        Sokoban_Stage = primaryStage;
        Sokoban_Stage.setTitle("Tetris");
        Sokoban_Stage.setScene(sokoban_scene);
        Sokoban_Stage.show();
    }
     
    /*
    ** Empty private Constructor for Singleton pattern 
    */
     
     private Sokoban_Main()
     {
     
     }

}
