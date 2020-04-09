/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author egypt
 */
public class Arkanoid_main {
      static Group root = new Group();

    //================================================================
    /*
     ** For Singleton Pattern 
     */
    private static Arkanoid_main sokobanInstance;

    public static Arkanoid_main getInstanceFromArkanoid() {
        if (sokobanInstance == null) {
            sokobanInstance = new Arkanoid_main();
        }

        return sokobanInstance;
    }

    private Arkanoid_main() {

    }
    //===============================================================
static Scene Arkanoid_scene ;
    public void Arkanoid_Main(Stage Arkanoid_main) throws IOException {
        
             
        Arkanoid_scene = new Scene(root, 1370, 750);
        map.make_hashmap();
        movement.start();
        Arkanoid_main.setTitle("Arkanoid");
        Arkanoid_main.setScene(Arkanoid_scene);
        Arkanoid_main.show();
    }

}
