
package Tetris;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class board {
    
    private static Image tetris_back_img = new Image("Resources/Tetris/tt.png", 1400, 800, false, false);
    protected static ImageView tetris_back_iv = new ImageView(tetris_back_img);

    public static Rectangle[][] grids = new Rectangle[20][14];
    public static GridPane grid = new GridPane();
    static int width = 50, height = 50;

    public static Rectangle[][] draw_back_ground() {
        
        for (int row = 0; row < 20; row++) {
            for (int column = 0; column < 14; column++) {
                grids[row][column] = new Rectangle(width, height);
                grids[row][column].setFill(Color.BLACK);
                grids[row][column].setStroke(Color.WHITESMOKE);
                grid.add(grids[row][column], row, column);
            }
        }
        return grids;
    }
          
   protected static void Abnb(Scene scene) 
    {
        
      scene.setOnMousePressed(e -> 
        {  
            int a = (int) e.getX() ;
            int b = (int) e.getY() ;
            System.out.println("a = "+a+"  b = "+b);
         });
    }
         
}
