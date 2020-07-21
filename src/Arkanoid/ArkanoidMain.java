
package Arkanoid;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author egypt
 */
public class ArkanoidMain {
       public static Group root = new Group();
      public  static Scene Arkanoid_scene;
   
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

    //===============================================================//
    public void openArkanoidMain(Stage Arkanoid_main) throws IOException {
        Arkanoid_scene = new Scene(root, 1370, 750);

        movement movment = new movement(Arkanoid_main);

        Arkanoid_main.setTitle("Arkanoid");
        Arkanoid_main.setScene(Arkanoid_scene);
        Arkanoid_main.show();
    }

}
