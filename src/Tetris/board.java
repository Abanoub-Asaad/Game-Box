
package Tetris;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class board {
    
    private static Image tetris_back_img = new Image("Resources/Tetris/tt.png" ,1400,800,false,false) ;
    protected static ImageView   tetris_back_iv  = new ImageView(tetris_back_img);
        
     
   public    static  Rectangle  [][] grids = new Rectangle [20][15];
   public    static  GridPane grid = new GridPane();
   
   public  static   Rectangle[][] draw_back_ground(){
     for(int row = 0; row < 20 ; row++){
      for(int column = 0; column <15; column ++){
        Rectangle b = new Rectangle(50,49);
            b.setFill(Color.BLACK);
            b.setStroke(Color.WHITESMOKE);
            grids[row][column] = b;
            grid.add(grids[row][column] , row , column);
            grid.setGridLinesVisible(true);
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
         
}
