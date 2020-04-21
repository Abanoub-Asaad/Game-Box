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
public class ArkanoidMain {
        static Group root = new Group();
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
        Arkanoid_scene = new Scene(root, 1370, 750);

        Movement movment = new Movement(Arkanoid_main);

        Arkanoid_main.setTitle("Arkanoid");
        Arkanoid_main.setScene(Arkanoid_scene);
        Arkanoid_main.show();
    }

}
