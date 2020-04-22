
package Sokoban;

import GameLoop.GameBox_Core;
import static Sokoban.Map.startlevel;
import static Sokoban.Time.move_text;
import static Sokoban.Time.option;
import static Sokoban.Time.time_text;
import static Sokoban.Time.timer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Eng.Waleed
 */
public class finish_level {
    
   public  static   int nLevel_in_score_file = 1;  
   static  Pane pane_finish= new Pane() ; 
   static  Pane pane= new Pane() ;
   
   protected  static   Scene scene_finish= new Scene(pane,1350,750); 
     static   GameBox_Core get_root = new GameBox_Core(); 
   //---------------------------------------------//
   // Texts refer to (score & time & nMoves ) for specific player which is displayed at the end of each level
   // to show the player his numbers in this level 
   static  Text text_of_score= new Text(190,175,"0");
   static  Text text_of_time = new Text(590,175,"00:00");
   static  Text text_of_move = new Text(950,175,"0");
   
   //---------------------------------------//
   final  static  Text text_of_title = new Text(450,100, " you win ! ");
   static   Button next_level  = new Button("continue"); 
   static   Button cancel  = new Button("cancel");

      
    public static void   style (){
        
       scene_finish= new Scene(pane_finish,1375,750); 
       
        scene_finish.getStylesheets().add(finish_level.class.getResource("css1.css").toExternalForm());
        Image img=new Image("Resources/Sokoban/back.png",1375,750,false,true);
        ImageView iv = new ImageView(img);
        pane_finish.getChildren().add(iv);
      
        text_of_time.setId("fancytext");
        text_of_move.setId("fancytext");
        text_of_score.setId("fancytext");
        next_level.setId("btn");
        cancel.setId("btn");
        pane_finish.getChildren().addAll(text_of_title);
        rank.show_score_pane.setLayoutX(350);
        rank.show_score_pane.setLayoutY(250);
        rank.show_score_pane.setPrefSize(600, 500);
        finish_level.pane_finish.getChildren().addAll(rank.show_score_pane );
        next_level.setLayoutX(250);
        next_level.setLayoutY(675);
        
        
        cancel.setLayoutX(900);
        cancel.setLayoutY(675);
        
        
        pane_finish.getChildren().addAll  (text_of_move,text_of_score,text_of_time,cancel,next_level);
        
         
      }
    
      public static   Scene finish_scene()  {
       
        text_of_score.setText(score.score_text.getText());
        text_of_time.setText(Time.time_text.getText());
        text_of_move.setText(Time.move_text.getText());
        
         
           timer.stop();
           
          next_level.setOnAction(e-> {
            
            
              nLevel_in_score_file++;
              score.score=0;
              Time.seconds=0;
              Time.time_text.setText("time :" +"00:00" + " ");
              Time.show_moves_number(0);
              Time.timer.play();
              Map.startlevel(1);
              GameBox_Core.Root.setScene(Sokoban_Main.sokoban_scene);
                
        
             });
       
          cancel.setOnAction(e->{
          GameBox_Core.Root.close();
           
             });
      
      return scene_finish;  
      
      }
     
    public finish_level() {
      
    }
    
  
    
}

