/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

import static Sokoban.Map.tmp_Level;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author egypt
 */
public class Buttons {

    static boolean check_mode43 = false;
    private static Image next_btn_img = new Image("Resources/Sokoban/next.jpg");
    private static Image prev_btn_img = new Image("Resources/Sokoban/prev.jpg");
    private static Image repeat_btn_img = new Image("Resources/Sokoban/repeat.jpg");
    public static ImageView nextbtn_iv = new ImageView(next_btn_img), prevbtn_iv = new ImageView(prev_btn_img), repeat_IV = new ImageView(repeat_btn_img);

    public static void practicebuttons() {
        nextbtn_iv.setX(1000);
        nextbtn_iv.setY(50);
        nextbtn_iv.setFitWidth(128);
        nextbtn_iv.setFitHeight(128);
        prevbtn_iv.setX(850);
        prevbtn_iv.setY(50);
        prevbtn_iv.setFitWidth(128);
        prevbtn_iv.setFitHeight(128);

        nextbtn_iv.setOnMousePressed(event -> {
            Map.startlevel(++tmp_Level);

        });
        if (tmp_Level != 1) {
            prevbtn_iv.setOnMousePressed(event -> {
                Map.startlevel(--tmp_Level);

            });

        }
    }

    public static void drawrepeatbutton() {
        repeat_IV.setX(1000);
        repeat_IV.setY(200);
        repeat_IV.setFitWidth(128);
        repeat_IV.setFitHeight(128);
        
        repeat_IV.setOnMousePressed(event -> {
            if(!check_mode43){
            Time.moves = 0;
            Time.seconds = 0;
            }
            Map.startlevel(tmp_Level);

        });
    }
}
