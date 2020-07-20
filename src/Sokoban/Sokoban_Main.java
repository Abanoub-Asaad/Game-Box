package Sokoban;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Sokoban_Main {

    public static Scene sokoban_scene;
    static Group root = new Group();

    //================================================================
    /*
     ** For Singleton Pattern 
     */
    private static Sokoban_Main sokobanInstance;

    public static Sokoban_Main getInstanceFromSokoban() {
        if (sokobanInstance == null) {
            sokobanInstance = new Sokoban_Main();
        }

        return sokobanInstance;
    }

    private Sokoban_Main() {

    }
    
    //===============================================================

    public void openSokobanMain(Stage Sokoban_Stage) throws IOException {
        if (!Buttons.check_mode43) {
            Time.time_score_move();
        }

        sokoban_scene = new Scene(root, 1370, 750);

        sokoban_scene.getStylesheets().add(Sokoban_Main.class.getResource("css1.css").toExternalForm());

        Map.make_hashmap();
        Map.startlevel(1);
        Piece.checkKeyboard(sokoban_scene);

        Sokoban_Stage.setTitle("SOKOBAN");
        Sokoban_Stage.show();
    }
}
