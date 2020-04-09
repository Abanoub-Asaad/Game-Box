package Sokoban;

import static Sokoban.map.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Piece {

    static int countboxesatstorage;
    /*
     ** checkKeyboard method is used for Accessing player's desired location 
     */

    protected static void checkKeyboard(Scene Sokoban_Scene) {

        Sokoban_Scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {

                if (e.getCode() == KeyCode.LEFT) {
                    Box.checkBox(-1, 0);
                    Player.checkForThePlayer(-1, 0); 
                    Player.player_imageView.setImage(map.playerL);
                } 

                if (e.getCode() == KeyCode.RIGHT) {
                    Box.checkBox(1, 0);
                    Player.checkForThePlayer(1, 0);
                    Player.player_imageView.setImage(map.playerR);
                }

                if (e.getCode() == KeyCode.UP) {
                    Box.checkBox(0, -1);
                    Player.checkForThePlayer(0, -1);
                    Player.player_imageView.setImage(map.playerU);
                }

                if (e.getCode() == KeyCode.DOWN) {
                    Box.checkBox(0, 1);
                    Player.checkForThePlayer(0, 1);
                    Player.player_imageView.setImage(map.player);
                }
                try {
                    checkIfStorageLogationsAreFilled();
                } catch (IOException ex) {
                    Logger.getLogger(Piece.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    /*
     * Check if the storage Location is filled , to change its shape using imageview.setImage(imageName)
     */
    private static void checkIfStorageLogationsAreFilled() throws IOException {
        
        countboxesatstorage = 0;
        for (ImageView Boxes_Imageviews_Array1 : map.Boxes_Imageviews_Array) {
            for (ImageView StorageLocation_Imageviews_Array1 : StorageLocation_Imageviews_Array) {
                if (Boxes_Imageviews_Array1.getX() == StorageLocation_Imageviews_Array1.getX() && Boxes_Imageviews_Array1.getY() == StorageLocation_Imageviews_Array1.getY()) {
                    Boxes_Imageviews_Array1.setImage(map.boxOnTarget);
                    countboxesatstorage++;
                    break;
                } else {
                    Boxes_Imageviews_Array1.setImage(map.box);
                    /*
                    * Here we should handle if the box in the storage location then we move it to an empty location
                    * so its shape should return to its originl shape
                    */
                }
            }
        }
        checkfinishlevel();
    }

    public static void checkfinishlevel() throws IOException {
        
        if (countboxesatstorage == map.Boxes_Imageviews_Array.size()) 
        {
            time.SetinformationBox();
            
            
        }
        
    }
}
