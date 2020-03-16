package Sokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map {

    private Image ground = new Image("Resources/Sokoban/ground.png", 50, 50, true, true);
    private Image wall = new Image("Resources/Sokoban/wall.png", 50, 50, true, true);
    
    protected static Image player = new Image("Resources/Sokoban/player.png", 50, 50, true, true);
    protected static Image playerU = new Image("Resources/Sokoban/player_02.png", 50, 50, true, true);
    protected static Image playerL = new Image("Resources/Sokoban/player_15.png", 50, 50, true, true);
    protected static Image playerR = new Image("Resources/Sokoban/player_13.png", 50, 50, true, true);
    
    protected static Image box = new Image("Resources/Sokoban/box.png", 50, 50, true, true);
    protected static Image target = new Image("Resources/Sokoban/target.png", 50, 50, true, true);
    protected static Image boxOnTarget = new Image("Resources/Sokoban/crate_27.png", 50, 50, true, true); 
    
    private static ImageView tmp_imageView = new ImageView();
    
    
    protected static ArrayList<ImageView> Walls_Imageviews_Array = new ArrayList<>() ;
    protected static ArrayList<ImageView> StorageLocation_Imageviews_Array = new ArrayList<>() ;
    protected static ArrayList<ImageView> Boxes_Imageviews_Array = new ArrayList<>() ;
    protected static ArrayList<ImageView> BoxeOnTarget_Imageviews_Array = new ArrayList<>() ;
    /*
     * posX & posY for Locating The level textures 
     */
    protected int posX = 50, posY = 50;

    private String fileName = "C:\\Game-Box\\src\\Resources\\Sokoban\\maps.txt";
   // private String fileName  = "src/Resources/Sokoban/maps.txt" ;
    private FileReader file_reader;
    private BufferedReader buffered_reader;

    /*
     * Parameterized Constructor to set the background 
     */
    Map(Group g) {
        Image SokobanImgback = new Image("Resources/Sokoban/l1.jpg", 1400, 800, true, false);
        ImageView Soko_ImagbackIV = new ImageView(SokobanImgback);
        g.getChildren().addAll(Soko_ImagbackIV);
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

        while ((currentLine = buffered_reader.readLine()) != null && !currentLine.equals("BREAK")) {

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
                        setPosition(wall, posX, posY);
                        break;

                    case '@':
                        setPosition(player, posX, posY);
                        break;

                    case '!':
                        break;

                    case ' ':
                       // setPosition( ground, posX, posY);
                        break;

                    case '.':
                        setPosition(target, posX, posY);
                        break;
                        
                    case '$':
                        setPosition(box, posX, posY);
                        break;
                        
                    case '&':
                        setPosition(target, posX, posY);
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
    public void setPosition(Image img, int x, int y) {

        tmp_imageView = new ImageView();

        tmp_imageView.setImage(img);
        tmp_imageView.setX(x);
        tmp_imageView.setY(y);

        Sokoban_Main.root.getChildren().add(tmp_imageView);

        if (img == player) {
            Player.player_imageView = tmp_imageView;
        }
        else if(img == wall ){
            Walls_Imageviews_Array.add(tmp_imageView) ;
        }
        else if(img == box){
            Boxes_Imageviews_Array.add(tmp_imageView );
        }
        else if(img == target){
            StorageLocation_Imageviews_Array.add(tmp_imageView);
        }
//        else if(img == boxOnTarget){
//           
//            Boxes_Imageviews_Array.add(tmp_imageView);
//            StorageLocation_Imageviews_Array.add(tmp_imageView);
//            
            
        //}  
    }

}
