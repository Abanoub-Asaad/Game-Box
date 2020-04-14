/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author egypt
 */
public class map {

    protected static Image brick1 = new Image("Resources/Arkanoid/normal brick1.png", 130, 386, true, true);
    protected static Image brick2 = new Image("Resources/Arkanoid/normal brick2.png", 130, 386, true, true);
    protected static Image brick3 = new Image("Resources/Arkanoid/normal brick3.png", 130, 386, true, true);
    protected static Image brick4 = new Image("Resources/Arkanoid/normal brick4.png", 130, 386, true, true);
    protected static Image brick5 = new Image("Resources/Arkanoid/normal brick5.png", 130, 386, true, true);
    protected static Image brick6 = new Image("Resources/Arkanoid/normal brick6.png", 130, 386, true, true);
    protected static Image brick7 = new Image("Resources/Arkanoid/normal brick7.png", 130, 386, true, true);
    protected static Image brick8 = new Image("Resources/Arkanoid/normal brick8.png", 130, 386, true, true);

    private static ImageView tmp_imageView = new ImageView();
    protected static ArrayList<ImageView> bricks_arraylist = new ArrayList<>();
    protected static int posX, posY;

    private static final String fileName = "C:\\Game-Box\\src\\Resources\\Arkanoid\\map.txt";
    private static FileReader file_reader;
    private static BufferedReader buffered_reader;
    public static Image ArkaniodImgback = new Image("Resources/Arkanoid/8972.jpg", 2000, 800, true, false);
    public static ImageView arkanoid_ImagbackIV = new ImageView(ArkaniodImgback);
    public static int level = 0;

    public static HashMap<Integer, ArrayList<String>> read_map = new HashMap<>();

    public static void initialize() throws FileNotFoundException {
        posX = 50;
        posY = 50;
        bricks_arraylist.clear();
        Arkanoid_main.root.getChildren().add(arkanoid_ImagbackIV);

    }

    public static void make_hashmap() throws FileNotFoundException, IOException {
        file_reader = new FileReader(fileName);
        buffered_reader = new BufferedReader(file_reader);
        String currentLine;

        while ((currentLine = buffered_reader.readLine()) != null) {
            ArrayList<String> rows = new ArrayList<>();

            if (currentLine.isEmpty()) {
                break;
            }

            int l = Integer.parseInt(currentLine);

            while (!currentLine.equals("BREAK")) {
                currentLine = buffered_reader.readLine();

                rows.add(currentLine);
            }
            read_map.put(l, rows);

        }
    }

    public static void startlevel() throws IOException {
        level++;
        initialize();

        ArrayList<String> levelmap = read_map.get(level);

        for (String levelmap1 : levelmap) {
            char[] values = levelmap1.toCharArray();
            for (int j = 0; j < values.length; j++) {
                switch (values[j]) {
                    case '1':
                        setPosition(brick1, posX, posY);
                        break;

                    case '2':
                        setPosition(brick2, posX, posY);
                        break;

                    case '3':
                        setPosition(brick3, posX, posY);
                        break;
                    case '4':
                        setPosition(brick4, posX, posY);
                        break;
                    case '5':
                        setPosition(brick5, posX, posY);
                        break;
                    case '6':
                        setPosition(brick6, posX, posY);
                        break;
                    case '7':
                        setPosition(brick7, posX, posY);
                        break;
                    case '8':
                        setPosition(brick8, posX, posY);
                        break;

                }
                posX += 130;
            }
            posY += 50;
            posX = 50;
        }
    }

    public static void setPosition(Image img, int x, int y) {

        tmp_imageView = new ImageView();

        tmp_imageView.setImage(img);
        tmp_imageView.setX(x);
        tmp_imageView.setY(y);

        Arkanoid_main.root.getChildren().add(tmp_imageView);
        bricks_arraylist.add(tmp_imageView);

    }
}
