package GameLoop;

import Sokoban.Menu;
import Sokoban.Sound;
import Sokoban.finish_level;
import Sokoban_menu_particle.Menu_particle;

import Tetris.Tetris_Menu;
import TicTacToe.Tic_Menu;
import Arkanoid.AR_Menu;
import Sokoban.Sokoban_Main;
import Sokoban.Time;
import Sokoban.start_level;
import Tetris.Tetris_Main;
import Tetris.Tetris_sound;
import TicTacToe.XO_Main;
import TicTacToe.player1_2;
import TicTacToe.sound;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Games {

    static Tic_Menu tic = new Tic_Menu();
    // static  Menu_particle menu_particle = new Menu_particle();
    private static Group gamesGroup = new Group();
    private final HBox gamesHBox = new HBox();
    public static Scene gamesScene = new Scene(gamesGroup, 1400, 780);
    //============= Counters for esc
    static int soko_esc = 0;
    static int tetris_esc = 0;
    static int Arkanoid_esc = 0;
    static int tic_esc = 0;

    //=====================//
    static void for_esc() {

        GameBox_Core.Root.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {

            if (e.getCode() == KeyCode.ESCAPE) {

                if (GameBox_Core.Root.getScene() == Menu.scene) {
                    GameBox_Core.Root.setScene(gamesScene);
                    soko_esc++;
                } else if (GameBox_Core.Root.getScene() == start_level.scene_StoreName) {
                    GameBox_Core.Root.setScene(Menu.scene);

                } else if (GameBox_Core.Root.getScene() == Tetris_Menu.scene) {
                    GameBox_Core.Root.setScene(gamesScene);
                    tetris_esc++;
                } else if (GameBox_Core.Root.getScene() == Tic_Menu.menu_scene) {
                    GameBox_Core.Root.setScene(gamesScene);
                    tic_esc++;
                } else if (GameBox_Core.Root.getScene() == AR_Menu.sceneButtons) {
                    GameBox_Core.Root.setScene(gamesScene);
                    Arkanoid_esc++;
                } else if (GameBox_Core.Root.getScene() == Sokoban_Main.sokoban_scene) {

                    GameBox_Core.Root.setScene(Menu.scene);
                    Time.layout.getChildren().clear();
                    Sound.mediaPlayer_back.stop();
                    Sound.mediaPlayer_back.seek(Duration.ZERO);
                } else if (GameBox_Core.Root.getScene() == Tetris_Main.Tetris_scene) {
                    GameBox_Core.Root.setScene(Tetris_Menu.scene);
                    Tetris_Main.tetris_pane.getChildren().clear();
                    Tetris_sound.mediaPlayer_back.stop();
                    Tetris_sound.mediaPlayer_back.seek(Duration.ZERO);
                    Tetris_Main.task.cancel();

                } else if (GameBox_Core.Root.getScene() == Tetris_Main.help_scene_tetris) {
                    GameBox_Core.Root.setScene(Tetris_Menu.scene);
                } //           else  if(GameBox_Core.Root.getScene()==ArkanoidMain.Arkanoid_scene){
                //                 GameBox_Core.Root.setScene(AR_Menu.sceneButtons);
                //                // ArkanoidMain.root.getChildren().clear();
                //                 Arkanoid_Map.level=1;
                //                 AR_Sound.mediaPlayer_background.stop();
                //                 AR_Sound.mediaPlayer_background.seek(Duration.ZERO);
                //           }
                else if (GameBox_Core.Root.getScene() == XO_Main.XO_scene) {
                    GameBox_Core.Root.setScene(Tic_Menu.menu_scene);
                    XO_Main.XO_group.getChildren().clear();
                    sound.mediaPlayer_back.stop();
                    sound.mediaPlayer_back.seek(Duration.ZERO);
                } else if (GameBox_Core.Root.getScene() == player1_2.scene) {
                    GameBox_Core.Root.setScene(Tic_Menu.menu_scene);
                    //   player1_2.root.getChildren().clear();
                    sound.mediaPlayer_back.stop();
                    sound.mediaPlayer_back.seek(Duration.ZERO);
                    Tic_Menu.count_esc_playe1_2_scene++;
                }

            }

        });

    }

    public Games(Stage gamesStage) {

        finish_level.style();
        gamesStage.setMaximized(true);
        gamesStage.setResizable(false);
        gamesStage.setScene(gamesScene);
        gamesStage.setTitle("Game Box");
        createBackground();
        createButtons(gamesStage);
        textChooseYourGame();
        gamesStage.show();

    }

    private void createBackground() {

        Image Imageback = new Image("Resources/gamesPage/home_back.jpg", 1370, 780, false, false);
        Image image = new Image("Resources/gamesPage/gamebox.png", 150, 150, true, false);

        ImageView ImagbackIV = new ImageView(Imageback);
        ImageView ImageIV = new ImageView(image);
        ImageIV.setX(600);
        ImageIV.setY(25);

        gamesGroup.getChildren().addAll(ImagbackIV, ImageIV);
    }

    private void createButtons(Stage MainStage) {

        Button SokobanBtn = new Button();
        SokobanBtn.setLayoutX(300);
        SokobanBtn.setLayoutY(250);
        Image sokobanImage = new Image("Resources/gamesPage/socopan.png", 200, 300, true, false);
        ImageView sokobanImageIV = new ImageView(sokobanImage);
        SokobanBtn.setGraphic(sokobanImageIV);
        SokobanBtn.setOnMousePressed(event -> {
            if (Menu.count_for_back_btn > 0 || soko_esc > 0) {
                MainStage.setScene(Menu.scene);
            } else {
                Menu_particle.start();
                try {
                    MainStage.setScene(Menu.openMenu_sokoban());
                } catch (IOException ex) {
                    Logger.getLogger(Games.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gamesGroup.getChildren().add(SokobanBtn);

        Button TetrisBtn = new Button();
        TetrisBtn.setLayoutX(550);
        TetrisBtn.setLayoutY(250);
        Image tetrisImage = new Image("Resources/gamesPage/tetris.png", 300, 300, true, false);
        ImageView tetrisImageIV = new ImageView(tetrisImage);
        TetrisBtn.setGraphic(tetrisImageIV);

        TetrisBtn.setOnMousePressed(event -> {
            if (Tetris_Menu.count_for_back_btn > 0 || tetris_esc > 0) {
                MainStage.setScene(Tetris_Menu.scene);
            } else {
                MainStage.setScene(Tetris_Menu.start());
            }
        });
        gamesGroup.getChildren().add(TetrisBtn);

        Button ArkanoidBtn = new Button();
        ArkanoidBtn.setLayoutX(900);
        ArkanoidBtn.setLayoutY(250);
        Image arkanoidImage = new Image("Resources/gamesPage/arkanoid.jpg", 200, 200, true, false);
        ImageView arkanoidImageIV = new ImageView(arkanoidImage);
        ArkanoidBtn.setGraphic(arkanoidImageIV);
        ArkanoidBtn.setOnMousePressed(event -> {
            if (AR_Menu.count_for_back_btn > 0 || Arkanoid_esc > 0) {
                MainStage.setScene(AR_Menu.sceneButtons);
            } else {
                Arkanoid.AR_Menu menu = new Arkanoid.AR_Menu(MainStage);
            }
        });
        gamesGroup.getChildren().add(ArkanoidBtn);

        Button TicTacToeBtn = new Button();
        TicTacToeBtn.setLayoutX(600);
        TicTacToeBtn.setLayoutY(470);
        Image xoImage = new Image("Resources/gamesPage/xo.png", 200, 200, true, false);
        ImageView xoImageIV = new ImageView(xoImage);
        TicTacToeBtn.setGraphic(xoImageIV);

        TicTacToeBtn.setOnMousePressed(event -> {

            // XO_Main.getInstanceFromXO().openTicTacToeMain(GameBox_Core.Root);
            try {
                if (Tic_Menu.count_for_back_btn > 0 || tic_esc > 0) {
                    MainStage.setScene(Tic_Menu.menu_scene);
                } else {
                    MainStage.setScene(tic.start());
                }

            } catch (Exception ex) {
                Logger.getLogger(Games.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        gamesGroup.getChildren().add(TicTacToeBtn);

        AnimationOfPage(SokobanBtn, TetrisBtn, ArkanoidBtn, TicTacToeBtn);
        buttonsShadow(SokobanBtn, TetrisBtn, ArkanoidBtn, TicTacToeBtn);

    }

    private void textChooseYourGame() {
        Text choose = new Text();
        choose.setText("Choose Your Game ");
        choose.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
        choose.setFill(Color.GOLD);
        choose.setX(280);
        choose.setY(210);
        gamesGroup.getChildren().add(choose);

        AnimationOfPage(choose);

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setColor(Color.ROSYBROWN);
        shadow.setHeight(5);
        shadow.setWidth(5);
        shadow.setRadius(5);
        shadow.setOffsetX(3);
        shadow.setOffsetY(2);
        shadow.setSpread(12);
        choose.setEffect(shadow);
    }

    private void AnimationOfPage(Button soko, Button tetris, Button arkanoid, Button XO) {
        FadeTransition sokoFade = new FadeTransition(Duration.millis(5000));
        sokoFade.setNode(soko);
        sokoFade.setFromValue(0);
        sokoFade.setToValue(1);
        sokoFade.setCycleCount(1);
        sokoFade.play();
        FadeTransition tetrisFade = new FadeTransition(Duration.millis(5000));
        tetrisFade.setNode(tetris);
        tetrisFade.setFromValue(0);
        tetrisFade.setToValue(1);
        tetrisFade.setCycleCount(1);
        tetrisFade.play();
        FadeTransition arkanoidFade = new FadeTransition(Duration.millis(5000));
        arkanoidFade.setNode(arkanoid);
        arkanoidFade.setFromValue(0);
        arkanoidFade.setToValue(1);
        arkanoidFade.setCycleCount(1);
        arkanoidFade.play();
        FadeTransition xoFade = new FadeTransition(Duration.millis(5000));
        xoFade.setNode(XO);
        xoFade.setFromValue(0);
        xoFade.setToValue(1);
        xoFade.setCycleCount(1);
        xoFade.play();
    }

    private void AnimationOfPage(Text text) {
        FadeTransition textFade = new FadeTransition(Duration.millis(5000));
        textFade.setNode(text);
        textFade.setFromValue(0);
        textFade.setToValue(1);
        textFade.setCycleCount(1);
        textFade.play();

    }

    private void buttonsShadow(Button soko, Button tetris, Button arkanoid, Button xo) {

        DropShadow sokoShadow = new DropShadow();
        sokoShadow.setBlurType(BlurType.THREE_PASS_BOX);
        sokoShadow.setHeight(10);
        sokoShadow.setWidth(10);
        sokoShadow.setSpread(12);
        soko.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            soko.setEffect(sokoShadow);
        });
        DropShadow tetrisShadow = new DropShadow();
        tetrisShadow.setBlurType(BlurType.THREE_PASS_BOX);
        tetrisShadow.setHeight(10);
        tetrisShadow.setWidth(10);
        tetrisShadow.setSpread(12);
        tetris.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            tetris.setEffect(tetrisShadow);
        });
        DropShadow arkanoidShadow = new DropShadow();
        arkanoidShadow.setBlurType(BlurType.THREE_PASS_BOX);
        arkanoidShadow.setHeight(10);
        arkanoidShadow.setWidth(10);
        arkanoidShadow.setSpread(12);
        arkanoid.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            arkanoid.setEffect(arkanoidShadow);
        });

        DropShadow xoShadow = new DropShadow();
        xoShadow.setBlurType(BlurType.THREE_PASS_BOX);
        xoShadow.setHeight(10);
        xoShadow.setWidth(10);
        xoShadow.setSpread(12);
        xo.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            xo.setEffect(arkanoidShadow);
        });
    }

}
