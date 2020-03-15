
package Sokoban;

import static Sokoban.Map.StorageLocation_Imageviews_Array;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Piece {
    
    /*
    ** checkKeyboard method is used for Accessing player's desired location 
    */
    protected static void checkKeyboard(Scene Sokoban_Scene)
    {
 
        Sokoban_Scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent e)
            {
                
                
                if (e.getCode() == KeyCode.LEFT) {
                    Box.checkBox(-1,0) ;
                    Player.checkForThePlayer(-1,0);
                    Player.player_imageView.setImage(Map.playerL);
                }
                    
                if (e.getCode() == KeyCode.RIGHT) {
                    Box.checkBox(1,0) ;
                    Player.checkForThePlayer(1,0);
                    Player.player_imageView.setImage(Map.playerR);
                }
                    
                
                if (e.getCode() == KeyCode.UP) {
                   Box.checkBox(0,-1) ;
                   Player.checkForThePlayer(0,-1);
                   Player.player_imageView.setImage(Map.playerU);
                }
                    
                
                if (e.getCode() == KeyCode.DOWN) {
                    Box.checkBox(0,1) ;
                    Player.checkForThePlayer(0,1);
                    Player.player_imageView.setImage(Map.player);
                }
                 checkIfStorageLogationsAreFilled() ;
            }
           
        });

    }
    
    /*
     * Check if the storage Location is filled , to change its shape using imageview.setImage(imageName)
    */
    private static void checkIfStorageLogationsAreFilled()
    {
        for(int i=0 ; i<Map.Boxes_Imageviews_Array.size()  ; i++)
        {
            for(int j=0 ; j<StorageLocation_Imageviews_Array.size(); j++)
            {
                if(Map.Boxes_Imageviews_Array.get(i).getX()==Map.StorageLocation_Imageviews_Array.get(j).getX()
                && Map.Boxes_Imageviews_Array.get(i).getY()==Map.StorageLocation_Imageviews_Array.get(j).getY())
                { 
                    Map.Boxes_Imageviews_Array.get(i).setImage(Map.boxOnTarget);
                }
                else 
                {
                    /*
                     * Here we should handle if the box in the storage location then we move it to an empty location 
                     * so its shape should return to its originl shape
                    */
                }
            }
        }
        
    }
    
    
}
