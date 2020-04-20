
package Sokoban;

import GameLoop.GameBox_Core;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Sokoban.Select_Level.*;

public class Menu {

    private static Pane menu_pane = new Pane();
    private static VBox text_pane = new VBox(22);
    
    private static Button new_game_btn = new Button(" NEW GAME ");
    private static Button continue_btn = new Button (" CONTINUE ");
     private static Button setting_btn = new Button(" SETTING ");
    private static Button exit_btn = new Button(" EXIT ");
   
    
    public static Scene menu_scene = new Scene(menu_pane, 1375, 750);

    public static Pane getMenu_pane() {
        return menu_pane;
    }
      
      public static Scene MenuStyle(){
         
        menu_scene.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());
        
        new_game_btn.setId("menubutton");
        continue_btn.setId("menubutton");
        exit_btn.setId("menubutton");
        setting_btn.setId("menubutton");
        
        
        menu_pane.setId("menupane");
        new_game_btn.setLayoutX(100);
        new_game_btn.setLayoutY(100);  
    
        text_pane.setLayoutX(540);
        text_pane.setLayoutY(180); 
        text_pane.setPrefSize(280, 400);
        text_pane.getChildren().addAll(new_game_btn,continue_btn,setting_btn,exit_btn);
        
        new_game_btn.setOnAction(e -> {

              try {
                GameBox_Core.Root.setScene(start_level.store_name());
           } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        });

        continue_btn.setLayoutX(100);
        continue_btn.setLayoutY(150);
          
        continue_btn.setOnAction(e -> {

              Page1 page1_obj = new Page1();
              
            try {
                page1_obj.IntializePage1(GameBox_Core.Root);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            
        });
        
        setting_btn.setLayoutX(100);
        setting_btn.setLayoutY(200);
        
        
        setting_btn.setOnAction(e -> {


            
        });
        
        exit_btn.setLayoutX(100);
        exit_btn.setLayoutY(250);
        exit_btn.setOnAction(e -> {

          GameBox_Core.Root.close();
            
        });
      
        menu_pane.getChildren().addAll(text_pane);
          
            return menu_scene; 
      }

    public static Scene getMenu_scene() {
        return menu_scene;
    }
      
}
