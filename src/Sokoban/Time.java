package Sokoban;

import static Sokoban.map.startlevel;
import java.io.IOException;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Eng.Waleed
 */
public class time {

    public static Integer moves = 0;
    public static Integer seconds = 0;
    public static Text time_text;
    public static Text move_text ;
    public static VBox layout = new VBox();
 //   public static Text time_text_newscene = new Text();
 //   public static Text mov_text_newscene = new Text();
    public static Timeline timer = new Timeline();
    public static Alert alert = new Alert(AlertType.NONE);
    public static Optional<ButtonType> option ;

    public static void setlayout() {

        time.layout.setLayoutX(900);
        time.layout.setLayoutY(50);
    }

   
/*
    public static void make_text_field(Text text) {
        
         text= new Text();
        time.layout.getChildren().add(text);
        text.setStroke(Color.CYAN);
        text.setFont(new Font("Arial", 40));
        text.setFill(Color.DARKBLUE);

    }
*/
    public static void dotime() {

      
    
        timer.setCycleCount(Timeline.INDEFINITE);
        if (timer != null) {
            timer.stop();
        }

        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                seconds++;
                
              
        
                String s = String.format("%02d:%02d", seconds / 60, seconds % 60);
                time_text.setText("time :" + s + " ");
            }
        });
        timer.getKeyFrames().add(frame);
        timer.playFromStart();
    }

    public static void show_moves_number(Integer x) {
        time.move_text.setText("moves :  " + x.toString());
    }
    
    
    
  public static void time_score_move() throws IOException{
      
      //   make_text_field(time.time_text);
     time_text = new Text(); 
      move_text = new Text();
      time_text.setId("for3");
      score.score_text.setId("for3");
      move_text.setId("for3");
        
      time_text.setText("time :" +"00:00" + " ");
          dotime();
      
      //   make_text_field(time.move_text);
         show_moves_number(0);
         
        // make_text_field(score.score_text);
      
         score.score_text.setText("score  :"+"0");
        
         time.layout.getChildren().addAll(time.time_text,time.move_text);
         setlayout();
         
     
   }
  
  
}
