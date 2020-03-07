
package gamebox_tetris;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class UI
{
    private static Group root_tetris = new Group() ;
    private Image tetris_back_img ;
    private ImageView tetris_back_iv ;
    
    public UI(Stage Tetris_Stage)
    {
        
        
        
        tetris_back_img = new Image("resources/tetris_back.png" ,1400,800,false,false) ;
        tetris_back_iv  = new ImageView(tetris_back_img);
        root_tetris.getChildren().addAll (tetris_back_iv );
        
        Scene scene = new Scene(root_tetris, 1370 , 750);
        
        Tetris_Stage.setTitle("Tetris");
        Tetris_Stage.setResizable(false);
        Tetris_Stage.setMaximized(true);
        Tetris_Stage.setScene(scene);
        Tetris_Stage.show();
    }
    
}
