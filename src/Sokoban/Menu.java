/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import GameLoop.GameBox_Core;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Eng.Waleed
 */
public class Menu {
     // static Image back = new Image("Resources/Sokoban/neon.jpg",1375,750,false,true); 
    //  static ImageView   back_view = new ImageView(back);
      static Pane menu_pane = new Pane();
      static VBox text_pane = new VBox(22);
      static   Button start_game  = new Button(" START ");
      static   Button exit  = new Button(" EXIT ");
      static   Button setting  = new Button(" SETTING ");
      static Scene menu_scene =  new Scene(menu_pane,1375,750);

    public static Pane getMenu_pane() {
        return menu_pane;
    }
      
      public static Scene MenuStyle(){
         
        menu_scene.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());
        start_game.setId("menubutton");
        exit.setId("menubutton");
        setting.setId("menubutton");
        
         menu_pane.setId("menupane");
        start_game.setLayoutX(100);
        start_game.setLayoutY(100);  
    
        text_pane.setLayoutX(540);
        text_pane.setLayoutY(180); 
        text_pane.setPrefSize(280, 400);
        text_pane.getChildren().addAll(start_game,setting,exit);
        
        start_game.setOnAction(e -> {

              try {
                GameBox_Core.Root.setScene(start_level.store_name());
           } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        });

        setting.setLayoutX(100);
        setting.setLayoutY(150);
          
        setting.setOnAction(e -> {

            
            
        });
        
        exit.setLayoutX(100);
        exit.setLayoutY(200);
        
        
        exit.setOnAction(e -> {

          GameBox_Core.Root.close();
            
        });
        
        
      
        menu_pane.getChildren().addAll(text_pane);
          
            return menu_scene; 
      }

    public static Scene getMenu_scene() {
        return menu_scene;
    }
      
}
