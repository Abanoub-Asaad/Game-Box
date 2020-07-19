
package Tetris;

import GameLoop.GameBox_Core;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

/**
 *
 * @author Eng.Waleed
 */
public class Tetris_Menu {
    
   
 private static VBox text_pane = new VBox(22);
 static Image m=new Image("Resources/Tetris/Effect.png",470,750,false ,false) ;
 static  ImageView mv= new ImageView(m);
 static  ImageView mv2= new ImageView(m);
 static Pane menu=new Pane();
 static Scene scene = new Scene(menu,1370,750);
 static Button new_game_btn= new Button("New game ");
 static Button setting_btn= new Button("Setting");
 static Button exit_btn= new Button("Exit");

  public  static Scene start (){
      
  //Font.loadFont(  getClass().getResourceAsStream("/font.ttf"), 16);
       scene.getStylesheets().add(Tetris_Menu.class.getResource("cs.css").toExternalForm());
        text_pane.getChildren().addAll(new_game_btn,  setting_btn, exit_btn);
        menu.getChildren().addAll(mv,mv2,text_pane);
        mv.setLayoutX(0);
        mv.setLayoutY(0);
        mv2.setLayoutX(1370-470);
        mv2.setLayoutY(0);
        menu.setStyle("-fx-background-color: black" );
        
        new_game_btn.setLayoutX(100);
        new_game_btn.setLayoutY(100);
        
        text_pane.setLayoutX(580);
        text_pane.setLayoutY(180);
        text_pane.setPrefSize(280, 400);
        setting_btn.setLayoutX(100);
        setting_btn.setLayoutY(150);
        
        exit_btn.setLayoutX(100);
        exit_btn.setLayoutY(200);
        
        new_game_btn.setOnAction(e->{
           
        Tetris_Main.getInstanceFromTetris().start_Tetris(GameBox_Core.Root);
        GameBox_Core.Root.setScene(Tetris_Main.Tetris_scene);
        });
         exit_btn.setOnMouseClicked(e -> {

            GameBox_Core.Root.close();

        });
         exit_btn.setId("btn");
         new_game_btn.setId("btn");
         setting_btn.setId("btn");
         
     return scene;
        
    }
}
