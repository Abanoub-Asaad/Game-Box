/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import GameLoop.GameBox;
import static Sokoban.start_level.scene_StoreName;
import static Sokoban.time.timer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author Eng.Waleed
 */
public class welcome_scene {
   
  //  Image i = new Image("https://i.pinimg.com/originals/5c/86/21/5c86215897ba8c64575dca3f77b93844.gif"); 
   // ImageView   imageview= new ImageView(i);
           
  public static    start_level n = new start_level() ;
  public  static   Pane  pane_welcome = new Pane();
 
 // public  static   Scene scene_welcome= new Scene(pane_welcome,1375,750);
  public static     Button btn;     
  public static  Text welcome_text; 
  
  public static Pane make_welcome_scene(){
      
       btn   = new Button("start"); 
       welcome_text= new Text(300,200,"welcome");
       welcome_text.setId("title");
       
     // scene_welcome.getStylesheets().add(welcome_scene.class.getResource("css1.css").toExternalForm());
       scene_StoreName.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());
         pane_welcome.setId("pan2");
         btn.setLayoutX(450);
         btn.setLayoutY(390);
         btn.setId("welcome");
         btn.setOnAction(e -> 
          {
              
           try {
               scene_StoreName.setRoot(start_level.store_name());
            
           } catch (IOException ex) {
               Logger.getLogger(welcome_scene.class.getName()).log(Level.SEVERE, null, ex);
           }
            } );
            
       
         pane_welcome.getChildren().addAll(btn,welcome_text);
       
       
       
       
 //   return scene_welcome;    
      return pane_welcome;
    }
    
    
    
    
}
