/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatmap;

import java.awt.Dimension;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JFrame;

public class Creatmap extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        map map_op = map.fromfile("map.txt");
        map_op.split_image_sheet();
        StackPane root = new StackPane();

        root.getChildren().add(map_op.canvas);

        Scene scene = new Scene(root, 800, 700);

        primaryStage.setTitle("test map");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
