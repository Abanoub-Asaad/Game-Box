package Sokoban.Select_Level;

import GameLoop.GameBox_Core;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import Sokoban.*;
import static Sokoban.Sokoban_Main.sokoban_scene;

public class Page1 {

    private Text selectLevel_txt = new Text("Select Level");
    public Group root = new Group();
    protected static Scene scene_page1;//= new Scene(root, 1800, 750);
    private boolean locked = true;
    private Image Imageback;
    private ImageView ImagbackIV;
    private int x, y;
    private static Page1 Page1;
    String fileName ="C:\\Game-Box\\src\\Resources\\Sokoban\\continue_player.txt";

    private FileReader file_reader;
    private BufferedReader buffered_reader;
    Image lvlImage;
    ImageView lvlImage_IV;

    /**
     * Method to get an object from the class it's a singleton pattern
     *
     * @return
     */
    public static Page1 getInstance2() {
        if (Page1 == null) {
            Page1 = new Page1();
        }
        return Page1;
    }

    public Page1() {

    }

    /**
     * Main method in "select level"
     *
     * @param stage
     * @throws IOException
     */
    public void IntializePage1(Stage stage) throws IOException {
        scene_page1 = new Scene(root, 1800, 750);
        x = 200;
        y = 200;

        CreateBackground();
        SelectLvlTxt();
        createImage();
        MovePage(stage);

        stage.setScene(scene_page1);
    }

    /**
     * Create background for the scene of select a specific level
     */
    public void CreateBackground() {
        Imageback = new Image("Resources/Sokoban/Select Level/ww.jpg", 1370, 780, true, false);
        ImagbackIV = new ImageView(Imageback);
        root.getChildren().add(ImagbackIV);
    }

    /**
     * Method for design and animation of text "Select Level"
     */
    public void SelectLvlTxt() {
        selectLevel_txt.setFont(Font.font("Copperplate Gothic Bold", FontWeight.LIGHT, 100));
        selectLevel_txt.setFill(Color.DEEPPINK);
        selectLevel_txt.setStroke(Color.GOLD);
        selectLevel_txt.setStrokeDashOffset(2);
        selectLevel_txt.setStrokeWidth(4);
        selectLevel_txt.setX(300);
        selectLevel_txt.setY(130);

        FadeTransition Fade = new FadeTransition(Duration.millis(5000));
        Fade.setNode(selectLevel_txt);
        Fade.setFromValue(0);
        Fade.setToValue(6);
        Fade.setCycleCount(1);
        Fade.play();
        root.getChildren().add(selectLevel_txt);
    }

    /**
     * Method for making a specific image for each level that appears in Select
     * Level scene
     *
     * @throws IOException
     */
    public void createImage() throws IOException {
        SetImage(0, x, y);
        lvlImage_IV.setLayoutX(200);
        x += 100;
        lvlImage_IV.setLayoutY(200);
        lvlImage_IV.setEffect(new DropShadow(+15d, 0d, +2d, Color.GREY));
        root.getChildren().addAll(lvlImage_IV);
        Text t;
        t = new Text(Integer.toString(1));
        t.setFill(Color.WHITE);
        t.setFont(Font.font(30));
        t.setX(x - 75);
        t.setY(y + 45);
        t.toFront();
        root.getChildren().addAll(t);
        for (int i = 1; i < 10; i++) {

            SetImage(i, x, y);
            lvlImage_IV.setLayoutX(x);
            lvlImage_IV.setLayoutY(200);
            lvlImage_IV.setEffect(new DropShadow(+15d, 0d, +2d, Color.PINK));
            x += 100;
            root.getChildren().addAll(lvlImage_IV);
            if (!locked) {
                t = new Text(Integer.toString(i + 1));
                t.setFill(Color.WHITE);
                t.setFont(Font.font(30));
                t.setX(x - 75);
                t.setY(y + 45);
                t.toFront();
                root.getChildren().addAll(t);
            }
        }

        for (int j = 10; j < 50; j++) {
            if (j % 10 == 0) {
                y += 100;
                x = 200;
            }
            SetImage(j, x, y);
            lvlImage_IV.setLayoutX(x);
            lvlImage_IV.setLayoutY(y);
            lvlImage_IV.setEffect(new DropShadow(+15d, 0d, +2d, Color.PINK));
            x += 100;
            root.getChildren().addAll(lvlImage_IV);
            if (!locked) {
                t = new Text(Integer.toString(j + 1));
                t.setFill(Color.WHITE);
                t.setFont(Font.font(30));
                t.setX(x - 80);
                t.setY(y + 45);
                t.toFront();
                root.getChildren().addAll(t);
            }

        }

    }

    /**
     * Method for transition between the 2 pages which contain the levels, each
     * page have 50 levels
     *
     * @param stage
     */
    public void MovePage(Stage stage) {

        Circle page1_circle, page2_circle;
        page1_circle = new Circle();
        page2_circle = new Circle();
        page1_circle.setRadius(10);
        page1_circle.setFill(Color.WHITE);

        page1_circle.setEffect(new DropShadow(+25d, 0d, +1d, Color.WHITE));
        page1_circle.setCenterX(690);
        page1_circle.setCenterY(710);

        page2_circle.setCenterX(660);
        page2_circle.setCenterY(710);

        page2_circle.setRadius(10);
        page2_circle.setFill(Color.GREY);
        page2_circle.setEffect(new DropShadow(+25d, 0d, +1d, Color.WHITE));

        page2_circle.setOnMouseEntered(event -> {
            page2_circle.setFill(Color.WHITE);
        });

        page2_circle.setOnMouseExited(event -> {
            page2_circle.setFill(Color.GREY);
        });

        page2_circle.setOnMouseClicked(event -> {
            try {
                Page2.getInstance().page2_Main(stage);
            } catch (IOException ex) {
                Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        root.getChildren().addAll(page1_circle, page2_circle);
    }

    /**
     * Method to set the level image number lvlN in specific position
     *
     * @param lvlN
     * @param X
     * @param Y
     * @throws FileNotFoundException
     * @throws IOException
     */
    protected void SetImage(int lvlN, int X, int Y) throws FileNotFoundException, IOException {
        locked = true;
        lvlImage = new Image("Resources/Sokoban/Select Level/lock.png", 70, 70, true, true);
        lvlImage_IV = new ImageView(lvlImage);

        file_reader = new FileReader(fileName);
        buffered_reader = new BufferedReader(file_reader);
  start_level.PlayerName_string = buffered_reader.readLine();
        String currentLine;
        while ((currentLine = buffered_reader.readLine()) != null) {
            if (lvlN + 1 == Integer.parseInt(currentLine)) {
                locked = false;
                if ((lvlN + 1) % 8 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/0.png", 70, 70, true, true);
                } else if ((lvlN + 1) % 7 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/1.png", 70, 70, true, true);
                } else if ((lvlN + 1) % 6 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/2.png", 70, 70, true, true);
                } else if ((lvlN + 1) % 5 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/3.png", 70, 70, true, true);
                } else if ((lvlN + 1) % 4 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/4.png", 70, 70, true, true);
                } else if ((lvlN + 1) % 3 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/5.png", 70, 70, true, true);
                } else if ((lvlN + 1) % 2 == 0) {
                    lvlImage = new Image("Resources/Sokoban/Select Level/6.png", 70, 70, true, true);
                } else {
                    lvlImage = new Image("Resources/Sokoban/Select Level/7.png", 70, 70, true, true);
                }
                lvlImage_IV.setImage(lvlImage);

                lvlImage_IV.setOnMousePressed(event -> {
                    //(lvlN + 1) 
                    
                    try {
                       Sokoban_Main.getInstanceFromSokoban().openSokobanMain(GameBox_Core.Root);
                    } catch (IOException ex) {
                        Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    GameLoop.GameBox_Core.Root.setScene(sokoban_scene);
                    Map.startlevel(lvlN + 1);
                    try {
                        Piece.checkIfStorageLogationsAreFilled();
                    } catch (IOException ex) {
                        Logger.getLogger(Page1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                // root.getChildren().add(lvlImage_IV);
                break;
            }

        }
    }
}
