package Sokoban;

import GameLoop.GameBox_Core;
import static Sokoban.Map.StorageLocation_Imageviews_Array;
import static Sokoban.score.file_unlockedLvls;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Piece {

    private static Pressure_Pad pad_obj = new Pressure_Pad();

    // to get   sort fn
    static rank r = new rank();
    static int countboxesatstorage;
    /*
     ** checkKeyboard method is used for Accessing player's desired location 
     */

    public static void checkKeyboard(Scene Sokoban_Scene) {

        Sokoban_Scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {

                if (e.getCode() == KeyCode.LEFT) {
                    Box.checkBox(-1, 0);
                    Player.checkForThePlayer(-1, 0, "LEFT");
                    Player.player_imageView.setImage(Map.playerL);
                    pad_obj.check_pad_isPressed();
                }

                if (e.getCode() == KeyCode.RIGHT) {
                    Box.checkBox(1, 0);
                    Player.checkForThePlayer(1, 0, "RIGHT");
                    Player.player_imageView.setImage(Map.playerR);
                    pad_obj.check_pad_isPressed();
                }

                if (e.getCode() == KeyCode.UP) {
                    Box.checkBox(0, -1);
                    Player.checkForThePlayer(0, -1, "UP");
                    Player.player_imageView.setImage(Map.playerU);
                    pad_obj.check_pad_isPressed();
                }

                if (e.getCode() == KeyCode.DOWN) {
                    Box.checkBox(0, 1);
                    Player.checkForThePlayer(0, 1, "DOWN");
                    Player.player_imageView.setImage(Map.player);
                    pad_obj.check_pad_isPressed();
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
    public static void checkIfStorageLogationsAreFilled() throws IOException {

        countboxesatstorage = 0;
        for (ImageView Boxes_Imageviews_Array1 : Map.Boxes_Imageviews_Array) {
            for (ImageView StorageLocation_Imageviews_Array1 : StorageLocation_Imageviews_Array) {
                if (Boxes_Imageviews_Array1.getX() == StorageLocation_Imageviews_Array1.getX() && Boxes_Imageviews_Array1.getY() == StorageLocation_Imageviews_Array1.getY()) {
                    Boxes_Imageviews_Array1.setImage(Map.boxOnTarget);
                    countboxesatstorage++;
                    break;
                } else {
                    Boxes_Imageviews_Array1.setImage(Map.box);
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

        if (countboxesatstorage == Map.Boxes_Imageviews_Array.size()) {
            Time.timer.stop();
            score.calculate_score();
            rank.Display_Rank();
            Sound.playsound(Sound.mediaPlayer_win);
            GameBox_Core.Root.setScene(finish_level.finish_scene());

        }

    }
}
