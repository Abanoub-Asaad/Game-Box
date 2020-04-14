/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import GameLoop.GameBox;
import static Sokoban.Time.move_text;
import static Sokoban.Time.time_text;
import static Sokoban.Time.timer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Eng.Waleed
 */
public class finish_level {

    public static int i = 1;
    public static Pane pane_finish = new Pane();
    public static Pane pane = new Pane();

    public static Scene scene_finish = new Scene(pane, 1350, 750);
    public static GameBox get_root = new GameBox();
    public static Text text_of_score = new Text(190, 175, "0");
    public static Text text_of_time = new Text(590, 175, "00:00");
    public static Text text_of_move = new Text(950, 175, "0");
    public static Text text_of_title = new Text(450, 100, " you win ! ");
    public static Button next_level = new Button("continue");
    public static Button cancel = new Button("cancel");

    public static start_level s = new start_level();

    public static void style() {

        scene_finish = new Scene(pane_finish, 1375, 750);

        scene_finish.getStylesheets().add(finish_level.class.getResource("css1.css").toExternalForm());
        Image img = new Image("Resources/Sokoban/back.png", 1375, 750, false, true);
        ImageView iv = new ImageView(img);
        pane_finish.getChildren().add(iv);

        text_of_time.setId("fancytext");
        text_of_move.setId("fancytext");
        text_of_score.setId("fancytext");
        next_level.setId("btn");
        cancel.setId("btn");
        pane_finish.getChildren().addAll(text_of_title);
        rank.inside.setLayoutX(350);
        rank.inside.setLayoutY(250);
        rank.inside.setPrefSize(600, 500);
        finish_level.pane_finish.getChildren().addAll(rank.inside);
        next_level.setLayoutX(250);
        next_level.setLayoutY(675);

        cancel.setLayoutX(900);
        cancel.setLayoutY(675);

        pane_finish.getChildren().addAll(text_of_move, text_of_score, text_of_time, cancel, next_level);

    }

    public static Scene finish_scene(Stage stage) {

        text_of_score.setText(score.score_text.getText());
        text_of_time.setText(time_text.getText());
        text_of_move.setText(move_text.getText());

        timer.stop();

        next_level.setOnAction(e -> {

            i++;
            score.score = 0;
            Time.seconds = 0;
            Time.time_text.setText("time :" + "00:00" + " ");
            Time.show_moves_number(0);
            Time.timer.play();
            Map.startlevel();
            GameBox.Root.setScene(Sokoban_Main.sokoban_scene);

        });

        cancel.setOnAction(e -> {
            GameBox.Root.close();

        });

        return scene_finish;

    }

    public finish_level() {

    }

}
