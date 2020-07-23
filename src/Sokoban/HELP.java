package Sokoban;

import GameLoop.GameBox_Core;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Nourhan Ahmed
 */
public class HELP {

    private static HBox root = new HBox(100);
    private static HBox[] hbox = new HBox[3];
    private static VBox array_box = new VBox(35);

    private static VBox box1 = new VBox(25);
    private static VBox box2 = new VBox(50);
    private static Scene scene = new Scene(root, 1370, 800);
    private static Image Imageback;
    private static ImageView IV;
    private static Text t = new Text("H o w  T o  P l a y !");
    private static BackgroundPosition backgroundPosition = new BackgroundPosition(Side.LEFT, 0, false, Side.TOP, 0, false);
    private static Button screen_shot = new Button("Screen Shots");
    private static Button back = new Button("Back");

    private static Button ctrl = new Button("Controls");
    private static Button rules = new Button("Rules");
    private static Button esn = new Button("Esentials");

    private static Label[] label = new Label[3];
    private static ImageView[] imgV = new ImageView[4];
    private static boolean flag;
    private static boolean f = false;

    public static Scene start() {
        scene.getStylesheets().add(start_level.class.getResource("css1.css").toExternalForm());

        box1.setId("box1");
        box2.setId("box2");
        Image socoban = new Image("Resources/Sokoban/socopan.png", 200, 200, true, true);

        IV = new ImageView(socoban);
        IV.setY(50);
        box1.getChildren().add(IV);
//backround
        Imageback = new Image("Resources/Sokoban/pattern.jpg", 250, 250, true, true);
        BackgroundImage br = new BackgroundImage(Imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, backgroundPosition, BackgroundSize.DEFAULT);
        Background b = new Background(br);
        root.setBackground(b);
        //how to play txt settings
        t.setFont(Font.font("pcsenior", 50));
        t.setFill(Color.AQUAMARINE);
        t.setStroke(Color.GOLD);
        t.setStrokeWidth(2);
        t.setLayoutX(900);
        t.setLayoutY(100);
        t.setX(900);
        t.setY(100);
        box2.getChildren().add(t);

        setBtn();
        createLabelContents();

        box1.setAlignment(Pos.TOP_CENTER);
        box2.setAlignment(Pos.TOP_CENTER);

        root.setPrefHeight(800);
        root.setPrefWidth(1370);

        array_box.getChildren().addAll(hbox[0], hbox[1], hbox[2]);
        box2.getChildren().add(array_box);
        root.getChildren().addAll(box1, box2);
        return scene;
    }

    private static void setBtn() {
        esn.setId("btn0");
        ctrl.setId("btn0");
        back.setId("btn0");
        screen_shot.setId("btn0");
        rules.setId("btn0");
        rules.setLayoutX(100);
        rules.setLayoutY(200);

        esn.setLayoutX(100);
        esn.setLayoutY(300);

        ctrl.setLayoutX(100);
        ctrl.setLayoutY(400);

        screen_shot.setLayoutX(100);
        screen_shot.setLayoutY(500);
        back.setLayoutX(100);
        back.setLayoutY(600);
        box1.getChildren().addAll(ctrl, esn, rules, screen_shot, back);

    }

    private static void setImg(Image img, int n) {
        imgV[n] = new ImageView();
        imgV[n].setImage(img);
        hbox[n].getChildren().add(imgV[n]);
    }

    private static void createLabelContents() {
        flag = false;
        hbox[0] = new HBox(10);
        hbox[1] = new HBox(10);
        hbox[2] = new HBox(10);

        Image plyr = new Image("Resources/Sokoban/player.png", 50, 50, true, true);
        Image wall = new Image("Resources/Sokoban/wall.png", 50, 50, true, true);
        Image box = new Image("Resources/Sokoban/box.png", 50, 50, true, true);
        Image trgt = new Image("Resources/Sokoban/target.png", 50, 50, true, true);
        Image shot1 = new Image("Resources/Sokoban/1.png", 450, 450, true, true);
        Image shot2 = new Image("Resources/Sokoban/2.png", 450, 450, true, true);
        Image shot3 = new Image("Resources/Sokoban/3.png", 450, 450, true, true);
        Image shot4 = new Image("Resources/Sokoban/4.png", 450, 450, true, true);

        label[0] = new Label();
        label[1] = new Label();
        label[2] = new Label();

        esnBtn(plyr, box, wall);

        ctrl.setOnMouseClicked((event -> {
            if (flag) {
                clear();
            }
            label[0].setId("label1");
            label[0].setText("These are the default controls for playing Sokoban:\n\t*Arrow up - for moving the charecter up.\n\t*"
                    + "Arrow Down - for moving the charecter down.\n\t"
                    + "*Arrow Left - for moving the character to left side.\n\t"
                    + "*Arrow Right - for moving the character to right side.\n\t"
                    + "*Esc button - to back to Game menu.\n\t"
                    + "*Reset Arrow - to reset the game level.\n\t");
            label[0].setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 70));
            hbox[0].getChildren().add(label[0]);
            flag = true;
        }));

        rules.setOnMouseClicked((event -> {
            if (flag) {
                clear();
            }
            label[0].setId("label3");
            label[0].setText("The game is played on a board of squares, where each square is a floor or a wall. "
                    + "\nSome floor squares contain boxes, and some floor squares are marked as storage locations."
                    + "\n" + "The player is confined to the board and may move horizontally or vertically onto empty squares "
                    + "\n(never through walls or boxes). The player can move a box by walking up to it "
                    + "\nand pushing it to the square beyond. Boxes cannot be pulled and cannot be pushed "
                    + "\nto squares with walls or other boxes. The number of boxes equals "
                    + "\nthe number of storage locations. The puzzle is solved when all boxes \nare placed at storage locations.");
            label[0].setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 70));
            hbox[0].getChildren().add(label[0]);
            flag = true;
        }));

        esn.setOnMouseClicked((event -> {
            esnBtn(plyr, box, wall);
        }));
        screen_shot.setOnMouseClicked((event -> {
            if (flag) {
                clear();
            }
            imgV[0] = new ImageView();
            imgV[0].setImage(shot1);
            imgV[1] = new ImageView();
            imgV[1].setImage(shot2);
            hbox[0].getChildren().addAll(imgV[0], imgV[1]);

            imgV[2] = new ImageView();
            imgV[2].setImage(shot3);
            imgV[3] = new ImageView();
            imgV[3].setImage(shot4);
            hbox[1].getChildren().addAll(imgV[2], imgV[3]);
            flag = true;

        }));
        back.setOnMouseClicked((event -> {

            GameBox_Core.Root.setScene(Menu.scene);

        }));
    }

    private static void clear() {
        array_box.getChildren().clear();
        for (int i = 0; i < 3; i++) {
            hbox[i].getChildren().clear();
            array_box.getChildren().add(hbox[i]);
        }
    }

    private static void esnBtn(Image plyr, Image box, Image wall) {
        if (flag) {
            clear();
        }

        label[0].setId("label2");
        setImg(plyr, 0);
        label[0].setText("You are in control of the Player. The Player can move up, down, "
                + "\nleft and right by using the arrow keys on the keyboard. ");
        label[0].setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 50));

        hbox[0].getChildren().add(label[0]);

        setImg(wall, 1);

        label[1].setId("label1");

        label[1].setText("Walls surround a Sokoban puzzle and the Player cannot walk through them.\n"
                + "Walls make up the layout of the puzzle.");
        label[1].setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 50));

        hbox[1].getChildren().add(label[1]);

        setImg(box, 2);
        label[2].setId("label2");

        label[2].setText("Boxes can be pushed by the Player.\nBoxes must be placed on all the targets in the puzzle.");
        label[2].setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 50));

        hbox[2].getChildren().add(label[2]);
        flag = true;
    }
}
