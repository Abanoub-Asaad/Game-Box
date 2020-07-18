/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import Arkanoid.MenuDesign.MenuBox;
import Arkanoid.MenuDesign.MenuItem;
import Arkanoid.MenuDesign.Title;
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

public class Menu {

    PlayerNameFile playerFile_obj = new PlayerNameFile();
    private static final int width = 1350;
    private static final int height = 700;

    static Scene sceneButtons;
    private AnchorPane pane1_buttons;

    private MenuItem START, HIGH_SCORES, SETTINGS, DRAW_YOUR_LEVEL, ENEMY, EXIT;

    Setting setting_obj;

    static Image cursor_img = new Image("Resources/Arkanoid/yellowCursor2.png", 200, 150, false, false);
    static Image cursor_img_hand = new Image("Resources/Arkanoid/hoverCursor2.png", 200, 150, false, false);

    public Menu(Stage Arkanoid_main) {

        pane1_buttons = new AnchorPane();
        createBackground();
        Title title = new Title("A R K A N O I D");
        title.setTranslateX(100);
        title.setTranslateY(200);

        Intialize();
        MenuBox VBox = new MenuBox(START, HIGH_SCORES, SETTINGS, DRAW_YOUR_LEVEL, ENEMY, EXIT);
        pane1_buttons.getChildren().addAll(title, VBox);
        VBox.setTranslateX(100);
        VBox.setTranslateY(300);

        AccessMenu(Arkanoid_main);

        Sound.mediaPlayer_Menu_Back.stop();
        Sound.mediaPlayer_Menu_Back.play();

        sceneButtons.setCursor(new ImageCursor(cursor_img));

    }

    private void Intialize() {
        START = new MenuItem("START ARKANOID");
        HIGH_SCORES = new MenuItem("HIGH SCORES");
        SETTINGS = new MenuItem("SETTINGS");
        DRAW_YOUR_LEVEL = new MenuItem("DRAW YOUR LEVEL");
        ENEMY = new MenuItem("ENEMY");
        EXIT = new MenuItem("EXIT");
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
            Sound.mediaPlayer_menu.stop();
            Sound.mediaPlayer_menu.play();
            try {
                Arkanoid_main_stage.setScene(playerFile_obj.MakeScene_PlayerName(Arkanoid_main_stage));
                Arkanoid_main_stage.setTitle("Arkanoid - Enter Your Name");

            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        HIGH_SCORES.setOnMousePressed(e -> {
            Sound.mediaPlayer_menu.stop();
            Sound.mediaPlayer_menu.play();
             try 
             {
                 Score score = new Score();
                 score.score(Arkanoid_main_stage);
             }
             catch (IOException ex) 
             {
                 Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
        SETTINGS.setOnMousePressed(e -> {
            Sound.mediaPlayer_menu.stop();
            Sound.mediaPlayer_menu.play();
            setting_obj = new Setting(Arkanoid_main_stage);
        });

        DRAW_YOUR_LEVEL.setOnMousePressed(e -> {
            Sound.mediaPlayer_menu.stop();
            Sound.mediaPlayer_menu.play();
            DrawyourLevel drawLevel = new DrawyourLevel (Arkanoid_main_stage) ;  
        });

        EXIT.setOnMousePressed(e -> {
            Sound.mediaPlayer_menu.play();
            Arkanoid_main_stage.hide();
        });

        ENEMY.setOnMousePressed(e -> {
            Sound.mediaPlayer_menu.stop();
            Sound.mediaPlayer_menu.play();
            Enemy enemy_obj = new Enemy(Arkanoid_main_stage);
        });

        sceneButtons = new Scene(pane1_buttons, 1370, 750);
        Arkanoid_main_stage.setScene(sceneButtons);
    }
}
