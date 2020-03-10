package Sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map {

    private Image ground = new Image("Resources/Sokoban/ground.png", 50, 50, true, true);
    private Image wall = new Image("Resources/Sokoban/wall.png", 50, 50, true, true);
    private Image box = new Image("Resources/Sokoban/box.png", 50, 50, true, true);
    private Image target = new Image("Resources/Sokoban/target.png", 50, 50, true, true);
    private Image player = new Image("Resources/Sokoban/player.png", 50, 50, true, true);
    private ImageView tmp_imageView = new ImageView();

    /*
     * posX & posY for Locating The level textures 
     */
    private int posX = 50, posY = 50;

    private String fileName = "C:\\Game-Box\\src\\Resources\\Sokoban\\maps.txt";
    private FileReader file_reader;
    private BufferedReader buffered_reader;

    Map() {

    }


    /*
     * This method Read the Map file text 
     * and Put images insted of characters which in the file
     */
    public void readMapFile(Group group) throws FileNotFoundException, IOException {

        file_reader = new FileReader(fileName);
        buffered_reader = new BufferedReader(file_reader);

        /*
         * CurrentLine attribute for accessing Each line in the file 
         * Level attribute for accessing Level Number 
         */
        String currentLine, Level;

        Level = buffered_reader.readLine();

        while ((currentLine = buffered_reader.readLine()) != null) {
            if (currentLine.isEmpty()) {
                break;
            }

            /*
             ** Converting each line in the level(that in file) to array of chars
             */
            char[] values = currentLine.toCharArray();

            /*
             ** Converting characters to its shapes (images)
             */
            for (int i = 0; i < values.length; i++) {
                switch (values[i]) {
                    case '#':
                        setPosition(group, wall, posX, posY);
                        break;

                    case '@':
                        setPosition(group, player, posX, posY);
                        break;

                    case '!':
                        break;

                    case ' ':
                        setPosition(group, ground, posX, posY);
                        break;

                    case '.':
                        setPosition(group, target, posX, posY);
                        break;

                    case '$':
                        setPosition(group, box, posX, posY);
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
    public void setPosition(Group group, Image img, int x, int y) {

        tmp_imageView = new ImageView();

        tmp_imageView.setImage(img);
        tmp_imageView.setX(x);
        tmp_imageView.setY(y);

        group.getChildren().add(tmp_imageView);

        //System.out.println(group.getChildren().size());
        //System.out.println((int)tmp_imageView.getX()+"  "+(int)tmp_imageView.getY());
    }
}
