package Sokoban;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        Sokoban_Stage.setScene(sokoban_scene);

        sokoban_scene = new Scene(root, 1370, 750);

        sokoban_scene.getStylesheets().add(Sokoban_Main.class.getResource("css1.css").toExternalForm());

        Map.make_hashmap();
        Map.startlevel(1);
        Piece.checkKeyboard(sokoban_scene);

        Sokoban_Stage.setTitle("SOKOBAN");
        check_Escape(Sokoban_Stage);
        Sokoban_Stage.show();
    }

    public static void check_Escape(Stage stage) {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                stage.setScene(Menu.scene);
                
            }
        });
    }
}
