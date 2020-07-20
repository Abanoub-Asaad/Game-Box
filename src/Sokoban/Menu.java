package Sokoban;

import GameLoop.GameBox_Core;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import Sokoban.Select_Level.*;
import static Sokoban.score.file_unlockedLvls;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javafx.animation.Timeline;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Sokoban_menu_particle.Menu_particle;
import Sokoban_menu_particle.GNButton;
import Sokoban_menu_particle.ButtonType;

import Sokoban_menu_particle.Settings;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Menu {

    public static Pane layerPane = new Pane();
    public static BorderPane root = new BorderPane();
    public static Scene scene = new Scene(root, 1370, 750);
    private static VBox text_pane = new VBox(22);

    private static GNButton new_game_btn = new GNButton("NEW GAME");
    private static GNButton continue_btn = new GNButton("CONTINUE");
    private static GNButton mode43_btn = new GNButton(" PRACTICE ");
    private static GNButton setting_btn = new GNButton("Back");
    private static GNButton exit_btn = new GNButton("EXIT");

    static Timeline timeline;

    //==============================================//
    private static List<Image> imageArrayList = new ArrayList<Image>();
    static int count = 0;

    static ImageView slideshowImageView = new ImageView();

    //==============================================//
    public static Scene openMenu_sokoban() {

        scene.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());
        new_game_btn.setId("menubutton");
        continue_btn.setId("menubutton");
        mode43_btn.setId("menubutton");
        exit_btn.setId("menubutton");
        setting_btn.setId("menubutton");

        layerPane.setId("menupane");
        new_game_btn.setLayoutX(100);
        new_game_btn.setLayoutY(100);

        text_pane.setLayoutX(540);
        text_pane.setLayoutY(200);
        text_pane.setPrefSize(280, 400);
        //text_pane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));

        text_pane.getChildren().addAll(new_game_btn, continue_btn,mode43_btn, setting_btn, exit_btn);

        new_game_btn.setButtonType(ButtonType.ALTERNATE);
        new_game_btn.setOnMouseClicked(e -> {

            try {
                GameBox_Core.Root.setScene(start_level.store_name());
                deleteContentOfSelectLevelFileAndIntializeToOne();

            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        continue_btn.setLayoutX(100);
        continue_btn.setLayoutY(150);

        continue_btn.setOnMouseClicked(e -> {

            Page1 page1_obj = new Page1();

            try {
                page1_obj.IntializePage1(GameBox_Core.Root);
//                Map.tmp_Level=1;
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        mode43_btn.setOnMouseClicked(e -> {
            Buttons.check_mode43 = true;
            try {
                Sokoban_Main.getInstanceFromSokoban().openSokobanMain(GameBox_Core.Root);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            GameBox_Core.Root.setScene(Sokoban_Main.sokoban_scene);

        });

        setting_btn.setLayoutX(100);
        setting_btn.setLayoutY(200);

        setting_btn.setOnMouseClicked(e -> {

        });

        exit_btn.setLayoutX(100);
        exit_btn.setLayoutY(250);
        exit_btn.setOnMouseClicked(e -> {

            GameBox_Core.Root.close();

        });
// BackgroundImage myBI= new BackgroundImage(new Image("Resources/Sokoban/black.jpg",32,32,false,true),
//        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//          BackgroundSize.DEFAULT);
//       
//   //addind buttons
        layerPane.getChildren().add(text_pane);
//   Menu_particle.layerPane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        return scene;
    }

    /**
     * delete every thing in the file of levels that used in select level then
     * make the file start from level one
     *
     * @throws IOException
     */
    private static void deleteContentOfSelectLevelFileAndIntializeToOne() throws IOException {
        Map.tmp_Level = 1;
        PrintWriter writer = new PrintWriter(file_unlockedLvls);
        writer.print("");
        writer.close();
        FileWriter filewriter_ = new FileWriter(file_unlockedLvls, true);
        BufferedWriter bufferwriter_ = new BufferedWriter(filewriter_);
        bufferwriter_.write("1");
        bufferwriter_.newLine();
        bufferwriter_.close();
        filewriter_.close();
    }

    public static void start() {

        Image a = new Image("Resources/Sokoban/menu1.jpg", 1375, 750, false, false);
        Image b = new Image("Resources/Sokoban/menu2.jpg", 1375, 750, false, false);
        Image c = new Image("Resources/Sokoban/menu3.jpg", 1375, 750, false, false);

        imageArrayList.add(c);
        imageArrayList.add(b);
        imageArrayList.add(a);
        layerPane.getChildren().addAll(slideshowImageView);
// then in your method

        long delay = 2000; //update once per 2 seconds.
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                slideshowImageView.setImage(imageArrayList.get(count++));
                if (count >= imageArrayList.size()) {
                    count = 0;
                }
            }
        }, 0, delay);

    }
}
