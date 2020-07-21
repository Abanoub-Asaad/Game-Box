package Arkanoid;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author egypt
 */
public class ArkanoidMain {

    public static Group root = new Group();
    static Scene Arkanoid_scene;
    //================================================================
    /*
     ** For Singleton Pattern 
     */
    private static ArkanoidMain sokobanInstance;

    public static ArkanoidMain getInstanceFromArkanoid() {
        if (sokobanInstance == null) {
            sokobanInstance = new ArkanoidMain();
        }

        return sokobanInstance;
    }

    private ArkanoidMain() {

    }

    //===============================================================
    public void openArkanoidMain(Stage Arkanoid_main) throws IOException {
        Arkanoid_main.setScene(Arkanoid_scene);

        Arkanoid_scene = new Scene(root, 1370, 750);

        movement movment = new movement(Arkanoid_main);

        Arkanoid_main.setTitle("Arkanoid");
        Arkanoid_main.setScene(Arkanoid_scene);
        check_Escape(Arkanoid_main, Menu.sceneButtons);

        Arkanoid_main.show();
    }

    public static void check_Escape(Stage stage, Scene goScene) {
        stage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {

                stage.setScene(goScene);

            }
        });
    }
}
