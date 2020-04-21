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
public class Arkanoid_Map {

    private final Image double_brick1 = new Image("Resources/Arkanoid/bricks/normal brick2.png", 130, 386, true, true);
    private final Image double_brick2 = new Image("Resources/Arkanoid/bricks/normal brick3.png", 130, 386, true, true);
    private final Image double_brick3 = new Image("Resources/Arkanoid/bricks/normal brick4.png", 130, 386, true, true);
    private final Image double_brick4 = new Image("Resources/Arkanoid/bricks/normal brick6.png", 130, 386, true, true);
    private final Image broken_double_brick1 = new Image("Resources/Arkanoid/bricks/broken brick2.png", 130, 386, true, true);
    private final Image broken_double_brick2 = new Image("Resources/Arkanoid/bricks/broken brick3.png", 130, 386, true, true);
    private final Image broken_double_brick3 = new Image("Resources/Arkanoid/bricks/broken brick4.png", 130, 386, true, true);
    private final Image broken_double_brick4 = new Image("Resources/Arkanoid/bricks/broken brick6.png", 130, 386, true, true);
    private final Image normal_brick1 = new Image("Resources/Arkanoid/bricks/normal brick1.png", 130, 386, true, true);
    private final Image normal_brick2 = new Image("Resources/Arkanoid/bricks/normal brick5.png", 130, 386, true, true);
    private final Image normal_brick3 = new Image("Resources/Arkanoid/bricks/normal brick7.png", 130, 386, true, true);
    private final Image normal_brick4 = new Image("Resources/Arkanoid/bricks/normal brick8.png", 130, 386, true, true);

    private static ImageView tmp_imageView = new ImageView();
    public static ArrayList<ImageView> bricks_arraylist = new ArrayList<>();
    private static int posX, posY;

    private final String fileName = "C:\\Game-Box\\src\\Resources\\Arkanoid\\map.txt";
    private FileReader file_reader;
    private BufferedReader buffered_reader;
    private final Image ArkaniodImgback = new Image("Resources/Arkanoid/8972.jpg", 2000, 800, true, false);
    private final ImageView arkanoid_ImagbackIV = new ImageView(ArkaniodImgback);
   public static int level = 0;

    private static HashMap<Integer, ArrayList<String>> read_map = new HashMap<>();

    public Arkanoid_Map() throws IOException {
        make_hashmap();
    }

    private void initialize() throws FileNotFoundException {
        posX = 50;
        posY = 50;
        bricks_arraylist.clear();
        ArkanoidMain.root.getChildren().add(arkanoid_ImagbackIV);

    }

    private void make_hashmap() throws FileNotFoundException, IOException {
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

    public void startlevel() throws IOException {
        level++;
        initialize();

        ArrayList<String> levelmap = read_map.get(level);

        for (String levelmap1 : levelmap) {
            char[] values = levelmap1.toCharArray();
            for (int j = 0; j < values.length; j++) {
                switch (values[j]) {
                    case '1':
                        setPosition(normal_brick1, posX, posY , "1");
                        break;
                    case '2':
                        setPosition(double_brick1, posX, posY,"21");
                        break;
                    case '3':
                        setPosition(double_brick2, posX, posY,"22");
                        break;
                    case '4':
                        setPosition(double_brick3, posX, posY,"23");
                        break;
                    case '5':
                        setPosition(normal_brick2, posX, posY,"1");
                        break;
                    case '6':
                        setPosition(double_brick4, posX, posY,"24");
                        break;
                    case '7':
                        setPosition(normal_brick3, posX, posY,"1");
                        break;
                    case '8':
                        setPosition(normal_brick4, posX, posY,"1");
                        break;

                }
                posX += 130;
            }
            posY += 50;
            posX = 50;
        }
    }

    private void setPosition(Image img, int x, int y, String degree) {

        tmp_imageView = new ImageView();

        tmp_imageView.setImage(img);
        tmp_imageView.setX(x);
        tmp_imageView.setY(y);
        tmp_imageView.setId(degree);
        ArkanoidMain.root.getChildren().add(tmp_imageView);
        bricks_arraylist.add(tmp_imageView);

    }

    public Image getBroken_double_brick1() {
        return broken_double_brick1;
    }

    public Image getBroken_double_brick2() {
        return broken_double_brick2;
    }

    public Image getBroken_double_brick3() {
        return broken_double_brick3;
    }

    public Image getBroken_double_brick4() {
        return broken_double_brick4;
    }
}
