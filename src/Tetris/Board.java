
package Tetris;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

class Board {
    
    private static Image tetris_back_img = new Image("Resources/Tetris/Basic.png", 1400, 800, false, false);
    protected static ImageView tetris_back_iv = new ImageView(tetris_back_img);

    protected static int XMAX =901;
    protected static int YMAX = 750;
    protected static int Size = 50 ; //size of the one rectangle
    protected static int MoveValue = 50 ;
    protected static Line line;

    protected static Rectangle[][] grids = new Rectangle[20][15];
    protected static GridPane grid = new GridPane();
    protected static Rectangle[][] draw_back_ground() {
        for (int row = 0; row < 20; row++) {
            for (int column = 0; column < 15; column++) {
                Rectangle b = new Rectangle(50, 50);
                b.setFill(Color.BLACK);
                grids[row][column] = b;
                grid.add(grids[row][column], row, column);
                //grid.setGridLinesVisible(true);
            
            }
        } 
        return  grids  ;
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
   
   protected static Line drawLine(){
        line = new Line(XMAX, 0, XMAX, YMAX);
        line.setFill(Color.RED);
        line.setStroke(Color.WHEAT);
        line.setStrokeWidth(5);
        
        return line;
   }
         
}
