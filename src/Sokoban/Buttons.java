
package Sokoban;

import static Sokoban.Map.tmp_Level;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class Buttons {

    static boolean check_mode43 = false, checknewgame = false;
    private static Image next_btn_img = new Image("Resources/Sokoban/next.png");
    private static Image prev_btn_img = new Image("Resources/Sokoban/prev.png");
    private static Image repeat_btn_img = new Image("Resources/Sokoban/repeat.png");
    public static ImageView nextbtn_iv = new ImageView(next_btn_img), prevbtn_iv = new ImageView(prev_btn_img), repeat_IV = new ImageView(repeat_btn_img);
    public static Text playername_txt = new Text(), level_txt = new Text();

    public static void practicebuttons() {
        nextbtn_iv.setX(1150);
        nextbtn_iv.setY(50);
        nextbtn_iv.setFitWidth(128);
        nextbtn_iv.setFitHeight(128);
        if (!checknewgame) {
            Buttons.prevbtn_iv.setX(1200);
            Buttons.prevbtn_iv.setY(200);
        } else {
            prevbtn_iv.setX(1000);
            prevbtn_iv.setY(50);
        }
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
            if (!check_mode43) {
                Time.moves = 0;
                Time.seconds = 0;
            }
            Map.startlevel(tmp_Level);

        });
    }

    public static void setnameandlevel() {

        playername_txt.setX(1000);
        playername_txt.setY(80);
        level_txt.setY(45);
        level_txt.setX(1000);
        level_txt.setId("for3");
        playername_txt.setId("for3");
        level_txt.setText("Level: " + tmp_Level);
        playername_txt.setText("Name: " + start_level.PlayerName_string);

    }

}
