package Sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map {

    private static Image wall = new Image("Resources/Sokoban/wall.bmp", 50, 50, true, true);

    protected static Image player = new Image("Resources/Sokoban/player.png", 50, 50, true, true);
    protected static Image playerU = new Image("Resources/Sokoban/player_02.png", 50, 50, true, true);
    protected static Image playerL = new Image("Resources/Sokoban/player_15.png", 50, 50, true, true);
    protected static Image playerR = new Image("Resources/Sokoban/player_13.png", 50, 50, true, true);
    protected static Image box = new Image("Resources/Sokoban/box.png", 50, 50, true, true);
    protected static Image target = new Image("Resources/Sokoban/target.png", 50, 50, true, true);
    protected static Image boxOnTarget = new Image("Resources/Sokoban/crate_27.png", 50, 50, true, true);
    protected static Image pipeR = new Image("Resources/Sokoban/pipeR.png", 50, 50, true, true);
    protected static Image pressure_pad = new Image("Resources/Sokoban/pressure_pad.png", 50, 50, true, true);
    protected static Image gate = new Image("Resources/Sokoban/gate.bmp", 50, 50, true, true);

    private static ImageView tmp_imageView = new ImageView();
    protected static ImageView pad_iv = new ImageView();

    protected static ArrayList<ImageView> Walls_Imageviews_Array = new ArrayList<>();
    protected static ArrayList<ImageView> StorageLocation_Imageviews_Array = new ArrayList<>();
    protected static ArrayList<ImageView> Boxes_Imageviews_Array = new ArrayList<>();
    protected static ArrayList<ImageView> Pipes_Imageviews_Array = new ArrayList<>();
    protected static ArrayList<ImageView> Gates_Imageviews_Array = new ArrayList<>();

    protected static int tmp_Level;
    /*
     * posX & posY for Locating The level textures 
     */
    protected static int posX, posY;

    private static String fileName = "C:\\Game-Box\\src\\Resources\\Sokoban\\maps.txt";
    // private String fileName  = "src/Resources/Sokoban/maps.txt" ;
    private static FileReader file_reader;
    private static BufferedReader buffered_reader;
    public static Image SokobanImgback = new Image("Resources/Sokoban/backa.jpg", 1800, 800, true, false);
    public static ImageView Soko_ImagbackIV = new ImageView(SokobanImgback);
    private static Image next_btn_img = new Image("Resources/Sokoban/next.jpg");
    private static Image prev_btn_img = new Image("Resources/Sokoban/prev.jpg");
    private static ImageView nextbtn_iv = new ImageView(next_btn_img), prevbtn_iv = new ImageView(prev_btn_img);
    public static HashMap<Integer, ArrayList<String>> read_map = new HashMap<>();
    private static FileReader file_reader2;
    private static BufferedReader buffered_reader2;
    public static int level = 1;
    /*
     * Parameterized Constructor to set the background 
     */

    Map() throws FileNotFoundException {
        file_reader = new FileReader(fileName);
        buffered_reader = new BufferedReader(file_reader);
    }

    public static void initialize() {

        posX = 50;
        posY = 50;

        Sokoban_Main.root.getChildren().clear();
        Boxes_Imageviews_Array.clear();
        StorageLocation_Imageviews_Array.clear();
        Walls_Imageviews_Array.clear();
        Pipes_Imageviews_Array.clear();
        Gates_Imageviews_Array.clear();
        Sokoban_Main.root.getChildren().remove(pad_iv);

        Sokoban_Main.root.getChildren().add(Soko_ImagbackIV);
        if (!Sokoban_Main.check_mode43) {
            Time.moves = 0;
            Time.seconds = 0;
            Sokoban_Main.root.getChildren().add(Time.layout);
        } else {
            if (tmp_Level != 1) {
                Sokoban_Main.root.getChildren().add(prevbtn_iv);
            }
            Sokoban_Main.root.getChildren().add(nextbtn_iv);
        }
    }

    /*
     * This method Read the Map file text 
     * and Put images instead of characters which in the file
     */
    public static void make_hashmap() throws FileNotFoundException, IOException {
        file_reader2 = new FileReader(fileName);
        buffered_reader2 = new BufferedReader(file_reader2);

        String currentLine;

        while ((currentLine = buffered_reader2.readLine()) != null) {
            ArrayList<String> rows = new ArrayList<>();

            if (currentLine.isEmpty()) {
                break;
            }

            int level = Integer.parseInt(currentLine);

            while (!currentLine.equals("BREAK")) {
                currentLine = buffered_reader2.readLine();

                rows.add(currentLine);
            }
            read_map.put(level, rows);

        }
    }

    public static void startlevel(int start_from_this_level) {
        tmp_Level = start_from_this_level;
        initialize();
        practicebuttons();
        ArrayList<String> levelmap = read_map.get(tmp_Level);

        for (int i = 0; i < levelmap.size(); i++) {
            char[] values = levelmap.get(i).toCharArray();

            for (int j = 0; j < values.length; j++) {
                switch (values[j]) {
                    case '#':
                        setPosition(wall, posX, posY);
                        break;

                    case '@':
                        setPosition(player, posX, posY);
                        break;

                    case '!':
                        break;

                    case '.':
                        setPosition(target, posX, posY);
                        break;

                    case 'F':
                        setPosition(pipeR, posX, posY);
                        break;

                    case '*':
                        setPosition(gate, posX, posY);
                        break;

                    case '&':
                        setPosition(pressure_pad, posX, posY);
                        break;

                    case '$':
                        setPosition(box, posX, posY);
                }
                posX += 50;

            }
            posY += 50;
            posX = 50;

        }

    }
    /*
     * Locate the Image's position and put its imageView in the layout "group"
     */

    public static void setPosition(Image img, int x, int y) {

        tmp_imageView = new ImageView();

        tmp_imageView.setImage(img);
        tmp_imageView.setX(x);
        tmp_imageView.setY(y);

        Sokoban_Main.root.getChildren().add(tmp_imageView);

        if (img == player) {
            Player.player_imageView = tmp_imageView;
        } else if (img == wall) {
            Walls_Imageviews_Array.add(tmp_imageView);
        } else if (img == box) {
            Boxes_Imageviews_Array.add(tmp_imageView);
        } else if (img == target) {
            StorageLocation_Imageviews_Array.add(tmp_imageView);
        } else if (img == pipeR) {
            Pipes_Imageviews_Array.add(tmp_imageView);
        } else if (img == pressure_pad) {
            Pressure_Pad.pressure_pad_posX = x;
            Pressure_Pad.pressure_pad_posY = y;
            pad_iv = tmp_imageView;
            Pressure_Pad.levelHasvePad = true;
        } else if (img == gate) {
            Gates_Imageviews_Array.add(tmp_imageView);
        }
    }

    private static void practicebuttons() {
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
}
