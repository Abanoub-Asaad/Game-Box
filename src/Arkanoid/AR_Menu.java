package Arkanoid;

import Arkanoid.MenuDesign.MenuBox;
import Arkanoid.MenuDesign.MenuItem;
import Arkanoid.MenuDesign.Title;
import GameLoop.GameBox_Core;
import GameLoop.Games;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AR_Menu {

    PlayerNameFile playerFile_obj = new PlayerNameFile();
    private static final int width = 1350;
    private static final int height = 700;
    public static int count_for_back_btn = 0;
    private static AnchorPane pane1_buttons = new AnchorPane();
    public static Scene sceneButtons = new Scene(pane1_buttons, 1370, 750);
    ;
   

    private MenuItem START, HIGH_SCORES, SETTINGS, DRAW_YOUR_LEVEL, ENEMY, EXIT, BACK;

    Setting setting_obj;

    static Image cursor_img = new Image("Resources/Arkanoid/yellowCursor2.png", 200, 150, false, false);
    static Image cursor_img_hand = new Image("Resources/Arkanoid/hoverCursor2.png", 200, 150, false, false);

    public AR_Menu(Stage Arkanoid_main) {

        //  pane1_buttons ;
        createBackground();
        Title title = new Title("A R K A N O I D");
        title.setTranslateX(100);
        title.setTranslateY(200);

        Intialize();
        MenuBox VBox = new MenuBox(START, HIGH_SCORES, SETTINGS, DRAW_YOUR_LEVEL, ENEMY, BACK, EXIT);
        pane1_buttons.getChildren().addAll(title, VBox);
        VBox.setTranslateX(100);
        VBox.setTranslateY(300);

        AccessMenu(Arkanoid_main);

        AR_Sound.mediaPlayer_Menu_Back.stop();
        AR_Sound.mediaPlayer_Menu_Back.play();

        sceneButtons.setCursor(new ImageCursor(cursor_img));

    }

    private void Intialize() {
        START = new MenuItem("START ARKANOID");
        HIGH_SCORES = new MenuItem("HIGH SCORES");
        SETTINGS = new MenuItem("SETTINGS");
        DRAW_YOUR_LEVEL = new MenuItem("DRAW YOUR LEVEL");
        ENEMY = new MenuItem("ENEMY");
        EXIT = new MenuItem("EXIT");
        BACK = new MenuItem("BACK");
    }

    private void createBackground() {
        Image Imageback = new Image("Resources/Arkanoid/bb.jpg", 1500, 780, false, true);
        BackgroundImage background
                = new BackgroundImage(Imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        pane1_buttons.setBackground(new Background(background));

    }

    //namefile.enter_name_scene
    public void AccessMenu(Stage Arkanoid_main_stage) {
        START.setOnMousePressed(event -> {
            AR_Sound.mediaPlayer_menu.stop();
            AR_Sound.mediaPlayer_menu.play();
            try {
                Arkanoid_main_stage.setScene(playerFile_obj.MakeScene_PlayerName(Arkanoid_main_stage));
                Arkanoid_main_stage.setTitle("Arkanoid - Enter Your Name");

            } catch (IOException ex) {
                Logger.getLogger(AR_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        BACK.setOnMousePressed(event -> {
            AR_Sound.mediaPlayer_menu.stop();
            AR_Sound.mediaPlayer_menu.play();
            AR_Sound.mediaPlayer_background.stop();
            AR_Sound.mediaPlayer_background.seek(Duration.ZERO);
            GameBox_Core.Root.setScene(Games.gamesScene);
            count_for_back_btn++;

        });

        HIGH_SCORES.setOnMousePressed(e -> {
            AR_Sound.mediaPlayer_menu.stop();
            AR_Sound.mediaPlayer_menu.play();
            try {
                Score score = new Score();
                score.score(Arkanoid_main_stage);
            } catch (IOException ex) {
                Logger.getLogger(AR_Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        SETTINGS.setOnMousePressed(e -> {
            AR_Sound.mediaPlayer_menu.stop();
            AR_Sound.mediaPlayer_menu.play();
            setting_obj = new Setting(Arkanoid_main_stage);
            AR_Sound.mediaPlayer_Menu_Back.stop();
        });

        DRAW_YOUR_LEVEL.setOnMousePressed(e -> {
            AR_Sound.mediaPlayer_menu.stop();
            AR_Sound.mediaPlayer_menu.play();
            DrawyourLevel drawLevel = new DrawyourLevel(Arkanoid_main_stage);
        });

        EXIT.setOnMousePressed(e -> {
            AR_Sound.mediaPlayer_menu.play();
            Arkanoid_main_stage.hide();
        });

        ENEMY.setOnMousePressed(e -> {
            AR_Sound.mediaPlayer_menu.stop();
            AR_Sound.mediaPlayer_menu.play();
            Enemy enemy_obj = new Enemy(Arkanoid_main_stage);
        });

        //sceneButtons = 
        Arkanoid_main_stage.setScene(sceneButtons);
    }
}
