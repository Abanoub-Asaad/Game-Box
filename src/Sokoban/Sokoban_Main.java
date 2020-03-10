package Sokoban;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Sokoban_Main {

    
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

    public void Sokoban_Main(Stage Sokoban_Stage) throws IOException {

        Image SokobanImgback = new Image("Resources/Sokoban/l1.jpg", 1400, 800, true, false);
        ImageView Soko_ImagbackIV = new ImageView(SokobanImgback);

        Group root = new Group();
        root.getChildren().addAll(Soko_ImagbackIV);

        Map mp_obj = new Map();
        mp_obj.readMapFile(root);

        Scene sokoban_scene = new Scene(root, 1370, 750);

        Sokoban_Stage.setTitle("Tetris");
        Sokoban_Stage.setScene(sokoban_scene);
        Sokoban_Stage.show();
    }

}
