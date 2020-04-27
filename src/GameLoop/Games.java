package GameLoop;

import Sokoban.Menu;
import Sokoban.Sokoban_Main;
import Sokoban.finish_level;

import Tetris.Tetris_Main;
import TicTacToe.XO_Main;
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

    
    private Group gamesGroup = new Group();
    private final HBox gamesHBox = new HBox();
    private Scene gamesScene = new Scene(gamesGroup, 1400, 780);

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
        
        Image Imageback = new Image("Resources/gamesPage/242556.png", 1370, 780, false, false);
        Image image = new Image("Resources/gamesPage/gamebox.png", 150, 150, true, false);
        
        
        ImageView ImagbackIV = new ImageView(Imageback);
        ImageView ImageIV = new ImageView(image);
        ImageIV.setX(600);ImageIV.setY(25);
        
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

            try {

                Sokoban_Main.getInstanceFromSokoban().openSokobanMain(GameBox_Core.Root);

                MainStage.setScene(Menu.openMenu_sokoban());
            } catch (IOException ex) {
                Logger.getLogger(Games.class.getName()).log(Level.SEVERE, null, ex);
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
            Tetris_Main.getInstanceFromTetris().Tetris_Main(MainStage);
        });
        gamesGroup.getChildren().add(TetrisBtn);


        Button ArkanoidBtn = new Button();
        ArkanoidBtn.setLayoutX(900);
        ArkanoidBtn.setLayoutY(250);
        Image arkanoidImage = new Image("Resources/gamesPage/arkanoid.jpg", 200, 200, true, false);
        ImageView arkanoidImageIV = new ImageView(arkanoidImage);
        ArkanoidBtn.setGraphic(arkanoidImageIV);
        ArkanoidBtn.setOnMousePressed(event -> {
            Arkanoid.Menu menu = new Arkanoid.Menu(MainStage);
        });
        gamesGroup.getChildren().add(ArkanoidBtn);


        Button TicTacToeBtn = new Button();
        TicTacToeBtn.setLayoutX(600);
        TicTacToeBtn.setLayoutY(470);
        Image xoImage = new Image("Resources/gamesPage/xo.png", 200, 200, true, false);
        ImageView xoImageIV = new ImageView(xoImage);
        TicTacToeBtn.setGraphic(xoImageIV);

        TicTacToeBtn.setOnMousePressed(event -> {
            XO_Main.getInstanceFromXO().openTicTacToeMain(MainStage);
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
