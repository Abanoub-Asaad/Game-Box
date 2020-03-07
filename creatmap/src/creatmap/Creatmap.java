/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatmap;

import java.awt.Dimension;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JFrame;

public class Creatmap extends Application {
     
    @Override
    public void start(Stage primaryStage) throws IOException {
    }

    public static void main(String[] args) throws IOException {
              map map_op = map.fromfile("map.txt");
        JFrame frame = new JFrame("test map");
        frame.setSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(map_op);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        }
    
}
