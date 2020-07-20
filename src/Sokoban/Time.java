package Sokoban;

import java.io.IOException;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Time {

    public static Integer moves = 0;
    public static Integer seconds = 0;
    public static Text time_text;
    public static Text move_text;
    public static VBox layout = new VBox();
    public static Timeline timer = new Timeline();
    public static Alert alert = new Alert(AlertType.NONE);
    public static Optional<ButtonType> option;

    public static void setlayout() {

        Time.layout.setLayoutX(900);
        Time.layout.setLayoutY(50);
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
                time_text.setText("Time :" + s + " ");
            }
        });
        timer.getKeyFrames().add(frame);
        timer.playFromStart();
    }

    public static void show_moves_number(Integer x) {
        Time.move_text.setText("Moves :  " + x.toString());
    }

    public static void time_score_move() throws IOException {

        //   make_text_field(time.time_text);
        time_text = new Text();
        move_text = new Text();
        time_text.setId("for3");
        move_text.setId("for3");

        time_text.setText("time :" + "00:00" + " ");
        dotime();

        show_moves_number(0);

        Time.layout.getChildren().addAll(Time.time_text, Time.move_text);
        setlayout();

    }

}
