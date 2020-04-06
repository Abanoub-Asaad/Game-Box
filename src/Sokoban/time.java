/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import static Sokoban.map.startlevel;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
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
    public static Text time_text = new Text();
    public static Text move_text = new Text();
    public static HBox layout = new HBox();
 //   public static Text time_text_newscene = new Text();
 //   public static Text mov_text_newscene = new Text();
    public static Timeline timer = new Timeline();
    public static Alert alert = new Alert(AlertType.NONE);
    public static Optional<ButtonType> option ;

    public static void setlayout() {

        time.layout.setLayoutX(900);
        time.layout.setLayoutY(50);
    }

    public static void SetinformationBox() {
        
        alert.setAlertType(AlertType.INFORMATION);
        alert.setTitle(""); ///put any title 
        alert.setHeaderText("your progress at level " + map.level);
        alert.setContentText("you finished that level in " + time_text.getText()
                + "  and you make " + move_text.getText() + " move in that level ");
        
        timer.stop();
     
        option = alert.showAndWait();
        
            if (time.option.get() == ButtonType.OK) 
            {
                startlevel();  
             time.time_text.setText("time :" +"00:00" + " ");
             time.show_moves_number(0);
             timer.play();
           
            }
            else if (time.option.get() == ButtonType.CANCEL) 
            {
                //return to the main or board scene             
        }
    }

    public static void make_text_field(Text text) {

        time.layout.getChildren().add(text);
        text.setStroke(Color.CYAN);
        text.setFont(new Font("Arial", 40));
        text.setFill(Color.DARKBLUE);

    }

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

}
