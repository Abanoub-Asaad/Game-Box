package Sokoban;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Sokoban_Main {

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

    public void Sokoban_Main(Stage Sokoban_Stage) throws IOException {

        Map mp_obj = new Map(root);
        mp_obj.readMapFile();

        Scene sokoban_scene = new Scene(root, 1370, 750);

        Piece.checkKeyboard(sokoban_scene);

        Sokoban_Stage.setTitle("SOKOBAN");
        Sokoban_Stage.setScene(sokoban_scene);
        Sokoban_Stage.show();
    }


}
